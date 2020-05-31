package graficos;

import java.awt.Color;

public class Sprite {

	// Tama�o del Sprite
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
	} // Fin del m�todo getTamanio()
	
	public Color getColor() {
		return color;
	} // Fin del m�todo getColor()
	
	public int getX() {
		return x;
	} // Fin del m�todo getX()
	
	public int getY() {
		return y;
	} // Fin del m�todo getY()
	
	public void setX(int x) {
		this.x = x;
	} // Fin del m�todo setX()
	
	public void setY(int y) {
		this.y = y;
	} // Fin del m�todo setY()
	
	public int getVX() {
		return vx;
	} // Fin del m�todo getVX()
	
	public int getVY() {
		return vy;
	}
	
	public void setVX(int vx) {
		this.vx = vx;
	} // Fin del m�todo setVX()
	
	public void setVY(int vy) {
		this.vy = vy;
	} // Fin del m�todo setVY()
	
	public double getCentroX() {
		return x + tamanio / 2;
	} // Fin del m�todo getCentroX()
	
	public double getCentroY() {
		return y + tamanio / 2;
	} // Fin del m�todo getCentroY()
	
} // Fin de la clase Sprite