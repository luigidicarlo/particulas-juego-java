package maquinaestado.estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import graficos.SuperficieDibujo;
import herramientas.Archivos;
import maquinaestado.GestorEstados;
import principal.GestorPrincipal;

public class EstadoPuntajes implements EstadoJuego {

	private String[] puntajes;
	private SuperficieDibujo superficie;
	
	public void inicializar() {
		puntajes = Archivos.leerDatos();
		superficie = GestorPrincipal.getSuperficie();
	} // Fin del método inicializar()

	public void actualizar() {
		if(superficie.getTeclado().teclas[superficie.getTeclado().QUITAR])
			GestorEstados.cambiarEstado(GestorEstados.MENU_PRINCIPAL);
	} // Fin del método actualizar()

	public void dibujar(Graphics g) {
		double suma = 0;
		
		// Limpia la superficie de dibujo
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, superficie.getAncho(), superficie.getAlto());
		
		// Coloca el color verde
		g.setColor(Color.GREEN);
		
		// Pinta el título de la pantalla
		g.setFont(new Font("Arial Black", Font.PLAIN, 48));
		g.drawString("PUNTAJES", superficie.getAncho() / 2 - 156, superficie.getAlto() / 2 - 96);
		g.setFont(new Font("Arial", Font.PLAIN, 16));
		
		// Proceso de pintado del puntaje
		if(puntajes.length > 0) {
			int contador = 1;
			for(int i=puntajes.length - 1; i>puntajes.length - 6; i--) {
				g.drawString("" + contador + " | " + puntajes[i], superficie.getAncho() / 2 - 48, superficie.getAlto() / 2 + 32 + (contador * 24) - 16);
				suma += Integer.parseInt(puntajes[i]);
				contador++;
			} // Fin de for
			g.drawString("Promedio de Puntajes: " + (suma / contador), superficie.getAncho() / 2 - 96, superficie.getAlto() - 48);
			g.drawString("Presiona la tecla Q para volver al menú principal", superficie.getAncho() / 2 - 156, 16);
		} // Fin de if
	} // Fin del método dibujar()

} // Fin de la clase EstadoPuntajes