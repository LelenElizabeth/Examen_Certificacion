-- Consulta 1
-- Se solicita mostrar el nombre de cada paciente y el nombre del doctor con el que tienen una cita asignada.

SELECT pacientes.Nombre, doctores.Nombre FROM pacientes 
INNER JOIN citas ON pacientes.ID = citas.Paciente_ID
INNER JOIN doctores ON citas.Doctor_ID = doctores.ID;

-- Consulta 2
-- Se solicita una lista del Nombre y la Especialidad de todos los doctores que atendieron al paciente “Juan Pérez”

SELECT doctores.Nombre, especialidades.Nombre, pacientes.Nombre FROM pacientes
INNER JOIN h ON pacientes.ID
INNER JOIN d ON h.Doctor_ID = doctores.ID
LEFT JOIN especialidades ON doctores.Especialidad_ID = especialidades.ID
WHERE pacientes.Nombre = "Juan Pérez";

-- Consulta 3
-- Se solicita una lista con el monto que factura cada doctor, ordenados alfabéticamente de forma descendente, agrupados por el nombre del Doctor.

SELECT d.Nombre, sum(f.Monto) AS Monto FROM citas c join doctores d on c.Doctor_ID = d.ID join gestion_clinica.facturas f on c.Factura_ID = f.ID group by d.Nombre order by d.Nombre desc;

-- Consulta 4
-- Se solicita una lista que muestre por paciente, el diagnóstico y tratamiento que recibió en su última cita. Ordenados de forma ascendente por el id del paciente.

SELECT p.ID, p.Nombre, h.Diagnostico, h.Tratamiento FROM historia_clinica h join pacientes p on h.Paciente_ID = p.ID order by p.ID asc;

-- Consulta 5
-- Se solicita una lista con la cantidad de pacientes que ha atendido cada doctor.

SELECT d.Nombre, count(*) as Pacientes FROM gestion_clinica.historia_clinica h join doctores d on h.Doctor_ID = d.id group by h.Doctor_ID;