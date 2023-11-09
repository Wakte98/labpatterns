package adapter2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.TableModel;

import domain.Covid19Pacient;


public class ShowPacientTableGUI extends JFrame{
	
	JTable table;
	Covid19Pacient pacient;
	List<Covid19Pacient> pacients;
	int index;
	
  public ShowPacientTableGUI(Covid19Pacient pacient) {
	  	this.setTitle("Covid Symptoms "+pacient.getName());
	  	
	  	this.pacient=pacient;
	  	
	  	setFonts();
	    
	  	TableModel tm=new Covid19PacientTableModelAdapter(pacient);
		table = new JTable(tm);
	    table.setRowHeight(36);
	    JScrollPane pane = new JScrollPane(table);
	    pane.setPreferredSize(
	      new java.awt.Dimension(300, 200));
	    this.getContentPane().add(pane);
	    
	    addNextButton();
  }
  
  /**
   * @author Josus009
   * @param pacients. A collection of pacients.
   * @param index of the current pacient.
   * 
   * This method calls to the main constructor with the pacient of the #index position of the list
   * of pacients.
   */ 
  public ShowPacientTableGUI(List<Covid19Pacient> pacients, int index) {
	  this(pacients.get(index));
	  this.index=index;
	  this.pacients=pacients;
	  
	  addNextButton();
  }
  
  /**
   * @author Josus009
   * @param pacients. A collection of pacients.
   * 
   * This method calls to the main constructor with the pacient of the first position of the list
   * of pacients.
   */
  public ShowPacientTableGUI(List<Covid19Pacient> pacients) {
	  this(pacients.get(0));
	  this.index = 0;
	  this.pacients=pacients;
	  
	  addNextButton();
  }
  
  /**
   * @author Josus009
   * 
   * This method includes the logic of the button for switching between pacients in the GUI.
   */
  private void addNextButton() {
      JButton nextButton = new JButton("Next Pacient");
      nextButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              index = (index + 1) % pacients.size(); // Avanza al siguiente paciente (o vuelve al primero si es el último)
              ShowPacientTableGUI nextGUI = new ShowPacientTableGUI(pacients, index);
              nextGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              nextGUI.pack();
              nextGUI.setLocationRelativeTo(null);
              nextGUI.setPreferredSize(
    			      new java.awt.Dimension(300, 200));
              nextGUI.setVisible(true);
              dispose(); // Cierra la ventana actual
          }
      });

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(nextButton);
      this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
  }

  private static void setFonts() {
    Font font = new Font("Dialog", Font.PLAIN, 18);
    UIManager.put("Table.font", font);
    UIManager.put("TableHeader.font", font);
  }
}
