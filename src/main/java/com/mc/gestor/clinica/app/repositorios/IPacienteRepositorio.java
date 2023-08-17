package com.mc.gestor.clinica.app.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mc.gestor.clinica.app.entidades.Paciente;

@Repository
public interface IPacienteRepositorio extends JpaRepository<Paciente, Integer>{
	List<Paciente> findByNombreContainingIgnoreCase(String nombre);
	List<Paciente> findByIdOrNombreContainingIgnoreCase(int id, String nombre);
}