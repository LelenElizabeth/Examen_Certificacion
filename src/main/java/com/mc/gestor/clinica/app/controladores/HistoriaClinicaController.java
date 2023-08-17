package com.mc.gestor.clinica.app.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mc.gestor.clinica.app.entidades.HistoriaClinica;
import com.mc.gestor.clinica.app.servicios.HistoriaClinicaServicio;

@RestController
@RequestMapping(path = "/api/historia-clinica", produces = MediaType.APPLICATION_JSON_VALUE)
public class HistoriaClinicaController {

	@Autowired
	private HistoriaClinicaServicio historiaClinicaServicio;
	
	@GetMapping
	public ResponseEntity<List<HistoriaClinica>> historiasClinicas() {
		return ResponseEntity.ok(historiaClinicaServicio.obtenerHistoriasClinicas());
	}
	
	@PostMapping
	public ResponseEntity<HistoriaClinica> crear(@RequestBody HistoriaClinica historiaClinica) {
		HistoriaClinica historia = historiaClinicaServicio.crearHistoriaClinica(historiaClinica);
		return ResponseEntity.ok(historia);
	}
	
	@PutMapping
	public ResponseEntity<?> actualizar(@RequestBody HistoriaClinica historiaClinica){
		HistoriaClinica historia = historiaClinicaServicio.actualizarHistoriaClinica(historiaClinica);
		return ResponseEntity.ok(historia);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") int id) {
		historiaClinicaServicio.borrarPorId(id);
		return ResponseEntity.ok("Ok");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable("id") int id) {
		HistoriaClinica historiaClinica = historiaClinicaServicio.obtenerPorId(id);
		if (historiaClinica == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(historiaClinica);
	}
}