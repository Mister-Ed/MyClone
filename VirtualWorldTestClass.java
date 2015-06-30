/*
 * @author: Mister Ed
 * For: Final Project - Virtual World
 * Date: June 27, 2015
 * Final Project - simple unit testing class for these associated classes:
 * MyClone
 * ShoutBox
 * BeerChant
 *
 * Performs unit testing on all classes, individually testing every method, getter, and
 * setter that is publically available. Those public methods that rely on private methods
 * are tested as complete units and may need to be run several times with prepopulated
 * lists and user defined lists to test the full extent of each public method.
 *
 * To run integrated testing or as the Virtual World, run the TestApp class
 *
 */
package myclone;

import java.util.Scanner;

/**
 *
 * @author Carl
 */
public class VirtualWorldTestClass {
    
    public static void main(String[] args) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
        String name;
        String str;
        String go;
        int i;
        boolean r;
        boolean keepGoing;
        String answerLoop;
        String userMiniTestLoop;
        boolean keepLooping;
        boolean unitLoop;
        boolean unitLoopTwo;
        boolean unitLoopThree;
        String answerUnitLoop;
        Scanner unitOne = new Scanner(System.in);
        Scanner unitTwo = new Scanner(System.in);
        Scanner unitThree = new Scanner(System.in);
        Scanner loopInput = new Scanner(System.in);
        Scanner userExitInput = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        String testMessage = ANSI_PURPLE + "\nAfter inspecting output, press the 'enter' or 'return' key to continue: " + ANSI_RESET;
        String testContMessage = ANSI_PURPLE + "\nPress the 'enter' or 'return' key to continue: " + ANSI_RESET;
        
