package org.uob.a2;

import java.util.Scanner;

import org.uob.a2.commands.*;
import org.uob.a2.gameobjects.*;
import org.uob.a2.parser.*;
import org.uob.a2.utils.*;

/**
 * Main class for the game application. Handles game setup, input parsing, and game execution.
 * 
 * <p>
 * This class initializes the game state, reads user input, processes commands, and maintains the game loop.
 * </p>
 */
public class Game {
    //all attributes
    private static GameState gameState;
    private static Scanner scanner;
    private static Tokeniser tokeniser;
    private static Parser parser;
    private static Command command;

    //Constructor
    public Game(){}
    public static void main(String[] args){
        //Runs both the setup and start methods
        setup();
        start();
    }
    
    public static void setup(){
        //Instantiates new objects to setup the game. Includes accessing the txt file and parsing it.
        gameState = GameStateFileParser.parse("F:\\CS\\Uni\\Assignment 2\\rxr428\\data\\game.txt");
        scanner = new Scanner(System.in);
        tokeniser = new Tokeniser();
        parser = new Parser();
    }
    
    public static void start(){
        //Timer start
        final long startTime = System.nanoTime();

        //Always displays this at the start of the game
        System.out.println("_____________________________");
        System.out.println("Welcome to Lordran, a world which feels... soulless");
        System.out.println("You are represented by the ^ symbol.");

        //boolean used for the main game loop
        boolean isPlaying = true;
        String input = "";

        //main game loop using a while loop with the boolean value
        while(isPlaying){
            //At the start of each new area, it displays the following info
            System.out.println("_____________________________");
            System.out.println("You are located at " + gameState.getMap().getCurrentRoom().getName());
            System.out.println(gameState.getMap().getCurrentRoom().getDescription());
            System.out.println("You see:");
            //Accounts for all visible exits
            for (Exit ex: gameState.getMap().getCurrentRoom().getExits()){
                if(!ex.getHidden()){
                    System.out.println(ex.getDescription());
                }
            }
            //Accounts for all visible equipment
            for (Equipment eq: gameState.getMap().getCurrentRoom().getEquipments()){
                if(!eq.getHidden()){
                    System.out.println(eq.getDescription() + " (" + eq.getName() + ")");
                }
            }
            //Accounts for all visible items
            for (Item i: gameState.getMap().getCurrentRoom().getItems()){
                if(!i.getHidden()){
                    System.out.println(i.getDescription() + " (" + i.getName() + ")");
                }
            }
            //Accounts for all visible features
            for (Feature f: gameState.getMap().getCurrentRoom().getFeatures()){
                if(!f.getHidden()){
                    System.out.println(f.getDescription() + " (" + f.getName() + ")");
                }
            }

            System.out.print(">> ");
            //Gets the user's input
            input = scanner.nextLine();
            tokeniser.resetTokens(); //Reset required to make sure the arraylist is emptied of the last input
            tokeniser.tokenise(input); //Input is tokenised
            try{
                //Parses the tokens arraylist into a suitable command and stores this.
                command = parser.parse(tokeniser.getTokens());
                //Used to execute the following command
                turn(command);
                //Checks if player has quit
                if (command.commandType == CommandType.QUIT){
                    //Works out time played. This is an extra feature, allowing for the ability to try and speedrun the game till completion.
                    long duration = System.nanoTime() - startTime;
                    long seconds = duration / Long.valueOf(1000000000);
                    long minutes = seconds / 60;
                    long remainder = seconds % 60;

                    //final messages
                    System.out.println("Your final score is " + gameState.getPlayer().getScore() + "/280");
                    System.out.println("Your final time is " + minutes + " minutes " + remainder + " seconds.");
                    System.out.println("The fastest pace set by the developer is 2 minutes 25 seconds");
                    System.out.println("Thank you for playing.");
                    isPlaying = false;
                }
            }
            catch (CommandErrorException e){
                //catches command error exception
                System.out.println("Invalid Command");
            }
        }
    }
    
    //Used to execute the following command
    public static void turn(Command command){
        System.out.println("_____________________________");
        System.out.println(command.execute(gameState));
    }
}
