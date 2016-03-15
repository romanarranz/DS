/**
 * Universidad de Granada - Grado en Informatica : 2016  
 * 
 * Asignatura: Desarrollo de Software
 * Practica 1 - Ejercicio 1
 * 
 * @author Roman Arranz Guerrero
 * @email roarrgue@gmail.com
 * 
 */

package GUI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ejer2.Observador;

public class TiempoSatelital implements Observador{
	private JLabel label;
	private int contadorImagenes;
	
	private ArrayList<String> imagenesLista;
	
	public TiempoSatelital(){
		contadorImagenes = 6;
		imagenesLista = new ArrayList<String>();
		imagenesLista.add("imagenes/image0.gif");
		imagenesLista.add("imagenes/image1.gif");
		imagenesLista.add("imagenes/image2.gif");
		imagenesLista.add("imagenes/image3.gif");
		imagenesLista.add("imagenes/image4.gif");
		imagenesLista.add("imagenes/image5.gif");
		
		label = new JLabel(new ImageIcon((new ImageIcon(imagenesLista.get(0))).getImage().getScaledInstance(500, 370,java.awt.Image.SCALE_SMOOTH)));
	}
	
	// Metodo para captar y guardar imagenes de google
	private void captaYGuardaImagen(){
		
		// No queremos mas de 10 imagenes de satelites en la carpeta
		if(contadorImagenes<10){
			try {
	            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=Madrid,Spain&zoom=6&size=800x800&maptype=hybrid&key=ABQIAAAAgb5KEVTm54vkPcAkU9xOvBR30EG5jFWfUzfYJTWEkWk2p04CHxTGDNV791-cU95kOnweeZ0SsURYSA&format=jpg";
	            String destinationFile = "imagenes/image"+contadorImagenes+".jpg";
	            URL url = new URL(imageUrl);
	            InputStream is = url.openStream();
	            OutputStream os = new FileOutputStream(destinationFile);
	
	            byte[] b = new byte[2048];
	            int length;
	
	            while ((length = is.read(b)) != -1) {
	                os.write(b, 0, length);
	            }
	
	            is.close();
	            os.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.exit(1);
	        }
			contadorImagenes++;
		}
	}
	
	public JLabel getMapa(){
		return label;
	}
	
	private static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public ImageIcon actualiza(){
		String imagenSeleccionada = imagenesLista.get(randInt(0,imagenesLista.size()-1));
		return new ImageIcon((new ImageIcon(imagenSeleccionada)).getImage().getScaledInstance(500, 370,java.awt.Image.SCALE_SMOOTH));
	}

	@Override
	public void manejarEvento(int temperaturaActual) {
		captaYGuardaImagen();
	}
}
