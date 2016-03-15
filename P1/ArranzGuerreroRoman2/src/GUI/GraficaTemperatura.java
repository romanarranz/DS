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
		
		//final DynamicTimeSeriesCollection dataset = new DynamicTimeSeriesCollection(1, COUNT, new Second());
		dataset = new DynamicTimeSeriesCollection(1, muestras, new Second());
		dataset.setTimeBase(new Second(t.get(0), t.get(1), t.get(2), t.get(3), t.get(4), t.get(5)));
		dataset.addSeries(generateData(), 0, nombreSerie);
		
		JFreeChart chart = createChart(dataset);

		panelGraficos = new ChartPanel(chart);
		panelGraficos.setBounds(0, 0, 800, 285);
	}
	
	private float[] generateData() {
	    float[] a = new float[muestras];
	    for (int i = 0; i < a.length; i++) {
	    	a[i] = 0;
	    }
	
	    return a;
	}
	
	private JFreeChart createChart(final XYDataset dataset) {
	    final JFreeChart result = ChartFactory.createTimeSeriesChart(
	        tituloGrafica, t.get(3)+"/"+t.get(4)+"/"+t.get(5), "Temperaturas", dataset, true, true, false
	    );
	    final XYPlot plot = result.getXYPlot();
	    ValueAxis domain = plot.getDomainAxis();
	    domain.setAutoRange(true);
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
	
	private ArrayList<Integer> getTiempo(){
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

		// Imprimo cuando será la proxima actualizacion de la serie
		// System.out.println("dataset1 : " + dataset.advanceTime());
        dataset.advanceTime();
        dataset.appendData(newData);
	}

	@Override
	public void manejarEvento(int temperaturaActual) {
		actualizaTemperatura(temperaturaActual);
	}
}
