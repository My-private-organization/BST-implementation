import java.util.Scanner;

public class BST_Offline {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MyBST myBST = new MyBST();

        while (true)
        {
            showMenu();

            System.out.print("Please enter an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter an item to insert: ");
                    myBST.insertItem(scanner.nextInt());
                }
                case 2 -> {
                    System.out.print("Enter an item to search: ");
                    System.out.println(myBST.searchItem(scanner.nextInt()));
                }
                case 3 -> {
                    System.out.print("Enter an item to get in order successor: ");
                    System.out.println(myBST.getInOrderSuccessor(scanner.nextInt()));
                }
                case 4 -> {
                    System.out.print("Enter an item to get in order predecessor: ");
                    System.out.println(myBST.getInOrderPredecessor(scanner.nextInt()));
                }
                case 5 -> {
                    System.out.print("Enter an item to delete: ");
                    myBST.deleteItem(scanner.nextInt());
                }
                case 6 -> {
                    System.out.print("Enter an item to get it's depth: ");
                    System.out.println(myBST.getItemDepth(scanner.nextInt()));
                }
                case 7 -> {
                    System.out.print("Max item of the tree is: ");
                    System.out.println(myBST.getMaxItem());
                }
                case 8 -> {
                    System.out.print("Min item of the tree is: ");
                    System.out.println(myBST.getMinItem());
                }
                case 9 -> {
                    System.out.print("Height of the tree is: ");
                    System.out.println(myBST.getHeight());
                }
                case 10 -> {
                    System.out.println("Printing the tree in order:");
                    myBST.printInOrder();
                }
                case 11 -> {
                    System.out.println("Printing the tree pre order:");
                    myBST.printPreOrder();
                }
                case 12 -> {
                    System.out.println("Printing the tree post order:");
                    myBST.printPostOrder();
                }
                case 13 ->{
                    System.out.println("Size of the tree is : "+myBST.getSize());
                }
            }
        }
    }

    private static void showMenu() {
        System.out.println("1. Insert Item");
        System.out.println("2. Search Item");
        System.out.println("3. Get In Order Successor");
        System.out.println("4. Get In Order Predecessor");
        System.out.println("5. Delete Item");
        System.out.println("6. Get Item Depth");
        System.out.println("7. Get Max Item");
        System.out.println("8. Get Min Item");
        System.out.println("9. Get Height");
        System.out.println("10. Print In Order");
        System.out.println("11. Print Pre Order");
        System.out.println("12. Print Post Order");
        System.out.println("13. Get Size");
        System.out.println();
    }
}
