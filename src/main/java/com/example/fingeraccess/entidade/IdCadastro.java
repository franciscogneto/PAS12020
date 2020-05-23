package com.example.fingeraccess.entidade;

import java.io.Serializable;

public class IdCadastro implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

	private long idCadastro;

    private long idLeitorBiometrico;
 
    public IdCadastro() {
    }

    public IdCadastro(long idCadastro, long idLeitorBiometrico) {
        this.idCadastro = idCadastro;
        this.idLeitorBiometrico = idLeitorBiometrico;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCadastro ^ (idCadastro >>> 32));
		result = prime * result + (int) (idLeitorBiometrico ^ (idLeitorBiometrico >>> 32));
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
		if (idLeitorBiometrico != other.idLeitorBiometrico)
			return false;
		return true;
	}
}