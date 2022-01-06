package simulation;

import database.Child;

public class YoungAdult implements ChildAgeCategory {

    private Child childRef;

    public YoungAdult(Child child) {
        childRef = child;
    }

    @Override
    public Double calculateAverageScore() {
        return null;
    }
}
