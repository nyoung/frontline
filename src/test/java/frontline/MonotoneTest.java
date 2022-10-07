package frontline;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MonotoneTest {
    @Test
    void noData() {
        var longest = new Monotone(List.of()).longest();
        Assertions.assertNull(longest);
    }

    @Test
    void atBeginning() {
        var longest = new Monotone(List.of(1, 2, 3, 4, 4, 5, 6, 4, 5, 6)).longest();
        Assertions.assertEquals(List.of(1, 2, 3, 4), longest);
    }

    @Test
    void atEnd() {
        var longest = new Monotone(List.of(4, 5, 6, 4, 5, 6, 1, 2, 3, 4)).longest();
        Assertions.assertEquals(List.of(1, 2, 3, 4), longest);
    }

    @Test
    void inMiddle() {
        var longest = new Monotone(List.of(4, 5, 6, 1, 2, 3, 4, 4, 5, 6)).longest();
        Assertions.assertEquals(List.of(1, 2, 3, 4), longest);
    }

    @Test
    void multipleSameLength() {
        var longest = new Monotone(List.of(1, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9, 10)).longest();
        // It should just pick up the first one
        Assertions.assertEquals(List.of(1, 2, 3, 4), longest);
    }

    @Test
    void entire() {
        var longest = new Monotone(List.of(1, 2, 3, 4, 6, 7, 9, 10)).longest();
        // It should just pick up the first one
        Assertions.assertEquals(List.of(1, 2, 3, 4, 6, 7, 9, 10), longest);
    }
}