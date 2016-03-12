package GUI;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class Tabla extends AbstractTableModel {
	private String[] nombreColumnas;
	private ArrayList<ArrayList<Object>> datos;

    public Tabla() {
    	nombreColumnas = new String[]{"#","Name","Price","Quantity"};
    	datos = new ArrayList<>();
    	for(int i = 0; i<3; i++){
			datos.add(new ArrayList<Object>());
		}
    	rellenaDatosEjemplo();
    }

	@Override
	public int getRowCount() {
		return datos.size();
	}

	@Override
	public int getColumnCount() {
		return datos.get(0).size();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
	    return nombreColumnas[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return datos.get(rowIndex).get(columnIndex);
	}

	private void rellenaDatosEjemplo(){
		datos.get(0).add(new String("Kathy"));
		datos.get(0).add(new String("Doe"));
		datos.get(0).add(new String("Rowing"));
		datos.get(0).add(new Integer(3));
		
		datos.get(1).add(new String("Kathy"));
		datos.get(1).add(new String("Doe"));
		datos.get(1).add(new String("Rowing"));
		datos.get(1).add(new Integer(3));
		
		datos.get(2).add(new String("Kathy"));
		datos.get(2).add(new String("Doe"));
		datos.get(2).add(new String("Rowing"));
		datos.get(2).add(new Integer(3));
	}
	
	public void setDato(int i, int j, Object dato){
		datos.get(i).set(j, dato);
	}
}                    