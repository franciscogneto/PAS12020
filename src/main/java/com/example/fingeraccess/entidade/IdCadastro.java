package com.example.fingeraccess.entidade;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class IdCadastro implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private long idCadastro;
 
    @OneToOne
    @JoinColumn(name="idLeitor", referencedColumnName="ID")
    private LeitorBiometrico leitorBiometrico;
 
    public IdCadastro() {
    }

    public IdCadastro(long idCadastro, LeitorBiometrico leitorBiometrico) {
        this.idCadastro = idCadastro;
        this.leitorBiometrico = leitorBiometrico;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCadastro ^ (idCadastro >>> 32));
		result = prime * result + ((leitorBiometrico == null) ? 0 : leitorBiometrico.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdCadastro other = (IdCadastro) obj;
		if (idCadastro != other.idCadastro)
			return false;
		if (leitorBiometrico == null) {
			if (other.leitorBiometrico != null)
				return false;
		} else if (!leitorBiometrico.equals(other.leitorBiometrico))
			return false;
		return true;
	}
}