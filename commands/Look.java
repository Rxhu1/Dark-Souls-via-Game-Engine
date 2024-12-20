package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the look command, allowing the player to examine various elements of the game world.
 * 
 * <p>
 * The look command can provide details about the current room, its exits, features, or specific items and equipment.
 * Hidden objects are not included in the output unless explicitly revealed.
 * </p>
 */
public class Look extends Command {

    public Look(String target){
        super.value = target;
    }

    @Override
    public String execute(GameState gameState){
        switch (super.value){
            case "room":
                String roomStr = gameState.getMap().getCurrentRoom().getDescription();
                roomStr += "\n";
                for (GameObject o: gameState.getMap().getCurrentRoom().getAll()){
                    if (!o.getHidden()){
                        roomStr += o.getName() + ": " + o.getDescription();
                        roomStr += "\n";
                    }
                }
                return roomStr;
            case "exits":
                String exitList = "The available exits are: ";
                for (Exit e: gameState.getMap().getCurrentRoom().getExits()){
                    if (!e.getHidden()){
                        exitList += e.getDescription();
                        exitList += "\n";
                    }
                }
                return exitList;
            case "features":
                String featureList = "You also see: ";
                for (Feature f: gameState.getMap().getCurrentRoom().getFeatures()){
                    if (!f.getHidden()){
                        featureList += f.getDescription();
                        featureList += "\n";
                    }
                }
                return featureList;
        }
        /*if (gameState.getPlayer().hasEquipment(super.value)){
            return gameState.getPlayer().getEquipment(super.value).getDescription();
        }
        else if (gameState.getPlayer().hasItem(super.value)){
            return gameState.getPlayer().getItem(super.value).getDescription();
        }
        else if (gameState.getMap().getCurrentRoom().hasFeature(super.value)){
            return gameState.getMap().getCurrentRoom().getFeatureByName(super.value).getDescription();
        }*/
        for (GameObject o: gameState.getMap().getCurrentRoom().getAll()){
            if (o.getName() == super.value){
                if (!o.getHidden()){
                    return o.getDescription();
                }
            }
        }
        return "";
    }
   
}
