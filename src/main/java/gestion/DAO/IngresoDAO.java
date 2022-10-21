package gestion.DAO;

import java.util.List;

import gestion.modelo.Ingreso;

public interface IngresoDAO {
	public void addIngreso(Ingreso ingreso) throws Exception;
	public List<Ingreso> mostrarIngresos() throws Exception;
}
