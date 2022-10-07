package frontline;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Node<T> {
    private final T data;
    private final Node<T> parent;
    private final List<Node<T>> children = new ArrayList<>();

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
        if (parent != null) {
            parent.addChild(this);
        }
    }

    public T getData() {
        return data;
    }

    public Node<T> findChildByValue(T value) {
        return children.stream().filter(child -> child.getData().equals(value)).findFirst().orElse(null);
    }

    public void addChild(Node<T> child) {
        children.add(child);
    }

    public String prettyPrint(String prefix) {
        // Including some hackery to not print the root node
        return MessageFormat.format(
                parent == null ? "{2}" : "{0}{1}\n{2}",
                prefix,
                data,
                children.stream()
                        .map(child -> parent == null
                                ? child.prettyPrint("")
                                : child.prettyPrint(prefix + "--"))
                        .sorted() // Since the stream is now strings, easy to sort here
                        .collect(Collectors.joining())); // Join it back into a single string

    }
}
