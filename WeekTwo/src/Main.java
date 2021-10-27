import java.util.ArrayList;
import java.util.HashMap;

public class Main {

  // Main Function
  public static void main(String[] args) {

    // Initialisation of Hashmap containing all variables in the programme.
    variables = new HashMap<String, Integer>();

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
  // Creates a public static hashmap for storing variables and their values.
  public static HashMap<String, Integer> variables;
}

// ###########SUDO CODE FOR INTERPRETER#####################################

// if code clear then do this
//// if value after clear not in variable list add to variable list with value 0
//// set value in code command to 0

// if code incr then do this
//// add 1 to value in code command

// if code decr then do this
//// take away 1 from the value in code command

// #############DO THE WHILE LOOP LAST AS MOST COMPLEX######################
// if code while then do this if statement is true
//// when code is end with same indentation then go back to start of while
// else skip code and continue reading the next lot of lines
// #########################################################################
