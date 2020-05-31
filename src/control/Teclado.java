package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {
	private final static int NUM_TECLAS = 256;
	public boolean teclas[];
	
	public int ARRIBA;
	public int IZQUIERDA;
	public int DERECHA;
	public int ABAJO;
	
	public int REINICIAR;
	public int QUITAR;
	
	public int SALIR_NIVEL;
	
	public Teclado() {
		teclas = new boolean[NUM_TECLAS];
	} // Fin del constructor Teclado
	
	public void inicializar() {
		ARRIBA = KeyEvent.VK_W;
		DERECHA = KeyEvent.VK_D;
		IZQUIERDA = KeyEvent.VK_A;
		ABAJO = KeyEvent.VK_S;
		REINICIAR = KeyEvent.VK_R;
		QUITAR = KeyEvent.VK_Q;
		SALIR_NIVEL = KeyEvent.VK_ESCAPE;
	} // Fin del método inicializar();

	public void keyTyped(KeyEvent e) {
		// TODO
	} // Fin del método keyTyped()

	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true;
	} // Fin del método keyPressed()

	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()] = false;
	} // Fin del método keyReleased()

} // Fin de la clase Teclado