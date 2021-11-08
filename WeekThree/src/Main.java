import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Main {

  // TODO
  // * add new functions: if/else, for and print.
  // * check for and leave out any comments

  // Main Function
  public static void main(String[] args) {

    // Initialisation of Hashmap containing all variables in the programme.
    variables = new HashMap<String, Integer>();

    // Initialisation of stack containing all the loops that are currently being executed.
    loopStack = new Stack<Integer>();

    // Initialisation of a boolean for checking if a current loop has ended or not.
    isCurrentLoopEnded = false;

    // Initialisation of a boolean for checking if comments are printed or not.
    canPrintComments = true;

    // Used to fetch a formatted version of the inputted BareBones code.
    try {
      Decode.decodeCode(Fetch.fetchCode());
    }
    // Returns an exception warning if no code is able to be fetched by the interpreter.
    catch (Exception e) {
      System.out.println("Unable to fetch code.");
    }

    // Outputs all variables at the end of running a programme for testing purposes.
    System.out.println(variables);
  }
  /** A public static hashmap for storing variables and their values. */
  public static HashMap<String, Integer> variables;

  /** Stack containing all the loops with the most indented one being at the top of the stack. */
  public static Stack<Integer> loopStack;

  /** Boolean used to signify if a loop has finished or not. */
  public static boolean isCurrentLoopEnded;

  /** Boolean which when true allows all comments in a program to be read */
  public static boolean canPrintComments;
}
