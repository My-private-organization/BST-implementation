public class MyNode {

    private int item;
    private MyNode parentNode;
    private MyNode leftNode;
    private MyNode rightNode;

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public MyNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(MyNode parentNode) {
        this.parentNode = parentNode;
    }

    public MyNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(MyNode leftNode) {
        this.leftNode = leftNode;
    }

    public MyNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(MyNode rightNode) {
        this.rightNode = rightNode;
    }
}
