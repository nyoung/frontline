package frontline;

import java.util.*;
import java.util.stream.Collectors;

public class Monotone {

  public static void main(String[] args) {
    List<Integer> list = List.of(1, 2, 9, 4, 7, 3, 11, 8, 14, 6);

    populateRefMap(list);
            findStartingKeys().stream()
                    .map(Monotone::getMonotonesForKey)
                    .flatMap(Collection::stream)
                    .forEach(System.out::println);
  }

  private static List<Integer> findStartingKeys() {
    List<Integer> startingKeys = new ArrayList<>();

    refMap.keySet().forEach(key -> {
      if (startingKeys.isEmpty() || key < Collections.min(startingKeys)) {
        startingKeys.add(key);
      }
    });

    return startingKeys;
  }

  private static Map<Integer, List<Integer>> refMap = new LinkedHashMap<>();

  private static void populateRefMap(List<Integer> valueList) {
    // Create a reference map of all the starting values
    valueList.forEach(element -> {
      refMap.forEach((key, value) -> {
        // if the element is subordinate to this key and a direct child, then add it to this key's children
        if (element > key && (value.isEmpty() || element < Collections.min(value))) {
          value.add(element);
        }
      });
      refMap.put(element, new ArrayList<>());
    });
  }

  private static List<LinkedList<Integer>> getMonotonesForKey(Integer key) {
    var monotones = refMap.get(key).stream()
            .map(Monotone::getMonotonesForKey)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

    if (monotones.isEmpty()) {
      monotones = new ArrayList<>(List.of(new LinkedList<>()));
    }

    monotones.forEach(monotone -> monotone.addFirst(key));

    return monotones;
  }
}

