package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

public class Warp extends Command {

    public Warp(String locationId){
        super.value = locationId;
    }

    @Override
    public String execute(GameState gameState){
        if (gameState.getPlayer().hasEquipment("ruby")){
            if (gameState.getPlayer().getEquipment("ruby").getUseInformation().isUsed()){
                gameState.getMap().setCurrentRoom(super.value);
                String name = gameState.getMap().getCurrentRoom().getName();
                gameState.getPlayer().minusScore(40);
                System.out.println("Score lost: -40");
                return "You have warped to " + name;
            }
            else{
                return "You have not used the ruby yet! You cannot warp.";
            }
        }
        else{
            return "You do not have the ruby. You cannot warp!";
        }
    }
}
