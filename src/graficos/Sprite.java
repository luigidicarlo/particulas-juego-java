package graficos;

import java.awt.Color;

public class Sprite {

	// Tamaño del Sprite
	protected int tamanio;
	
	// Color del Sprite
	protected Color color;
	
	// Coordenadas del Sprite
	protected int x;
	protected int y;
	
	// Velocidad del Sprite
	protected int vx;
	protected int vy;
	
	public int getTamanio() {
		return tamanio;
	} // Fin del método getTamanio()
	
	public Color getColor() {
		return color;
	} // Fin del método getColor()
	
	public int getX() {
		return x;
	} // Fin del método getX()
	
	public int getY() {
		return y;
	} // Fin del método getY()
	
	public void setX(int x) {
		this.x = x;
	} // Fin del método setX()
	
	public void setY(int y) {
		this.y = y;
	} // Fin del método setY()
	
	public int getVX() {
		return vx;
	} // Fin del método getVX()
	
	public int getVY() {
		return vy;
	}
	
	public void setVX(int vx) {
		this.vx = vx;
	} // Fin del método setVX()
	
	public void setVY(int vy) {
		this.vy = vy;
	} // Fin del método setVY()
	
	public double getCentroX() {
		return x + tamanio / 2;
	} // Fin del método getCentroX()
	
	public double getCentroY() {
		return y + tamanio / 2;
	} // Fin del método getCentroY()
	
} // Fin de la clase Sprite