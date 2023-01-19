package com.practicas.personal.services;

import com.practicas.personal.models.Cuenta;

import java.util.List;

public interface CuentaService {
    public List<Cuenta>listarCuentas();
    public Cuenta guardarCuenta(Cuenta cuenta);
    public Cuenta obtenerCuentaPorId(Long id);
    public Cuenta actualizarPersona(Cuenta cuenta);
    public void eliminarCuenta(Long id);
}
