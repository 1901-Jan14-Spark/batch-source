import java.util.Comparator;

/**
 * NumLegComp
 */
public class NumLegComp implements Comparator<Animal> {
    public int compare(Animal a1, Animal a2){
        Integer a1I = a1.getNumLegs(); Integer a2I = a2.getNumLegs();
        return a1I.compareTo(a2I);
    }

}