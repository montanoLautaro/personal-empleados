package com.practicas.personal.services;

import com.practicas.personal.models.Cuenta;
import com.practicas.personal.repositories.CuentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CuentaServiceImp implements CuentaService{
    private CuentaRepository cuentaRepository;

    public CuentaServiceImp(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public List<Cuenta> listarCuentas() {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta guardarCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta obtenerCuentaPorId(Long id) {
        return cuentaRepository.findById(id).get();
    }

    @Override
    public Cuenta actualizarPersona(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public void eliminarCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }
}
