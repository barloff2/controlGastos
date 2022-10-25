package gestion.DAO;

import java.util.List;

import gestion.modelo.Gasto;

public interface GastoDAO {
	public void addGasto(Gasto gasto) throws Exception;
	public List<Gasto> mostrarGastos() throws Exception;
}
