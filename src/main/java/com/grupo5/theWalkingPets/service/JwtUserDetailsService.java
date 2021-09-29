package com.grupo5.theWalkingPets.service;

import com.grupo5.theWalkingPets.entity.Usuario;
import com.grupo5.theWalkingPets.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario user = userService.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }else {
            return new org.springframework.security.core.userdetails.User(email, user.getPassword(),user.getAuthorities());
        }

    }
}
