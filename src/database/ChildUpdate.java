package database;

import enums.Category;

import java.util.ArrayList;

public class ChildUpdate {

    public ChildUpdate() {

    }

    private Long id;
    private Double niceScore;
    private ArrayList<Category> newPreferences = new ArrayList<>();

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

    public ArrayList<Category> getNewPreferences() {
        return newPreferences;
    }

    public void addNewPreferences(Category giftCat) {
        this.newPreferences.add(giftCat);
    }
}
