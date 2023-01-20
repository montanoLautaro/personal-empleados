package com.practicas.personal.controllers;

import com.practicas.personal.models.Personal;
import com.practicas.personal.services.CuentaService;
import com.practicas.personal.services.PersonalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class  PersonalController {
    private final CuentaService cuentaService;
    private final PersonalService personalService;

    public PersonalController(CuentaService cuentaService, PersonalService personalService) {
        this.cuentaService = cuentaService;
        this.personalService = personalService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){return "login";}

    @GetMapping("/registro")
    public String mostrarFormularioCrearPersona(Model model){
        Personal personal = new Personal();
        model.addAttribute("personal", personal);
        return "registro";
    }

}
