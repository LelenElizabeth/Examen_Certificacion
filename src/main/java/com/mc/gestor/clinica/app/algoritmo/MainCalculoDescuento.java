package com.mc.gestor.clinica.app.algoritmo;

public class MainCalculoDescuento {

	public static void main(String[] args) {
		//Descuento Edad
		CalculoDescuento descuentoEdad = new CalculoEdad();

        String[] detalle1 = { "5" };
        String[] detalle2 = { "12" };
        String[] detalle3 = { "8" };
        String[] detalle4 = { "63" };

        double descuento1 = descuentoEdad.descuento(detalle1);
        double descuento2 = descuentoEdad.descuento(detalle2);
        double descuento3 = descuentoEdad.descuento(detalle3);
        double descuento4 = descuentoEdad.descuento(detalle4);

        System.out.println("Descuento 1: " + (descuento1 * 100) + "%");
        System.out.println("Descuento 2: " + (descuento2 * 100) + "%");
        System.out.println("Descuento 3: " + (descuento3 * 100) + "%");
        System.out.println("Descuento 4: " + (descuento4 * 100) + "%");
        
        
        //Descuento Experiencia y Especialidad
        CalculoDescuento descuentoExperiencia = new CalculoEspecialidadExperiencia();
        
        String[] especialista1 = { "8", "Cardiologo" };
        String[] especialista2 = { "15", "Neurologo" };
        String[] especialista3 = { "10", "Endocrinologo" };
        String[] especialista4 = { "12", "Dermatologo" };
        String[] especialista5 = { "25", "Cirujano" };
        String[] especialista6 = { "3", "Oncologo" };

        double descuentoEspecialista1 = descuentoExperiencia.descuento(especialista1);
        double descuentoEspecialista2 = descuentoExperiencia.descuento(especialista2);
        double descuentoEspecialista3 = descuentoExperiencia.descuento(especialista3);
        double descuentoEspecialista4 = descuentoExperiencia.descuento(especialista4);
        double descuentoEspecialista5 = descuentoExperiencia.descuento(especialista5);
        double descuentoEspecialista6 = descuentoExperiencia.descuento(especialista6);

        System.out.println("Descuento para médico 1: " + (descuentoEspecialista1 * 100) + "%");
        System.out.println("Descuento para médico 2: " + (descuentoEspecialista2 * 100) + "%");
        System.out.println("Descuento para médico 3: " + (descuentoEspecialista3 * 100) + "%");
        System.out.println("Descuento para médico 4: " + (descuentoEspecialista4 * 100) + "%");
        System.out.println("Descuento para médico 5: " + (descuentoEspecialista5 * 100) + "%");
        System.out.println("Descuento para médico 6: " + (descuentoEspecialista6 * 100) + "%");
	}
}