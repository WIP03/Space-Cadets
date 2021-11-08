import java.util.ArrayList;

/** A class that stores all the code functions to be called in the decoder. */
public class Execute {
  // *TODO ADD FUNCTIONS FOR EACH FUNCTION TYPES (E.G CLEAR, INCR, DECR, WHILE, END, ECT)
  // TODO THEN CHANGE FUNCTIONS TO OWN CLASSES TO ALLOW FOR ERROR CHECKING AND EASY RECURSION
  // TODO recursive descent for recognising more complex mathematical calculations to work.
  // TODO MAKE SURE ALL VALUES NOT IN THE LIST ARE SET TO ZERO BEFORE IS NEEDED.

  /** Sets the given variable in the functions' operand to zero. * */
  public static void clear(String variable) {
    if (!Main.isCurrentLoopEnded) {
      Main.variables.put(variable, 0);
    }
  }

  /**
   * Sets the given variable in the functions' operand to is given input (if negative is set to 0).
   */
  public static void set(String variable, String value) {
    if (!Main.isCurrentLoopEnded) {
      if (Integer.parseInt(value) < 0) {
        Main.variables.put(variable, 0);
      } else {
        Main.variables.put(variable, Integer.parseInt(value));
      }
    }
  }

  /** Prints out a given inputted statement into the console when the command is called. */
  public static void print(String[] lineCode) {
    if (!Main.isCurrentLoopEnded) {
      for (String word : lineCode) {
        if (!word.equals("print")) {
          System.out.print(word + " ");
        }
      }
      System.out.println();
    }
  }

  /** Returns the value of a given variable into the console. */
  public static void ret(String variable) {
    if (!Main.isCurrentLoopEnded) {
      if (!Main.variables.containsKey(variable)) {
        Main.variables.put(variable, 0);
      }
      System.out.println(Main.variables.get(variable));
    }
  }

  /**
   * Increase the given variables value by one (if it doesn't exist a variable with the same
   * identifier is set to one as variables don't need to already exist to have a function called on
   * it).
   */
  public static void incr(String variable) {
    if (!Main.isCurrentLoopEnded) {
      if (!Main.variables.containsKey(variable)) {
        Main.variables.put(variable, 1);
      } else {
        Main.variables.put(variable, Main.variables.get(variable) + 1);
      }
    }
  }

  /**
   * Decrease the given variables value by one (if it doesn't exist a variable with the same
   * identifier is set to zero).
   */
  public static void decr(String variable) {
    if (!Main.isCurrentLoopEnded) {
      if (!Main.variables.containsKey(variable)) {
        Main.variables.put(variable, 0);
      } else if (Main.variables.get(variable) > 0) {
        Main.variables.put(variable, Main.variables.get(variable) - 1);
      }
    }
  }

  /**
   * Adds the given variables variableA and variableB together and stores there output in the
   * variable denoted by variableOutput.
   */
  public static void add(String variableOutput, String variableA, String variableB) {
    if (!Main.isCurrentLoopEnded) {
      Main.variables.put(
          variableOutput, (Main.variables.get(variableA) + Main.variables.get(variableB)));
    }
  }

  /**
   * Takes the given variable variableB from variableA and then stores there output in the variable
   * denoted by variableOutput.
   */
  public static void sub(String variableOutput, String variableA, String variableB) {
    if (!Main.isCurrentLoopEnded) {
      if ((Main.variables.get(variableA) - Main.variables.get(variableB) < 0)) {
        Main.variables.put(variableOutput, 0);
      } else {
        Main.variables.put(
            variableOutput, (Main.variables.get(variableA) - Main.variables.get(variableB)));
      }
    }
  }

  /**
   * Multiplies the given variables variableA and variableB together and stores there output in the
   * variable denoted by variableOutput.
   */
  public static void multi(String variableOutput, String variableA, String variableB) {
    if (!Main.isCurrentLoopEnded) {
      Main.variables.put(
          variableOutput, (Main.variables.get(variableA) * Main.variables.get(variableB)));
    }
  }

  /**
   * Divides the variable variableA by the variable variableB and then stores there output in the
   * variable denoted by variableOutput (value is rounded as outputs can't be floats).
   */
  public static void div(String variableOutput, String variableA, String variableB) {
    if (!Main.isCurrentLoopEnded) {
      Main.variables.put(
          variableOutput,
          Math.round(Main.variables.get(variableA) / Main.variables.get(variableB)));
    }
  }

  /**
   * This is the start of the while loop. It firstly makes a check to see if the values in the while
   * loop function are not equal. If they are not equal then the position of the loop is added to
   * the loop stack, if they are however then the variable Main.isCurrentLoopEnded to true to make
   * the program know that the loop is finished.
   */
  public static void whileLoop(String[][] bbProgramme, Integer lineNum) {
    // Checks to see if condition is met then the loop is ended and all code till the next end
    // function is ignored (else statement does this in this instance).
    if ((Main.variables.get(bbProgramme[lineNum][1]) != Integer.parseInt(bbProgramme[lineNum][3]))
        & !Main.isCurrentLoopEnded) {
      Main.loopStack.push(lineNum);
    } else {
      Main.isCurrentLoopEnded = true;
    }
  }

  /**
   * This is the start of the for loop. It firstly makes a check to see if the first values in the
   * for loop function is greater than or equal to the second one. If they are greater than or equal
   * to then the position of the loop is added to the loop stack, if they are however then the
   * variable Main.isCurrentLoopEnded to true to make the program know that the loop is finished.
   */
  public static void forLoop(String[][] bbProgramme, Integer lineNum) {
    // Used to create variable in list if it doesn't already exist.
    incr(bbProgramme[lineNum][1]);
    decr(bbProgramme[lineNum][1]);

    // Checks to see if condition is met the loop is ended and all code till the next end function
    // is ignored (else statement does this in this instance).
    if ((Main.variables.get(bbProgramme[lineNum][1]) < Integer.parseInt(bbProgramme[lineNum][3]))
        & !Main.isCurrentLoopEnded) {
      Main.loopStack.push(lineNum);
      incr(bbProgramme[lineNum][1]);
    } else {
      Main.isCurrentLoopEnded = true;
    }
  }

  /**
   * This function checks to see if the loop is still going. If it is then it will take the current
   * while from the list and change the current line to is position. Also, if the while list isn't
   * empty then it sets the variable Main.isCurrentLoopEnded to false as a loop must exist. Once
   * these checks occur the Integer storing the value of the current line to execute is returned.
   */
  public static Integer end(Integer lineNum) {
    // Removes current loop from stack and sets the new line number base on the position of that
    // loop in the code.
    if (!Main.isCurrentLoopEnded & !Main.loopStack.isEmpty()) {
      lineNum = Main.loopStack.peek() - 1;
      Main.loopStack.pop();
    }

    // Allows for function calls to work when loop stack is not empty or is empty but the loop has
    // ended.
    if (!Main.loopStack.isEmpty() || (Main.isCurrentLoopEnded & Main.loopStack.isEmpty())) {
      Main.isCurrentLoopEnded = false;
    }

    return lineNum;
  }
}
