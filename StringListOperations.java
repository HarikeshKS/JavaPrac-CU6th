import java.util.ArrayList;
import java.util.Scanner;

public class StringListOperations {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Search");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the string to insert: ");
                    String insertString = scanner.next();
                    insert(stringList, insertString);
                    break;
                
                case 2:
                    System.out.print("Enter the string to delete: ");
                    String deleteString = scanner.next();
                    delete(stringList, deleteString);
                    break;
                
                case 3:
                    display(stringList);
                    break;
                
                case 4:
                    System.out.print("Enter the string to search: ");
                    String searchString = scanner.next();
                    search(stringList, searchString);
                    break;
                
                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);
                
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void insert(ArrayList<String> list, String item) {
        list.add(item);
        System.out.println(item + " inserted successfully.");
    }

    private static void delete(ArrayList<String> list, String item) {
        if (list.remove(item)) {
            System.out.println(item + " deleted successfully.");
        } else {
            System.out.println(item + " not found in the list.");
        }
    }

    private static void display(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            System.out.println("List contents:");
            for (String item : list) {
                System.out.println(item);
            }
        }
    }

    private static void search(ArrayList<String> list, String item) {
        if (list.contains(item)) {
            System.out.println(item + " found in the list.");
        } else {
            System.out.println(item + " not found in the list.");
        }
    }
}
