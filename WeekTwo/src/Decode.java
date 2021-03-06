public class Decode {
  // TODO ADD SWITCH/CASE BASED DECODING

  public static void decodeCode(String[][] programme) {

    // Loops through all lines of code in the programme decoding what they do
    // and then executing the command to give the desired effect. While loops
    // are used to allow barebones loops to move around the code when needed.
    int i = 0;
    while (i < programme.length) {
      System.out.println(Main.variables);
      // Case and switch used to call functions based on the inputted barebones commands.
      switch (programme[i][0]) {
        case "clear":
          // Calls a function to clear a variable value.
          Execute.clear(programme[i][1]);
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
        case "while":
          // Calls a function to initiate a loop if a statement is true.
          Execute.whileLoop(programme, i);
          i++;
          break;
        case "end":
          // Calls a function to set in motion the end of a loop or exit one depending on current
          // variable values.
          i = Execute.end(i);
          i++;
          break;
      }
    }
  }
}
