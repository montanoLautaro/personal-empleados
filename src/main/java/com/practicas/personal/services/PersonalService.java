package com.practicas.personal.services;

import com.practicas.personal.models.Cuenta;
import com.practicas.personal.models.Personal;

import java.util.List;

public interface PersonalService {
    public List<Personal> listarPersonal();
    public Personal guardarPersonal(Personal personal);
    public Personal obtenerPersonalPorId(Long id);
    public Personal actualizarPersonal(Personal personal);
    public void eliminarCuenta(Long id);
}
