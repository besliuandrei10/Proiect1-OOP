package simulation;

import database.Child;

public class Baby implements ChildAgeCategory {

    private Child childRef;

    public Baby(final Child child) {
        childRef = child;
    }

    @Override
    public Double calculateAverageScore() {
        return 10.0;
    }
}
