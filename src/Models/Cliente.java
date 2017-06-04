package Models;

import java.util.Date;

public class Cliente {

	protected Date horaentrada;
	protected Date horasalida;
	protected String dinero;

	public Cliente(Date horaentrada) {
		this.horaentrada = horaentrada;
	}

	
	public Date getHoraentrada() {
		return horaentrada;
	}

	public void setHoraentrada(Date horaentrada) {
		this.horaentrada = horaentrada;
	}

	public Date getHorasalida() {
		return horasalida;
	}

	public void setHorasalida(Date horasalida) {
		this.horasalida = horasalida;
	}

	public String getDinero() {
		return dinero;
	}

	public void setDinero(String dinero) {
		this.dinero = dinero;
	}

	
	
}
