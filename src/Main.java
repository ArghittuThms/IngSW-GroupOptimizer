import com.opencsv.exceptions.CsvException;
import group_opt.Group;

import java.io.IOException;


/**
 * The Main class is the entry point for running the application. It processes a CSV file, calculates the optimal groupings
 * based on the data, and prints the final results to the console.
 *
 * @author arghittu_thms
 */
public class Main {
    final static String CSV_PATH = "data.csv";
//    final static String CSV_PATH = "data2.csv";
//    final static String CSV_PATH = "data3.csv";

    public static void main(String[] args) {

        try {
            // Create a Group object by loading data from the specified CSV file.
            // The 'true' flag ensures that the CSV data is printed after loading.
            Group group = new Group(CSV_PATH, true);

            // Calculate the optimal groupings based on the data loaded from the CSV file.
            group.calculateOptGroups();

            // Print the final optimal groupings and the associated average score.
            group.printFinalOptGroupFormatted();

        } catch (IOException | CsvException e) {
            System.err.println("Error while reading CSV file: " + e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
