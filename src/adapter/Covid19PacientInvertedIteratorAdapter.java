package adapter;

import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientInvertedIteratorAdapter implements InvertedIterator{
	
	protected Covid19Pacient pacient;
	protected Symptom[] symptoms;
	protected int lastIndex;
	protected int position;
	
	public Covid19PacientInvertedIteratorAdapter(Covid19Pacient pacient) {
		this.pacient = pacient;
		this.symptoms = pacient.getSymptoms().toArray(new Symptom[pacient.getSymptoms().size()]);
		this.lastIndex = symptoms.length;
	}

	@Override
	public Object previous() {
		if(position>0) {
			this.position-=1;
			return symptoms[position];
		}else return null;
	}

	@Override
	public boolean hasPrevious() {
		return position>0;
	}

	@Override
	public void goLast() {
		this.position = lastIndex;
		
	}

}
