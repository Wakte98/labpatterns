package comparator;

import java.util.Comparator;

import domain.Symptom;

public class SeverityIndexComparator implements Comparator<Object>{
	public int compare (Object o1, Object o2) {
		Symptom s1=(Symptom) o1;
		Symptom s2=(Symptom) o2;
		return Integer.compare(s1.getSeverityIndex(), s2.getSeverityIndex());
	}
}
