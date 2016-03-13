package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.DynamicTimeSeriesCollection;
import org.jfree.data.time.Second;
import org.jfree.data.xy.XYDataset;

import ejer2.GraficaTemperatura;

public class TimerSeriesTemperatura {
	
	private static final String TITLE = "Monitor Temperaturas Cº";
    private static final String START = "Comenzar";
    private static final String STOP = "Parar";
    private static final float MINMAX = 50;
    private static final int COUNT = 30;
    private static final int FAST = 100;
    private static final int SLOW = FAST * 20;
   
    private Timer timer;
    private ChartPanel panelGraficos;
    private JPanel btnPanel; 
    
    private float temperaturaActual;
    private ArrayList<Integer> t;
    
    private DynamicTimeSeriesCollection dataset;
	public TimerSeriesTemperatura(final String nombreSerie) {
		t = getTiempo();
		
		//final DynamicTimeSeriesCollection dataset = new DynamicTimeSeriesCollection(1, COUNT, new Second());
		dataset = new DynamicTimeSeriesCollection(1, COUNT, new Second());
		dataset.setTimeBase(new Second(t.get(0), t.get(1), t.get(2), t.get(3), t.get(4), t.get(5)));
		dataset.addSeries(generateData(), 0, nombreSerie);
		
		JFreeChart chart = createChart(dataset);

		final JButton run = new JButton(STOP);
		
		run.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if (STOP.equals(cmd)) {
					//timer.stop();
					run.setText(START);
				} else {
					//timer.start();
					run.setText(STOP);
				}
			}
		});

		final JComboBox combo = new JComboBox();
		combo.addItem("Lento");
		combo.addItem("Rapido");		
		combo.addActionListener(new ActionListener() {	        
			@Override
	        public void actionPerformed(ActionEvent e) {
	            if ("Rapido".equals(combo.getSelectedItem())) {
	            	//timer.setDelay(FAST);
	            	System.out.println(FAST+"fast");
	            } else {
	                //timer.setDelay(SLOW);
	            	System.out.println(SLOW+"slow");
	            }
	        }
		});

		panelGraficos = new ChartPanel(chart);
		//btnPanel = new JPanel(new FlowLayout());
		panelGraficos.setBounds(0, 0, 336, 415);
		btnPanel = new JPanel();
		btnPanel.add(run);
		btnPanel.add(combo);

		/*timer = new Timer(SLOW, new ActionListener() {
	        float[] newData = new float[1];
	
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            newData[0] = temperaturaActual;
	            //System.out.println("dataset1 : " + dataset.advanceTime());
	            dataset.advanceTime();
	            dataset.appendData(newData);
	        }
		});*/
	}
	
	private float[] generateData() {
	    float[] a = new float[COUNT];
	    for (int i = 0; i < a.length; i++) {
	        a[i] = GraficaTemperatura.randomTemperatura();
	    }
	
	    return a;
	}
	
	private JFreeChart createChart(final XYDataset dataset) {
	    final JFreeChart result = ChartFactory.createTimeSeriesChart(
	        TITLE, t.get(3)+"/"+t.get(4)+"/"+t.get(5), "Temperaturas", dataset, true, true, false
	    );
	    final XYPlot plot = result.getXYPlot();
	    ValueAxis domain = plot.getDomainAxis();
	    domain.setAutoRange(true);
	    ValueAxis range = plot.getRangeAxis();
	    range.setRange(0, MINMAX);
	
	    return result;
	}
	
	public void start() {
	    timer.start();
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
            //System.out.println("dataset1 : " + dataset.advanceTime());
            dataset.advanceTime();
            dataset.appendData(newData);
	}
}
