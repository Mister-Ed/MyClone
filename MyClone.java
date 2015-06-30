/*
 * @author: Mister Ed
 * For: Final Project - Virtual World
 * Date: June 27, 2015
 * Final submission of the MyClone class to private designation (encapsulation).
 * Checks input strings for valid a-zA-Z characters before allowing private
 * instance varaibles to be set for first and last names. Instructions in
 * introduction() are stubbed out.
 *
 * MyClone package/class
 */
package myclone;

import java.util.Scanner;


/**
 *
 * @author Mister Ed
 */
public class MyClone {

    /**
     * @param args the command line arguments
     */
    private // Can't touch this .. publically that is
            String firstName; // has getter & setter
            String lastName; // has getter & setter
            // These below have no need for getters & setters
            String nameSorry;
            String placeHolder;
            String introPreInstruct;
            String appInstructions;
            Scanner input;
    
    
    // Default constructor
    public MyClone() { 
        this.firstName = null;
        this.lastName = null;
        this.placeHolder = null;
        this.input = new Scanner(System.in);
        this.nameSorry = "Sorry, please enter only use cap/lower case letters for your";
        this.introPreInstruct = "Please enter your first and last names.\n"
                + "Use only capital or lower case letters";
        this.appInstructions = "This application allows you to setup and operate a very simple virtual world with a few decisions below.\n\n"
                + "First we will allow you to help create this virtual world and ask you to chose whether to enter the list\n"
                + "of messages or have us build one automatically.\n"
                + "Next we will ask for you to chose to enter several lists of words or let us build them for you. These\n"
                + "lists are used to generate a random message comprised of random words from each list in the form of:\n"
                + "Subject - Verb - Adjective - Object - Adverb\n\n"
                + "Once the virtual world is complete, we then will let you choose your favorite phrase or a randomly selected phrase.\n"
                + "You can then try your luck at building random message phrases compiled at random from each individual word list.\n"
                + "Then finally you will be challenged to a beer chant war, but be warned, it is tough to beat us!";
    }
    
    
    public void introduction() {
        
        // check to see if first & last name is set, if so skip.
        if ( (this.firstName == null) && (this.lastName == null) ) {
            
            // Prelim instructions
            printMessage(this.introPreInstruct);
            
            
            // Get first name from console/command line
            System.out.print("What's your First Name: ");
            placeHolder = input.nextLine();
            this.setFirstName(placeHolder);
        

            // Get last name from console/command line
            System.out.print("What's your Last Name: ");
            placeHolder = input.nextLine();
            this.setLastName(placeHolder);
        }
        
        String instructionMessage = "\nWelcome " + getFirstName() + " "
                + getLastName() + "!\n" + this.appInstructions;
        
        printMessage(instructionMessage);
        
    }
    
    
    public String getFirstName() { //a getter
        return this.firstName;
    }
    
     
    public String getLastName() { // a getter
        return this.lastName;
    }
    
    
    public void reDoIntro() {
        this.firstName = null;
        this.lastName = null;
    }
    
    public void setFirstName(String str) { // a setter
        
        // user input not valid
        if (!(validateString(str))) {
            // run it until valid
            do {
                System.out.print(this.nameSorry + " First Name: ");
                str = input.nextLine();
            } while (!validateString(str));
        }

        // user input okay, assign name
        this.firstName = str;
    }
    
    
    public void setLastName(String str) { // a setter
        
        // user input not valid
        if (!(validateString(str))) {
            // run it until valid
            do {
                System.out.print(this.nameSorry + " Last Name: ");
                str = input.nextLine();
            } while (!validateString(str));
        }

        // user input okay, assign name
        this.lastName = str;
    }
    
    
    // print out messages with additional blank line
    private void printMessage(String outmsg) {
        System.out.println(outmsg + "\n");
    }
    
    
    // print misc lines
    public void printOutMessages(String theMessage) {
        System.out.println( theMessage );
    }
    
    
    public Boolean validateString(String str) {
        // only upper and lower case allowed
        return str.matches("[a-zA-Z]+");
    }


}
