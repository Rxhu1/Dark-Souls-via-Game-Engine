package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

public class Combine extends Command{
    private String item1;
    private String item2;

    public Combine(String item1, String item2){
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public String execute(GameState gameState){
        if ((this.item1.equals("keytop") || this.item1.equals("keybot")) && (this.item2.equals("keytop") || this.item2.equals("keybot"))){
            UseInformation greenKeyUseInfo = new UseInformation(false,"open","greendoor","s4","You opened the door! A new entrance has opened creating a path east!");
            Equipment greenKey = new Equipment("greenkey","greenkey","A green key. Could be used in the fortress...",false, greenKeyUseInfo);
            gameState.getPlayer().addEquipment(greenKey);
            gameState.getPlayer().getInventory().remove(gameState.getPlayer().getItem("keytop"));
            gameState.getPlayer().getInventory().remove(gameState.getPlayer().getItem("keybot"));
            System.out.println("Score gained: +20");
            gameState.getPlayer().addScore(20);
            return "You have combine these two items to make a green key!";
        }
        else{
            return "You cannot combine these two items!";
        }
    }
}
