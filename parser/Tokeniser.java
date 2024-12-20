package org.uob.a2.parser;

import java.util.ArrayList;

/**
 * The {@code Tokeniser} class is responsible for converting a string input into a list of tokens
 * that can be parsed into commands by the game.
 * 
 * <p>
 * The tokeniser identifies keywords, variables, and special symbols, assigning each a {@code TokenType}.
 * </p>
 */
public class Tokeniser {
    private ArrayList<Token> tokens;

    public Tokeniser(){
        this.tokens = new ArrayList<Token>();
    }

    public ArrayList<Token> getTokens(){
        return this.tokens;
    }

    public void resetTokens(){
        tokens.clear();
    }

    public String sanitise(String s){
        return s.trim().toLowerCase();
    }

    public void tokenise(String s){
        s = this.sanitise(s);
        String[] words = s.split("\\s+");
        for (int i=0; i<words.length; i++){
            switch (words[i]){
                case "use":
                    this.tokens.add(new Token(TokenType.USE, words[i]));
                    break;
                case "warp":
                    this.tokens.add(new Token(TokenType.WARP, words[i]));
                    break;
                case "combine":
                    this.tokens.add(new Token(TokenType.COMBINE, words[i]));
                    break;
                case "get":
                    this.tokens.add(new Token(TokenType.GET, words[i]));
                    break;
                case "drop":
                    this.tokens.add(new Token(TokenType.DROP, words[i]));
                    break;
                case "look":
                    this.tokens.add(new Token(TokenType.LOOK, words[i]));
                    break;
                case "status":
                    this.tokens.add(new Token(TokenType.STATUS, words[i]));
                    break;
                case "help":
                    this.tokens.add(new Token(TokenType.HELP, words[i]));
                    break;
                case "quit":
                    this.tokens.add(new Token(TokenType.QUIT, words[i]));
                    break;
                case "move":
                    this.tokens.add(new Token(TokenType.MOVE, words[i]));
                    break;
                case "on":
                case "with":
                case "using":
                    this.tokens.add(new Token(TokenType.PREPOSITION, words[i]));
                    break;
                default:
                    this.tokens.add(new Token(TokenType.VAR, words[i]));
                    break;
                /*case "knife":
                case "key":
                case "lava_ring":
                case "strength_ring":
                case "chest":
                case "lever":
                case "drake":
                case "lava":
                case "door":
                    this.tokens.add(new Token(TokenType.VAR, words[i]));
                    break;
                default:
                    this.tokens.add(new Token(TokenType.ERROR));
                    break;*/
            }
        }
        this.tokens.add(new Token(TokenType.EOL));
    }
}
