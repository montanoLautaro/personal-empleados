package com.practicas.personal.services;

import com.practicas.personal.models.Personal;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface PersonalService {
    List<Personal> listarPersonal();
    Personal guardarPersonal(Personal personal);
    Personal obtenerPersonalPorId(Long id);
    Personal actualizarPersonal(Personal personal);
    void eliminarCuenta(Long id);

}
