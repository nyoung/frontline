package frontline;

import java.util.Comparator;
import java.util.List;

/**
 * Monotone sub-array is a sequence of elements where each element is bigger than the previous one.
 */
public class MonotoneOld {

    final List<List<Integer>> monotones;

    public MonotoneOld(List<Integer> originalArray) {
        this.monotones = calculateMonotones(originalArray);
    }

    /**
     * Find the longest monotone sub-array from an array of numbers.
     */
    List<Integer> longest() {
        return monotones.stream().max(Comparator.comparing(List::size)).orElse(null);
    }

    private List<List<Integer>> calculateMonotones(List<Integer> originalArray) {

        var x = originalArray.stream().reduce((a, b) -> {
            return a > b ? a : b;
        });

        System.out.println(x);

        return null;

//        List<List<Integer>> monotones = new ArrayList<>();
//        List<Integer> currentRun = new ArrayList<>();
//
//        originalArray.forEach(element -> {
//            if (!currentRun.isEmpty() && element <= currentRun.get(currentRun.size() - 1)) {
//                monotones.add(new ArrayList<>(currentRun));
//                currentRun.clear();
//            }
//            currentRun.add(element);
//        });
//
//        if (!currentRun.isEmpty()) {
//            monotones.add(currentRun);
//        }
//
//        return monotones;
    }
}
