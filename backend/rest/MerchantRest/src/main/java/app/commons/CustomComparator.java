package app.commons;

import java.util.Comparator;

import app.model.Season;

public class CustomComparator implements Comparator<Season> {
    @Override
    public int compare(Season s1, Season s2) {
        return s1.getDate().compareTo(s2.getDate());
    }
}