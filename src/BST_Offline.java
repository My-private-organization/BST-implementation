public class BST_Offline {
    public static void main(String[] args) {
        MyBST myBST = new MyBST();

        myBST.insertItem(10);
        myBST.insertItem(5);
        myBST.insertItem(17);
        myBST.insertItem(3);
        myBST.insertItem(7);
        myBST.insertItem(12);
        myBST.insertItem(19);
        myBST.insertItem(1);
        myBST.insertItem(4);
        myBST.insertItem(13);

        System.out.println(myBST.getItemDepth(17));

    }
}
