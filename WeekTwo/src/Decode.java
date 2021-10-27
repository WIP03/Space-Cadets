public class Decode {
  // TODO ADD SWITCH/CASE BASED DECODING

  public static void decodeCode(String[][] programme) {

    // Loops through all lines of code in the programme decoding what they do
    // and then executing the command to give the desired effect.
    for (int i = 0; i < programme.length; i++) {
      switch (programme[i][0]) {
        case "clear":
          Execute.clear(programme[i][1]);
          break;
        case "incr":
          Execute.incr(programme[i][1]);
          break;
        case "decr":
          Execute.decr(programme[i][1]);
          break;
        case "while":
          System.out.println("w");
          break;
        case "end":
          System.out.println("e");
          break;
      }
    }
  }
}
