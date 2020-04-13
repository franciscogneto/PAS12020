package com.example.fingeraccess.service;

import java.util.List;

import com.example.fingeraccess.entidade.LeitorBiometrico;
import com.example.fingeraccess.entidade.Master;
import com.example.fingeraccess.entidade.Usuario;
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

    // -------------------- Usuário ----------------------------------------
    /**
     * Método responsável em retornar todos os usuários do Banco de Dados
     * 
     * @return Lista de usuários do Banco de Dados
     */
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
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

    // ------------------- Master ---------------------------------------------
    /**
     * Método responsável em retornar todos os logins masters do Banco de Dados
     * 
     * @return Lista de usuários do Banco de Dados
     */
    public List<Master> getMaster() {
        return masterRepository.findAll();
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
                return true;
        }
        return false;
    }

}