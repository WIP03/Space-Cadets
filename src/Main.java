//Importing all required classes.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //Main program function.
    public static void main(String[] args) throws IOException {

        //Asks for user to input there chosen name id.
        System.out.println("Please enter your chosen emailId: ");

        //Scanner takes the user input and stores it to a variable.
        Scanner scanner = new Scanner(System.in);
        String emailId = scanner.nextLine();

        //The id is added to a URL giving us the webpage for that user.
        String emailIdUrl = "https://www.ecs.soton.ac.uk/people/" + emailId;

        //This string is turned to a URL data type and a connection is opened
        //allowing the program to get information from the webpage.
        URL webpageName = new URL(emailIdUrl);
        URLConnection con = webpageName.openConnection();
        InputStream is = con.getInputStream();

        //This code sets up the buffered reader which reads information about
        //each page of the website for that emailId.
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;

        //Sets up the prefix and suffix of the name to be used in finding that said name.
        String namePrefix = "property=\"name\">";
        String nameSuffix = "<em";

        //This function reads through all lines of the website,
        //if the page contains the info we are looking for then
        //the line is checked by the program.
        while ((line = br.readLine()) != null) {
            if(line.contains(namePrefix)){

                //This code looks to see if a certain patten is followed on this line
                //if so it outputs the information we are looking for.
                Pattern pattern = Pattern.compile(("(?<=" + namePrefix + ")(.*?)(?=" + nameSuffix + ")"));
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println(matcher.group(0));
                }
            }
        }
    }
}
