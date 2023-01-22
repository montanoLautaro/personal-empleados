package com.practicas.personal.controllers;

import com.practicas.personal.models.Cuenta;
import com.practicas.personal.models.Personal;
import com.practicas.personal.services.CuentaService;
import com.practicas.personal.services.PersonalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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

    //PROBANDO
    @PostMapping("/loginCheck")
    public String checkLogin(@ModelAttribute("personal") Personal personal) {
        if (personalService.checkUser(personal)) {
            return "redirect:/registro_hora";
        } else {
            return "registro";
        }
    }
    //PROBANDO

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
    //NUEVO
    @GetMapping("/registro_hora")
    public String mostrarFormularioCrearHorario(Model model){
        Cuenta cuenta = new Cuenta();
        model.addAttribute("cuenta", cuenta);
        return "registro_hora";
    }
    @PostMapping("/registro_hora")
    public String guardarHora(@ModelAttribute("cuenta") Cuenta cuenta){
        cuentaService.guardarCuenta(cuenta);
        return "redirect:/login/lista_admin";
    }
    //NUEVO

    /**
    @GetMapping("/login/lista_user")
    public String listarPersonalUser(Model modelo){
        modelo.addAttribute("personal", personalService.listarPersonal());
        return "lista_user";
    }
    **/
}
