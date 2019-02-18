package weekC.assignment;
import java.util.*;

public class WeightComp implements Comparator<Elephant>{

	@Override
	public int compare(Elephant e1, Elephant e2) {
		return e1.getWeight() - e2.getWeight();
	}

}
