package database;

import enums.Category;
import enums.Cities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class Child {

    public Child() { }

    // data gathered from parser
    private Long id;
    private Long age;
    private String lastName;
    private String firstName;
    private Cities city;
    private Double niceScore;
    private ArrayList<Category> giftsPreferences = new ArrayList<>();

    // data for simulation needs
    private Double averageScore;
    private ArrayList<Double> niceHistory = new ArrayList<>();
    private ArrayList<Gift> receivedGifts = new ArrayList<>();

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public ArrayList<Double> getNiceHistory() {
        return niceHistory;
    }

    public void setNiceHistory(ArrayList<Double> niceHistory) {
        this.niceHistory = niceHistory;
    }

    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(ArrayList<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public void setGiftsPreferences(ArrayList<Category> giftsPreferences) {
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

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void addGiftsPreferences(Category gift) {
        this.giftsPreferences.add(gift);
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
        output.put("giftPreferences", giftPreferences);
        output.put("averageScore", this.averageScore);

        JSONArray niceScoreHistory = new JSONArray();
        for (Double score : this.getNiceHistory()) {
            niceScoreHistory.add(score);
        }
        output.put("niceScoreHistory", niceScoreHistory);
        output.put("assignedBudget", "69");

        JSONArray receivedGifts = new JSONArray();
        for (Gift gift : this.getReceivedGifts()) {
            niceScoreHistory.add(gift.toJSONObject());
        }
        output.put("receivedGifts", receivedGifts);

        return output;
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
