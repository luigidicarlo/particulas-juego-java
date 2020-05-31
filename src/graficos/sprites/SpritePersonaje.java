package graficos.sprites;

import java.awt.Color;

import control.Teclado;
import graficos.Sprite;
import principal.GestorPrincipal;

public class SpritePersonaje extends Sprite {

	// Velocidad del Jugador
	private final int velocidad = 6;
	
	// Puntos del Jugador
	private int puntos;
	
	public SpritePersonaje() {
		this.color = Color.GREEN;
		tamanio = 32;
		puntos = 0;
	} // Fin del constructor SpritePersonaje()
	
	public void mover(Teclado teclado) {		
		// Modificar velocidad del personaje según los botones que se presionen
		if(teclado.teclas[teclado.ARRIBA] && !teclado.teclas[teclado.ABAJO])
			vy = -velocidad;
		if(teclado.teclas[teclado.ABAJO] && !teclado.teclas[teclado.ARRIBA])
			vy = velocidad;
		if(teclado.teclas[teclado.IZQUIERDA] && !teclado.teclas[teclado.DERECHA])
			vx = -velocidad;
		if(teclado.teclas[teclado.DERECHA] && !teclado.teclas[teclado.IZQUIERDA])
			vx = velocidad;
		if(GestorPrincipal.getModoZen() &&
				!teclado.teclas[teclado.ARRIBA] &&
				!teclado.teclas[teclado.ABAJO] &&
				!teclado.teclas[teclado.IZQUIERDA] &&
				!teclado.teclas[teclado.DERECHA]) {
			vx = 0;
			vy = 0;
		} // Fin de if para detener el movimiento del personaje
			
		
		// Mueve al personaje según los valores de las velocidades en x y en y
		x += vx;
		y += vy;
	} // Fin del método mover()
	
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	} // Fin del método setTamanio()
	
	public int getPuntos() {
		return puntos;
	} // Fin del método getPuntos()
	
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	} // Fin del método setPuntos()
	
} // Fin de la clase SpritePersonaje