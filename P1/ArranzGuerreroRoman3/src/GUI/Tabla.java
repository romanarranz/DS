package GUI;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class Tabla extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private String[] nombreColumnas;
	private ArrayList<ArrayList<Object>> datos;

    public Tabla() {
    	nombreColumnas = new String[]{"#","Numero de Peticiones","Nombre","Precio Unitario","Descuento aplicable"};
    	datos = new ArrayList<>();
    	addRow();
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

	public void addRow(){
		ArrayList<Object> row = new ArrayList<Object>();
				
		row.add(new String(""));
		row.add(new String(""));
		row.add(new String(""));
		row.add(new String(""));
		row.add(new String(""));
		
		datos.add(row);
	}
	
	public void setDato(int i, int j, Object dato){
		datos.get(i).set(j, dato);
		fireTableDataChanged();
	}
}                    