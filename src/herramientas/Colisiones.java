package herramientas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import graficos.SuperficieDibujo;
import graficos.sprites.SpriteParticula;
import graficos.sprites.SpritePersonaje;
import maquinaestado.GestorEstados;
import principal.GestorPrincipal;

public class Colisiones {
	
	public static boolean colision(SpritePersonaje personaje, SpriteParticula particula) {
		double dx = personaje.getCentroX() - particula.getCentroX();
		double dy = personaje.getCentroY() - particula.getCentroY();
		double sumaTamaniosX = personaje.getTamanio() / 2 + particula.getTamanio() / 2;
		double sumaTamaniosY = personaje.getTamanio() / 2 + particula.getTamanio() / 2;
		if(Math.abs(dx) < sumaTamaniosX) {
			if(Math.abs(dy) < sumaTamaniosY) {
				return true;
			}
		}
		return false;
	} // Fin del método colision()
	
	public static void corregirMovimientoJugador(SpritePersonaje personaje, SuperficieDibujo superficie) {
		// Control de colisiones del jugador
		if(personaje.getX() < 0)
			personaje.setX(0);
		if(personaje.getY() < 0)
			personaje.setY(0);
		if(personaje.getX() + personaje.getTamanio() > superficie.getAncho())
			personaje.setX(superficie.getAncho() - personaje.getTamanio());
		if(personaje.getY() + personaje.getTamanio() > superficie.getAlto())
			personaje.setY(superficie.getAlto() - personaje.getTamanio());
	} // Fin del método corregirMovimientoJugador()
	
	public static void corregirMovimientoParticula(SpriteParticula particula, SuperficieDibujo superficie) {
		// Control de colisiones para las partículas
		if(particula.getX() < 0 || particula.getX() + particula.getTamanio() > superficie.getAncho())
			particula.setVX(particula.getVX() * -1);
		if(particula.getY() < 0 || particula.getY() + particula.getTamanio() > superficie.getAlto())
			particula.setVY(particula.getVY() * -1) ;
	} // Fin del método corregirMovimientoParticula()
	
	public static void reiniciarJuego(SpritePersonaje personaje, SuperficieDibujo superficie, ArrayList<SpriteParticula> particulas) {
		for(int i=0; i<particulas.size(); i++) {
			particulas.removeAll(particulas);
		} // Fin del bucle for
		personaje.setPuntos(0);
		personaje.setTamanio(32);
		personaje.setX(superficie.getAncho() / 2 - personaje.getTamanio() / 2);
		personaje.setY(superficie.getAlto() / 2 - personaje.getTamanio() / 2);
		personaje.setVX(0);
		personaje.setVY(0);
		GestorEstados.cambiarEstado(GestorEstados.NIVEL_1);
	} // Fin del método reiniciarJuego();
	
	public static void terminarNivel(SpritePersonaje personaje, SuperficieDibujo superficie) {
		personaje.setX(superficie.getAncho() / 2 - personaje.getTamanio() / 2);
		personaje.setY(superficie.getAlto() / 2 - personaje.getTamanio() / 2);
		personaje.setVX(0);
		personaje.setVY(0);
		personaje.setTamanio(32);
		Archivos.agregarDatos(personaje.getPuntos());
	} // Fin del método terminarNivel()
	
	public static void dibujarNivel(SpritePersonaje personaje, SuperficieDibujo superficie, Graphics g) {
		String textoNivel = "";
		
		g.setColor(GestorPrincipal.getColor());
		g.fillRect(0, 0, superficie.getAncho(), superficie.getAlto());
		
		for(int i=0; i<GestorPrincipal.getParticulas().size(); i++) {
			SpriteParticula particula = GestorPrincipal.getParticulas().get(i);
			if(particula.esEnemigo())
				g.setColor(Color.RED);
			else
				g.setColor(Color.GREEN);
			g.fillRect(particula.getX(), particula.getY(), particula.getTamanio(), particula.getTamanio());
		}
		
		g.setColor(personaje.getColor());
		g.fillRect(personaje.getX(), personaje.getY(), personaje.getTamanio(), personaje.getTamanio());
		
		g.setColor(Color.GREEN);
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		g.drawString(GestorPrincipal.getContador(), 32, 32);
		
		g.drawString("Puntos: " + personaje.getPuntos(), superficie.getAncho() - 128, 16);
		g.drawString("PosX: " + personaje.getX(), superficie.getAncho() - 128, 32);
		g.drawString("PosY: " + personaje.getY(), superficie.getAncho() - 128, 48);
		switch(GestorEstados.getIndiceEstadoActual()) {
			case 2: textoNivel = "Nivel: 1"; break;
			case 3: textoNivel = "Nivel: 2"; break;
		} // Fin de switch
		g.drawString(textoNivel, superficie.getAncho() - 128, 64);
	} // Fin del método dibujarNivel()

} // Fin de la clase Colisiones