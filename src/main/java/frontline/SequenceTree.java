package frontline;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SequenceTree {
    Node<String> tree;

    public SequenceTree(List<String> values) {
        tree = populateTree(values);
    }

    public Node<String> populateTree(List<String> recordSet) {
        var root = new Node<>("root", null);

        recordSet.forEach(record -> {
            // Split by periods
            final Pattern pattern = Pattern.compile("([^\\.]+)", Pattern.MULTILINE);
            final Matcher matcher = pattern.matcher(record);

            Node<String> currentNode = root;
            while (matcher.find()) {
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    // Traverse the tree to find any existing nodes
                    var child = currentNode.findChildByValue(matcher.group(i));

                    if (child == null) {
                        // Add the values that don't exist as a new node
                        child = new Node<>(matcher.group(i), currentNode);
                    }

                    currentNode = child;
                }
            }
        });
        return root;
    }

    @Override
    public String toString() {
        return tree == null ? "" : tree.prettyPrint("");
    }
}
