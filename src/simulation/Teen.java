package simulation;

import database.Child;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Teen implements ChildAgeCategory {

    private Child childRef;

    public Teen(final Child child) {
        childRef = child;
    }

    @Override
    public Double calculateAverageScore() {
        ArrayList<Double> niceHistory = childRef.getNiceHistory();
        double sum = 0.0;
        int weights = 0;

        if (niceHistory.isEmpty()) {
            return childRef.getNiceScore();
        }

        HashMap<Double, Integer> map = new HashMap<>();
        for (Double niceScore : niceHistory) {
            if (map.containsKey(niceScore)) {
                map.put(niceScore, map.get(niceScore) + 1);
            } else {
                map.put(niceScore, 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            sum += entry.getKey() * entry.getValue();
            weights += entry.getValue();
        }
        return (Double) (sum / weights);
    }
}
