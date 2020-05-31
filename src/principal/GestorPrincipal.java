package principal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import graficos.SuperficieDibujo;
import graficos.Ventana;
import graficos.sprites.SpriteParticula;
import graficos.sprites.SpritePersonaje;
import herramientas.Archivos;
import maquinaestado.GestorEstados;

public class GestorPrincipal {
	
	// Variables de control de estado
	private static boolean ejecutando = false;
	private static boolean modoZen = false;
	
	// Nombre de la ventana
	private static final String NOMBRE = "Partículas";
	
	// Contexto gráfico
	private static SuperficieDibujo superficie;
	
	// Contadores de FPS y UPS 
	private static int ups = 0;
	private static int fps = 0;
	private static String contador = "FPS: 0 || UPS : 0";
	
	// Color por defecto del fondo
	private static Color color = Color.BLACK;
	
	// Personaje principal y partículas
	private static SpritePersonaje personaje;
	private static ArrayList<SpriteParticula> particulas = new ArrayList<SpriteParticula>();
	
	// Variable para guardar los puntajes
	private static String[] puntajes;
	
	public static void iniciarJuego() {
		ejecutando = true;
		inicializar();
	} // Fin del método iniciarJuego()
	
	public static void detenerJuego() {
		ejecutando = false;
		System.exit(0);
	} // Fin del método detenerJuego()
	
	public static void inicializar() {
		personaje = new SpritePersonaje();
		superficie = new SuperficieDibujo(640, 480, personaje);
		Ventana ventana = new Ventana(NOMBRE, superficie);
		GestorEstados.inicializar();
		personaje.setX(superficie.getAncho() / 2 - personaje.getTamanio() / 2);
		personaje.setY(superficie.getAlto() / 2 - personaje.getTamanio() / 2);
		puntajes = Archivos.leerDatos();
		iterarBuclePrincipal();
	} // Fin del método inicializar()
	
	public static void actualizar() {
		ups++;
		GestorEstados.actualizar();
	} // Fin del método actualizar()
	
	public static void dibujar() {
		fps++;
		superficie.dibujar();
	} // Fin del método dibujar()
	
	public static void iterarBuclePrincipal() {
		final int NS_POR_SEGUNDO = 1000000000;
		final int VELOCIDAD_DESEADA = 60;
		final long NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / VELOCIDAD_DESEADA;
		long refContador = System.nanoTime();
		long antesBucle = System.nanoTime();
		long refCreacion = System.nanoTime(); // Referencia para crear partículas
		
		Random random = new Random(); // Generador de números aleatorios
		
		int contadorEnemigos = 0;
		int refContadorEnemigos = random.nextInt(10) + 5;
		
		double tiempoTranscurrido;
		
		double delta = 0;
		
		while(ejecutando) {
			long inicioBucle = System.nanoTime();
			
			tiempoTranscurrido = inicioBucle - antesBucle;
			antesBucle = inicioBucle;
			
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
			
			while(delta >= 1) {
				actualizar();
				delta--;
			} // Actualiza 60 veces por segundo
			
			dibujar();
			
			if(System.nanoTime() - refCreacion > NS_POR_SEGUNDO) {
				if(particulas.size() < 1000) {
					SpriteParticula nuevaParticula = new SpriteParticula();
					int particulaX = random.nextInt(superficie.getWidth() - nuevaParticula.getTamanio());
					int particulaY = random.nextInt(superficie.getHeight() - nuevaParticula.getTamanio());
					if(contadorEnemigos >= refContadorEnemigos) {
						nuevaParticula.generarParticula(particulaX, particulaY, true);
						if(GestorEstados.getIndiceEstadoActual() == GestorEstados.NIVEL_2)
							nuevaParticula.establecerVelocidad();
						contadorEnemigos = 0;
						refContadorEnemigos = random.nextInt(10) + 5;
					} else {
						nuevaParticula.generarParticula(particulaX, particulaY, false);
						contadorEnemigos++;
					}
					particulas.add(nuevaParticula);
				}
				refCreacion = System.nanoTime();
			} // Genera partículas de forma aleatoria
			
			if(System.nanoTime() - refContador > NS_POR_SEGUNDO) {
				contador = "FPS: " + fps + " || UPS: " + ups;
				ups = 0;
				fps = 0;
				refContador = System.nanoTime();
			} // Reinicia los contadores de FPS y UPS
		} // Fin del bucle principal
	} // Fin del método iterarBuclePrincipal()
	
	/*
	private int generarCoordenada(SpriteParticula nuevaParticula) {
		Random random = new Random();
		int coordenadas[] = new int[2];
		for(int i=0; i<coordenadas.length; i++)
			int coordenadas[i] = random.nextInt(superficie.getWidth() - nuevaParticula.getTamanio());
		
		return coordenadas;
	} // Fin del método generarCoordenada()*/
	
	public static String getContador() {
		return contador;
	} // Fin del método getContador()
	
	public static Color getColor() {
		return color;
	} // Fin del método getColor()
	
	public static SpritePersonaje getPersonaje() {
		return personaje;
	} // Fin del método getPersonaje()
	
	public static SuperficieDibujo getSuperficie() {
		return superficie;
	} // Fin del método getSuperficie()
	
	public static ArrayList<SpriteParticula> getParticulas() {
		return particulas;
	} // Fin del método getParticulas()
	
	public static String getNombreJuego() {
		return NOMBRE;
	} // Fin del método getNombreJuego()
	
	public static void setModoZen(boolean zen) {
		modoZen = zen;
	} // Fin del método setModoZen()
	
	public static boolean getModoZen() {
		return modoZen;
	} // Fin del método getModoZen()
	
	public static String[] getPuntajes() {
		return puntajes;
	} // Fin del método getPuntajes()
	
} // Fin de la clase GestorPrincipal