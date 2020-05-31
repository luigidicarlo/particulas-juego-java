package maquinaestado.estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import graficos.SuperficieDibujo;
import graficos.sprites.SpriteParticula;
import graficos.sprites.SpritePersonaje;
import herramientas.Colisiones;
import maquinaestado.GestorEstados;
import principal.GestorPrincipal;

public class EstadoGameOver implements EstadoJuego {
	
	private SpritePersonaje personaje;
	private SuperficieDibujo superficie;
	private ArrayList<SpriteParticula> particulas;
	
	public void inicializar() {
		personaje = GestorPrincipal.getPersonaje();
		superficie = GestorPrincipal.getSuperficie();
		particulas = GestorPrincipal.getParticulas();
	} // Fin del método inicializar()

	public void actualizar() {
		if(superficie.getTeclado().teclas[superficie.getTeclado().REINICIAR])
			Colisiones.reiniciarJuego(personaje, superficie, particulas);
		if(superficie.getTeclado().teclas[superficie.getTeclado().QUITAR])
			GestorEstados.cambiarEstado(GestorEstados.MENU_PRINCIPAL);
	} // Fin del método actualizar()
	
	public void dibujar(Graphics g) {		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, superficie.getAncho(), superficie.getAlto());
		
		g.setColor(Color.GREEN);
		g.setFont(new Font("Arial Black", Font.PLAIN, 32));
		g.drawString("GAME OVER", superficie.getAncho() / 2 - 128, superficie.getAlto() / 2 - 16);
		g.setFont(new Font("Arial", Font.PLAIN, 16));
		g.drawString(String.format("Puntos: %d" , personaje.getPuntos()), superficie.getAncho() / 2 - 48, superficie.getAlto() / 2 + 16);
		g.drawString("Presiona R para jugar de nuevo o Q para volver al menú principal", superficie.getAncho() / 2 - 160, superficie.getAlto() - 32);
	} // Fin del método dibujar()
	
} // Fin de la clase EstadoGameOver