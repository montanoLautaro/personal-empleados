package com.practicas.personal.services;

import com.practicas.personal.models.Personal;
import com.practicas.personal.repositories.PersonalRepository;
import org.springframework.stereotype.Service;

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
}
