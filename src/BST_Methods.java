public interface BST_Methods {
    void insertItem(int item);
    boolean searchItem(int item);
    int getInOrderSuccessor(int item);
    int getInOrderPredecessor(int item);
    void deleteItem(int item);
    int getItemDepth(int item);
    int getMaxItem();
    int getMinItem();
    int getHeight();
    void printInOrder();
    void printPreOrder();
    void printPostOrder();
    int getSize();
}
