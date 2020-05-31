package graficos.sprites;

import java.util.Random;

import graficos.Sprite;

public class SpriteParticula extends Sprite {
	
	private boolean enemigo;
	
	private final int velocidad = 3;
	
	public SpriteParticula() {
		this.tamanio = 16;
	} // Fin del constructor Sprite()
	
	public void establecerVelocidad() {
		Random random = new Random();
		this.vx = random.nextInt(4) + 1;
		this.vy = random.nextInt(4) + 1;
	} // Fin del m�todo establecerVelocidad()
	
	public void mover() {
		this.x += this.vx;
		this.y += this.vy;
	} // Fin del m�todo mover()

	public void generarParticula(int x, int y, boolean enemigo) {
		this.x = x;
		this.y = y;
		this.enemigo = enemigo;
		vx = 0;
		vy = 0;
	} // Fin del m�todo generarParticula
	
	public boolean esEnemigo() {
		return enemigo;
	} // Fin del m�todo esEnemigo()
	
} // Fin de la clase SpriteParticula