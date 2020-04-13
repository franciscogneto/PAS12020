package com.example.fingeraccess.controller;

import java.util.List;

import com.example.fingeraccess.entidade.LeitorBiometrico;
import com.example.fingeraccess.service.LeitorBiometricoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LeitorBiometricoController {

    @Autowired
    private LeitorBiometricoService service;
    
    @GetMapping("/leitores")
    public ModelAndView getLeitoresBiometricos(){

        ModelAndView mv = new ModelAndView("leitoresBiometricosView");
        List <LeitorBiometrico> list = service.getLeitoresBiometricos();
        
        mv.addObject("leitores", list);

        return mv;
    }
}