package database;

import java.util.ArrayList;

public class AnnualChange {

    public AnnualChange() { }

    private Double newSantaBudget;
    private ArrayList<Gift> newGifts = new ArrayList<>();
    private ArrayList<Child> newChildren = new ArrayList<>();
    private ArrayList<ChildUpdate> childrenUpdates = new ArrayList<>();

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public ArrayList<Gift> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(ArrayList<Gift> newGifts) {
        this.newGifts = newGifts;
    }

    public void addNewGifts(Gift gift) {
        this.newGifts.add(gift);
    }

    public ArrayList<Child> getNewChildren() {
        return newChildren;
    }

    public void addNewChildren(Child child) {
        this.newChildren.add(child);
    }

    public void setNewChildren(ArrayList<Child> newChildren) {
        this.newChildren = newChildren;
    }

    public ArrayList<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(ArrayList<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    public void addChildrenUpdates(ChildUpdate update) {
        this.childrenUpdates.add(update);
    }

    @Override
    public String toString() {
        return "AnnualChange{" +
                "newSantaBudget=" + newSantaBudget +
                ", newGifts=" + newGifts +
                ", newChildren=" + newChildren +
                ", childrenUpdates=" + childrenUpdates +
                '}';
    }
}
