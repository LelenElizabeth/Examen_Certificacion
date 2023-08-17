package com.mc.gestor.clinica.app.algoritmo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculoEspecialidadExperienciaTest {

	@Test
	void testDescuentoExperienciaMenor10() {
		CalculoEspecialidadExperiencia calculo = new CalculoEspecialidadExperiencia();
		String[] detalle = { "5", "Cardiologo" };
		double descuento = calculo.descuento(detalle);
		assertEquals(0.15, descuento);
	}

	@Test
	void testDescuentoEspecialidadCardiologoExperienciaEntre10Y20() {
		CalculoEspecialidadExperiencia calculo = new CalculoEspecialidadExperiencia();
		String[] detalle = { "15", "Cardiologo" };
		double descuento = calculo.descuento(detalle);
		assertEquals(0.05, descuento);
	}
	
	@Test
	void testDescuentoExperienciaMayor20() {
		CalculoEspecialidadExperiencia calculo = new CalculoEspecialidadExperiencia();
		String[] detalle = { "25", "Neurologo" };
		double descuento = calculo.descuento(detalle);
		assertEquals(0.05, descuento);
	}
	
	@Test
    void testDetalleLargoInvalido() {
        CalculoEspecialidadExperiencia calculo = new CalculoEspecialidadExperiencia();
        String[] detalle = {"10", "Cardiologo", "extra"};
        assertThrows(IllegalArgumentException.class, () -> calculo.descuento(detalle));
    }
}