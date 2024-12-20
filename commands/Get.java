package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the get command, allowing the player to pick up an item from the current room and add it to their inventory.
 * 
 * <p>
 * This command checks if the specified item is present in the current room. If the item exists and the player
 * does not already have it, the item is added to the player's inventory and removed from the room. Otherwise,
 * an appropriate message is returned.
 * </p>
 */
public class Get extends Command {

    public Get(String item){
        super.value = item;
    }

    @Override
    public String execute(GameState gameState){
        if (gameState.getMap().getCurrentRoom().hasItem(super.value) && !gameState.getPlayer().hasItem(super.value)){
            Item item = gameState.getMap().getCurrentRoom().getItemByName(super.value);
            gameState.getMap().getCurrentRoom().getItems().remove(item);
            gameState.getPlayer().addItem(item);
            gameState.getPlayer().addScore(10);
            System.out.println("Score gained: +10");
            return "You pick up: " + super.value;
        }
        else if (gameState.getPlayer().hasItem(super.value)){
            return "You already have " + super.value;
        }
        else if (gameState.getMap().getCurrentRoom().hasEquipment(super.value) && !gameState.getPlayer().hasEquipment(super.value)){
            Equipment equipment = gameState.getMap().getCurrentRoom().getEquipmentByName(super.value);
            gameState.getMap().getCurrentRoom().getEquipments().remove(equipment);
            gameState.getPlayer().addEquipment(equipment);
            gameState.getPlayer().addScore(10);
            System.out.println("Score gained: +10");
            return "You pick up: " + super.value;
        }
        else if (gameState.getPlayer().hasEquipment(super.value)){
            return "You already have " + super.value;
        }
        else{
            return "No " + super.value + " to get.";
        }
    }

    @Override
    public String toString(){
        return "Last item picked up: " + super.value;
    }
}
