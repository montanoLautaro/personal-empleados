package com.practicas.personal.controllers;

import com.practicas.personal.services.CuentaService;
import com.practicas.personal.services.PersonalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class  PersonalController {
    private CuentaService cuentaService;
    private PersonalService personalService;

    public PersonalController(CuentaService cuentaService, PersonalService personalService) {
        this.cuentaService = cuentaService;
        this.personalService = personalService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }


}
