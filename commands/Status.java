package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the status command, allowing the player to retrieve information
 * about their inventory, specific items, or their overall status.
 * 
 * <p>
 * The status command can display a list of items in the player's inventory, 
 * provide details about a specific item, or show the player's general status.
 * </p>
 */
public class Status extends Command {

        public Status(String topic){
            super.value = topic;
        }

        @Override
        public String execute(GameState gameState){
            String message = "";
            switch (super.value){
                case "inventory":
                    for (Item i: gameState.getPlayer().getInventory()){
                        message += i.getName() + " ";
                    }
                    for (Equipment e: gameState.getPlayer().getEquipment()){
                        message += e.getName() + " ";
                    }
                    return message;
                case "player":
                    return gameState.getPlayer().toString();
                case "map":
                    System.out.println("Score lost: -10");
                    gameState.getPlayer().minusScore(10);
                    return gameState.getMap().display(gameState);
                case "score":
                    return gameState.getPlayer().getScore();
            }
            for (Item i: gameState.getPlayer().getInventory()){
                if (i.getName().equals(super.value)){
                    return i.getDescription();
                }
            }
            for (Equipment e: gameState.getPlayer().getEquipment()){
                if (e.getName().equals(super.value)){
                    return e.getDescription();
                }
            }
            return message;
        }
}
