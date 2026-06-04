import java.util.Stack;

public class Global {
    public static int turn = 0; 
    public static String name;
    public static int choice;
    public static String next;
    public static Stack<String> deaths = new Stack<>();
        /* Fell = died to falling out of the library
            Lost = died in endless library
            Wall = crashed into wall from Seimei's chase
            Aka = died in bathroom */
    public static boolean fellOut = false;
}