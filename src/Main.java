import com.opencsv.exceptions.CsvException;
import group_opt.Group;
import utils.CombinationGenerator;

import java.io.IOException;
import java.util.List;


public class Main {
    final static String CSV_PATH = "data.csv";

    public static void main(String[] args) {

        try {
            Group group = new Group(CSV_PATH);

            System.out.println("Formatted csv data:");
            group.printCsvDataScoreFormatted();

//            System.out.println(group.calculateAvg(List.of(0, 1, 2)));

            group.calculateOptGroups();

            System.out.println("\nOptimized group(s):");
            group.getOpt_groups().forEach(integers -> System.out.println(integers));

            System.out.println("\nFinal score:");
            System.out.println(group.getAvg_group_score());

        } catch (IOException | CsvException e) {
            System.err.println("Error while reading CSV file: " + e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}




//         int[][] pp = new int[][]{{0, 1, 2, 3}, {1, 0, 4, 5}, {2, 4, 0, 6}, {3, 5, 6, 0}};
//         int[][] ppp = new int[][]{{0, 1, 2, 2, 5, 2}, {1, 0, 4, 3, 4, 5}, {2, 2, 0, 2, 4, 1}, {1, 1, 5, 0, 5, 1}, {2, 2, 3, 4, 0, 5}, {2, 1, 4, 3, 5, 0}};
//
//         System.out.println(GroupOptimizer.calculateAvg(ppp, new int[]{1, 3, 5}));
