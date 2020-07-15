package com.contable.app.empleados;

import java.util.List;

public interface IEmpleados {
	List<Empleados> findAll();
	Empleados findByIdentification(String identification);
	Empleados findByEmail(String email);
	Empleados findByIdentificationAndEmail(String identification,String email);
	Integer save(Empleados empleado);
}
