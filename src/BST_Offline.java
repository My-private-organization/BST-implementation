public class BST_Offline {
    public static void main(String[] args) {
        MyBST myBST = new MyBST();

        myBST.insertItem(50);
        myBST.insertItem(30);
        myBST.insertItem(20);
        myBST.insertItem(40);
        myBST.insertItem(70);
        myBST.insertItem(60);
        myBST.insertItem(80);

        myBST.printInOrder();

        myBST.deleteItem(20);

        myBST.printInOrder();

        System.out.println("\nDelete 30");

        myBST.deleteItem(30);

        myBST.printInOrder();

        System.out.println("\nDelete 50");
        myBST.deleteItem(50);
        System.out.println("Inorder traversal of the modified tree");
        myBST.printInOrder();

    }
}
