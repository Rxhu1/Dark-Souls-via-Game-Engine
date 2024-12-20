package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the use command, allowing the player to use equipment on a specific target in the game.
 * 
 * <p>
 * The use command checks if the player has the specified equipment and whether it can interact with
 * the target. The target can be a feature, item, or the current room, depending on the game context.
 * </p>
 */
public class Use extends Command {
    private String equipmentName;

    public Use(String equipmentName, String target){
        this.equipmentName = equipmentName;
        super.value = target;
    }

    @Override
    public String execute(GameState gamestate){
        if (super.value.equals(this.equipmentName)){
            GameObject target = gamestate.getPlayer().getEquipment(this.equipmentName);
            if (gamestate.getPlayer().hasEquipment(this.equipmentName)){
                if (!gamestate.getPlayer().getEquipment(this.equipmentName).getUseInformation().isUsed()){
                    if (target != null){
                        if (target.getId().equals(gamestate.getPlayer().getEquipment(this.equipmentName).getUseInformation().getTarget())){
                            gamestate.getPlayer().addScore(20);
                            System.out.println("Score gained: +20");
                            return gamestate.getPlayer().getEquipment(this.equipmentName).use(target, gamestate);
                        }
                        else{
                            return "Invalid use target.";
                        }
                    }
                    else{
                        return "Invalid use target.";
                    }
                }
                else{
                    return "You have already used " + this.equipmentName;
                }
            }
            else{
                return "You do not have " + this.equipmentName;
            }

        }
        else{
            GameObject target = gamestate.getMap().getCurrentRoom().getObjectByName(super.value);
            if (gamestate.getPlayer().hasEquipment(this.equipmentName)){
                if (!gamestate.getPlayer().getEquipment(this.equipmentName).getUseInformation().isUsed()){
                    if (target != null){
                        if (target.getId().equals(gamestate.getPlayer().getEquipment(this.equipmentName).getUseInformation().getTarget())){
                            gamestate.getPlayer().addScore(20);
                            System.out.println("Score gained: +20");
                            return gamestate.getPlayer().getEquipment(this.equipmentName).use(target, gamestate);
                        }
                        else{
                            return "Invalid use target.";
                        }
                    }
                    else{
                        return "Invalid use target.";
                    }
                }
                else{
                    return "You have already used " + this.equipmentName;
                }
            }
            else{
                return "You do not have " + this.equipmentName;
            }
        }
    }

    @Override
    public String toString(){
        return equipmentName + " on " + super.value;
    }
}
