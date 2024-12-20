package org.uob.a2.gameobjects;

public class Chest extends GameObject {

    public Chest(String id, String name, String description, boolean hidden){
        super(id, name, description, hidden);
    }

    public String getName(){
        return super.name;
    }
}