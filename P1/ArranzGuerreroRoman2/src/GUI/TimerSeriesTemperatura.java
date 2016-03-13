package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
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

public class TimerSeriesTemperatura {
	
	private static final String TITLE = "Dynamic Series";
    private static final String START = "Start";
    private static final String STOP = "Stop";
    private static final float MINMAX = 100;
    private static final int COUNT = 2 * 60;
    private static final int FAST = 100;
    private static final int SLOW = FAST * 5;
    private static final Random random = new Random();
    private Timer timer;
    private ChartPanel panelGraficos;
    private JPanel btnPanel; 
    
	public TimerSeriesTemperatura() {
		final DynamicTimeSeriesCollection dataset = new DynamicTimeSeriesCollection(1, COUNT, new Second());
		dataset.setTimeBase(new Second(0, 0, 0, 1, 1, 2011));
		dataset.addSeries(gaussianData(), 0, "Gaussian data");
		
		JFreeChart chart = createChart(dataset);

		final JButton run = new JButton(STOP);
		
		run.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if (STOP.equals(cmd)) {
					timer.stop();
					run.setText(START);
				} else {
					timer.start();
					run.setText(STOP);
				}
			}
		});

		final JComboBox combo = new JComboBox();
		combo.addItem("Fast");
		combo.addItem("Slow");
		combo.addActionListener(new ActionListener() {	        
			@Override
	        public void actionPerformed(ActionEvent e) {
	            if ("Fast".equals(combo.getSelectedItem())) {
	            	timer.setDelay(FAST);
	            } else {
	                timer.setDelay(SLOW);
	            }
	        }
		});

		panelGraficos = new ChartPanel(chart);
		btnPanel = new JPanel(new FlowLayout());
		btnPanel.add(run);
		btnPanel.add(combo);

		timer = new Timer(FAST, new ActionListener() {
	        float[] newData = new float[1];
	
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            newData[0] = randomValue();
	            System.out.println("dataset1 : " + dataset.advanceTime());
	            dataset.advanceTime();
	            dataset.appendData(newData);
	        }
		});
	}
		
	private float randomValue() {
	    System.out.println("randomvalue : " + (float) (random.nextGaussian() * MINMAX / 3));
	    return (float) (random.nextGaussian() * MINMAX / 3);
	}
	
	private float[] gaussianData() {
	    float[] a = new float[COUNT];
	    for (int i = 0; i < a.length; i++) {
	        a[i] = randomValue();
	    }
	
	    return a;
	}
	
	private JFreeChart createChart(final XYDataset dataset) {
	    final JFreeChart result = ChartFactory.createTimeSeriesChart(
	        TITLE, "hh:mm:ss", "Claims Received", dataset, true, true, false);
	    final XYPlot plot = result.getXYPlot();
	    ValueAxis domain = plot.getDomainAxis();
	    domain.setAutoRange(true);
	    ValueAxis range = plot.getRangeAxis();
	    range.setRange(-MINMAX, MINMAX);
	
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
}
