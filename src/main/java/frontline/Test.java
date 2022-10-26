//class Node {
//    int value;
//    Node left;
//    Node right;
//
//    Node (int value) {
//        this.value = value;
//        left = null;
//        right = null;
//    }
//
//    public Node getLeft() {
//        return left;
//    }
//
//    public Node getRight() {
//        return right;
//    }
//}
//
//
//
//
//List<Node> processQueue = new ArrayList<>(rootNode);
//
//int position = 0;
//while (position < processQueue.length()) {
//    var currentNode = processQueue.get(position);
//    processQueue.add(currentNode.getLeft());
//    processQueue.add(currentNode.getRight());
//
//    print(currentNode.getValue())
//    position++;
//}
