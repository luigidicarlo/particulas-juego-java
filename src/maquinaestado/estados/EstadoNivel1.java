package maquinaestado.estados;

import java.awt.Graphics;
import java.util.ArrayList;

import graficos.SuperficieDibujo;
import graficos.sprites.SpriteParticula;
import graficos.sprites.SpritePersonaje;
import herramientas.Colisiones;
import maquinaestado.GestorEstados;
import principal.GestorPrincipal;

public class EstadoNivel1 implements EstadoJuego {
	
	private SpritePersonaje personaje;
	private SuperficieDibujo superficie;
	private ArrayList<SpriteParticula> particulas;
	private final int PUNTOS_SIG_NIVEL = 10;
	
	public void inicializar() {
		personaje = GestorPrincipal.getPersonaje();
		superficie = GestorPrincipal.getSuperficie();
		particulas = GestorPrincipal.getParticulas();
		personaje.setVX(0);
		personaje.setVY(0);
		particulas.removeAll(particulas);
	} // Fin del método inicializar()

	public void actualizar() {
		for(int i=0; i<particulas.size(); i++) { 
			SpriteParticula particula = particulas.get(i);
			if(Colisiones.colision(personaje, particula))
				if(particula.esEnemigo()) {
					GestorEstados.cambiarEstado(GestorEstados.GAME_OVER);
					Colisiones.terminarNivel(personaje, superficie);
				} else {
					if(personaje.getPuntos() > PUNTOS_SIG_NIVEL)
						GestorEstados.cambiarEstado(GestorEstados.NIVEL_2);
					particulas.remove(particula);
					if(personaje.getTamanio() <= superficie.getAncho() / 8)
						personaje.setTamanio(personaje.getTamanio() + 2);
					personaje.setPuntos(personaje.getPuntos() + 1);
				}
		} // Fin del for
		personaje.mover(superficie.getTeclado());
		Colisiones.corregirMovimientoJugador(personaje, superficie);
		if(superficie.getTeclado().teclas[superficie.getTeclado().SALIR_NIVEL]) {
			GestorEstados.cambiarEstado(GestorEstados.MENU_PRINCIPAL);
			Colisiones.terminarNivel(personaje, superficie);
		}
	} // Fin del método actualizar()
	
	public void dibujar(Graphics g) {
		Colisiones.dibujarNivel(personaje, superficie, g);
	} // Fin del método dibujar()
	
} // Fin de la clase EstadoNivel1