package com.example.fingeraccess.controller;

import java.util.List;
import java.util.Optional;

import com.example.fingeraccess.entidade.Acesso;
import com.example.fingeraccess.entidade.Cadastro;
import com.example.fingeraccess.entidade.LeitorBiometrico;
import com.example.fingeraccess.entidade.Master;
import com.example.fingeraccess.entidade.Usuario;
import com.example.fingeraccess.repository.LeitorBiometricoRepository;
import com.example.fingeraccess.service.GeralService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class GeralController {

    @Autowired
    private GeralService service;

    @Autowired
    private LeitorBiometricoRepository leitorRep;

    // -------------------- Leitor ------------------------------------------
    @GetMapping("/leitores")
    public String showLeitoresPage(Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("data", leitorRep.findAll(PageRequest.of(page, 4)));

        return "leitoresView";
    }

    @PostMapping("/saveLeitor")
    public String saveLeitor(LeitorBiometrico leitor) {

        service.addLeitorBiometrico(leitor);

        return "redirect:/leitores";
    }

    @GetMapping("/deleteLeitor")
    public String deleteLeitor(Long id) {

        // service.deleteLeitorBiometrico(id);

        leitorRep.deleteById(id);

        return "redirect:/leitores";
    }

    @GetMapping("/findOneLeitor")
    @ResponseBody
    public Optional<LeitorBiometrico> findOneLeitor(Long id) {

        return leitorRep.findById(id);
    }

    /*@GetMapping("/leitores")
    public ModelAndView getLeitoresBiometricos() {

        ModelAndView mv = new ModelAndView("leitoresBiometricosView");

        List<LeitorBiometrico> list = service.getLeitoresBiometricos();

        mv.addObject("leitores", list);

        return mv;
    }

    @GetMapping("/cadastroLeitor")
    public String cadastroLeitor(){

        return "cadastroLeitorView";
    }

    @PostMapping("/salvaLeitor")
    public ModelAndView salvaLeitor(@ModelAttribute LeitorBiometrico leitorBiometrico) {

        ModelAndView mv = new ModelAndView();

        if(leitorBiometrico.getLocal().trim().isEmpty() || leitorBiometrico.getCapacidade() <= 0 || leitorBiometrico.getFabricante().trim().isEmpty() || leitorBiometrico.getSenha().trim().isEmpty())
        {
            mv.setViewName("errorView");         
        }
        else
        {
            service.addLeitorBiometrico(leitorBiometrico);

            mv.setViewName("redirect:/app/cadastroLeitor");
        }

        return mv;
    }*/

    // -------------------- Usuário ----------------------------------------
    @GetMapping("/usuarios")
    public ModelAndView getUsuarios() {

        ModelAndView mv = new ModelAndView("usuariosView");
        
        List<Usuario> list = service.getUsuarios();

        mv.addObject("usuarios", list);

        return mv;
    }

    @GetMapping("/cadastroUsuario")
    public String cadastroUsuario(){

        return "cadastroUsuarioView";
    }

    @PostMapping("/salvaUsuario")
    public ModelAndView salvaUsuario(@ModelAttribute Usuario usuario) {

        ModelAndView mv = new ModelAndView();

        if(usuario.getNome().trim().isEmpty() || usuario.getCpf().trim().isEmpty() || usuario.getDatanasc().trim().isEmpty()
            || usuario.getCidade().trim().isEmpty() || usuario.getEndereco().trim().isEmpty() || usuario.getEmail().trim().isEmpty()
            || usuario.getTelefone().trim().isEmpty() || usuario.getCelular().trim().isEmpty())
        {
            mv.setViewName("errorView");         
        }
        else
        {
            service.addUsuario(usuario);

            mv.setViewName("redirect:/app/cadastroUsuario");
        }

        return mv;
    }

    // -------------------- Cadastro ----------------------------------------
    @GetMapping("/cadastros")
    public ModelAndView getCadastros() {

        ModelAndView mv = new ModelAndView("cadastrosView");
        
        List<Cadastro> list = service.getCadastros();

        mv.addObject("cadastros", list);

        return mv;
    }

    @GetMapping("/cadastroCadastro")
    public String cadastroCadastro(){

        return "cadastroCadastroView";
    }

    @PostMapping("/salvaCadastro")
    public ModelAndView salvaCadastro(@ModelAttribute Cadastro cadastro) {

        ModelAndView mv = new ModelAndView();

        if(cadastro.getIdCadastro() < 0 || cadastro.getIdCadastro() >= cadastro.getLeitorBiometrico().getCapacidade() || cadastro.getDataCadastro().trim().isEmpty())
        {
            mv.setViewName("errorView");         
        }
        else
        {
            service.addCadastro(cadastro);

            mv.setViewName("redirect:/app/cadastroCadastro");
        }

        return mv;
    }

    // -------------------- Acesso ----------------------------------------
    @GetMapping("/acessos")
    public ModelAndView getAcessos() {

        ModelAndView mv = new ModelAndView("acessosView");
        
        List<Acesso> list = service.getAcessos();

        mv.addObject("acessos", list);

        return mv;
    }

    // -------------------- Master ------------------------------------------
    @GetMapping("/login")
    public ModelAndView getMaster() {
        ModelAndView mv = new ModelAndView("login/loginView");
        //mv.addObject("masters", service.getMaster());
        //mv.addObject("exist", true);
        return mv;
    }
    //Valida o login e senha inseridos
    @PostMapping("/login")
    public ModelAndView confereLogin(@ModelAttribute Master master) {
        ModelAndView mv = new ModelAndView();
        System.out.println(master);
        if (service.confereLogin(master))
            mv.setViewName("login/masterView");
        else {
            mv.setViewName("login/loginView");
        }

        return mv;

    }
}