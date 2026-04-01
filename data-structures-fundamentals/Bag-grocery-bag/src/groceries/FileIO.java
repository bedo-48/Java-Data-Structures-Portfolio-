package groceries;

import java.io.*;
import java.util.Scanner;

/**
 * Practice reading and writing to a file.
 * 
 * @author Obed Mavungu
 * @version 2026.02.13
 */
public class FileIO {
    /**
     * Reads groceries from a file and adds them to a GroceryBag object,
     * the writes the groceries back to a file using GroceryBag's
     * toString method.
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        try {

            File file = new File("grocerylist.txt");
            Scanner scan = new Scanner(file);
            GroceryBag bag = new GroceryBag();

            while (scan.hasNext()) {
                String item = scan.next();
                bag.add(item);
            }

            scan.close();

            PrintWriter writer = new PrintWriter("output.txt");
            writer.print(bag.toString());
            writer.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("Scanner error opening the file ");
            System.out.println(e.getMessage());
        }

    }
}
