package com.grupo5.theWalkingPets.service;

import com.grupo5.theWalkingPets.dto.UsuarioDTO;
import com.grupo5.theWalkingPets.dto.ViaCepDTO;
import com.grupo5.theWalkingPets.entity.Permissao;
import com.grupo5.theWalkingPets.entity.Usuario;
import com.grupo5.theWalkingPets.repository.PermissaoRepository;
import com.grupo5.theWalkingPets.repository.UsuarioRepository;
import com.grupo5.theWalkingPets.util.ConversaoUtil;
import com.grupo5.theWalkingPets.util.JwtTokenUtil;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PermissaoRepository permissaoRepository;

    private final JwtTokenUtil jwtTokenUtil;

    final String PERMISAO_PESSOA_FISICA = "PESSOA_FISICA";

    final String PERMISAO_PESSOA_JURIDICA = "PESSOA_JURIDICA";

    public UsuarioService(UsuarioRepository usuarioRepository, PermissaoRepository permissaoRepository, JwtTokenUtil jwtTokenUtil) {
        this.usuarioRepository = usuarioRepository;
        this.permissaoRepository = permissaoRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public boolean validoParaCriacao(Usuario usuario) {
        return !usuarioRepository.existsByEmail(usuario.getEmail());
    }

    public Usuario criarUsuario(UsuarioDTO usuario, ViaCepDTO viaCepDTO){
        if(usuario.getTipo().equals(PERMISAO_PESSOA_FISICA)){
            return criarUsuarioPessoaFisica(usuario.converterParaUsuarioComLocalizacao(viaCepDTO));
        }else if (usuario.getTipo().equals(PERMISAO_PESSOA_JURIDICA)){
            return criarUsuarioPessoaJuridica(usuario.converterParaUsuarioComLocalizacao(viaCepDTO));
        }
        return null;
    }


    private Usuario criarUsuarioPessoaJuridica(Usuario usuario) {
        usuario.setPermissoes(Collections.singletonList(permissaoRepository.findByNome(PERMISAO_PESSOA_FISICA)));
        return criar(usuario);
    }

    private Usuario criarUsuarioPessoaFisica(Usuario usuario) {
        usuario.setPermissoes(Collections.singletonList(permissaoRepository.findByNome(PERMISAO_PESSOA_FISICA)));
        return criar(usuario);
    }

    public List<UsuarioDTO> buscarUsuariosJuridicosPorCidade(String cidade){
        return converterParaDTO(usuarioRepository.findAllByCidade(cidade));
    }

    private List<UsuarioDTO> converterParaDTO(List<Usuario> usuarios){
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();

        for(Usuario usuario : usuarios){
            usuarioDTOS.add(usuario.converterParaDTO());
        }

        return usuarioDTOS;
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
            permissaoRepository.save(new Permissao(PERMISAO_PESSOA_JURIDICA));

            Usuario user = new Usuario();
            user.setEmail("admin");
            user.setSenha("123");
            user.setPermissoes(Collections.singleton(permissionAdm));
            user.changePassword();
            usuarioRepository.save(user);
        }
    }

}
