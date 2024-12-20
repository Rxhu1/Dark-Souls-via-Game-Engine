package org.uob.a2.gameobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.nio.file.*;

import org.uob.a2.utils.*;

/**
 * Represents the game map, which consists of a collection of rooms and the current room the player is in.
 * 
 * <p>
 * The map allows for navigation between rooms, adding new rooms, and managing the current room context.
 * </p>
 */
public class Map {
    private HashMap<String, Room> map;
    private ArrayList<Room> rooms;
    private String currRoomId;
    private char[][] lordran;


    public Map(){
        this.map = new HashMap<String, Room>();
        this.rooms = new ArrayList<Room>();
        this.lordran = new char[4][4];
        /*Room empty = new Room();
        for (int i=0; i<7; i++){
            for (int j=0; j<7; j++){
                this.map.put("" + i + j, empty);
            }
        }*/
    }

    public Room getCurrentRoom(){
        return this.map.get(this.currRoomId);
    }

    public void addRoom(Room room){
        this.rooms.add(room);
        this.map.put(room.id, room);
    }

    public void setCurrentRoom(String roomId){
        this.currRoomId = roomId;
    }

    public String display(GameState gameState){
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('#')){this.lordran[0][0] = '#';}else{this.lordran[0][0] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('#')){this.lordran[1][0] = '#';}else{this.lordran[1][0] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('B')){this.lordran[2][0] = 'B';}else{this.lordran[2][0] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('L')){this.lordran[3][0] = 'L';}else{this.lordran[3][0] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('V')){this.lordran[0][1] = 'V';}else{this.lordran[0][1] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('#')){this.lordran[1][1] = '#';}else{this.lordran[1][1] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('U')){this.lordran[2][1] = 'U';}else{this.lordran[2][1] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('#')){this.lordran[3][1] = '#';}else{this.lordran[3][1] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('C')){this.lordran[0][2] = 'C';}else{this.lordran[0][2] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('F')){this.lordran[1][2] = 'F';}else{this.lordran[1][2] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('S')){this.lordran[2][2] = 'S';}else{this.lordran[2][2] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('A')){this.lordran[3][2] = 'A';}else{this.lordran[3][2] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('#')){this.lordran[0][3] = '#';}else{this.lordran[0][3] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('D')){this.lordran[1][3] = 'D';}else{this.lordran[1][3] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('N')){this.lordran[2][3] = 'N';}else{this.lordran[2][3] = '^';}
        if (gameState.getMap().getCurrentRoom().getName().charAt(0) != ('#')){this.lordran[3][3] = '#';}else{this.lordran[3][3] = '^';}
        

        String mapLayout = "";
        for (int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                mapLayout += this.lordran[j][i] + " ";
            }
            if (i == 3){break;}
            mapLayout += "\n";
        }
        return mapLayout;
    }

    /**
     * Returns a string representation of the map, including all rooms.
     *
     * @return a string describing the map and its rooms
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Map:\n");
        for (Room r : this.rooms) {
            out.append(r.toString()).append("\n");
        }
        return out.toString();
    }
}

