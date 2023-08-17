package com.mc.gestor.clinica.app.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mc.gestor.clinica.app.entidades.HistoriaClinica;
import com.mc.gestor.clinica.app.entidades.Paciente;
import com.mc.gestor.clinica.app.servicios.HistoriaClinicaServicio;
import com.mc.gestor.clinica.app.servicios.PacienteServicio;

@Controller
public class PacienteControlador {

	@Autowired
	private PacienteServicio pacienteServicio;
	
	@Autowired
	private HistoriaClinicaServicio historiaClinicaServicio;
	
	@GetMapping("/buscar")
    public String buscarPacientesPorNombre(@RequestParam("parametro") String parametro, Model model) {
        List<Paciente> pacientes = pacienteServicio.buscarPorIdONombre(parametro);
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("parametroIngresado", parametro);
        return "inicio";
    }
	
	@GetMapping("/historia")
	public String historiaClinica(@RequestParam(name = "parametro", required = false) String parametro,
									@RequestParam(name = "pacienteId", required = false) Integer pacienteId, Model model) {
		List<Paciente> pacientes = new ArrayList<>();
		List<HistoriaClinica> historiasClinicas = new ArrayList<>();

		if (parametro != null) {
			pacientes = pacienteServicio.buscarPorIdONombre(parametro);
		}

		if (pacienteId != null) {
			historiasClinicas = historiaClinicaServicio.buscarPorPacienteId(pacienteId);
		}

		model.addAttribute("pacientes", pacientes);
		model.addAttribute("historiasClinicas", historiasClinicas);
		model.addAttribute("parametroIngresado", parametro);
		return "inicio";
	}
}