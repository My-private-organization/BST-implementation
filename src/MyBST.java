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
            }
            else
            {
                parentNode.setRightNode(myNode);
            }

            myNode.setParentNode(parentNode);
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
        return getMaxItem(rootNode);
    }

    private int getMaxItem(MyNode rootNode) {

        MyNode currentNode = rootNode;

        while (currentNode.getRightNode() != null) {
            currentNode = currentNode.getRightNode();
        }

        return (currentNode.getItem());
    }

    @Override
    public int getMinItem() {
        return getMinItem(rootNode);
    }

    private int getMinItem(MyNode rootNode) {

        MyNode currentNode = rootNode;

        while (currentNode.getLeftNode() != null) {
            currentNode = currentNode.getLeftNode();
        }

        return (currentNode.getItem());
    }

    @Override
    public int getHeight() {
        return getHeight(rootNode);
    }

    private int getHeight(MyNode myNode)
    {
        if (myNode == null)
            return 0;

        else
        {
            int leftSide = getHeight(myNode.getLeftNode());
            int rightSide = getHeight(myNode.getRightNode());

            if (leftSide > rightSide)
                return leftSide + 1;
            else
                return rightSide + 1;
        }
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
    public int getSize()
    {
        return getSize(rootNode);
    }

    private int getSize(MyNode myNode)
    {
        if(myNode == null){
            return 0;
        }
        else{
            return 1 + getSize(myNode.getLeftNode()) + getSize(myNode.getRightNode());
        }
    }
}
