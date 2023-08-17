package com.mc.gestor.clinica.app.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mc.gestor.clinica.app.entidades.Paciente;
import com.mc.gestor.clinica.app.servicios.PacienteServicio;

@Controller
public class PacienteControlador {

	@Autowired
	private PacienteServicio pacienteServicio;
	
	@GetMapping("/buscar")
    public String buscarPacientesPorNombre(@RequestParam("parametro") String parametro, Model model) {
        List<Paciente> pacientes = pacienteServicio.buscarPorIdONombre(parametro);
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("parametroIngresado", parametro);
        return "inicio";
    }
}