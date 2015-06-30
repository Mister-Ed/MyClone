/*
 * @author: Mister Ed
 * For: Final Project - Virtual World
 * Date: June 27, 2015
 * 
 * Instance Objects will populate with either canned messages supplied by
 * default or allow user messages to be supplied instead.
 *
 * Can sort HashMap entries if changed to Strings as key values, using
 * sortHashMap method
 */
package myclone;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator; // for HashMap sorting
import java.util.Map.Entry;  // for HashMap sorting
import java.util.Set; // for HashMap sorting
import java.util.TreeMap; // for HashMap sorting

/**
 *
 * @author Mister Ed
 */
public class ShoutBox {
    
    private 
            static final String ANSI_RESET = "\u001B[0m";
            static final String ANSI_RED = "\u001B[31m";
            static final String ANSI_GREEN = "\u001B[32m";
            static final String ANSI_BLUE = "\u001B[34m";
            boolean loadedMessages;
            boolean loadedWordLists;
            final int messageCount; // how many messages we are using/expecting
            final int totalPlusOne;
            final int totalPlusTwo;
            final int sentenceWords;
            String returnString;
            String sorryWord;
            String messageOptionsList; // the built list of options to chose from
            int userSelectedThis; // users option choice
            Scanner userSelection; // facilitates user's choice/selection
            final HashMap<Integer, String> shoutMessages; //using HashMap not ArrayList
            TreeMap<Integer, String> sorted;
            Entry<Integer, String> mapping;
            Set<Entry<Integer, String>> mappings;
            Iterator<Entry<Integer, String>> it;
            final String[] cannedMessageList; // fixed array. Number of elements must equal messageCount
            ArrayList<String> subjects;
            ArrayList<String> verbs;
            ArrayList<String> adjectives;
            ArrayList<String> objects;
            ArrayList<String> adverbs;
            String[] subjectList;
            String[] verbList;
            String[] adjectiveList;
            String[] objectList;
            String[] adverbList;

    
    // Default constructor
    public ShoutBox() {
        this.userSelectedThis = 0;
        this.messageOptionsList = ANSI_RED + "\nSorry, no messages yet\n" + ANSI_RESET;
        this.returnString = "";
        this.messageCount = 10;
        this.totalPlusOne = this.messageCount + 1;
        this.totalPlusTwo = this.totalPlusOne + 1;
        this.sentenceWords = 5;
        this.loadedMessages = false;
        this.loadedWordLists = false;
        this.sorryWord = ANSI_RED + "Sorry, please enter only use cap/lower case letters for each word: " + ANSI_RESET;
        this.shoutMessages = new HashMap<>();
        // our pre-populated list of messages.
        this.cannedMessageList = new String[]{
                "Pick Me! Pick me! I'm number one!",
                "Second place is the first loser in the line up",
                "When searching for something, it is always found in the last place you look",
                "My friend snorts loudly when they laugh.",
                "Programming is kind of like spelunking, the deeper you go the more you see!",
                "Features & benefits are just more lies from the marketing dept!",
                "How many Project Managers do we really need?",
                "Ugh! yet another SCRUM meeting, can I just code please?",
                "I'm bored ... I like grapes",
                "Okay, so if y**2 is too many whys for variable guy, then how many x's should guy have?"
            };
       
        // Various arrays/lists of words for shoutOutRandomMessage
        this.subjects = new ArrayList<>();
        this.subjectList = new String[]{ "You", "We", "They" };
        this.verbs = new ArrayList<>();
        this.verbList = new String[]{ "write", "wear", "eat", "ride", "drive", "use", "grip", "flip",
            "kick", "fold", "squeeze", "hold", "file", "watch"  };
        this.adjectives = new ArrayList<>();
        this.adjectiveList = new String[]{ "funny", "hard", "soft", "awesome", "big", "small", "tiny",
            "stinky", "wet", "weird" };
        this.objects = new ArrayList<>();
        this.objectList = new String[]{ "books", "phones", "horses", "cars", "bananas", "fart guns",
            "shoes", "cows", "people", "papers", "movies"  };
        this.adverbs = new ArrayList<>();
        this.adverbList = new String[]{ "quickly", "slowly", "stylishly", "carefully", "sloppily",
            "lazily", "quietly", "tentatively", "eagerly" };

    } // end default constructor
    
