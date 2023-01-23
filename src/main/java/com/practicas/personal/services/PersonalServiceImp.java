package com.practicas.personal.services;

import com.practicas.personal.models.Personal;
import com.practicas.personal.repositories.PersonalRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class PersonalServiceImp implements PersonalService{
    private final PersonalRepository personalRepository;

    public PersonalServiceImp(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    @Override
    public List<Personal> listarPersonal() {
        return personalRepository.findAll();
    }

    @Override
    public Personal guardarPersonal(Personal personal) {
        return personalRepository.save(personal);
    }

    @Override
    public Personal obtenerPersonalPorId(Long id) {
        return personalRepository.findById(id).get();
    }

    @Override
    public Personal actualizarPersonal(Personal personal) {
        return personalRepository.save(personal);
    }

    @Override
    public void eliminarCuenta(Long id) {
        personalRepository.deleteById(id);
    }

    /*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personal personal = personalRepository.findByUsername(username);
        if(personal == null){
            throw new UsernameNotFoundException("Usuario o contraseña invalido.");
        }
        return new User(personal.getUsername(), personal.getPassword(), );


    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre()))
    }

     */
}
