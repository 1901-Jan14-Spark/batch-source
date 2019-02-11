package animals;

import java.util.Comparator;
//trying to set up comparator
public class LegsComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}

	
	
}