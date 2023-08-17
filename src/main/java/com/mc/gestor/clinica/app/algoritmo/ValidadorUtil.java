package com.mc.gestor.clinica.app.algoritmo;

public class ValidadorUtil {

	public static boolean esNumero(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean esNull(String valor) {
		return valor == null || valor == "";
	}
}
