package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
    private String start;
    private String stop;
    private float minYAxis;
    private float maxYAxis;
    private int muestras;
    private int fastUpdate = 100;
    private int slowUpdate = fastUpdate* 20;
   
    private ChartPanel panelGraficos;
    private JPanel btnPanel; 
    
    private float temperaturaActual;
    private ArrayList<Integer> t;
    
    private DynamicTimeSeriesCollection dataset;
	public GraficaTemperatura(final String nombreSerie) {
		tituloGrafica = "Monitor Temperaturas Cº";
		start = "Comenzar";
		stop = "Parar";
		
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

		final JButton run = new JButton(stop);
		
		run.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if (stop.equals(cmd)) {
					//timer.stop();
					run.setText(start);
				} else {
					//timer.start();
					run.setText(stop);
				}
			}
		});

		final JComboBox<String> combo = new JComboBox<String>();
		combo.addItem("Lento");
		combo.addItem("Rapido");		
		combo.addActionListener(new ActionListener() {	        
			@Override
	        public void actionPerformed(ActionEvent e) {
	            if ("Rapido".equals(combo.getSelectedItem())) {
	            	//timer.setDelay(FAST);
	            	System.out.println(fastUpdate+"fast");
	            } else {
	                //timer.setDelay(SLOW);
	            	System.out.println(slowUpdate+"slow");
	            }
	        }
		});

		panelGraficos = new ChartPanel(chart);
		panelGraficos.setBounds(0, 0, 336, 415);
		btnPanel = new JPanel();
		btnPanel.add(run);
		btnPanel.add(combo);
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
