package simulation;

import com.fasterxml.jackson.databind.ObjectMapper;
import database.Database;
import io.Writer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Simulation {

    private JSONArray annualChanges;

    public Simulation() {

    }

    public void writeReport(final FileWriter file) throws IOException {
        JSONObject output = new JSONObject();
        output.put("annualChanges", this.annualChanges);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(output);

        file.write(json);
        file.close();
    }

    public void simulateYears() {
        Long numberOfYears = Database.getInstance().getNumberOfYears();
        JSONArray annualChanges = new JSONArray();

        for (int i = 0; i < numberOfYears + 1; i++) {
            // simulate stuff
            JSONObject children = Writer.writeAllChildren();
            annualChanges.add(children);
        }
        this.annualChanges = annualChanges;
    }
}
