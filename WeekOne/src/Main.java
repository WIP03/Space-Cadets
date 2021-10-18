//Importing all required classes.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //TODO
    //* Error catching for IO error (e.g. when there is no internet)
    //* Report if URL doesn't exist.
    //- Ability for user to input multiple id's.
    //- Ability for user to be given extra info (like the email and phone number of the id).
    //- For the information to be put into a json file to be read by the user.
    //- Add anagrams of the id's name to the json file.
    //- Add french translations of the id's name to the json file (use google translate).
    //- Add id's of related people to the json file of the inputted id.

    //Main program function.
    public static void main(String[] args){

        //Asks for user to input there chosen name id.
        System.out.println("Please enter your chosen emailId: ");

        //Scanner takes the user input and stores it to a variable.
        Scanner scanner = new Scanner(System.in);
        String emailId = scanner.nextLine();

        //The id is added to a URL giving us the webpage for that user.
        String emailIdUrl = "https://www.ecs.soton.ac.uk/people/" + emailId;

        //This string is turned to a URL data type and a connection is opened
        //allowing the program to get information from the webpage.
        try {
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
                if (line.contains(namePrefix)) {

                    //This code looks to see if a certain patten is followed on this line
                    //if so it outputs the information we are looking for.
                    Pattern pattern = Pattern.compile(("(?<=" + namePrefix + ")(.*?)(?=" + nameSuffix + ")"));
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        System.out.println(matcher.group(0));
                    }
                }
            }

            br.close();
        }

        //A catch for if an invalid id is entered.
        catch(MalformedURLException exception){
            System.out.println("The url for the emailId " + emailIdUrl + " is invalid.");
        }

        //A catch used to let the user know of IO errors.
        catch(IOException exception){
            System.out.println("IO Error: " + exception.getStackTrace()[0]);
        }
    }
}
