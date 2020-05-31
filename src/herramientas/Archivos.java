package herramientas;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import graficos.sprites.SpritePersonaje;
import principal.GestorPrincipal;

public class Archivos {
	
	private static int contarLineas(String archivo) throws IOException {
		InputStream entrada = new BufferedInputStream(new FileInputStream(archivo));
		try {
			byte[] c = new byte[1024];
			int contador = 0;
			int leerCaracteres = 0;
			boolean terminaConNuevaLinea = false;
			while((leerCaracteres = entrada.read(c)) != -1) {
				for(int i=0; i < leerCaracteres; i++) {
					if(c[i] == '\n')
						contador++;
				} // Fin de for
				terminaConNuevaLinea = (c[leerCaracteres - 1] != '\n');
			} // Fin de while
			if(terminaConNuevaLinea) {
				contador++;
			} // Fin de if
			return contador;
		} finally {
			entrada.close();
		} // Fin de try-finally
	} // Fin del método contarLineas()
	
	private static String leerTexto() {
		String texto = "";
		String aux;
		FileReader lector = null;
		File archivo = new File("pardat.txt");
		try {
			lector = new FileReader(archivo);
			BufferedReader br = new BufferedReader(lector);
			while((aux = br.readLine()) != null) {
				texto += aux + '\n';
			} // Fin de while
			br.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} // Fin de try-catch
		texto.replaceAll("\\s", "\n");
		return texto;
	} // Fin del método leerTexto()

	public static void agregarDatos(int puntos) {
		File archivo = new File("pardat.txt");
        SpritePersonaje personaje = GestorPrincipal.getPersonaje();
        puntos = personaje.getPuntos();
        String datosAnteriores = leerTexto();
        String datosNuevos = datosAnteriores + puntos;
        datosNuevos.replaceAll("\\s", "\n");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(datosNuevos);
            bw.close();
        } catch(Exception ex) {
        	ex.printStackTrace();
        } // Fin del bloque try-catch
	} // Fin del método agregarDatos()
	
	public static String[] leerDatos() {
        String puntuacion;
        String[] salida = null;
		try {
			salida = new String[contarLineas("pardat.txt")];
		} catch (IOException e) {
			e.printStackTrace();
		} // Fin de try-catch
        FileReader lector = null;
        File archivo = new File("pardat.txt");
        int i = 0;
        try {
        	lector = new FileReader(archivo);
        	BufferedReader br = new BufferedReader(lector);
        	while((puntuacion = br.readLine()) != null) {
        		salida[i] = puntuacion;
        		i++;
            } //while
            br.close();
        } catch(Exception ex) {
        	ex.printStackTrace();
        } // Fin del bloque try-catch
        return salida;
	} // Fin del método leerDatos()
	
} // Fin de la clase Archivos