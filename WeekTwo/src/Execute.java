import java.util.ArrayList;

public class Execute {
  // TODO ADD FUNCTIONS FOR EACH FUNCTION TYPES (E.G CLEAR, INCR, DECR, WHILE, END, ECT)
  // TODO THEN CHANGE FUNCTIONS TO OWN CLASSES TO ALLOW FOR ERROR CHECKING AND EASY RECURSION

  // Sets the given variable in the functions' operand to zero.
  public static void clear(String variable) {
    Main.variables.put(variable, 0);
  }

  // Increase the given variables value by one (if it doesn't
  // exist a variable with the same identifier is set to one as
  // variables don't need to already exist to have a function called on it).
  public static void incr(String variable) {
    if (!Main.variables.containsKey(variable)) {
      Main.variables.put(variable, 1);
    } else {
      Main.variables.put(variable, Main.variables.get(variable) + 1);
    }
  }

  // Decrease the given variables value by one (if it doesn't exist a
  // variable with the same identifier is set to zero).
  public static void decr(String variable) {
    if (!Main.variables.containsKey(variable)) {
      Main.variables.put(variable, 0);
    } else if (Main.variables.get(variable) > 0) {
      Main.variables.put(variable, Main.variables.get(variable) - 1);
    }
  }

  // recursive descent for recognising more complex mathematical calculations to work.
}
