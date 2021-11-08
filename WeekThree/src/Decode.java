/** This class contains the function that decodes the given barebones instructions. */
public class Decode {
  /**
   * Loops through all lines of code in the programme decoding what they do and then executing the
   * command to give the desired effect. While loops are used to allow barebones loops to move
   * around the code when needed.
   */
  public static void decodeCode(String[][] programme) {

    int i = 0;
    while (i < programme.length) {
      // Case and switch used to call functions based on the inputted barebones commands.
      switch (programme[i][0]) {
        case "clear":
          // Calls a function to clear a variable value.
          Execute.clear(programme[i][1]);
          i++;
          break;
        case "set":
          // Calls a function to set a variable value to a given value.
          Execute.set(programme[i][1], programme[i][2]);
          i++;
          break;
        case "print":
          // Calls a function to print a given string.
          Execute.print(programme[i]);
          i++;
          break;
        case "ret":
          // Calls a function to return the value of a given variable.
          Execute.ret(programme[i][1]);
          i++;
          break;
        case "incr":
          // Calls a function to increase a variable value.
          Execute.incr(programme[i][1]);
          i++;
          break;
        case "decr":
          // Calls a function to decrease a variable value.
          Execute.decr(programme[i][1]);
          i++;
          break;
        case "add":
          // Calls a function to add the second two variables and store there value in the first
          // one.
          Execute.add(programme[i][1], programme[i][2], programme[i][3]);
          i++;
          break;
        case "sub":
          // Calls a function to take away the last variable from the middle one and store there
          // value in the first one.
          Execute.sub(programme[i][1], programme[i][2], programme[i][3]);
          i++;
          break;
        case "multi":
          // Calls a function to multiply the second two variables and store there value in the
          // first one.
          Execute.multi(programme[i][1], programme[i][2], programme[i][3]);
          i++;
          break;
        case "div":
          // Calls a function to divide the middle variable by the value of the final decode
          // variable. This value is then stored in the first variable.
          Execute.div(programme[i][1], programme[i][2], programme[i][3]);
          i++;
          break;
        case "while":
          // Calls a function to initiate a loop if a statement is true.
          Execute.whileLoop(programme, i);
          i++;
          break;
        case "for":
          // Calls a function to initiate a loop if a variables value is less than that of a given
          // number.
          Execute.forLoop(programme, i);
          i++;
          break;
        case "end":
          // Calls a function to set in motion the end of a loop or exit one depending on current
          // variable values.
          i = Execute.end(i);
          i++;
          break;
        case "#":
          // Comment recognition to prevent code crashes when comments are used.
          if (Main.canPrintComments) {
            Execute.print(programme[i]);
          }
          i++;
          break;
      }
    }
  }
}
