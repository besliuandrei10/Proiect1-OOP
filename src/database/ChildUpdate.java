package database;

import enums.Category;

import java.util.LinkedList;

public class ChildUpdate {

    public ChildUpdate() {

    }

    private Long id;
    private Double niceScore;
    private LinkedList<Category> newPreferences = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(Double niceScore) {
        this.niceScore = niceScore;
    }

    public LinkedList<Category> getNewPreferences() {
        return newPreferences;
    }

    public void addNewPreferences(Category giftCat) {
        this.newPreferences.add(giftCat);
    }

}
