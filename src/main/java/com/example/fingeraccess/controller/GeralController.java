package com.example.fingeraccess.controller;

import java.util.List;

import com.example.fingeraccess.entidade.LeitorBiometrico;
import com.example.fingeraccess.entidade.Master;
import com.example.fingeraccess.entidade.Usuario;
import com.example.fingeraccess.service.GeralService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class GeralController {

    @Autowired
    private GeralService service;

    // -------------------- Leitor ------------------------------------------
    @GetMapping("/leitores")
    public ModelAndView getLeitoresBiometricos() {

        ModelAndView mv = new ModelAndView("leitoresBiometricosView");
        List<LeitorBiometrico> list = service.getLeitoresBiometricos();
        mv.addObject("leitores", list);
        return mv;
    }

    // -------------------- Usuário ----------------------------------------
    @GetMapping("/usuarios")
    public ModelAndView getUsuarios() {

        ModelAndView mv = new ModelAndView("usuariosView");
        List<Usuario> list = service.getUsuarios();

        mv.addObject("usuarios", list);

        return mv;
    }

    // -------------------- Master ------------------------------------------
    @GetMapping("/login")
    public ModelAndView getMaster() {
        ModelAndView mv = new ModelAndView("redirect: /app/login/loginView");
        //mv.addObject("masters", service.getMaster());
        mv.addObject("exist", true);
        return mv;
    }
    //Valida o login e senha inseridos
    @PostMapping("/login")
    public ModelAndView confereLogin(@ModelAttribute Master master) {
        ModelAndView mv = new ModelAndView();
        if (service.confereLogin(master))
            mv.setViewName("redirect: /app/login/masterView");
        else {
            mv.setViewName("redirect: /app/login/loginView");
            mv.addObject("exist", false);
        }

        return mv;

    }
}