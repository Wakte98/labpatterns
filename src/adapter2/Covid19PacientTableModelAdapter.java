package adapter2;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.swing.table.AbstractTableModel;

import domain.Covid19Pacient;
import domain.Symptom;
import iterator.Covid19PacientIterator;

public class Covid19PacientTableModelAdapter extends AbstractTableModel {
	
	  protected Covid19Pacient pacient;
	  protected String[] columnNames =
	    new String[] {"Pacient", "Symptom", "Weight" };
	  protected List<Symptom> symptoms = new Vector<Symptom>();
	  
	  public Covid19PacientTableModelAdapter(Covid19Pacient p) {
	    this.pacient=p;
	    Iterator<Symptom> i= pacient.getSymptoms().iterator();
		  while(i.hasNext()) {
			  this.symptoms.add(i.next());
		  }
	  }

	  /**
	   * @author Josus009
	   * this method returns the number of colums in the table
	   */
	  public int getColumnCount() {
		 return columnNames.length;
	  }

	  /**
	   * @author Josus009
	   * this method returns the name of the colums of the table
	   */
	  public String getColumnName(int i) {
		  return columnNames[i];
	  }

	  /**
	   * @author Josus009
	   * this method returns the number of rows in the table
	   */
	  public int getRowCount() {
		  return pacient.getSymptoms().size();
	  }

	  /**
	   * @author Josus009
	   * @param row, number of the row of the element to return
	   * @param col, number of the column of the element to return
	   * this method returns the element of the cell at (row, col)
	   */
	  public Object getValueAt(int row, int col) {
		  Symptom s = symptoms.get(row);
		  if(col==0) return pacient.getName();
		  if(col==1) return s.getName();
		  else return pacient.getWeight(s);
	  }
	}