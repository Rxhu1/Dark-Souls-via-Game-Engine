package org.uob.a2.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.uob.a2.gameobjects.*;

/**
 * Utility class for parsing a game state from a file.
 * 
 * <p>
 * This class reads a structured text file to create a {@code GameState} object,
 * including the player, map, rooms, items, equipment, features, and exits.
 * </p>
 */
public class GameStateFileParser {

    public GameStateFileParser(){}

    public static GameState parse(String filename){
        try{
            //InputStream input = new BufferedInputStream(file.newInputStream(filename));
            //BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            /*File file = new File(filename);
            Scanner reader = new Scanner(file);
            
            String line = reader.nextLine();
            line = line.trim();
            String[] colon = line.split(":");
            String[] comma = colon[1].split(",");
            Player player = new Player(comma[0].trim());

            line = reader.nextLine();
            line = line.trim();
            colon = line.split(":");
            comma = colon[1].split(",");
            Map map = new Map();
            map.setCurrentRoom(comma[0].trim());

            line = reader.nextLine();
            line = line.trim();
            colon = line.split(":");
            comma = colon[1].split(",");*/

            FileReader fileReader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fileReader);

            //buffReader.ready();
            String line = reader.readLine();
            line = line.trim();
            String[] colon = line.split(":");
            String[] comma = colon[1].split(",");
            Player player = new Player(comma[0].trim());

            line = reader.readLine();
            line = line.trim();
            colon = line.split(":");
            comma = colon[1].split(",");
            Map map = new Map();
            map.setCurrentRoom(comma[0].trim());

            line = reader.readLine();
            line = line.trim();
            colon = line.split(":");
            comma = colon[1].split(",");

            //intialise everything
            while(reader.ready()){
                if (colon[0].equals("room")){
                    String roomId = comma[0].trim();
                    String roomName = comma[1].trim();
                    String roomDescription = comma[2].trim();
                    String roomHidden = comma[3].trim();
                    Room room = new Room(roomId, roomName, roomDescription, Boolean.valueOf(roomHidden));
                    //rooms.add(room);
                    map.addRoom(room);

                    line = reader.readLine();
                    line = line.trim();
                    colon = line.split(":");
                    comma = colon[1].split(",");
                    while (!colon[0].equals("room") && reader.ready()){
                        switch(colon[0]){
                            case("item"):
                                String itemId = comma[0].trim();
                                String itemName = comma[1].trim();
                                String itemDescription = comma[2].trim();
                                String itemHidden = comma[3].trim();
                                Item item = new Item(itemId, itemName, itemDescription, Boolean.valueOf(itemHidden));
                                room.addItem(item);
                                /*System.out.println(itemId);
                                System.out.println(room.getItem(itemId).getId());
                                if (map.getCurrentRoom().getItem("item1").getId() == item.getId()){
                                    System.out.println("awuyddwyu");
                                }
                                System.out.println(map.getCurrentRoom().getItem("item1").getName());*/
                                break;
                            case("equipment"):
                                String eqId = comma[0].trim();
                                String eqName = comma[1].trim();
                                String eqDescription = comma[2].trim();
                                String eqHidden = comma[3].trim();
                                String eqAction = comma[4].trim();
                                String eqTarget = comma[5].trim();
                                String eqResult = comma[6].trim();
                                String eqMessage = comma[7].trim();
                                UseInformation useInfo = new UseInformation(false, eqAction, eqTarget, eqResult, eqMessage);
                                Equipment eq = new Equipment(eqId, eqName, eqDescription, Boolean.valueOf(eqHidden), useInfo);
                                room.addEquipment(eq);
                                break;
                            case("container"):
                                String conId = comma[0].trim();
                                String conName = comma[1].trim();
                                String conDescription = comma[2].trim();
                                String conHidden = comma[3].trim();
                                Container con = new Container(conId, conName, conDescription, Boolean.valueOf(conHidden));
                                room.addFeature(con);
                                break;
                            case("exit"):
                                String exitId = comma[0].trim();
                                String exitName = comma[1].trim();
                                String exitDescription = comma[2].trim();
                                String exitNextRoom = comma[3].trim();
                                String exitHidden = comma[4].trim();
                                Exit exit = new Exit(exitId, exitName, exitDescription, exitNextRoom, Boolean.valueOf(exitHidden));
                                room.addExit(exit);
                                break;
                        }
                        line = reader.readLine();
                        line = line.trim();
                        colon = line.split(":");
                        comma = colon[1].split(",");
                    }
                    if (!reader.ready()){
                        switch(colon[0]){
                            case("item"):
                                String itemId = comma[0].trim();
                                String itemName = comma[1].trim();
                                String itemDescription = comma[2].trim();
                                String itemHidden = comma[3].trim();
                                Item item = new Item(itemId, itemName, itemDescription, Boolean.valueOf(itemHidden));
                                room.addItem(item);
                                /*System.out.println(itemId);
                                System.out.println(room.getItem(itemId).getId());
                                if (map.getCurrentRoom().getItem("item1").getId() == item.getId()){
                                    System.out.println("awuyddwyu");
                                }
                                System.out.println(map.getCurrentRoom().getItem("item1").getName());*/
                                break;
                            case("equipment"):
                                String eqId = comma[0].trim();
                                String eqName = comma[1].trim();
                                String eqDescription = comma[2].trim();
                                String eqHidden = comma[3].trim();
                                String eqAction = comma[4].trim();
                                String eqTarget = comma[5].trim();
                                String eqResult = comma[6].trim();
                                String eqMessage = comma[7].trim();
                                UseInformation useInfo = new UseInformation(false, eqAction, eqTarget, eqResult, eqMessage);
                                Equipment eq = new Equipment(eqId, eqName, eqDescription, Boolean.valueOf(eqHidden), useInfo);
                                room.addEquipment(eq);
                                break;
                            case("container"):
                                String conId = comma[0].trim();
                                String conName = comma[1].trim();
                                String conDescription = comma[2].trim();
                                String conHidden = comma[3].trim();
                                Container con = new Container(conId, conName, conDescription, Boolean.valueOf(conHidden));
                                room.addFeature(con);
                                break;
                            case("exit"):
                                String exitId = comma[0].trim();
                                String exitName = comma[1].trim();
                                String exitDescription = comma[2].trim();
                                String exitNextRoom = comma[3].trim();
                                String exitHidden = comma[4].trim();
                                Exit exit = new Exit(exitId, exitName, exitDescription, exitNextRoom, Boolean.valueOf(exitHidden));
                                room.addExit(exit);
                                break;
                        }
                    }
                }
            }
            GameState gameState = new GameState(map,player);
            reader.close();
            return gameState;
        }
        catch (Exception e){
            Map map = new Map();
            Player player = new Player("");
            GameState gameState = new GameState(map,player);
            return gameState;
        }
    }
}
