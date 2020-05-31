package control;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Raton extends MouseAdapter implements MouseMotionListener {
	
	private Point puntoClick;
	private Point puntoPos;

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	} // Fin del m�todo mouseEntered()

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	} // Fin del m�todo mouseExited()

	public void mousePressed(MouseEvent e) {
		puntoClick = e.getPoint();
	} // Fin del m�todo mousePressed()

	public void mouseReleased(MouseEvent e) {
		// TODO
	} // Fin del m�todo mouseReleased()
	
	public void mouseMoved(MouseEvent e) {
		puntoPos = e.getPoint();
	} // Fin del m�todo mouseMoved()
	
	public void mouseDragged(MouseEvent e) {
		
	} // Fin del m�todo mouseDragged()
	
	public Point getPuntoClick() {
		return puntoClick;
	} // Fin del m�todo getPunto()
	
	public Point getPuntoPos() {
		return puntoPos;
	} // Fin del m�todo getPuntoPos()
	
} // Fin de la clase Raton