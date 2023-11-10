package adapter2;

import java.util.List;
import java.util.Vector;

import domain.Covid19Pacient;
import factory.SymptomFactory;

public class Main {

	public static void main(String[] args) {
		Covid19Pacient pacient=new Covid19Pacient("Aitor", 35, new SymptomFactory());
		Covid19Pacient pacient2=new Covid19Pacient("Ainara", 26, new SymptomFactory()); //Nuevo Paciente
		
		pacient.addSymptomByName("disnea", 2);
		pacient.addSymptomByName("cefalea", 1);
		pacient.addSymptomByName("astenia", 3);
		
		pacient2.addSymptomByName("diarrea", 1);
		pacient2.addSymptomByName("astenia", 3);
		pacient2.addSymptomByName("nauseas", 1);
		pacient2.addSymptomByName("vomitos", 2);
		
		List<Covid19Pacient> pacients = new Vector<Covid19Pacient>();
		pacients.add(pacient);
		pacients.add(pacient2);
		
		ShowPacientTableGUI gui=new ShowPacientTableGUI(pacients);
		gui.setPreferredSize(
			      new java.awt.Dimension(300, 200));
		gui.setVisible(true);


	}

}
