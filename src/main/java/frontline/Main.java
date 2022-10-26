package frontline;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(new MonotoneOld(List.of(1, 2, 1, 2, 3, 4, 5, 6, 2, 3, 4, 1, 2, 3)).longest());

        System.out.println(new SequenceTree(List.of("1.2.3", "1.2.5", "1.5.6", "1.2.4", "2.5.6", "1.5.7", "2.5.3")));
    }
}