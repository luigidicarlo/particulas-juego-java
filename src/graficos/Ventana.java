package graficos;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	public Ventana(String NOMBRE, SuperficieDibujo superficie) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(NOMBRE);
		setResizable(false);
		setLayout(new BorderLayout());
		add(superficie, BorderLayout.CENTER);
		pack();
		setVisible(true);
	} // Fin del constructor Ventana() con 2 parámetros
	
} // Fin de la clase Ventana