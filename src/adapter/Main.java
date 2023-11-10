package adapter;

import java.util.Iterator;

import comparator.SeverityIndexComparator;
import comparator.SymptomNameComparator;
import domain.Covid19Pacient;
import domain.Symptom;
import factory.SymptomFactory;

public class Main {
	public static void main(String[] args) {
		Covid19Pacient p=new Covid19Pacient("Amagoia", 23, new SymptomFactory());
		p.addSymptom(new Symptom("nauseas", 10, 10), 1);
		p.addSymptom(new Symptom("astenia", 10, 12), 2);
		p.addSymptom(new Symptom("expectoracion", 10, 11), 5);
		p.addSymptom(new Symptom("vomitos", 10, 10), 3);
		p.addSymptom(new Symptom("mialgia", 10, 15), 4);
		
		
		//Instancias de los comparadores
		SymptomNameComparator nameComparator = new SymptomNameComparator();
        SeverityIndexComparator severityComparator = new SeverityIndexComparator();
        
        //Instancio el adapter
        InvertedIterator adapter = new Covid19PacientInvertedIteratorAdapter(p);
        
        //Imprimimos por orden de nombre
        System.out.println("Symptoms sorted by name: ");
        Iterator i=Sorting.sortedIterator(adapter, nameComparator);
        while(i.hasNext()) {
        	System.out.println(i.next());
        }
		
        //Ordenamos por orden de severidad
        System.out.println("\nSymptoms sorted by severity index: ");
		i=Sorting.sortedIterator(adapter, severityComparator);
		while(i.hasNext())
			System.out.println(i.next());
	}

}
