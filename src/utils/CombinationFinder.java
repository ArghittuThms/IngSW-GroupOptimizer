package utils;

import java.util.ArrayList;
import java.util.List;

public class CombinationFinder {

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

    private static void combHelp(List<Integer> array, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == array.size() / 2) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < array.size(); i++) {
            current.add(array.get(i));
            combHelp(array, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

