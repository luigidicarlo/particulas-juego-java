package graficos;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import control.Raton;
import control.Teclado;
import graficos.sprites.SpritePersonaje;
import maquinaestado.GestorEstados;

public class SuperficieDibujo extends Canvas {
	private int ANCHO;
	private int ALTO;
	
	private BufferStrategy buffer;
	private Graphics g;
	
	private SpritePersonaje personaje;
	
	private final Teclado teclado;
	private final Raton raton;

	public SuperficieDibujo(int ANCHO, int ALTO, SpritePersonaje personaje) {
		this.ANCHO = ANCHO;
		this.ALTO = ALTO;
		this.personaje = personaje;
		setPreferredSize(new Dimension(ANCHO, ALTO));
		teclado = new Teclado();
		raton = new Raton();
		teclado.inicializar();
		addKeyListener(teclado);
		addMouseListener(raton);
		addMouseMotionListener(raton);
		setFocusable(true);
		requestFocus();
	} // Fin del constructor SuperficieDibujo() con 2 par�metros
	
	public void dibujar() {
		buffer = getBufferStrategy();
		
		if(buffer == null) {
			createBufferStrategy(3);
			return;
		}
		
		g = buffer.getDrawGraphics();
		
		GestorEstados.getEstadoActual().dibujar(g);
		
		Toolkit.getDefaultToolkit().sync();
		
		g.dispose();
		
		buffer.show();
	} // Fin del m�todo dibujar()
	
	public Teclado getTeclado() {
		return teclado;
	} // Fin del m�todo getTeclado()
	
	public Raton getRaton() {
		return raton;
	} // Fin del m�todo getRaton()
	
	public int getAncho() {
		return ANCHO;
	} // Fin del m�todo getAncho()
	
	public int getAlto() {
		return ALTO;
	} // Fin del m�todo getAlto()
	
} // Fin de la clase SuperficieDibujo