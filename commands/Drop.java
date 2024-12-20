package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the drop command, allowing the player to drop an item from their inventory into the current room.
 * 
 * <p>
 * This command checks if the player possesses the specified item and, if so, removes it from their inventory
 * and adds it to the current room. If the player does not have the item, an error message is returned.
 * </p>
 */
public class Drop extends Command {

    public Drop(String item){
        super.value = item;
    }

    @Override
    public String execute(GameState gameState){
        if (gameState.getPlayer().hasItem(super.value)){
            Item item = gameState.getPlayer().getItem(super.value);
            gameState.getPlayer().getInventory().remove(item);
            gameState.getMap().getCurrentRoom().addItem(item);
            return "You drop: " + super.value;
        }
        else if (gameState.getPlayer().hasEquipment(super.value)){
            Equipment equipment = gameState.getPlayer().getEquipment(super.value);
            gameState.getPlayer().getEquipment().remove(equipment);
            gameState.getMap().getCurrentRoom().addEquipment(equipment);
            return "You drop: " + super.value;
        }
        else{
            return "You cannot drop " + super.value;
        }
    }
}
