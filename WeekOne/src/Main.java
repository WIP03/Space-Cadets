//Importing all required classes.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //TODO
    //* Error catching for IO error (e.g. when there is no internet)
    //* Report if URL doesn't exist.
    //* Ability for user to input multiple id's.
    //- Ability for user to be given extra info (like the email and phone number of the id).
    //- For the information to be put into a json file to be read by the user.
    //- Add anagrams of the id's name to the json file.
    //- Add french translations of the id's name to the json file (use google translate).
    //- Add id's of related people to the json file of the inputted id.

    //Main program function.
    public static void main(String[] args){

        //This loop continues around the main function until the user decides to exit.
        while(true) {
            //Prints command list for the main menu.
            System.out.println("################################"
                    + "\n# EmailId Info Scraper        #"
                    + "\n# 1: Enter New Id             #"
                    + "\n# 2: Quit To Menu             #"
                    + "\n###############################"
                    + "\n"
                    + "\nEnter your choice bellow:");

            //Checks the command line to see if the user inputs there menu choice.
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();

            //Uses the inputted number to make a menu decision.
            if (userInput.equals("1")){
                //Runs a function to allow the user to get the name of a given user ID.
                clearConsole(30);
                obtainIdInfo();
            }
            else if (userInput.equals("2")){
                //Force exits the program on the users wishes.
                System.exit(0);
            }
            else{
                //Lets the user know if an input is wrong and resets the menu asking for an input again.
                clearConsole(30);
                System.out.println("Invalid input please try again.");
                sleep(2);
                clearConsole(30);
            }
        }
    }

    //Function which asks for an emailId to be given and then prints the name of associated with that id.
    public static void obtainIdInfo(){
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
            //the line is checked by the program. If the name is never found
            //them the page is considered to be of an invalid account and
            //thus an error message is sent to the user.
            boolean nameFound = false;

            clearConsole(2);
            while ((line = br.readLine()) != null) {
                if (line.contains(namePrefix)) {

                    //This code looks to see if a certain patten is followed on this line
                    //if so it outputs the information we are looking for.
                    Pattern pattern = Pattern.compile(("(?<=" + namePrefix + ")(.*?)(?=" + nameSuffix + ")"));
                    Matcher matcher = pattern.matcher(line);

                    //This code is used to return a found name to the user and let the code
                    //know that the user exists preventing the need for showing an error code.
                    if (matcher.find()) {
                        System.out.println(matcher.group(0));
                        nameFound = true;
                    }
                }
            }

            //An error code that is run by the program if the entered id has no name on the page
            //and thus the website is showing a generic page instead letting us know the id
            //doesn't exist.
            if (!nameFound){
                System.out.println("EmailId doesn't exist on site and is thus invalid.");
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

        sleep(5);
        clearConsole(30);
    }

    //This function prints empty lines to clean the console.
    public static void clearConsole(int lines){
        for(int i = 0; i < lines; i++){
            System.out.println("");
        }
    }

    //This function is used to pause the program when needed.
    public static void sleep(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
