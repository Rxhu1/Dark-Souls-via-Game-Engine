package org.uob.a2.gameobjects;

import java.util.ArrayList;

/**
 * Represents a room in the game, which is a type of {@code GameObject}.
 * 
 * <p>
 * Rooms can have items, equipment, features, and exits. They also manage navigation
 * and interactions within the game world.
 * </p>
 */
public class Room extends GameObject {
    private ArrayList<Exit> exits;
    private ArrayList<Item> items;
    private ArrayList<Feature> features;
    private ArrayList<Equipment> equipments;
    private ArrayList<GameObject> gameObjects;
    
    public Room(String id, String name, String description, boolean hidden){
        super(id, name, description, hidden);
        this.exits = new ArrayList<Exit>();
        this.items = new ArrayList<Item>();
        this.features = new ArrayList<Feature>();
        this.equipments = new ArrayList<Equipment>();
        this.gameObjects = new ArrayList<GameObject>();
    }
    
    public Room(){}

    public void setName(String name){
        super.name = name;
    }

    public void setDescription(String description){
        super.description = description;
    }

    public String getName(){
        return super.name;
    }

    public String getDescription(){
        return super.description;
    }

    public ArrayList<Exit> getExits(){
        return this.exits;
    }

    public void addExit(Exit exit){
        this.exits.add(exit);
        this.gameObjects.add(exit);
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    public Item getItem(String id){
        for (Item i: this.items){
            if (i.getId().equals(id)){
                return i;
            }
        }
        return null;
    }

    public Item getItemByName(String name){
        for (Item i: this.items){
            if (i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }

    public Feature getFeatureByName(String name){
        for (Feature f: this.features){
            if (f.getName().equals(name)){
                return f;
            }
        }
        return null;
    }

    public ArrayList<Equipment> getEquipments(){
        return this.equipments;
    }

    public Equipment getEquipmentByName(String name){
        for (Equipment eq: this.equipments){
            if (eq.getName().equals(name)){
                return eq;
            }
        }
        return null;
    }

    public Equipment getEquipment(String id){
        for (Equipment eq: this.equipments){
            if (eq.getId().equals(id)){
                return eq;
            }
        }
        return null;
    }

    public Exit getExit(String id){
        for (Exit ex: this.exits){
            if (ex.getId().equals(id)){
                return ex;
            }
        }
        return null;
    }

    public Exit getExitByName(String name){
        for (Exit ex: this.exits){
            if (ex.getName().equals(name)){
                return ex;
            }
        }
        return null;
    }

    public void addEquipment(Equipment equipment){
        this.equipments.add(equipment);
        this.gameObjects.add(equipment);
    }

    public Feature getFeature(String id){
        for (Feature f: this.features){
            if (f.getId().equals(id)){
                return f;
            }
        }
        return null;
    }

    public void addItem(Item item){
        this.items.add(item);
        this.gameObjects.add(item);
    }

    public ArrayList<Feature> getFeatures(){
        return this.features;
    }

    public ArrayList<GameObject> getAll(){
        return this.gameObjects;
    }

    public GameObject getObjectByName(String name){
        for (GameObject o: gameObjects){
            if (o.getName().equals(name)){
                return o;
            }
        }
        return null;
    }

    public boolean hasGameObject(String objectName){
        if (this.getObjectByName(objectName) == null){
            return false;
        }
        return true;
    }

    public void addFeature(Feature feature){
        this.features.add(feature);
        this.gameObjects.add(feature);
    }

    public boolean hasItem(String itemName){
        if (this.getItemByName(itemName) == null){
            return false;
        }
        return true;
    }

    public boolean hasEquipment(String name){
        if (this.getEquipmentByName(name) == null){
            return false;
        }
        return true;
    }

    public boolean hasFeature(String name){
        if (getFeatureByName(name) == null){
            return false;
        }
        return true;
    }

    /**
     * Returns a string representation of the room, including its contents and description.
     *
     * @return a string describing the room
     */
    @Override
    public String toString() {
        String out = "[" + id + "] Room: " + name + "\nDescription: " + description + "\nIn the room there is: ";
        for (Item i : this.items) {
            out += i + "\n";
        }
        for (Equipment e : this.equipments) {
            out += e + "\n";
        }
        for (Feature f : this.features) {
            out += f + "\n";
        }
        for (Exit e : this.exits) {
            out += e + "\n";
        }
        return out + "\n";
    }
}
