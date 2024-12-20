package org.uob.a2.parser;

import java.util.ArrayList;

import org.uob.a2.commands.*;

/**
 * The {@code Parser} class processes a list of tokens and converts them into {@code Command} objects
 * that can be executed by the game.
 * 
 * <p>
 * The parser identifies the type of command from the tokens and creates the appropriate command object.
 * If the command is invalid or incomplete, a {@code CommandErrorException} is thrown.
 * </p>
 */
public class Parser {

    public Parser(){}

    public Command parse(ArrayList<Token> tokens) throws CommandErrorException{  
        try{
            switch (tokens.get(0).getTokenType()){
                case USE:
                    Command use = new Use(tokens.get(1).getValue(),tokens.get(3).getValue());
                    use.commandType = CommandType.USE;
                    return use;
                case WARP:
                    Command warp = new Warp(tokens.get(1).getValue());
                    warp.commandType = CommandType.WARP;
                    return warp;
                case COMBINE:
                    Command combine = new Combine(tokens.get(1).getValue(),tokens.get(3).getValue());
                    combine.commandType = CommandType.COMBINE;
                    return combine;
                case GET:
                    Command get = new Get(tokens.get(1).getValue());
                    get.commandType = CommandType.GET;
                    return get;
                case DROP:
                    Command drop = new Drop(tokens.get(1).getValue());
                    drop.commandType = CommandType.DROP;
                    return drop;
                case LOOK:
                    Command look = new Look(tokens.get(1).getValue());
                    look.commandType = CommandType.LOOK;
                    return look;
                case STATUS:
                    Command status = new Status(tokens.get(1).getValue());
                    status.commandType = CommandType.STATUS;
                    return status;
                case HELP:
                    Command help = new Help(tokens.get(1).getValue());
                    help.commandType = CommandType.HELP;
                    return help;
                case QUIT:
                    Command quit = new Quit();
                    quit.commandType = CommandType.QUIT;
                    return quit;
                case MOVE:
                    Command move = new Move(tokens.get(1).getValue());
                    move.commandType = CommandType.MOVE;
                    return move;
                default:
                    throw new CommandErrorException("Invalid Command");
                }
        }
        catch(Exception e){
            throw new CommandErrorException("Invalid Command");
        }
    }
}
