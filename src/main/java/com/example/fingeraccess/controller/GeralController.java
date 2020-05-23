package com.example.fingeraccess.controller;

import java.util.Optional;
import com.example.fingeraccess.entidade.Cadastro;
import com.example.fingeraccess.entidade.IdCadastro;
import com.example.fingeraccess.entidade.LeitorBiometrico;
import com.example.fingeraccess.entidade.Master;
import com.example.fingeraccess.entidade.Usuario;
import com.example.fingeraccess.repository.AcessoRepository;
import com.example.fingeraccess.repository.CadastroRepository;
import com.example.fingeraccess.repository.LeitorBiometricoRepository;
import com.example.fingeraccess.repository.UsuarioRepository;
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
    @Autowired
    private UsuarioRepository usuarioRep;
    @Autowired
    private CadastroRepository cadastroRep;
    @Autowired
    private AcessoRepository acessoRep;

    // -------------------- Leitor ------------------------------------------
    @GetMapping("/leitores")
    public String showLeitoresPage(Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("data", leitorRep.findAll(PageRequest.of(page, 4)));

        model.addAttribute("currentPage", page);

        return "leitoresView";
    }

    @PostMapping("/saveLeitor")
    public String saveLeitor(LeitorBiometrico leitor) {

        service.addLeitorBiometrico(leitor);

        return "redirect:/app/leitores";
    }

    @GetMapping("/deleteLeitor")
    public String deleteLeitor(Long id) {

        // service.deleteLeitorBiometrico(id);

        leitorRep.deleteById(id);

        return "redirect:/app/leitores";
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
    public String showUsuariosPage(Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("data", usuarioRep.findAll(PageRequest.of(page, 4)));

        model.addAttribute("currentPage", page);

        return "usuariosView";
    }

    @PostMapping("/saveUsuario")
    public String saveUsuario(Usuario usuario) {

        service.addUsuario(usuario);

        return "redirect:/app/usuarios";
    }

    @GetMapping("/deleteUsuario")
    public String deleteUsuario(Long id) {

        usuarioRep.deleteById(id);

        return "redirect:/app/usuarios";
    }

    @GetMapping("/findOneUsuario")
    @ResponseBody
    public Optional<Usuario> findOneUsuario(Long id) {

        return usuarioRep.findById(id);
    }

    /*@GetMapping("/usuarios")
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
    }*/

    // -------------------- Cadastro ----------------------------------------
    @GetMapping("/cadastros")
    public String showCadastrosPage(Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("cadastro",  new Cadastro());
        model.addAttribute("data", cadastroRep.findAll(PageRequest.of(page, 4)));

        model.addAttribute("currentPage", page);

        model.addAttribute("leitores", leitorRep.findAll());
        model.addAttribute("usuarios", usuarioRep.findAll());

        return "cadastrosView";
    }

    @PostMapping("/saveCadastro")
    public String saveCadastro(Cadastro cadastro) {

        service.addCadastro(cadastro);

        return "redirect:/app/cadastros";
    }

    @GetMapping("/deleteCadastro")
    public String deleteCadastro(IdCadastro idCadastro) {

        cadastroRep.deleteById(idCadastro);

        return "redirect:/app/cadastros";
    }

    @GetMapping("/findOneCadastro")
    @ResponseBody
    public Cadastro findOneCadastro(Long idCadastro, Long idLeitorBiometrico) {
        return cadastroRep.findByIdCadastroAndIdLeitorBiometrico(idCadastro, idLeitorBiometrico);
    }
    
    /*@GetMapping("/cadastros")
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
    }*/

    // -------------------- Acesso ----------------------------------------
    @GetMapping("/acessos")
    public String showAcessosPage(Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("data", acessoRep.findAll(PageRequest.of(page, 4)));

        model.addAttribute("currentPage", page);

        return "acessosView";
    }

    // -------------------- Master ------------------------------------------
    @GetMapping("/login")
    public ModelAndView getMaster() {
        ModelAndView mv = new ModelAndView("login/loginView");
        return mv;
    }
    //Valida o login e senha inseridos
    @PostMapping("/login")
    public ModelAndView confereLogin(@ModelAttribute Master master) {

        ModelAndView mv = new ModelAndView();
        if (service.confereLogin(master))
            mv.setViewName("/Menu/menuView");
        else {
            mv.setViewName("login/loginErrorView");
        }

        return mv;
    }

    @PostMapping("/updateMaster")
    public String updateMaster(Master master) {

        service.saveMaster(master);

        return "redirect:/app/menu";
    }

    @GetMapping("/findMasterAtual")
    @ResponseBody
    public Master findMasterAtual() {

        Master masterAtual = service.getMasterAtual();

        return masterAtual;
    }

    @GetMapping("/menu")
    public String returnToMenu(){
        return "/Menu/menuView";
    }
}