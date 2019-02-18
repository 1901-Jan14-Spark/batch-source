package com.Comparable;

import java.util.Comparator;

public class TitleCompare implements Comparator<TV_Show> {

    public int compare(TV_Show t1, TV_Show t2) {
        return t1.getTitle().compareTo(t2.getTitle());
    }
}
