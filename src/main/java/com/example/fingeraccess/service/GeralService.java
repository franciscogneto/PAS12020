package com.example.fingeraccess.service;

import java.util.List;

import com.example.fingeraccess.entidade.Acesso;
import com.example.fingeraccess.entidade.Cadastro;
import com.example.fingeraccess.entidade.LeitorBiometrico;
import com.example.fingeraccess.entidade.Master;
import com.example.fingeraccess.entidade.Usuario;
import com.example.fingeraccess.repository.AcessoRepository;
import com.example.fingeraccess.repository.CadastroRepository;
import com.example.fingeraccess.repository.LeitorBiometricoRepository;
import com.example.fingeraccess.repository.MasterRepository;
import com.example.fingeraccess.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeralService {

    @Autowired
    private MasterRepository masterRepository;
    @Autowired
    private LeitorBiometricoRepository leitorRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CadastroRepository cadastroRepository;
    @Autowired
    private AcessoRepository acessoRepository;

    private String usuarioAtual;

    // -------------------- Usuário ----------------------------------------
    /**
     * Método responsável em retornar todos os usuários do Banco de Dados
     * 
     * @return Lista de usuários do Banco de Dados
     */
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    /**
     * Método responsável em cadastrar um novo usuário no Banco de Dados
    */
    public void addUsuario(Usuario usuario)
    {
        if(usuarioRepository.existsById(usuario.getIdUsuario()))
        {
            usuario.setCadastros(usuarioRepository.findById(usuario.getIdUsuario()).get().getCadastros());
            usuario.setAcessos(usuarioRepository.findById(usuario.getIdUsuario()).get().getAcessos());
        }

        usuarioRepository.save(usuario);
    }

    

    // -------------------- Leitor ------------------------------------------

    /**
     * Método responsável em retornar todos os leitores do Banco de Dados
     * 
     * @return Lista de usuários do Banco de Dados
     */
    public List<LeitorBiometrico> getLeitoresBiometricos() {
        return leitorRepository.findAll();
    }

    /**
     * Método responsável em cadastrar um novo Leitor Biometrico no Banco de Dados
    */
    public void addLeitorBiometrico(LeitorBiometrico leitorBiometrico)
    {
        if(leitorRepository.existsById(leitorBiometrico.getIdLeitor()))
        {
            leitorBiometrico.setCadastros(leitorRepository.findById(leitorBiometrico.getIdLeitor()).get().getCadastros());
            leitorBiometrico.setAcessos(leitorRepository.findById(leitorBiometrico.getIdLeitor()).get().getAcessos());
        }

        leitorRepository.save(leitorBiometrico);
    }

    // -------------------- Cadastro ------------------------------------------

    /**
     * Método responsável em retornar todos os cadastros de usuários em leitores biométricos do Banco de Dados
     * 
     * @return Lista de cadastros de usuários em leitores biométricos do Banco de Dados
     */
    public List<Cadastro> getCadastros() {
        return cadastroRepository.findAll();
    }

    /**
     * Método responsável em cadastrar um novo cadastro de usuário em um leitor biométrico do Banco de Dados
    */
    public void addCadastro(Cadastro cadastro)
    {
        cadastro.setIdLeitorBiometrico(cadastro.getLeitorBiometrico().getIdLeitor());
        cadastroRepository.save(cadastro);
    }

    // -------------------- Acesso ------------------------------------------

    /**
     * Método responsável em retornar todos os acessos de usuários em leitores biométricos do Banco de Dados
     * 
     * @return Lista de acessos de usuários em leitores biométricos do Banco de Dados
     */
    public List<Acesso> getAcessos() {
        return acessoRepository.findAll();
    }

    // ------------------- Master ---------------------------------------------
    /**
     * Método responsável em retornar todos os logins masters do Banco de Dados
     * 
     * @return Lista de usuários do Banco de Dados
     */
    public List<Master> getMaster() {
        return masterRepository.findAll();
    }

    public Master getMasterAtual() {

        return masterRepository.findByUsuario(usuarioAtual);
    }

    /**
     * Método responsável em retornar se o login existe ou não no Banco de Dados
     * 
     * @param Master
     * @return True se existir tal login ou False caso não exista
     */
    public boolean confereLogin(Master master) {
        for (Master aux : masterRepository.findAll()) {
            if (aux.getUsuario().equals(master.getUsuario()) && aux.getPassword().equals(master.getPassword()))
            {
                usuarioAtual = master.getUsuario();
                return true;              
            }
               
        }
        return false;
    }

    /**
     * Método responsável em cadastrar um novo login master no Banco de Dados
    */
    public void saveMaster(Master loginMaster)
    {
        usuarioAtual = loginMaster.getUsuario();
        masterRepository.save(loginMaster);
    }
}