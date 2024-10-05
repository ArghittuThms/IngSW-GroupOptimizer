package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for generating combinations of integer lists.
 * It provides methods to generate combinations by swapping elements between
 * the first half and the second half of the list.
 */
public class CombinationGenerator {
    /**
     * Generates all combinations of the input list by swapping elements between
     * the first half and the second half of the list.
     *
     * @param input The list of integers to generate combinations from.
     *              The list must contain an even number of elements.
     * @return A list of lists where each inner list represents a combination
     *         of integers after a swap operation.
     * @throws Exception If the input list contains an odd number of elements.
     */
    public static List<List<Integer>> generateComb(List<Integer> input) throws Exception {
        if (input.size()%2 != 0) throw new Exception("Input array must contain an even number of elements");

        List<List<Integer>> comb = new ArrayList<>();
        comb.add(input);

        for (int i=0; i<(input.size()/2); i++) {
            for (int j=input.size()/2; j<input.size(); j++) {
                comb.add(swapAtIndex(input, i, j));
            }
        }

        return comb;
    }

    /**
     * Swaps two elements in the input list at the specified indices and returns a new list with the swapped elements.
     *
     * @param input The list of integers in which the elements will be swapped.
     * @param first_index The index of the first element to swap.
     * @param second_index The index of the second element to swap.
     * @return A new list of integers with the elements at the specified indices swapped.
     * @throws Exception If one of the indices is greater than the size of the input list.
     */
    private static List<Integer> swapAtIndex(List<Integer> input, int first_index, int second_index) throws Exception {
        if (first_index > input.size() || second_index > input.size()) throw new Exception("Indices must be less than the length of the input");

        List<Integer> tempList = new ArrayList<>(input);

        Integer temp = input.get(first_index);
        tempList.set(first_index, input.get(second_index));
        tempList.set(second_index, temp);

        return tempList;
    }
}