    /*
     * Prints out the 10 canned messages already built (from prepopulation or user entry) and adds option of
     * random pick from the 10 messages OR an option to display a message built from the 5 message ArrayLists, 
     * each being randomly selected individually -- calls shoutOutRandomMessage() method
    */
    public String shoutOutCannedMessage() {
        
        boolean failed;
        
        // Use selects canned message (or has a message built randomly via option to select shoutOutRandomMessage)
        this.userSelection = new Scanner(System.in);
            
        printOutMessages("Select your favorite of the " + this.totalPlusTwo + " message options below ...");
        printOutMessages(this.messageOptionsList);
        printOutMessages("Option #" + this.totalPlusOne + ": For a random selection from the messages above");
        printOutMessages("Option #" + this.totalPlusTwo + ": For a message built from random words within lists");
        
        // Checking for valid choice & entries
        while ( (this.userSelectedThis < 1) || (this.userSelectedThis > this.totalPlusTwo) ) {
            System.out.print("\nWhich one was your favorite? ( "
                    + "enter number between 1 and " + this.totalPlusTwo + "): ");
            
            // Check for valid integer
            if (this.userSelection.hasNextInt()) {
                this.userSelectedThis = this.userSelection.nextInt();
                failed = false; // reset just in case failed in prior loop run
            }
            else {
                printOutMessages(ANSI_RED + "\nWhat you entered was not a valid integer" + ANSI_RESET);
                failed = true;
            }

            /*
             * if user input not within our range of valid message entries, print out error.
             * Skip error message if input was not an integer
            */
            if ( ( (this.userSelectedThis < 1) || (this.userSelectedThis > this.totalPlusTwo) ) && !(failed) ) {
                System.out.println(ANSI_RED + "The number entered was not between 1 and "
                        + this.totalPlusTwo + "!\n" + ANSI_RESET);
            }

            }
            
            if (this.userSelectedThis == this.totalPlusOne) {
                // Let the Randomness begin
                // int r = (int) (Math.random() * (b - a + 1)) + a;
                int r = (int) (Math.random() * (this.totalPlusOne));
                this.returnString = "\nYour Randomly Selected Message #" + r + ": "
                    + ANSI_BLUE + getStringFromHashMap(r) + ANSI_RESET;
            }
            else if (this.userSelectedThis == this.totalPlusTwo) {
                // Call method to build random sentence from word lists
                this.returnString = this.shoutOutRandomMessage();
            }
            else {
                this.returnString = "\nYour Selected Favorite Message: "
                        + ANSI_BLUE + getStringFromHashMap(this.userSelectedThis) + ANSI_RESET;
        }

        this.userSelectedThis = 0; // reset for possible next iteration
        
        // Return our selected message
        return returnString;
        
    }
    
    
    /*
     * Random message generator that picks 5 words in the form of:
     * Subject - Verb - Adjective - Object - Adverb
     * Prints out the message built from the 5 message ArrayLists, 
     * each being randomly selected individually and already built previously
     * by the buildRandomLists() method.
     *
     * Can be accessed directly and via shoutOutCannedMessage()
    */
    public String shoutOutRandomMessage() {
        
        int subj = (int) (Math.random() * (this.subjects.size()));
        int verb = (int) (Math.random() * (this.verbs.size()));
        int adj = (int) (Math.random() * (this.adjectives.size()));
        int obj = (int) (Math.random() * (this.objects.size()));
        int adverb = (int) (Math.random() * (this.adverbs.size()));
        
        // Internal testing only
        /*System.out.println(subj + "/" + this.subjects.size()+ " " + verb + "/" + this.verbs.size()+ " " + adj + "/" + this.adjectives.size() + " "
         *        + obj + "/" + this.objects.size() + " " + adverb + "/" + this.adverbs.size());
         */
        
        // Return our randomly compiled message
        return this.returnString = "\nYour random message we created: "
                + ANSI_BLUE + this.subjects.get(subj) + " "
                + this.verbs.get(verb) + " "
                + this.adjectives.get(adj) + " "
                + this.objects.get(obj) + " "
                + this.adverbs.get(adverb) + ANSI_RESET;
    }
    
    
    // add messages to HashMap - a mutator/setter.
    private void addStringToHashMap(Integer counter,String incomingString) {
        shoutMessages.put(counter, incomingString);
    }
    
    
    // builds HashMap from fixed array of canned messages - a mutator/setter.
    private void buildHashFromFixedArray() {
        int counter = 0; // declare and initialize the counter
        while ( counter < this.messageCount ) {
            // get a canned message string
            this.shoutMessages.put(counter+1,this.cannedMessageList[counter]);
            counter++;
        }
    }
    
   
    // Sort HashMap by keys
    private void sortHashMapKeys() {
        this.messageOptionsList = ""; // reset just in case
        // start sort HashMap by keys since ordering is not assurred
        this.sorted = new TreeMap<>(this.shoutMessages);
        this.mappings = sorted.entrySet();
        
        // HashMap after sorting by keys in ascending order
        for (this.it = this.mappings.iterator(); it.hasNext();) {
            this.mapping = it.next();
            this.messageOptionsList += "\nOption #" + this.mapping.getKey() + ": " + this.mapping.getValue();
        }
    }
    
    
    // to get message from ArrayList -- a getter
    private String getStringFromHashMap(int incomingIndex) {
        return this.shoutMessages.get(incomingIndex);
    }
    
