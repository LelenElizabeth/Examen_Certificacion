package com.mc.gestor.clinica.app.algoritmo;

public class CalculoEdad implements CalculoDescuento {

	@Override
	public double descuento(String[] detalle) {

		if (detalle.length != 1) {
			throw new IllegalArgumentException("El detalle debe tener un largo de 1.");
		}
		
		if (!ValidadorUtil.esNumero(detalle[0])) {
			throw new IllegalArgumentException("El valor no es numerico.");
		}
		
		int edad = Integer.parseInt(detalle[0]);
		if (edad <= 5) {
			return 0.05; // 5% de descuento
		} else if (edad < 13) {
			return 0.03; // 3% de descuento
		} else if (edad <= 35) {
			return 0.0; // No hay descuento
		} else if (edad < 60) {
			return 0.10; // 10% de descuento
		} else {
			return 0.30; // 30% de descuento
		}
	}
}