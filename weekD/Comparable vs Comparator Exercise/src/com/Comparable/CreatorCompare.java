package com.Comparable;

import java.util.Comparator;

public class CreatorCompare implements Comparator<TV_Show> {

    public int compare(TV_Show t1, TV_Show t2) {
        return t1.getCreator().compareTo(t2.getCreator());
    }

}
