package Models;

import java.util.Date;

public class Cliente {

	protected Date horaentrada;
	protected Date horasalida;
	protected String dinero;

	public Cliente(Date horaentrada) {
		this.horaentrada = horaentrada;
		this.horasalida = setHorasalida(horasalida);
		this.dinero = setDinero(dinero);
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

	public Date setHorasalida(Date horasalida) {
		return this.horasalida = horasalida;
	}

	public String getDinero() {
		return dinero;
	}

	public String setDinero(String dinero) {
		return this.dinero = dinero;
	}

}
