/*
 * @author: Mister Ed
 * For: Final Project - Virtual World
 * Date: June 27, 2015
 * Final submission of MyClone to operate the MyClone Package and these associated classes:
 * MyClone
 * ShoutBox
 * BeerChant
 *
 * Operates Virtual World and allows for integrated testing. See VirtualWorldTestClass
 * for unit testing.
 *
 * Testing loops added to repeat steps, otherwise it would be a run once application.
 *
 */
package myclone;

import java.util.Scanner;


/**
 *
 * @author Mister Ed
 */
public class TestApp {
    
    public static void main(String[] args) {
        
        boolean keepGoing;
        String answerLoop;
        String userMiniTestLoop;
        boolean keepLooping;
        String ANSI_RESET = "\u001B[0m";
        String ANSI_PURPLE = "\u001B[35m";
        Scanner userExitInput = new Scanner(System.in);
        Scanner loopInput = new Scanner(System.in);
        // ShoutBox class inherits from MyClone class, and uses "super" class.
        MyClone myClone = new MyClone();
        ShoutBox myShout = new ShoutBox();
        BeerChant beerClone = new BeerChant();
        
        
        // Begin test cycle container
        do {

            // MyClone introduction() method
            myClone.introduction();

            
            // test a few MyClone & beerChant getters / setters / public
            //String testMsg = "TEST MSG: Using Getters from MyClone object/super. First Name is: " + myClone.getFirstName() +
            //        " --- Last Name is: " + myClone.getLastName() + "\n";
            //myClone.printOutMessages(testMsg);
            beerClone.setBeerName(myClone.getFirstName());
            
            
            //build virtual world
            myShout.buildCannedList();
            myShout.buildRandomLists();
            myClone.printOutMessages("OUR VIRTUAL WORLD IS NOW COMPLETE! HERE WE GO...\n");
            
            // run message/phrase selection
            do {
                myClone.printOutMessages(myShout.shoutOutCannedMessage());
                System.out.print("TESTING LOOP: Try this again (y/ank-key): ");
                userMiniTestLoop = loopInput.nextLine();
                keepLooping = userMiniTestLoop.equalsIgnoreCase("y");
            } while (keepLooping);
            
            
            // run random phrase builder by itself (also accessed via myClone.shoutOutCannedMessage()
            do {
                myClone.printOutMessages(myShout.shoutOutRandomMessage());
                System.out.print("TESTING LOOP: Try this again (y/any-key): ");
                userMiniTestLoop = loopInput.nextLine();
                keepLooping = userMiniTestLoop.equalsIgnoreCase("y");
            } while (keepLooping);
            
            System.out.println("");
            
            // Programmer selected method - let's start a beer chant war
            //myClone.printOutMessages("TEST MSG: beer name is: " + beerClone.getBeerName());
            
            System.out.println("Okay, " + beerClone.getBeerName() + ", I challenge you to a beer chant war! You pick first and I'll respond. Ready?");
            
            beerClone.theBeerWar();
 
    
            // for testing cycle use - ask if they want to restart the test cycle
            System.out.println("\nWould you like to run this program again? (y/c/anykey)\n"
                    + "Enter 'y' to restart from the beginning,\n or 'c' to continue"
                    + " using the previous name you entered, or any other key to exit: ");
            
            answerLoop = userExitInput.nextLine();
            keepGoing = answerLoop.equalsIgnoreCase("c"); // continue with current lists
            
            // allow resetting of lists to reselect entry/building options
            if (answerLoop.equalsIgnoreCase("y")) {
                myClone.reDoIntro();
                myShout.reChooseOptionsList();
                keepGoing = answerLoop.equalsIgnoreCase("y");
            }
            
            System.out.println(); // for screen/readability formatting

        } while (keepGoing);
        // end of testing container
        
        System.out.println("\n" + ANSI_PURPLE + "Good Bye!, ya'all come again real soon!\n" + ANSI_RESET);
        
    }
    
}
