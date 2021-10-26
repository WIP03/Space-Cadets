public class Main {

  // Main Function
  public static void main(String[] args) {

    //Used to fetch a formatted version of the inputted BareBones code.
    try{System.out.println(Fetch.fetchCode()[4][2]);}
    //Returns an exception warning if no code is able to be fetched by the interpreter.
    catch (Exception e){System.out.println("Unable to fetch code.");}


    //OLD CODE USER FOR REFERENCE ONLY
    /*
    try {
      FileReader program = new FileReader(System.getProperty("user.dir") + "/programs/code.txt");
      BufferedReader readBuffer = new BufferedReader(program);

      String code;

      ArrayList<ArrayList<String>> variables = new ArrayList();

      while ((code = readBuffer.readLine()) != null) {

        if (code.contains("clear")){
          boolean isStored = false;

          for(int i = 0; i < variables.stream().count(); i++){
            if (variables.get(i).get(0) == getOperand(code, "clear")){
              ArrayList<String> tempList = new ArrayList<>();
              tempList.add(variables.get(i).get(0));
              tempList.add("0");

              isStored = true;
              variables.set(i, tempList);
            }
          }

          if(!isStored){
            ArrayList<String> tempList = new ArrayList<>();
            tempList.add(getOperand(code, "clear"));
            tempList.add("0");

            variables.add(tempList);
          }

        }

      }

      readBuffer.close();
      System.out.println(variables);

    }

    // A catch used to let the user know of IO errors.
    catch (IOException exception) {
      System.out.println("IO Error: " + exception.getStackTrace()[0]);
    }
  }

  public static String getOperand(String codeToInspect, String opcode){
    Pattern pattern = Pattern.compile("(?<=" + opcode + " )(.*?)(?=;)");
    Matcher matcher = pattern.matcher(codeToInspect);

    //Returns the operand for a given opcode.
    if (matcher.find()) {
      return matcher.group(0);
    }else{
      return "No Present Opcode";
    }

     */

  }
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