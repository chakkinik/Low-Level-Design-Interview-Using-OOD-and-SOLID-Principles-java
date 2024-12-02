package priorityQueue;

public class PriorityNode {

    int element;
    PriorityNode left;
    PriorityNode right;
    PriorityNode parent;

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public PriorityNode getLeft() {
        return left;
    }

    public void setLeft(PriorityNode left) {
        this.left = left;
    }

    public PriorityNode getRight() {
        return right;
    }

    public void setRight(PriorityNode right) {
        this.right = right;
    }

    public PriorityNode getParent() {
        return parent;
    }

    public void setParent(PriorityNode parent) {
        this.parent = parent;
    }

    public PriorityNode(int element) {
        this.element = element;
    }
}
