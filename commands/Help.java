package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the help command, providing the player with instructions or information
 * about various topics related to the game.
 * 
 * <p>
 * The help command displays information on how to play the game, including details about 
 * available commands, their syntax, and their purpose.
 * </p>
 */
public class Help extends Command {

    public Help(String topic){
        super.value = topic;
    }

    @Override
    public String execute(GameState gamestate){
        if (super.value != null){
            switch (super.value){
                case "move":
                    //move case
                    return "MOVE Command: Use the 'move' command with <direction> right after. You can only move in a direction if there is a visible exit in that direction.";
                case "use":
                    //use case
                    return "USE Command: Use the 'use' command with <item/equipment> right after, to use items together or use an item on its own.";
                case "command":
                    //command case
                    return "COMMAND Command: Here are a list of all available commands:\n 1. drop\n 2. get\n 3. help\n 4. look\n 5. move\n 6. quit\n 7. status\n 8. use";
                default:
                    //invalid case
                    return "No help available for the topic: " + super.value;
            }
        }
        else {
            return "Welcome to the game! move <north/south/east/west> - MOVE. move/use/commands - HELP";
        }
    }

    @Override
    public String toString(){
        return "HELP: topic is " + super.value;
    }
  
}
