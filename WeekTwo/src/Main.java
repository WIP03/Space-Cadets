import java.io.*;
import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  // Main Function
  public static void main(String[] args) {

    try {
      FileReader program = new FileReader(System.getProperty("user.dir") + "/programs/code.txt");
      BufferedReader readBuffer = new BufferedReader(program);

      String code;

      ArrayList<ArrayList<String>> varibles = new ArrayList();

      while ((code = readBuffer.readLine()) != null) {

        if (code.contains("clear")){
          boolean isStored = false;

          for(int i = 0; i < varibles.stream().count(); i++){
            if (varibles.get(i).get(0) == getVaribleType(code, "clear")){
              ArrayList<String> tempList = new ArrayList<>();
              tempList.add(varibles.get(i).get(0));
              tempList.add("0");

              isStored = true;
              varibles.set(i, tempList);
            }
          }

          if(!isStored){
            ArrayList<String> tempList = new ArrayList<>();
            tempList.add(getVaribleType(code, "clear"));
            tempList.add("0");

            varibles.add(tempList);
          }

        }

      }

      readBuffer.close();
      System.out.println(varibles);

    }

    // A catch used to let the user know of IO errors.
    catch (IOException exception) {
      System.out.println("IO Error: " + exception.getStackTrace()[0]);
    }
  }

  public static String getVaribleType(String codeToInspect, String command){
    Pattern pattern = Pattern.compile("(?<=" + command + " )(.*?)(?=;)");
    Matcher matcher = pattern.matcher(codeToInspect);

    //Returns the name of the variable in the function if in correct syntax.
    if (matcher.find()) {
      return matcher.group(0);
    }else{
      return "N/A (No Value)";
    }

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