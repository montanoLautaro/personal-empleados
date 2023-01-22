package com.practicas.personal.controllers;

import com.practicas.personal.models.Personal;
import com.practicas.personal.services.CuentaService;
import com.practicas.personal.services.PersonalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class  PersonalController{
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

    @PostMapping("/registro")
    public String crearPersonal(@ModelAttribute("personal") Personal personal){
        personalService.guardarPersonal(personal);
        return "redirect:/login";
    }

    @GetMapping("/login/lista_admin")
    public String listarPersonalAdmin(Model modelo){
        modelo.addAttribute("personal", personalService.listarPersonal());
        return "lista_admin";
    }
    @GetMapping("/login/lista_user")
    public String listarPersonalUser(Model modelo){
        modelo.addAttribute("personal", personalService.listarPersonal());
        return "lista_user";
    }
}
