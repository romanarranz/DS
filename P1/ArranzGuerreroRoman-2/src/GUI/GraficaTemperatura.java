/**
 * Universidad de Granada - Grado en Informatica : 2016  
 * 
 * Asignatura: Desarrollo de Software
 * Practica 1 - Ejercicio 2
 * 
 * @author Roman Arranz Guerrero
 * @email roarrgue@gmail.com
 * 
 */

package GUI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.DynamicTimeSeriesCollection;
import org.jfree.data.time.Second;
import org.jfree.data.xy.XYDataset;

import ejer2.Observador;

public class GraficaTemperatura implements Observador{
	
	private String tituloGrafica;
    private float minYAxis;
    private float maxYAxis;
    private int muestras;
   
    private ChartPanel panelGraficos;
    private JPanel btnPanel; 
    
    private float temperaturaActual;
    private ArrayList<Integer> t;
    
    private DynamicTimeSeriesCollection dataset;
	public GraficaTemperatura(final String nombreSerie) {
		tituloGrafica = "Monitor Temperaturas Cº";
		
		// valores del eje y, desde el 0 al 50
		minYAxis = 0;
		maxYAxis = 50;
		
		// numero de muestras que van apareciendo en la serie
		muestras = 5;
		
		t = getTiempo();
		
		// serie de datos como serie dinamica, para que se pueda actualizar en el tiempo
		dataset = new DynamicTimeSeriesCollection(1, muestras, new Second());
		dataset.setTimeBase(new Second(t.get(0), t.get(1), t.get(2), t.get(3), t.get(4), t.get(5)));
		dataset.addSeries(crearDatosIniciales(), 0, nombreSerie);
		
		JFreeChart chart = crearGrafica(dataset);
		panelGraficos = new ChartPanel(chart);
		panelGraficos.setBounds(0, 0, 800, 285);
	}
	
	// metodo que crea la primera muestra de la aplicacion
	private float[] crearDatosIniciales() {
	    float[] a = new float[muestras];
	    for (int i = 0; i < a.length; i++) {
	    	a[i] = 0;
	    }
	    
	    return a;
	}
	
	// metodo para crear un JFreeChart a traves de una serie de muestras
	private JFreeChart crearGrafica(final XYDataset dataset) {
	    final JFreeChart result = ChartFactory.createTimeSeriesChart(
	        tituloGrafica, t.get(3)+"/"+t.get(4)+"/"+t.get(5), "Temperaturas", dataset, true, true, false
	    );
	    
	    final XYPlot plot = result.getXYPlot();
	    
	    // dominio en el eje X es variable, porque se ira actualizando en funcion del tiempo
	    ValueAxis domain = plot.getDomainAxis();
	    domain.setAutoRange(true);
	    
	    // rango de la serie de datos en el eje y
	    ValueAxis range = plot.getRangeAxis();
	    range.setRange(minYAxis, maxYAxis);
	
	    return result;
	}
	
	public ChartPanel getPanelChart(){
		return panelGraficos;
	}
	
	public JPanel getBtnPanel(){
		return btnPanel;
	}
	
	// obtener el timpo actual en un array de forma [sec,min,hora,dia,mes,anio]  
	private ArrayList<Integer> getTiempo(){

		// seleccionamos como region Europa/Madrid y el idioma español como referencia de partida
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid"), new Locale("es","es"));
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int hora = cal.get(Calendar.HOUR_OF_DAY);
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		int mes = cal.get(Calendar.MONTH);
		int anio = cal.get(Calendar.YEAR);
		
		ArrayList<Integer> t = new ArrayList<>();
		t.add(sec);
		t.add(min);
		t.add(hora);
		t.add(dia);
		t.add(mes);
		t.add(anio);
		
		return t;
	}
	
	public void actualizaTemperatura(int t){
		temperaturaActual = t;
		
		float[] newData = new float[1];
		newData[0] = temperaturaActual;
		
		// avanzamos la serie en el tiempo, eje x
        dataset.advanceTime();
        
        // añadimos a la serie de datos el nuevo dato, en este caso la temperaturaActual
        dataset.appendData(newData);
	}

	@Override
	public void manejarEvento(int temperaturaActual) {
		actualizaTemperatura(temperaturaActual);
	}
}
