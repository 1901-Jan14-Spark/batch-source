package pillar.java.exersice;

import java.util.Comparator;

public class OcelotComp implements Comparator<Ocelot> {
//I think this is the right implementation of this. But I'm not quite sure.
	@Override
	public int compare(Ocelot o1, Ocelot o2) {
		return o1.getTaxonomy().compareTo(o2.getTaxonomy());
	}

}
