package com.example.fingeraccess.controller;

import java.util.List;

import com.example.fingeraccess.entidade.Usuario;
import com.example.fingeraccess.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * UsuarioController
 */

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService service;
    
    @GetMapping("/usuarios")
    public ModelAndView getUsuarios(){

        ModelAndView mv = new ModelAndView("usuariosView");
        List <Usuario> list = service.getUsuarios();
        
        mv.addObject("usuarios", list);

        return mv;
    }
}