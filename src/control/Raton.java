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
	} // Fin del método mouseEntered()

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	} // Fin del método mouseExited()

	public void mousePressed(MouseEvent e) {
		puntoClick = e.getPoint();
	} // Fin del método mousePressed()

	public void mouseReleased(MouseEvent e) {
		// TODO
	} // Fin del método mouseReleased()
	
	public void mouseMoved(MouseEvent e) {
		puntoPos = e.getPoint();
	} // Fin del método mouseMoved()
	
	public void mouseDragged(MouseEvent e) {
		
	} // Fin del método mouseDragged()
	
	public Point getPuntoClick() {
		return puntoClick;
	} // Fin del método getPunto()
	
	public Point getPuntoPos() {
		return puntoPos;
	} // Fin del método getPuntoPos()
	
} // Fin de la clase Raton