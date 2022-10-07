package frontline;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SequenceTreeTest {

    @Test
    void example() {
        var tree = new SequenceTree(List.of("1.2.3", "1.2.5", "1.5.6", "1.2.4", "2.5.6", "1.5.7", "2.5.3"));

        Assertions.assertEquals(
                "1\n" +
                        "--2\n" +
                        "----3\n" +
                        "----4\n" +
                        "----5\n" +
                        "--5\n" +
                        "----6\n" +
                        "----7\n" +
                        "2\n" +
                        "--5\n" +
                        "----3\n" +
                        "----6\n",
                tree.toString()
        );
    }

    @Test
    void alphaNumeric() {
        var tree = new SequenceTree(List.of("" +
                "2.1.B.B.A","C.2.2.C.1","A.1.A.A.1","3.A.A.3.C","2.A.A.1.A","2.B.B.B.C","A.3.3.A.B","2.3.C.3.C","2.A.2.C.2","1.3.2.1.3"));

        Assertions.assertEquals(
                "1\n" +
                        "--3\n" +
                        "----2\n" +
                        "------1\n" +
                        "--------3\n" +
                        "2\n" +
                        "--1\n" +
                        "----B\n" +
                        "------B\n" +
                        "--------A\n" +
                        "--3\n" +
                        "----C\n" +
                        "------3\n" +
                        "--------C\n" +
                        "--A\n" +
                        "----2\n" +
                        "------C\n" +
                        "--------2\n" +
                        "----A\n" +
                        "------1\n" +
                        "--------A\n" +
                        "--B\n" +
                        "----B\n" +
                        "------B\n" +
                        "--------C\n" +
                        "3\n" +
                        "--A\n" +
                        "----A\n" +
                        "------3\n" +
                        "--------C\n" +
                        "A\n" +
                        "--1\n" +
                        "----A\n" +
                        "------A\n" +
                        "--------1\n" +
                        "--3\n" +
                        "----3\n" +
                        "------A\n" +
                        "--------B\n" +
                        "C\n" +
                        "--2\n" +
                        "----2\n" +
                        "------C\n" +
                        "--------1\n",
                tree.toString()
        );
    }

    @Test
    void testToString() {
    }
}