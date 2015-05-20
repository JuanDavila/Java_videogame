package main;

public abstract class Arma {
	private long tiempoAnterior;
	private long tiempoDeRecarga;


	public abstract void shoot();

	public boolean canShoot(){
		long tiempoActual = System.currentTimeMillis();

		long tiempoTranscurrido = tiempoActual - tiempoAnterior;
		tiempoAnterior = tiempoActual;

		return tiempoTranscurrido > tiempoDeRecarga;
	}
	
	public void setTiempoDeRecarga(int tRecarga) {
		tiempoDeRecarga = tRecarga;
	}

}
