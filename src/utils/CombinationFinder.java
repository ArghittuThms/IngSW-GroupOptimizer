package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods for generating combinations of elements from a given list.
 */
public class CombinationFinder {

    /**
     * Generates all possible combinations of elements from the given list, dividing them into two equal-sized groups.
     *
     * @param array The list of elements to generate combinations for.
     * @return A list of lists, where each inner list represents a combination.
     */
    public static List<List<Integer>> generateComb(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        combHelp(array, 0, new ArrayList<>(), result);

        int loop_c = result.size() / 2;
        for (int i = 0; i < loop_c; i++) {
            result.get(i).addAll(result.getLast());
            result.removeLast();
        }

        return result;
    }

    /**
     * A helper method that recursively generates combinations.
     *
     * @param array The list of elements to generate combinations for.
     * @param start The starting index to consider in the list.
     * @param current The current combination being built.
     * @param result The list of all generated combinations.
     */
    private static void combHelp(List<Integer> array, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == array.size() / 2) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < array.size(); i++) {
            current.add(array.get(i));
            combHelp(array, i + 1, current, result);
            current.removeLast();
        }
    }
}

