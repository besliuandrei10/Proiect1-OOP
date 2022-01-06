package database;

import java.util.ArrayList;
import java.util.LinkedList;

public class Database {
    private final static Database database = new Database();

    Long numberOfYears;
    Double santaBudget;

    LinkedList<Child> childList = new LinkedList<>();
    ArrayList<Gift> giftList = new ArrayList<>();
    ArrayList<AnnualChange> changes = new ArrayList<>();

    public ArrayList<AnnualChange> getChanges() {
        return changes;
    }

    public void setChanges(ArrayList<AnnualChange> changes) {
        this.changes = changes;
    }

    public void addChange(AnnualChange change) {
        this.changes.add(change);
    }

    public Long getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(Long numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public ArrayList<Gift> getGiftList() {
        return giftList;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public LinkedList<Child> getChildList() {
        return childList;
    }

    public void addToChildList(Child child) {
        this.childList.add(child);
    }

    public void removeFromChildList(Child child) {
        this.childList.remove(child);
    }

    public void addToGiftsList(Gift gift) {
        this.giftList.add(gift);
    }

    public Child childByID(final Long id) {
        for (Child child : this.childList) {
            if (child.getId().equals(id)) {
                return child;
            }
        }
        return null;
    }

    public void clearDatabase() {
        this.childList.clear();
        this.giftList.clear();
        this.numberOfYears = 0L;
        this.santaBudget = 0.0;
        this.changes.clear();
    }

    public Database() { }

    public static Database getInstance() {
        return database;
    }
}
