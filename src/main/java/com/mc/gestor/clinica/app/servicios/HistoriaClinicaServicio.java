package com.mc.gestor.clinica.app.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.gestor.clinica.app.entidades.HistoriaClinica;
import com.mc.gestor.clinica.app.repositorios.IHistoriaClinicaRepositorio;

@Service
public class HistoriaClinicaServicio {

	@Autowired
	private IHistoriaClinicaRepositorio historiaClinicaRepositorio;
	
	public List<HistoriaClinica> obtenerHistoriasClinicas() {
		return historiaClinicaRepositorio.findAll();
	}
	
	public HistoriaClinica obtenerPorId(int id) {
		return historiaClinicaRepositorio.findById(id).orElse(null);
	}
	
	public HistoriaClinica crearHistoriaClinica(HistoriaClinica historiaClinica) {
		return historiaClinicaRepositorio.save(historiaClinica);
	}
	
	public HistoriaClinica actualizarHistoriaClinica(HistoriaClinica historiaClinica) {
		return historiaClinicaRepositorio.save(historiaClinica);
	}
	
	public void borrarPorId(int id) {
		historiaClinicaRepositorio.deleteById(id);
	}
	
	public List<HistoriaClinica> buscarPorPacienteId(int pacienteId) {
		return historiaClinicaRepositorio.findByPacienteId(pacienteId);
	}

}