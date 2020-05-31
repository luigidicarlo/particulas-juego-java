package maquinaestado;

import maquinaestado.estados.EstadoGameOver;
import maquinaestado.estados.EstadoJuego;
import maquinaestado.estados.EstadoMenuPrincipal;
import maquinaestado.estados.EstadoNivel1;
import maquinaestado.estados.EstadoNivel2;
import maquinaestado.estados.EstadoPuntajes;

public class GestorEstados {
	
	private static final int NUM_ESTADOS = 5;
	private static EstadoJuego estadoActual;
	private static int indiceEstadoActual;
	
	public static EstadoJuego[] estados;
	
	public static final int MENU_PRINCIPAL = 0;
	public static final int GAME_OVER = 1;
	public static final int NIVEL_1 = 2;
	public static final int NIVEL_2 = 3;
	public static final int PUNTAJES = 4;
	
	public static void inicializar() {
		estados = new EstadoJuego[NUM_ESTADOS];
		estados[0] = new EstadoMenuPrincipal();
		estados[1] = new EstadoGameOver();
		estados[2] = new EstadoNivel1();
		estados[3] = new EstadoNivel2();
		estados[4] = new EstadoPuntajes();
		estadoActual = estados[MENU_PRINCIPAL];
		indiceEstadoActual = MENU_PRINCIPAL;
		estadoActual.inicializar();
	} // Fin del método inicializar()
	
	public static void actualizar() {
		estadoActual.actualizar();
	} // Fin del método actualizar()
	
	public static void cambiarEstado(int estado) {
		estadoActual = estados[estado];
		indiceEstadoActual = estado;
		estadoActual.inicializar();
	} // Fin del método cambiarEstado()
	
	public static EstadoJuego getEstadoActual() {
		return estadoActual;
	} // Fin del método getEstadoActual()
	
	public static int getIndiceEstadoActual() {
		return indiceEstadoActual;
	} // Fin del método getIndiceEstadoActual()

} // Fin de la clase GestorEstados