    // print misc lines
    private void printOutMessages(String theMessage) {
        System.out.println( theMessage );
    }
    
    
    // validate incoming name strings
    private Boolean validateString(String str) {
        // only upper and lower case allowed
        return str.matches("[a-zA-Z]+");
    }
    
    
    // loops over user inputs until valid. If initially valid, returns original string
    private String userWordsValidate(String str) {
        if (!(validateString(str))) {
            Scanner input = new Scanner(System.in); // local only user input
            // run it until valid
            do {
                System.out.print(this.sorryWord);
                str = input.nextLine();
            } while (!validateString(str));
        }
        return str;
    }
    
    
    /* Builds the list of Canned messages either from prepopulated option or
     * from user input for all "n" messages.
     * Use during virtual world creation phase
    */
    public void buildCannedList() {
        
        // run only if we have not already built the messages HashMap
        if (!(this.loadedMessages)) {
            // local variables
            String messageTypeAnswer;
            boolean useUserMessages;
            int counter = 1;
            
            // user decides whether to used canned messages or enter their own
            System.out.print("\nPress 1 to enter your own messages "
                    + "OR press another key to build list from our messages: ");
        
            Scanner vWorldSetupOption = new Scanner(System.in);
            
            messageTypeAnswer = vWorldSetupOption.nextLine();
            useUserMessages = messageTypeAnswer.equals("1");
        
            if (useUserMessages) {
                // need to get user supplied messages
                printOutMessages("We need " + this.messageCount + " simple messages/sentences from you ..." );
                
                // get all the user messages/entries one line at a time
                while ( counter < totalPlusOne ) {
                    System.out.print("Enter Message #" + counter + ": " );
                    addStringToHashMap(counter, vWorldSetupOption.nextLine());
                    counter++;
                }
            }
            else {
                // Build message ArrayList from canned messages (fixed) array.
                buildHashFromFixedArray();
            }
        
            // sort HashMap & build returnString
            sortHashMapKeys();
            this.loadedMessages = true;
        } // end of building HashMap & sorting and building printout
    }
    
    
    // builds lists for the random message generator
    public void buildRandomLists() {
        
        // run only if we have not already built the word lists
        if (!(this.loadedWordLists)) {
            // local variables
            String messageTypeAnswer;
            String placeHolder;
            boolean useUserMessages;
            int counter = 0;
            int size;
            
            // user decides whether to used canned messages or enter their own
            System.out.print("\nPress 1 to build the 5 'word type' lists by manually entering each one\n"
                    + "OR press another key to build the word lists automatically: ");
        
            Scanner vWorldSetupOption = new Scanner(System.in);
            
            messageTypeAnswer = vWorldSetupOption.nextLine();
            useUserMessages = messageTypeAnswer.equals("1");
        
            // need to get user supplied messages
            if (useUserMessages) {

                printOutMessages("Thank you. You have selected to enter your own word lists manually.\n" );

                // get all the user messages/entries one line at a time
                
                //get subjects
                printOutMessages("Enter only single words. Type 'q' when finished entering 'subject' words ..." );                
                do {
                    System.out.print("Enter a subject (as a single word): " );
                    placeHolder = vWorldSetupOption.nextLine();
                    placeHolder = userWordsValidate(placeHolder); // Validate placeHolder string
                    if (!placeHolder.equalsIgnoreCase("q")) {
                        this.subjects.add(placeHolder);
                    }
                } while (!placeHolder.equalsIgnoreCase("q"));
                System.out.println(); // for screen/readability formatting
                
                //get verbs
                printOutMessages("Enter only single words. Type 'q' when finished entering 'verb' words ..." );
                do {
                    System.out.print("Enter a verb (as a single word): " );
                    placeHolder = vWorldSetupOption.nextLine();
                    placeHolder = userWordsValidate(placeHolder); // Validate placeHolder string
                    if (!placeHolder.equalsIgnoreCase("q")) {
                        this.verbs.add(placeHolder);
                    }
                } while (!placeHolder.equalsIgnoreCase("q"));
                System.out.println(); // for screen/readability formatting
                
                //get adjectives
                do {
                    System.out.print("Enter an adjective (as a single word): " );
                    placeHolder = vWorldSetupOption.nextLine();
                    placeHolder = userWordsValidate(placeHolder); // Validate placeHolder string
                    if (!placeHolder.equalsIgnoreCase("q")) {
                        this.adjectives.add(placeHolder);
                    }
                } while (!placeHolder.equalsIgnoreCase("q"));
                System.out.println(); // for screen/readability formatting
                
                //get objects
                do {
                    System.out.print("Enter an object (as a single word): " );
                    placeHolder = vWorldSetupOption.nextLine();
                    placeHolder = userWordsValidate(placeHolder); // Validate placeHolder string
                    if (!placeHolder.equalsIgnoreCase("q")) {
                        this.objects.add(placeHolder);
                    }
                } while (!placeHolder.equalsIgnoreCase("q"));
                System.out.println(); // for screen/readability formatting
                
                //get adverbs
                do {
                    System.out.print("Enter an adverb (single word) or type 'q' if finished entering adverbs: " );
                    placeHolder = vWorldSetupOption.nextLine();
                    placeHolder = userWordsValidate(placeHolder); // Validate placeHolder string
                    if (!placeHolder.equalsIgnoreCase("q")) {
                        this.adverbs.add(placeHolder);
                    }
                } while (!placeHolder.equalsIgnoreCase("q"));
                System.out.println(); // for screen/readability formatting
        
                

            } // end building user entered word lists
            else {
                                
                //build subjects ArrayList
                size = this.subjectList.length; 
                while ( counter < size ) {
                    // get a canned message string
                    this.subjects.add(this.subjectList[counter]);
                    counter++;
                }
                
                //build verbs ArrayList
                size = this.verbList.length;
                counter = 0;
                while ( counter < size ) {
                    // get a canned message string
                    this.verbs.add(this.verbList[counter]);
                    counter++;
                }
                
                //build adjectives ArrayList
                size = this.adjectiveList.length;
                counter = 0;
                while ( counter < size ) {
                    // get a canned message string
                    this.adjectives.add(this.adjectiveList[counter]);
                    counter++;
                }
                
                //build objects ArrayList
                size = this.objectList.length;
                counter = 0;
                while ( counter < size ) {
                    // get a canned message string
                    this.objects.add(this.objectList[counter]);
                    counter++;
                }
                
                //build adverbs ArrayList
                size = this.adverbList.length;
                counter = 0;
                while ( counter < size ) {
                    // get a canned message string
                    this.adverbs.add(this.adverbList[counter]);
                    counter++;
                }

            } // End autobuild word lists from default arrays
        
             this.loadedWordLists = true;
             printOutMessages(ANSI_GREEN + "Thank you! We are done creating the list of word we needed for the random message generator.\n" + ANSI_RESET);
             
        } // end of building word lists
 
    }
    
    
    // Allows setting the booloean to choose entry of list or use of prepopulated list
    public void reChooseOptionsList() {
        this.loadedMessages = false;
        this.loadedWordLists = false;
    }

    
    // getter returns how many messages we are using/expecting/etc
    public int getHowManyMessages() {
        return messageCount;
    }
    
}
