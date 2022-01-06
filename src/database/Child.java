package database;

import enums.Category;
import enums.Cities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;

public class Child {

    public Child() { }

    // data gathered from parser
    private Long id;
    private Long age;
    private String lastName;
    private String firstName;
    private Cities city;
    private Double niceScore;
    private LinkedList<Category> giftsPreferences = new LinkedList<>();

    // data for simulation needs
    private Double averageScore;
    private Double allocatedBudget;
    private ArrayList<Double> niceHistory = new ArrayList<>();
    private ArrayList<Gift> receivedGifts = new ArrayList<>();

    public Double getAllocatedBudget() {
        return allocatedBudget;
    }

    public void setAllocatedBudget(Double allocatedBudget) {
        this.allocatedBudget = allocatedBudget;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public ArrayList<Double> getNiceHistory() {
        return niceHistory;
    }

    public void addToNiceHistory(Double score) {
        this.niceHistory.add(score);
    }

    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(ArrayList<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public void addToReceivedGifts(Gift gift) {
        this.receivedGifts.add(gift);
    }

    public void setGiftsPreferences(LinkedList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(Double niceScore) {
        this.niceScore = niceScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public LinkedList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void addGiftsPreferences(Category category) {
        this.giftsPreferences.add(category);
    }

    public void removePreference(Category category) {
        this.giftsPreferences.remove(category);
    }

    public JSONObject toJSONObject() {
        JSONObject output = new JSONObject();

        output.put("id", this.id);
        output.put("lastName", this.lastName);
        output.put("firstName", this.firstName);
        output.put("city", this.city.getValue());
        output.put("age", this.age);

        JSONArray giftPreferences = new JSONArray();
        for (Category giftPref : this.getGiftsPreferences()) {
            giftPreferences.add(giftPref.getValue());
        }
        output.put("giftsPreferences", giftPreferences);
        output.put("averageScore", this.averageScore);

        JSONArray niceScoreHistory = new JSONArray();
        for (Double score : this.getNiceHistory()) {
            niceScoreHistory.add(score);
        }
        output.put("niceScoreHistory", niceScoreHistory);
        output.put("assignedBudget", allocatedBudget);

        JSONArray receivedGifts = new JSONArray();
        for (Gift gift : this.getReceivedGifts()) {
            receivedGifts.add(gift.toJSONObject());
        }
        output.put("receivedGifts", receivedGifts);

        return output;
    }

    public void clearFieldsForNextYear() {
        this.averageScore = 0.0;
        this.receivedGifts.clear();
        this.allocatedBudget = 0.0;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", age=" + age +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", city=" + city +
                ", niceScore=" + niceScore +
                ", giftsPreferences=" + giftsPreferences +
                '}';
    }
}
