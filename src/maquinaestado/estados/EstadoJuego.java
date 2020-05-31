package maquinaestado.estados;

import java.awt.Graphics;

public interface EstadoJuego {
	
	void inicializar();

	void actualizar();
	
	void dibujar(Graphics g);
	
 } // Fin de la interfaz EstadoJuego