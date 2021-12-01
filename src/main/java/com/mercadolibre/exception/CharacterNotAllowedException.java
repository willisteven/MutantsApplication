package com.mercadolibre.exception;

public class CharacterNotAllowedException extends Exception {

	private String code;

	public CharacterNotAllowedException(String message) {
		super(message);
	}

	public CharacterNotAllowedException(String code, String message, Throwable cause) {
		super(message, cause);
		this.setCode(code);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}