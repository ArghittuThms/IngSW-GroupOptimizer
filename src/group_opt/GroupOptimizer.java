package group_opt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GroupOptimizer {



    public static double calculateAvg(int[][] csv_data, int[] range) {
        int total = 0;

        for (int i=0; i<range.length - 1; i++) {
            for (int j=i+1; j<range.length; j++) {
                total += csv_data[range[i]][range[j]];
                total += csv_data[range[j]][range[i]];
            }
        }

        return ((double) total / range.length);
    }


}
