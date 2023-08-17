package com.mc.gestor.clinica.app.algoritmo;

public class CalculoEspecialidadExperiencia implements CalculoDescuento {

	@Override
	public double descuento(String[] detalle) {
		
		if (detalle.length != 2 ) {
			throw new IllegalArgumentException("El detalle debe tener un largo de 2.");
		}
		
		if (!ValidadorUtil.esNumero(detalle[0])) {
			throw new IllegalArgumentException("El valor 1 no es numerico.");
		}
		
		if (ValidadorUtil.esNull(detalle[1])) {
			throw new IllegalArgumentException("El valor 2 no puede ser null ni vacio.");
		}
		
		int experiencia = Integer.parseInt(detalle[0]);
		String especialidad = detalle[1];

		if (experiencia < 10) {
			return 0.15; // 15% de descuento
		} else if ((especialidad.equals("Cardiologo") || especialidad.equals("Neurologo")) && experiencia > 10
				&& experiencia < 20) {
			return 0.05; // 5% de descuento
		} else if ((especialidad.equals("Endocrinologo") || especialidad.equals("Oncologo")) && experiencia > 5) {
			return 0.10; // 10% de descuento
		} else if (especialidad.equals("Dermatologo")) {
			return 0.0; // No hay descuento
		} else if (experiencia > 20) {
			return 0.05; // 5% de descuento
		} else {
			return 0.0; // No hay descuento por defecto
		}
	}
}