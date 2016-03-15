/**
 * Universidad de Granada - Grado en Informatica : 2016  
 * 
 * Asignatura: Desarrollo de Software
 * Practica 1 - Ejercicio 3
 * 
 * @author Roman Arranz Guerrero
 * @email roarrgue@gmail.com
 * 
 */

package GUI;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

// Implementacion del modelo tabla para que pueda actualizarse dinamicamente
public class Tabla extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private String[] nombreColumnas;
	private ArrayList<ArrayList<Object>> datos;

    public Tabla() {
    	// cabecera de la tabla
    	nombreColumnas = new String[]{"#","Numero de Peticiones","Nombre","Precio Unitario","Descuento aplicable"};
    	datos = new ArrayList<>();
    	
    	// añadimos la primera fila vacia
    	addRow();
    }

    // obtener numero de filas
	@Override
	public int getRowCount() {
		return datos.size();
	}

	// obtener numero de columnas
	@Override
	public int getColumnCount() {
		return datos.get(0).size();
	}
	
    // obtener nombre de la fila i
	@Override
	public String getColumnName(int columnIndex) {
	    return nombreColumnas[columnIndex];
	}

    // obtener el valor de la fila i y la columna j
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return datos.get(rowIndex).get(columnIndex);
	}

    // añadir una fila vacia
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
		
		// refrescar la tabla
		fireTableDataChanged();
	}
}                    