        // Begin test cycle container
        do {
            
            
            System.out.println("#######################################################################");
            System.out.println(ANSI_PURPLE + "BEGIN UNIT TESTING" + ANSI_RESET);
            System.out.println("#######################################################################\n");
        
        
            // Begin unit one test container
            do {
        
                System.out.println("#######################################################################");
                System.out.println(ANSI_GREEN + "Unit Testing First Class - MyClone" + ANSI_RESET);
                System.out.println("#######################################################################\n");
        
                //Call a constructor to construct an object of the first class to test
                MyClone testClone = new MyClone();
        

                // #######################################################################
                //Call the getter of the first attribute of the first class  and
                //print the value returned from the getter - verify that the correct value is printed
                name = testClone.getFirstName();
                System.out.println("Testing First Name getter. Expecting: null, got back: " + name);
                System.out.print("Test ");
                if (name == null) {
                    System.out.println(ANSI_GREEN + "SUCCEEDED" + ANSI_RESET);
                }
                else {
                    System.out.println(ANSI_RED + "FAILED" + ANSI_RESET);
                }
                System.out.print(testMessage);
                go = input.nextLine();
                System.out.println("\n#######################################################################\n");
        
                // #######################################################################
                // Testing name string validation method
                System.out.println("Testing name string validators as boolean results against [a-z][A-Z].");
                r = testClone.validateString("Popcorn");
                System.out.println("Sending: PopCorn  -->  expecting: true. Got: " + r);
                System.out.print("Test ");
                if ( r ) {
                    System.out.println(ANSI_GREEN + "SUCCEEDED" + ANSI_RESET);
                }
                else {
                    System.out.println(ANSI_RED + "FAILED" + ANSI_RESET);
                }
                System.out.print(testMessage);
                go = input.nextLine();
        
                System.out.println("");
        
                r = testClone.validateString("Pop123corn");
                System.out.println("Sending: Pop123Corn  -->  expecting: false. Got: " + r);
                System.out.print("Test ");
                if ( !r ) {
                    System.out.println(ANSI_GREEN + "SUCCEEDED" + ANSI_RESET);
                }
                else {
                    System.out.println(ANSI_RED + "FAILED" + ANSI_RESET);
                }
                System.out.print(testMessage);
                go = input.nextLine();
        
                System.out.println("\n#######################################################################\n");
        
                // #######################################################################
        
                //Call the setter to change the value of the first attribute of the first class
                System.out.println("Testing First Name setter (note, validation tested above, but included within this method). "
                        + "Setting First Name to: Popcorn");
                testClone.setFirstName("Popcorn");
        
                //Call the getter of the first attribute  and
                //print the value returned from the getter - verify that the attribute now has a new value
                name = testClone.getFirstName();
                System.out.println("Re-Testing First Name getter. Expecting: Popcorn, got back: " + name);
                System.out.print("Test ");
                if (name.equals("Popcorn")) {
                    System.out.println(ANSI_GREEN + "SUCCEEDED" + ANSI_RESET);
                }
                else {
                    System.out.println(ANSI_RED + "FAILED" + ANSI_RESET);
                }
                System.out.print(testMessage);
                go = input.nextLine();
                System.out.println("\n#######################################################################\n");
        
                // #######################################################################
                // Testing second attribute that has getters and setters        
                name = testClone.getLastName();
                System.out.println("Testing Last Name getter. Expecting: null, got back: " + name);
                System.out.print("Test ");
                if (name == null) {
                    System.out.println(ANSI_GREEN + "SUCCEEDED" + ANSI_RESET);
                }
                else {
                    System.out.println(ANSI_RED + "FAILED" + ANSI_RESET);
                }
                System.out.print(testMessage);
                go = input.nextLine();
                System.out.println("\n#######################################################################\n");
        
                System.out.println("Testing Last Name setter. Setting to: Jones");
                testClone.setLastName("Jones");
        
                name = testClone.getLastName();
                System.out.println("Re-Testing Last Name getter. Expecting: Jones, got back: " + name);
                if (name.equals("Jones")) {
                    System.out.println(ANSI_GREEN + "SUCCEEDED" + ANSI_RESET);
                }
                else {
                    System.out.println(ANSI_RED + "FAILED" + ANSI_RESET);
                }
                System.out.print(testMessage);
                go = input.nextLine();
                System.out.println("\n#######################################################################\n");
        
                // #######################################################################
                //Call each method of the class and verify that each method provides
                //the correct behavior or results
                // #######################################################################
        
        
                // Testing introduction() method
                System.out.println("Testing introduction() --> " + ANSI_PURPLE + "MANUALLY INSPECT INTRODUCTION FOR ERRORS."
                        + ANSI_RESET + " First and Last Names already set above ");
                testClone.introduction();
                System.out.print(testMessage);
                go = input.nextLine();
                System.out.println("\n#######################################################################\n");
        
                // #######################################################################
        
                // Testing printOutMessages(String theMessage) method
                System.out.println("Testing printOutMessages(String theMessage) --> "
                        + ANSI_PURPLE + "MANUALLY INSPECT INSTRUCTIONS FOR ERRORS. " + ANSI_RESET);
                System.out.println("Expecting:\nThis is line one of the test message.\nThis is line two.\n");
                System.out.println("Got:");
                testClone.printOutMessages("This is line one of the test message.\nThis is line two.");
                System.out.print(testMessage);
                go = input.nextLine();
                System.out.println("\n#######################################################################\n");
        
                // #######################################################################
        
                // Testing reset intro method
                System.out.println("Testing reDoIntro() that resets First and Last Names both to: null");
                testClone.reDoIntro();
                name = testClone.getFirstName();
                str = testClone.getLastName();
                System.out.println("Reset complete! Testing First & Last Name getters. Expecting: null null, got back: " + name + " " + str);
                System.out.print("Test ");
                if ( (name == null) && (str == null) ) {
                   System.out.println(ANSI_GREEN + "SUCCEEDED" + ANSI_RESET);
                }
                else {
                    System.out.println(ANSI_RED + "FAILED" + ANSI_RESET);
                }

               // #######################################################################
        
                // for testing unit one cycle use - ask if they want to restart the unit one tests
                System.out.print("");
                System.out.println(ANSI_PURPLE + "Would you like to run unit one tests again? (y/anykey)\n Enter"
                    + " 'y' to restart unit one tests, or any other key to continue to unit two: " + ANSI_RESET);
                answerUnitLoop = unitOne.nextLine();
                unitLoop = answerUnitLoop.equalsIgnoreCase("y"); // continue with current lists
            
                System.out.println(); // for screen/readability formatting
        

            } while (unitLoop);
            // end of unit one testing container
            
            // #######################################################################
            
            ShoutBox myShout= new ShoutBox();
        
            // Begin unit two test container
            do {
        
                System.out.println("\n#######################################################################");
                System.out.println(ANSI_GREEN + "Unit Testing Second Class - ShoutBox" + ANSI_RESET);
                System.out.println("#######################################################################\n");
        
                
                // Testing getHowManyMessages() which gets the total canned messages we are expecting/using
                i = myShout.getHowManyMessages();
                System.out.println("Testing getHowManyMessages() getter. Expecting: 10, got back: " + i);
                System.out.print("Test ");
                if (i == 10) {
                    System.out.println(ANSI_GREEN + "SUCCEEDED" + ANSI_RESET);
                }
                else {
                    System.out.println(ANSI_RED + "FAILED" + ANSI_RESET);
                }
                
                
                
                System.out.println("\n#######################################################################\n");
                
                // Testing build canned list builder method
                System.out.println("Testing buildCannedList() method that builds the canned list.");
                System.out.print(testContMessage);
                go = input.nextLine();
                
                myShout.buildCannedList();
                System.out.println("\nTest " + ANSI_GREEN + "SUCCEEDED" + ANSI_RESET);
                
                System.out.println("\n#######################################################################\n");
                
                // Testing random word list builder method
                System.out.println("Testing buildCannedList() method that builds the 5 word lists we need to build random sentences.");
                
                System.out.print(testContMessage);
                go = input.nextLine();
                
                myShout.buildRandomLists();
                
                System.out.println("\nTest " + ANSI_GREEN + "SUCCEEDED" + ANSI_RESET);
                
                System.out.println("\n#######################################################################\n");
                
                // #######################################################################
                
                // test canned message/phrase selection
                System.out.println("Testing shoutOutCannedMessage() method that outputs user selection from the canned list.\n"
                        + ANSI_GREEN + "Make sure to select options inside and outside the selection range as well as\n"
                        + "the options at each end of the option range." + ANSI_RESET);
                
                System.out.print(testContMessage);
                go = input.nextLine();
                
                do {
                    System.out.println(myShout.shoutOutCannedMessage());
                    System.out.print("");
                    System.out.print(ANSI_PURPLE + "TESTING LOOP: Select a canned message again (y/ank-key): " + ANSI_RESET);
                    userMiniTestLoop = loopInput.nextLine();
                    keepLooping = userMiniTestLoop.equalsIgnoreCase("y");
                } while (keepLooping);
                
                System.out.println("\nTest " + ANSI_GREEN + "SUCCEEDED" + ANSI_RESET);
                
                System.out.println("\n#######################################################################\n");

                // test random sentences built from individual randomly selected words from 5 lists
                System.out.println("Testing shoutOutRandomMessage() method that outputs a sentence using randomly indexed\n"
                        + "words from each individual word list that was built. Try a few times.");
                
                System.out.print(testContMessage);
                go = input.nextLine();
                
                do {
                    System.out.println(myShout.shoutOutRandomMessage());
                    System.out.print("");
                    System.out.print(ANSI_PURPLE + "TESTING LOOP: Test a random sentence again? (y/ank-key): " + ANSI_RESET);
                    userMiniTestLoop = loopInput.nextLine();
                    keepLooping = userMiniTestLoop.equalsIgnoreCase("y");
                } while (keepLooping);
                
                System.out.println("\nTest " + ANSI_GREEN + "SUCCEEDED" + ANSI_RESET);

                // #######################################################################
        
                // for testing unit one cycle use - ask if they want to restart the unit one tests
                System.out.println("\n" + ANSI_PURPLE + "Would you like to run unit two tests again? (y/c/anykey)\n"
                        + ANSI_PURPLE + "Enter" + "'y'" + ANSI_PURPLE +  "to restart unit two tests from the beginning,\n or "
                        + "'c'" + ANSI_PURPLE +  "to continue using the previous lists you created,\n or"
                        + " any other key to continue to unit three: " + ANSI_RESET);
                answerUnitLoop = unitTwo.nextLine();
                unitLoopTwo = answerUnitLoop.equalsIgnoreCase("c"); // continue with current lists
                
                // allow resetting of lists to reselect entry/building options
                if (answerUnitLoop.equalsIgnoreCase("y")) {
                    //myClone.reDoIntro();
                    myShout.reChooseOptionsList();
                    unitLoopTwo = answerUnitLoop.equalsIgnoreCase("y");
                }
            
                System.out.println(); // for screen/readability formatting
            
            } while (unitLoopTwo);
            // end of unit two testing container
        
            // #######################################################################
            
            // Begin unit test three container
            do {
                
                System.out.println("\n#######################################################################");
                System.out.println(ANSI_GREEN + " Unit Testing Third Class - BeerChant" + ANSI_RESET);
                System.out.println("#######################################################################\n");
        
                BeerChant myBeer= new BeerChant();
        
                System.out.print(testMessage);
                go = input.nextLine();
        
                System.out.println("Testing Beer Name setter. Setting to: Bubba");
                myBeer.setBeerName("Bubba");
        
                name = myBeer.getBeerName();
                System.out.println("Testing Beer Name getter. Expecting: Bubba, got back: " + name);
                if (name.equals("Bubba")) {
                    System.out.println(ANSI_GREEN + "SUCCEEDED" + ANSI_RESET);
                }
                else {
                    System.out.println(ANSI_RED + "FAILED" + ANSI_RESET);
                }
                
                System.out.println("\n#######################################################################\n");
                
                System.out.println("Testing theBeerWar() method which produces the beer chant wars between you and the computer.");
                System.out.print(testMessage);
                go = input.nextLine();
                
                do {
                    System.out.println(myShout.shoutOutRandomMessage());
                    System.out.println("\nTest " + ANSI_GREEN + "SUCCEEDED" + ANSI_RESET);
                    System.out.print("");
                    System.out.print(ANSI_PURPLE + "TESTING LOOP: Test Beer Wars again? (y/ank-key): " + ANSI_RESET);
                    userMiniTestLoop = loopInput.nextLine();
                    keepLooping = userMiniTestLoop.equalsIgnoreCase("y");
                } while (keepLooping);
                
                // #######################################################################
        
                // for testing unit one cycle use - ask if they want to restart the unit one tests
                System.out.println(ANSI_PURPLE + "\nWould you like to run unit three tests again? (y/anykey)\n"
                    + "Enter 'y' to restart unit three tests, or any other key to continue to finish testing: " + ANSI_RESET);
                answerUnitLoop = unitThree.nextLine();
                unitLoopThree = answerUnitLoop.equalsIgnoreCase("y"); // continue with current lists
            
                System.out.println(); // for screen/readability formatting
        

            } while (unitLoopThree);
            // end of unit three testing container

            System.out.println("\n#######################################################################\n");
        
            System.out.println(ANSI_PURPLE + "\nDone Testing!"+ ANSI_RESET);
        
        
            // for testing cycle use - ask if they want to restart the test cycle
            System.out.println("\nWould you like to run this program again? (y/anykey)\n"
                    + "Enter 'y' to restart from the beginning, or any other key to exit: ");
            
            answerLoop = userExitInput.nextLine();
            keepGoing = answerLoop.equalsIgnoreCase("y"); // continue with current lists
            
            System.out.println(); // for screen/readability formatting
        

        } while (keepGoing);
        // end of testing container
    }
    
}
