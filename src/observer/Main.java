package observer;

import java.util.Observable;

import factory.SymptomFactory;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String	args[]){
		Observable pacient=new	Covid19Pacient("aitor",	35, new SymptomFactory());
		new	PacientObserverGUI(pacient);
		new	PacientSymptomGUI((Covid19Pacient)pacient);
		new PacientThermometerGUI(pacient);
		
		Observable pacient2=new	Covid19Pacient("ane",	29, new SymptomFactory());
		new	PacientObserverGUI(pacient2);
		new	PacientSymptomGUI((Covid19Pacient)pacient2);
		new PacientThermometerGUI(pacient2);
	}

}
