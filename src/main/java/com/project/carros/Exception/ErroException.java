package com.project.carros.Exception;

import java.io.Serializable;

public class ErroException implements Serializable {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String erro;
	
	public ErroException(String erro) {
		 this.erro = erro;
	}
	
	public String getErro() {
		return erro;
	}
}
