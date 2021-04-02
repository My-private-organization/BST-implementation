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
    public int getInOrderSuccessor(int item) {

        MyNode myNode = searchNode(item);

        if(myNode != null)
        {
            MyNode inorderSuccessor = getInOrderSuccessor(rootNode, myNode);

            if(inorderSuccessor!=null)
                return inorderSuccessor.getItem();
            else
                return Integer.MIN_VALUE;
        }
        else
            return Integer.MIN_VALUE;
    }

    private MyNode getInOrderSuccessor(MyNode rootDummyNode, MyNode myNode)
    {
        if (myNode.getRightNode() != null)
            return getMinItem(myNode.getRightNode());

        MyNode inorderSuccessor = null;

        while (rootDummyNode != null)
        {
            if (myNode.getItem() < rootDummyNode.getItem())
            {
                inorderSuccessor = rootDummyNode;
                rootDummyNode = rootDummyNode.getLeftNode();
            }
            else if (myNode.getItem() > rootDummyNode.getItem())
                rootDummyNode = rootDummyNode.getRightNode();
            else
                break;
        }
        return inorderSuccessor;
    }

    private MyNode searchNode(int item)
    {
        MyNode currentNode = rootNode;

        while(currentNode != null)
        {
            if(item == currentNode.getItem())
                return currentNode;
            if(item < currentNode.getItem())
                currentNode = currentNode.getLeftNode();
            else
                currentNode = currentNode.getRightNode();
        }

        return null;
    }

    @Override
    public int getInOrderPredecessor(int item) {

        MyNode inOrderPredecessor =  getInOrderPredecessor(rootNode, item);

        if(inOrderPredecessor != null)
            return inOrderPredecessor.getItem();
        else
            return Integer.MIN_VALUE;
    }

    private MyNode getInOrderPredecessor(MyNode myNode, int item)
    {
        MyNode predecessor = null;

        while (true)
        {
            if (item < myNode.getItem()) {
                myNode = myNode.getLeftNode();
            }

            else if (item > myNode.getItem())
            {
                predecessor = myNode;
                myNode = myNode.getRightNode();
            }
            else {
                if (myNode.getLeftNode() != null) {
                    predecessor = getMaxItem(myNode.getLeftNode());
                }
                break;
            }

            if (myNode == null) {
                return null;
            }
        }

        return predecessor;
    }

    @Override
    public void deleteItem(int item) {
        rootNode = deleteItem(rootNode, item);
    }

    private MyNode deleteItem(MyNode myNode, int item)
    {
        if (myNode == null)
            return myNode;

        if (item < myNode.getItem())
            myNode.setLeftNode(deleteItem(myNode.getLeftNode(), item));

        else if (item > myNode.getItem())
            myNode.setRightNode(deleteItem(myNode.getRightNode(), item));


        else {
            if (myNode.getLeftNode() == null)
                return myNode.getRightNode();
            else if (myNode.getRightNode() == null)
                return myNode.getLeftNode();

            myNode.setItem(getMinItem(myNode.getRightNode()).getItem());

            myNode.setRightNode(deleteItem(myNode.getRightNode(), item));

        }

        return myNode;
    }

    @Override
    public int getItemDepth(int item) {

        int depth = getItemDepth(item, rootNode, 0);

        if(depth == 0 && item == rootNode.getItem())
            return 0;

        else if(depth == 0 && item!= rootNode.getItem())
        {
            return -1;
        }

        return depth;
    }

    private int getItemDepth(int item, MyNode myNode, int depth) {

        if (myNode == null)
            return 0;

        if (myNode.getItem() == item)
            return depth;

        int currentLevel = getItemDepth(item, myNode.getLeftNode(), depth + 1);

        if(currentLevel != 0)
            return currentLevel;

        currentLevel = getItemDepth(item, myNode.getRightNode(), depth+1);

        return currentLevel;
    }

    @Override
    public int getMaxItem() {
        return getMaxItem(rootNode).getItem();
    }

    private MyNode getMaxItem(MyNode rootNode) {

        MyNode currentNode = rootNode;

        while (currentNode.getRightNode() != null) {
            currentNode = currentNode.getRightNode();
        }

        return currentNode;
    }

    @Override
    public int getMinItem() {
        return getMinItem(rootNode).getItem();
    }

    private MyNode getMinItem(MyNode rootNode) {

        MyNode currentNode = rootNode;

        while (currentNode.getLeftNode() != null) {
            currentNode = currentNode.getLeftNode();
        }

        return currentNode;
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
