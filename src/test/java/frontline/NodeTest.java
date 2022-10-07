package frontline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void getData() {
        var node = new Node<>("root", null);

        assertEquals("root", node.getData());
    }

    @Test
    void findChildByValue() {
        var node = new Node<>("root", null);
        new Node<>("foo", node);
        var child2 = new Node<>("bar", node);
        new Node<>("baz", node);

        assertEquals(child2, node.findChildByValue("bar"));
    }
}