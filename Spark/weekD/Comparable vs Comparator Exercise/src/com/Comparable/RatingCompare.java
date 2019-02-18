package com.Comparable;

import java.util.Comparator;

public class RatingCompare implements Comparator<TV_Show> {

    public int compare(TV_Show t1, TV_Show t2) {
        if (t1.getRating() > t2.getRating()) return -1;
        if (t1.getRating() < t2.getRating()) return 1;
        else return 0;
    }
}
