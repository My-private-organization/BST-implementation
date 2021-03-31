public class MyBST implements BST_Methods{

    private MyNode rootNode;

    @Override
    public void insertItem(int item)
    {

        MyNode myNode = new MyNode();
        myNode.setItem(item);

        MyNode parentNode;

        if(rootNode == null)
        {
            rootNode = myNode;
        }
        else
        {
            parentNode = null;

            MyNode currentNode = rootNode;

            while (currentNode != null)
            {
                parentNode = currentNode;

                if(myNode.getItem() < currentNode.getItem())
                    currentNode = currentNode.getLeftNode();
                else
                    currentNode = currentNode.getRightNode();
            }

            if(myNode.getItem() < parentNode.getItem())
            {
                parentNode.setLeftNode(myNode);
                myNode.setParentNode(parentNode);
            }
            else
            {
                parentNode.setRightNode(myNode);
                myNode.setParentNode(parentNode);
            }
        }
    }

    @Override
    public boolean searchItem(int item)
    {
        MyNode currentNode = rootNode;

        while(currentNode != null)
        {
            if(item == currentNode.getItem())
                return true;
            if(item < currentNode.getItem())
                currentNode = currentNode.getLeftNode();
            else
                currentNode = currentNode.getRightNode();
        }

        return false;
    }

    @Override
    public MyNode getInOrderSuccessor(int item) {
        return null;
    }

    @Override
    public MyNode getInOrderPredecessor(int item) {
        return null;
    }

    @Override
    public void deleteItem(int item) {

    }

    @Override
    public int getItemDepth(int item) {
        return 0;
    }

    @Override
    public int getMaxItem() {
        return 0;
    }

    @Override
    public int getMinItem() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void printInOrder() {
        printInOrder(rootNode);
    }

    private void printInOrder(MyNode myNode)
    {

        if (myNode == null)
            return;

        printInOrder(myNode.getLeftNode());
        System.out.print(myNode.getItem() + " ");
        printInOrder(myNode.getRightNode());
    }

    @Override
    public void printPreOrder() {
        printPreOrder(rootNode);
    }

    private void printPreOrder(MyNode myNode)
    {
        if (myNode == null)
            return;
        System.out.print(myNode.getItem() + " ");
        printPreOrder(myNode.getLeftNode());
        printPreOrder(myNode.getRightNode());
    }

    @Override
    public void printPostOrder() {
        printPostOrder(rootNode);
    }

    private void printPostOrder(MyNode myNode)
    {
        if (myNode == null)
            return;
        printPostOrder(myNode.getLeftNode());
        printPostOrder(myNode.getRightNode());

        System.out.print(myNode.getItem() + " ");
    }

    @Override
    public int getSize() {
        return 0;
    }
}
