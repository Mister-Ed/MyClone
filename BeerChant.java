/*
 * @author: Mister Ed
 * For: Final Project - Virtual World
 * Date: June 27, 2015
 * Final submission of the programmer chosen class/object.
 * Assumes first and last names are already set in MyClone, so only invoked after
 * MyClone introduction is successful.
 *
 * BeerChant class inherits from MyClone class, and uses "super" class.
 *
 * Except for beerName, no other virtual world setup needed.
 *
 * MyClone package / BeerChant class
 */
package myclone;

import java.util.Scanner;

/**
 *
 * @author Mister Ed
 */
public class BeerChant {
    
    private
            String beerName; // first name
            String chantOne;
            String chantTwo;
            static final String ANSI_RESET = "\u001B[0m";
            static final String ANSI_BLUE = "\u001B[34m";
            final int messageCount; // how many messages we are using
            final String[] messageList; // needs to match messageCount in elements used
            Scanner input;
            
    
    // Default constructor
    public BeerChant() {
        this.beerName = null;
        this.chantOne = "Less Filling!";
        this.chantTwo = "Tastes Great!";
        this.input = new Scanner(System.in);
        this.messageCount = 10; /// how many messages in our array
        this.messageList = new String[]{
            "Give it up already,",
            "Hey!",
            "No way!",
            "Get Real!",
            "What a jerk, ",
            "Don't make me come over there and slap you silly, ",
            "Your momma said:",
            "Trust me!",
            "I can do this all day,",
            "Okay, you win ... not!"
        };
    }
    
    
    // the main war
    public void theBeerWar() {
        String str;
        do {
            printBeerOptions();
            str = input.nextLine();
            switch (str) {
                case "1":
                    printMessage("\n" + ANSI_BLUE + getRandom() + " " + getChantTwo() + ANSI_RESET + "\n");
                    break;
                case "2":
                    printMessage("\n" + ANSI_BLUE + getRandom() + " " + getChantOne() + ANSI_RESET + "\n");
                    break;
                default:
                    printMessage("\n" + ANSI_BLUE + getBeerName() + ", I knew you'd give up! I win!!!!!\n " + ANSI_RESET);
                    break;
            }
            
        } while (str.equals("1") || str.equals("2"));
    }
    
    
    // get name
    public String getBeerName() {
        return this.beerName;
    }
    
    
    // set name, requires first name to be supplied
    public void setBeerName(String str) {
        this.beerName = str;
    }
    
    
    // prints out options for user to select
    private void printBeerOptions() {
        System.out.println(getBeerName() + ", your favorite beer:\n"
                + "Option #1: is " + getChantOne()
                + "\nOption #2: " + getChantTwo()
                + "\nGive up? press any other key to end this war");
    }
    
    
    // random message genarator for the conflict/war
    private String getRandom() {
        int r = (int) (Math.random() * (this.messageCount));
        return getStringFromArray(r);
    }
    
    
    // to get message from Array -- a getter
    private String getStringFromArray(int incomingIndex) {
        return messageList[incomingIndex];
    }
    
    // returns chantOne
    private String getChantOne() {
        return this.chantOne;
    }
    
    // returns chantTwo
    private String getChantTwo() {
        return this.chantTwo;
    }
    
    
    private void printMessage(String outmsg) {
        System.out.println(outmsg);
    }
    
}
