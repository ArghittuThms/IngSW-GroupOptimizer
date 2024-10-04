package group_opt;

import com.opencsv.exceptions.CsvException;
import utils.CombinationGenerator;
import utils.DataCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Group {

    private final List<String> components_name;
    private final List<List<Integer>> csv_data_score;
    private List<List<Integer>> opt_groups;
    private double avg_group_score;

    //region Constructors
    private Group() {
        components_name = new ArrayList<>();
        csv_data_score = new ArrayList<>();
        opt_groups = new ArrayList<>();

        avg_group_score = 0;
    }

    public Group(String path) throws IOException, CsvException {
        this();

        importData(DataCSV.loadCSVFile(path));
    }
    //endregion

    //region Public Method
    public void calculateOptGroups() throws Exception {
        List<Integer> init_comb = IntStream.rangeClosed(0, csv_data_score.getFirst().size() - 1).boxed().toList();
        List<List<Integer>> combinations = CombinationGenerator.generateComb(init_comb);

        for (List<Integer> list : combinations) {
            double group_1 = calculateAvg(list.subList(0, list.size()/2 ));
            double group_2 = calculateAvg(list.subList(list.size()/2, list.size()));

            double groups_avg = (group_1 + group_2) / 2;

            if (groups_avg > avg_group_score) {
                System.out.println("DEBUG: groups " + list.subList(0, list.size()/2 ) + list.subList(list.size()/2, list.size()));
                System.out.println("DEBUG: g1 " + group_1);
                System.out.println("DEBUG: g2 " + group_2);
                System.out.println("DEBUG: g_avg " + groups_avg);
                System.out.println();


                opt_groups.clear();
                opt_groups.add(list);
                avg_group_score = groups_avg;
            } else if (groups_avg == avg_group_score) {
                opt_groups.add(list);
            }
        }
    }

    /**
     * Prints the content of the csv_data_score list.
     */
    public void printCsvDataScoreFormatted() {
        for (List<Integer> row : csv_data_score) {
            for (Integer value : row) {
                System.out.print(value + "\t");  // Prints each value followed by a tab.
            }
            System.out.println();  // Moves to the next line after printing all values in the row.
        }
    }

    public List<String> getComponents_name() {
        return components_name;
    }

    public List<List<Integer>> getCsv_data_score() {
        return csv_data_score;
    }

    // TODO: Return integer mapped with real components name
    public List<List<Integer>> getOpt_groups() {
        return opt_groups;
    }

    public double getAvg_group_score() {
        return avg_group_score;
    }

    //endregion

    //region Private Methods
    /**
     * Imports data from a list of string arrays (typically loaded from a CSV file) and populates two internal lists:
     * 1. [csv_data_score]: Populated with integer scores extracted from the imported data (starting from the second row).
     * 2. [components_name]: Populated with component names extracted from the first row of the imported data.
     *
     * @param imported_data A list of string arrays where each array represents a row of data from the CSV file.
     *                      The first row contains component names, and the following rows contain scores.
     */
    private void importData(List<String[]> imported_data) {
        int n = imported_data.size();

        /*
          Populate [csv_data_score] with integers loaded from CSV file
         */
        for (int i = 1; i <= n - 1; i++) {
            List<Integer> temp_list = new ArrayList<>();

            for (int j = 1; j <= n - 1; j++) {
                temp_list.add(Integer.parseInt(imported_data.get(i)[j]));
            }

            csv_data_score.add(temp_list);
        }


        /*
          Populate [components_name] with names loaded from CSV file
         */
        for (int i = 0; i < n; i++) {
            components_name.add(imported_data.getFirst()[i]);
        }
    }

    public double calculateAvg (List<Integer> values) {
        int total = 0;

        for (int i=0; i<values.size(); i++) {
            for (int j=i+1; j<values.size(); j++) {
                total += csv_data_score.get(values.get(i)).get(values.get(j));
                total += csv_data_score.get(values.get(j)).get(values.get(i));
            }
        }

        return (double)total/values.size();
    }
    //endregion
}
