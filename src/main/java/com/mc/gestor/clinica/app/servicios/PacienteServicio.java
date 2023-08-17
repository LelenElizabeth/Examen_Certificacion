package com.mc.gestor.clinica.app.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.gestor.clinica.app.entidades.Paciente;
import com.mc.gestor.clinica.app.repositorios.IPacienteRepositorio;

@Service
public class PacienteServicio {

	@Autowired
	private IPacienteRepositorio pacienteRepositorio;
	
	public List<Paciente> obtenerTodosLosPacientes() {
		return pacienteRepositorio.findAll();
	}

	public Paciente obtenerPacientePorId(int id) {
		return pacienteRepositorio.findById(id).orElse(null);
	}

	public Paciente guardarPaciente(Paciente paciente) {
		return pacienteRepositorio.save(paciente);
	}

	public void eliminarPaciente(int id) {
		pacienteRepositorio.deleteById(id);
	}
	
	public List<Paciente> buscarPorIdONombre(String parametro) {
        int id;
        try {
            id = Integer.parseInt(parametro);
            return pacienteRepositorio.findByIdOrNombreContainingIgnoreCase(id, parametro);
        } catch (NumberFormatException e) {
            return pacienteRepositorio.findByNombreContainingIgnoreCase(parametro);
        }
    }
}