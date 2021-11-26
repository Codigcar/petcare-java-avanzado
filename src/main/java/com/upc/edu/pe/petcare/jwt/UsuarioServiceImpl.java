package com.upc.edu.pe.petcare.jwt;


import com.upc.edu.pe.petcare.exception.ModelNotFoundException;
import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.repository.AccountRepository;
import com.upc.edu.pe.petcare.repository.GenericRepository;
import com.upc.edu.pe.petcare.repository.PersonProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//UserDetailsService: para recuperar un nombre de usuario, contraseña y otros atributos para autenticarse con un nombre de usuario y contraseña.
@Service
public class UsuarioServiceImpl implements UserDetailsService{


    @Autowired
    private AccountRepository accountRepository;
/*
    @Autowired
    private PersonProfileRepository personProfileRepository;

*/
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
/*
        Usuario usuario = repo.findOneByUsername(username);

        if(usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        usuario.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        });

        UserDetails ud = new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(), true, true, true, roles);

        return ud;

 */
        Account accountDB = accountRepository.findOneByEmail(email);
        //PersonProfile personProfileDB = personProfileRepository.findPersonProfileByAccount_Id(accountDB.getId());


        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(accountDB.getRol().getName()));

        UserDetails ud = new User(accountDB.getEmail(), accountDB.getPassword(), true, true, true, true, roles);

        return ud;
    }

}
