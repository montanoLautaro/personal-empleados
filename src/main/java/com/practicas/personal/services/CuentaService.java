package com.practicas.personal.services;

import com.practicas.personal.models.Cuenta;

import java.util.List;

public interface CuentaService {
    List<Cuenta>listarCuentas();
    Cuenta guardarCuenta(Cuenta cuenta);
    Cuenta obtenerCuentaPorId(Long id);
    Cuenta actualizarPersona(Cuenta cuenta);
    void eliminarCuenta(Long id);
}
