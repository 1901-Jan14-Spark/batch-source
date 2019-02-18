package com.Comparable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<TV_Show> list = new ArrayList<>();
        list.add(new TV_Show("The Haunting of Hill House", "Mike Flanagan", 10, 8.8));
        list.add(new TV_Show("Breaking Bad", "Vince Gilligan", 62, 9.4));
        list.add(new TV_Show("Band of Brothers", "Rick Winter", 15, 9.5));
        list.add(new TV_Show("Game of Thrones", "David Benioff, D.B. Weiss", 73, 9.6));
        list.add(new TV_Show("Sherlock", "Mark Gatiss, Steven Moffat", 15, 9.1));

        Collections.sort(list);

        System.out.println("Sorting TV shows by its episode number:");
        for (TV_Show show : list) {
            System.out.println(show.getTitle() + " created by: " +
                                show.getCreator() + " has " +
                                show.getEpNumber() + " episodes, with an IMBD rating of " +
                                show.getRating());
        }

        System.out.println();
        System.out.println("********************************************");
        System.out.println();
        System.out.println("Sorting TV shows by its title:");
        TitleCompare titleCompare = new TitleCompare();
        Collections.sort(list, titleCompare);
        for (TV_Show show: list) {
            System.out.println(show.getTitle() + " created by: " +
                    show.getCreator() + " has " +
                    show.getEpNumber() + " episodes, with an IMBD rating of " +
                    show.getRating());
        }

        System.out.println();
        System.out.println("********************************************");
        System.out.println();
        System.out.println("Sorting TV shows by its creator:");
        CreatorCompare creatorCompare = new CreatorCompare();
        Collections.sort(list, creatorCompare);
        for (TV_Show show: list) {
            System.out.println(show.getTitle() + " created by: " +
                    show.getCreator() + " has " +
                    show.getEpNumber() + " episodes, with an IMBD rating of " +
                    show.getRating());
        }

        System.out.println();
        System.out.println("********************************************");
        System.out.println();
        System.out.println("Sorting TV shows by its rating:");
        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(list, ratingCompare);
        for (TV_Show show: list) {
            System.out.println(show.getTitle() + " created by: " +
                    show.getCreator() + " has " +
                    show.getEpNumber() + " episodes, with an IMBD rating of " +
                    show.getRating());
        }
    }
}
