import java.util.ArrayList;

public class Execute {
  // *TODO ADD FUNCTIONS FOR EACH FUNCTION TYPES (E.G CLEAR, INCR, DECR, WHILE, END, ECT)
  // TODO THEN CHANGE FUNCTIONS TO OWN CLASSES TO ALLOW FOR ERROR CHECKING AND EASY RECURSION
  // TODO recursive descent for recognising more complex mathematical calculations to work.
  // use me to fix not reading stuff after list function "|| Main.whileStack.isEmpty()"

  // Sets the given variable in the functions' operand to zero.
  public static void clear(String variable) {
    if (!Main.isCurrentLoopEnded) {
      Main.variables.put(variable, 0);
    }
  }

  // Increase the given variables value by one (if it doesn't
  // exist a variable with the same identifier is set to one as
  // variables don't need to already exist to have a function called on it).
  public static void incr(String variable) {
    if (!Main.isCurrentLoopEnded) {
      if (!Main.variables.containsKey(variable)) {
        Main.variables.put(variable, 1);
      } else {
        Main.variables.put(variable, Main.variables.get(variable) + 1);
      }
    }
  }

  // Decrease the given variables value by one (if it doesn't exist a
  // variable with the same identifier is set to zero).
  public static void decr(String variable) {
    if (!Main.isCurrentLoopEnded) {
      if (!Main.variables.containsKey(variable)) {
        Main.variables.put(variable, 0);
      } else if (Main.variables.get(variable) > 0) {
        Main.variables.put(variable, Main.variables.get(variable) - 1);
      }
    }
  }

  // This is the start of the while loop. It firstly makes a check to see if the values in the while
  // loop function are not equal. If they are not equal then the position of the loop is added to
  // the while stack, if they are however then the variable Main.isCurrentLoopEnded to true to make
  // the program now that the loop is finished.
  public static void whileLoop(String[][] bbProgramme, Integer lineNum) {
    if ((Main.variables.get(bbProgramme[lineNum][1]) != Integer.parseInt(bbProgramme[lineNum][3]))
        & !Main.isCurrentLoopEnded) {
      Main.whileStack.push(lineNum);
    } else {
      Main.isCurrentLoopEnded = true;
    }
  }

  // This function checks to see if the loop is still going. If it is then it will take the current
  // while from the list and change the current line to is position. Also, if the while list isn't
  // empty then it sets the variable Main.isCurrentLoopEnded to false as a loop must exist. Once
  // these checks occur the Integer storing the value of the current line to execute is returned.
  public static Integer end(Integer lineNum) {
    // Removes current loop from stack and sets the new line number base on the position of that
    // loop in the code.
    if (!Main.isCurrentLoopEnded & !Main.whileStack.isEmpty()) {
      lineNum = Main.whileStack.peek() - 1;
      Main.whileStack.pop();
    }

    // Allows for function calls to work when loop stack is not empty or is empty but the loop has
    // ended.
    if (!Main.whileStack.isEmpty() || (Main.isCurrentLoopEnded & Main.whileStack.isEmpty())) {
      Main.isCurrentLoopEnded = false;
    }

    return lineNum;
  }
}
