package com.mc.gestor.clinica.app.algoritmo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculoEdadTest {

	@Test
	void testDescuentoMenorDe5() {
		CalculoEdad calculoEdad = new CalculoEdad();
		String[] detalle = { "3" };
		double descuento = calculoEdad.descuento(detalle);
		assertEquals(0.05, descuento);
	}
	
	@Test
    void testDescuentoEntre5Y12() {
        CalculoEdad calculoEdad = new CalculoEdad();
        String[] detalle = {"10"};
        double descuento = calculoEdad.descuento(detalle);
        assertEquals(0.03, descuento);
    }
	
	@Test
    void testDescuentoEntre60YMayor() {
        CalculoEdad calculoEdad = new CalculoEdad();
        String[] detalle = {"65"};
        double descuento = calculoEdad.descuento(detalle);
        assertEquals(0.30, descuento);
    }
	
	@Test
    void testDetalleLargoInvalido() {
        CalculoEdad calculoEdad = new CalculoEdad();
        String[] detalle = {"20", "30"};
        assertThrows(IllegalArgumentException.class, () -> calculoEdad.descuento(detalle));
    }
}