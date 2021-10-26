import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Fetch {

    public static String[][] fetchCode() throws IOException {

        //Sets up a buffered reader and creates the file path string based on the current user directory.
        String filePath = System.getProperty("user.dir") + "/programs/code.txt";
        FileReader program = new FileReader(filePath);
        BufferedReader readBuffer = new BufferedReader(program);

        //Sets up base variables needed to fetch formatted code.
        String currentLine;
        String[][] replaceList = {{"\n", ""}, {"\r", ""}, {"   ", ""}, {"  ", ""}, {"; ", ";"}, {";", ""}};
        Integer currentCodeIndex = 0;

        //3D String Array to be used in storing the formatted code.
        String[][] formattedCode = new String[(int)Files.lines(Path.of(filePath)).count()][1];

        //While loop to pass through all lines of codes in the BareBones program.
        while ((currentLine = readBuffer.readLine()) != null) {

            //Goes through the current lines of code removing useless information.
            for(int i = 0; i < replaceList.length; i++){
                currentLine = currentLine.replace(replaceList[i][0], replaceList[i][1]);
            }

            //Adds the formatted code into a 3D string array (separates each term into its own element.
            formattedCode[currentCodeIndex] = currentLine.split(" ");

            //Adds one to the current index of the code.
            currentCodeIndex++;
        }
        //Closes the buffered reader.
        readBuffer.close();

        //Returns the 3D string array containing the formatted code.
        return formattedCode;
    }
}
