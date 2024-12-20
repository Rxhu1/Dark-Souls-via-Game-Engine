package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the move command, allowing the player to navigate to a different room in the game world.
 * 
 * <p>
 * The move command checks if the specified direction corresponds to an available exit in the current room.
 * If a matching exit is found, the player's location is updated to the connected room.
 * </p>
 */
public class Move extends Command {

    public Move(String direction){
        super.value = direction;
    }

    @Override
    public String execute(GameState gamestate){
        Exit exit = gamestate.getMap().getCurrentRoom().getExitByName(super.value);
        String message = "";
        if (exit != null){
            if (!exit.getHidden()){
                message += "Moving towards " + super.value + "\n";
                gamestate.getMap().setCurrentRoom(exit.getNextRoom());
                return message;
            }
            else{
                return "No exit found in that direction.";
            }
            /*switch (super.value){
                case "north":
                    //TO DO: check if exit is north
                    gamestate.getMap().setCurrentRoom(exit.getNextRoom());
                    return "You moved north";
                case "south":
                    //TO DO: check if exit is south
                    gamestate.getMap().setCurrentRoom(exit.getNextRoom());
                    return "You moved south";
                case "east":
                    //TO DO: check if exit is east
                    gamestate.getMap().setCurrentRoom(exit.getNextRoom());
                    return "You moved east";
                case "west":
                    //TO DO: check if exit is west
                    gamestate.getMap().setCurrentRoom(exit.getNextRoom());
                    return "You moved west";
            }*/
        }
        return "No exit found in that direction.";
    }

    @Override
    public String toString(){
        return "Last move: " + super.value;
    }
}
