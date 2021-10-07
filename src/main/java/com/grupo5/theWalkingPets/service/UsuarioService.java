package com.grupo5.theWalkingPets.service;

import com.grupo5.theWalkingPets.entity.Permissao;
import com.grupo5.theWalkingPets.entity.Usuario;
import com.grupo5.theWalkingPets.repository.PermissaoRepository;
import com.grupo5.theWalkingPets.repository.UsuarioRepository;
import com.grupo5.theWalkingPets.util.ConversaoUtil;
import com.grupo5.theWalkingPets.util.JwtTokenUtil;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PermissaoRepository permissaoRepository;

    private final JwtTokenUtil jwtTokenUtil;

    final String PERMISAO_PESSOA_FISICA = "PESSOA_FISICA";

    public UsuarioService(UsuarioRepository usuarioRepository, PermissaoRepository permissaoRepository, JwtTokenUtil jwtTokenUtil) {
        this.usuarioRepository = usuarioRepository;
        this.permissaoRepository = permissaoRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public boolean validoParaCriacao(Usuario usuario) {
        return !usuarioRepository.existsByEmail(usuario.getEmail());
    }

    public Usuario criarUsuarioPessoaFisica(Usuario usuario) {
        usuario.setPermissoes(Arrays.asList(permissaoRepository.findByNome(PERMISAO_PESSOA_FISICA)));
        return criar(usuario);
    }

    private Usuario criar(Usuario usuario) {
        if (validoParaCriacao(usuario)) {
            usuario.changePassword();
            return usuarioRepository.save(usuario);
        } else {
            return null;
        }
    }

    public String generateToken(Usuario user) {
        if (user.validForLogin()) {
            Usuario userDb = usuarioRepository.findByEmail(user.getEmail());
            if (userDb != null) {
                if (ConversaoUtil.matches(user.getPassword(), userDb.getPassword())) {
                    return jwtTokenUtil.generateToken(userDb);
                }
            }
        }
        return null;
    }

    public Usuario buscarUsuarioPorToken(String token) {
        return usuarioRepository.findByEmail(jwtTokenUtil.getUsernameFromToken(token.substring(7)));
    }


    @EventListener(ApplicationReadyEvent.class)
    private void createIfDbIsEmpty() {

        if (usuarioRepository.count() == 0) {


            final String PERMISAO_ADMIN = "ADMIN";

            Permissao permissionAdm = permissaoRepository.save(new Permissao(PERMISAO_ADMIN));

            permissaoRepository.save(new Permissao(PERMISAO_PESSOA_FISICA));

            Usuario user = new Usuario();
            user.setEmail("admin");
            user.setSenha("123");
            user.setPermissoes(Collections.singleton(permissionAdm));
            user.changePassword();
            usuarioRepository.save(user);
        }
    }

}
