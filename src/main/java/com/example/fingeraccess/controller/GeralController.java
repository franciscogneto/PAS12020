package com.example.fingeraccess.controller;

import java.util.Optional;

import com.example.fingeraccess.entidade.Acesso;
import com.example.fingeraccess.entidade.Cadastro;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String saveLeitor(RedirectAttributes redirAttr, LeitorBiometrico leitor) {

        if(!leitor.getLocal().trim().isEmpty() && !leitor.getFabricante().trim().isEmpty() && !leitor.getSenha().trim().isEmpty() && leitor.getCapacidade() > 0)
        {
            service.addLeitorBiometrico(leitor);
        }
        else
        {
            redirAttr.addFlashAttribute("verifyEdit", true);
        }
       
        return "redirect:/app/leitores";
    }

    @GetMapping("/deleteLeitor")
    public String deleteLeitor(RedirectAttributes redirAttr, Long id) {

        if(leitorRep.findById(id).get().getCadastros().isEmpty() && leitorRep.findById(id).get().getAcessos().isEmpty())
        {
            leitorRep.deleteById(id);
        }
        else
        {
            redirAttr.addFlashAttribute("verifyDelete", true);
        }
       
        return "redirect:/app/leitores";
    }

    @GetMapping("/findOneLeitor")
    @ResponseBody
    public Optional<LeitorBiometrico> findOneLeitor(Long id) {

        return leitorRep.findById(id);
    }

    @GetMapping("/detalhesLeitor/{id}")
    public ModelAndView getLeitorDetalhes(@PathVariable(name = "id") Long id) {

        LeitorBiometrico leitor = leitorRep.findById(id).get();
        ModelAndView mv = new ModelAndView("detalhesLeitorBiometrico");
        mv.addObject("leitor", leitor);

        return mv;
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
    public String saveUsuario(RedirectAttributes redirAttr, Usuario usuario) {

        if(!usuario.getNome().trim().isEmpty() && !usuario.getCpf().trim().isEmpty() && !usuario.getDatanasc().trim().isEmpty() &&
        !usuario.getCidade().trim().isEmpty() && !usuario.getEndereco().trim().isEmpty() && !usuario.getEmail().trim().isEmpty() &&
        !usuario.getTelefone().trim().isEmpty() && !usuario.getCelular().trim().isEmpty()){
            service.addUsuario(usuario);
        }
        else
        {
            redirAttr.addFlashAttribute("verifyEdit", true);
        }

        return "redirect:/app/usuarios";
    }

    @GetMapping("/deleteUsuario")
    public String deleteUsuario(RedirectAttributes redirAttr, Long id) {

        if(usuarioRep.findById(id).get().getCadastros().isEmpty() && usuarioRep.findById(id).get().getAcessos().isEmpty())
        {
            usuarioRep.deleteById(id);
        }
        else
        {
            redirAttr.addFlashAttribute("verifyDelete", true);
        }
    
        return "redirect:/app/usuarios";
    }

    @GetMapping("/findOneUsuario")
    @ResponseBody
    public Optional<Usuario> findOneUsuario(Long id) {

        return usuarioRep.findById(id);
    }

    @GetMapping("/detalhesUsuario/{id}")
    public ModelAndView getUsuarioDetalhes(@PathVariable(name = "id") Long id) {

        Usuario usuario = usuarioRep.findById(id).get();
        ModelAndView mv = new ModelAndView("detalhesUsuario");
        mv.addObject("usuario", usuario);

        return mv;
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
    public String saveCadastro(RedirectAttributes redirAttr, Cadastro cadastro) {

        if(cadastro.getIdCadastro() > 0 && !cadastro.getDataCadastro().trim().isEmpty())
        {
            service.addCadastro(cadastro);
        }
        else
        {
            redirAttr.addFlashAttribute("verifyEdit", true);
        }

        return "redirect:/app/cadastros";
    }

    @GetMapping("/deleteCadastro")
    public String deleteCadastro(Long idCadastro, Long idLeitorBiometrico) {

        cadastroRep.delete(cadastroRep.findByIdCadastroAndIdLeitorBiometrico(idCadastro, idLeitorBiometrico));

        return "redirect:/app/cadastros";
    }

    @GetMapping("/findOneCadastro")
    @ResponseBody
    public Cadastro findOneCadastro(Long idCadastro, Long idLeitorBiometrico) {
        return cadastroRep.findByIdCadastroAndIdLeitorBiometrico(idCadastro, idLeitorBiometrico);
    }
    
    @GetMapping("/detalhesCadastro/{idCadastro}/{idLeitorBiometrico}")
    public ModelAndView getCadastroDetalhes(@PathVariable(name = "idCadastro") Long idCadastro, @PathVariable(name = "idLeitorBiometrico") Long idLeitorBiometrico) {

        Cadastro cadastro = cadastroRep.findByIdCadastroAndIdLeitorBiometrico(idCadastro, idLeitorBiometrico);
        ModelAndView mv = new ModelAndView("detalhesCadastro");
        mv.addObject("cadastro", cadastro);

        return mv;
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

    @GetMapping("/detalhesAcesso/{num}")
    public ModelAndView getAcessoDetalhes(@PathVariable(name = "num") Long num) {

        Acesso acesso = acessoRep.findById(num).get();
        ModelAndView mv = new ModelAndView("detalhesAcesso");
        mv.addObject("acesso", acesso);

        return mv;
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