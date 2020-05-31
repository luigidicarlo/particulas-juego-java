package maquinaestado.estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import control.Raton;
import graficos.SuperficieDibujo;
import graficos.sprites.SpritePersonaje;
import maquinaestado.GestorEstados;
import principal.GestorPrincipal;

public class EstadoMenuPrincipal implements EstadoJuego {
	
	private SuperficieDibujo superficie;
	private SpritePersonaje personaje;
	private final String[] opciones = {"Modo Normal", "Modo Zen", "Puntajes", "Salir del Juego"};
	private Rectangle[] rectangulos;
	private Raton raton;
	private Point punto;
	private Color elemMenu[];
	private Color fuenteMenu[]; 
	
	public void inicializar() {
		superficie = GestorPrincipal.getSuperficie();
		personaje = GestorPrincipal.getPersonaje();
		personaje.setPuntos(0);
		rectangulos = new Rectangle[opciones.length];
		elemMenu = new Color[rectangulos.length];
		fuenteMenu = new Color[rectangulos.length];
		raton = superficie.getRaton();
		for(int i=0; i<rectangulos.length; i++) {
			rectangulos[i] = new Rectangle(superficie.getAncho() / 2 - 48, superficie.getAlto() / 2 + 32 + (i * 24) - 16, 128, 24);
			elemMenu[i] = Color.BLACK;
			fuenteMenu[i] = Color.GREEN;
		} // Fin del bucle for
	} // Fin del método inicializar()

	public void actualizar() {
		if(raton.getPuntoPos() != null) {
			punto = raton.getPuntoPos();
			for(int i=0; i<opciones.length; i++) {
				if(rectangulos[i].contains(punto)) {
					elemMenu[i] = Color.GREEN;
					fuenteMenu[i] = Color.BLACK;
				} else {
					elemMenu[i] = Color.BLACK;
					fuenteMenu[i] = Color.GREEN;
				} // Fin de if-else
			} // Fin del bucle for
		} // Fin de if
		if(raton.getPuntoClick() != null) {
			Point puntoClick = raton.getPuntoClick();
			for(int i=0; i<opciones.length; i++) {
				if(rectangulos[i].contains(puntoClick)) {
					switch(i) {
						case 0:
							GestorPrincipal.setModoZen(false);
							GestorEstados.cambiarEstado(GestorEstados.NIVEL_1);
						break;
						case 1: 
							GestorPrincipal.setModoZen(true); 
							GestorEstados.cambiarEstado(GestorEstados.NIVEL_1);
						break;
						case 2:  
							GestorPrincipal.setModoZen(false);
							GestorEstados.cambiarEstado(GestorEstados.PUNTAJES);
						break;
						case 3: GestorPrincipal.detenerJuego(); break;
					}
					puntoClick.setLocation(0, 0);
				}
			}
		}
	} // Fin del método actualizar()

	public void dibujar(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, superficie.getAncho(), superficie.getAlto());
		
		g.setColor(Color.GREEN);
		g.setFont(new Font("Arial Black", Font.PLAIN, 48));
		g.drawString(GestorPrincipal.getNombreJuego(), superficie.getAncho() / 2 - 128, superficie.getAlto() / 2 - 64);
		
		
		g.setFont(new Font("Arial", Font.PLAIN, 16));
		g.setColor(Color.GREEN);
		for(int i=0; i<opciones.length; i++) {
			g.setColor(elemMenu[i]);
			g.fillRect(superficie.getAncho() / 2 - 48, superficie.getAlto() / 2 + 32 + (i * 24) - 16, 128, 24);
			g.setColor(fuenteMenu[i]);
			g.drawString(opciones[i], superficie.getAncho() / 2 - 48 , superficie.getAlto() / 2 + 32 + (i * 24));
		}
	} // Fin del método dibujar()

} // Fin de la clase EstadoMenuPrincipal()