package com.practicas.personal.controllers;

import com.practicas.personal.models.Personal;
import com.practicas.personal.services.PersonalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class  PersonalController{
    private final PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String formularioLogin(@ModelAttribute("personal") Personal personal, Model model ){
        ArrayList<Personal> personalList = (ArrayList<Personal>) personalService.listarPersonal();

        for (Personal aux: personalList) {
            if(aux.getUsername().equals(personal.getUsername())){
                if(aux.getPassword().equals(personal.getPassword())){
                    return "mensaje_bienvenida";
                }
            }
        }
        model.addAttribute("invalidCredentials", true);
        return "login";
    }

    @GetMapping("/registro")
    public String mostrarFormularioCrearPersona(Model model){
        Personal personal = new Personal();
        personal.setRol("user");
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
