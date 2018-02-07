/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dexbot;

import java.io.*;
import java.nio.charset.Charset;
/**
 *
 * @author colek
 */
public class Pokemon {
    private static String pokemonNames[] = new String[806];
    private String name;
    private int pokedexNum;
    private boolean caught;
    private int hp;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;
    
    public Pokemon(int pokedexNum)throws IllegalArgumentException{
        if(pokedexNum<1||pokedexNum>(pokemonNames.length-1)) {
            throw new IllegalArgumentException("Not a real pokemon dex num");
        }
        this.name=pokemonNames[pokedexNum-1];
        this.pokedexNum=pokedexNum;
        caught=false;
        setStats();
    }
    
    public Pokemon(String name)throws IllegalArgumentException{
        this.name=name;
        if(findPokemonDexNum(name)<0) {
            throw new IllegalArgumentException("That pokemon name isn't a real pokemon name");
        }
        this.pokedexNum=findPokemonDexNum(name);
        caught=false;
        setStats();
    }
    
    public Pokemon(String name, int pokedexNum, boolean caught) {
        this.name=name;
        this.pokedexNum=pokedexNum;
        this.caught=caught;
        setStats();
    }
    /**
     * Tries to find a pokemons dex number based on the name
     * @param name the pokemons name, case is ignored
     * @return returns the dex number, or 0 if it couldn't find that pokemon
     */
    private int findPokemonDexNum(String name) {
        for(int i=0;i<pokemonNames.length;i++) {
            if(name.equalsIgnoreCase(pokemonNames[i])) {
                return i+1;
            }
        }
        return 0;
    }
    
    private void setStats() {
        String currentLine ="";
        try {
            currentLine = fileReader("..\\..\\\\pokemonData\\pokemonStats.txt");
        } catch (IOException e1) {
            System.out.println(e1);
        }
        System.out.println(currentLine);
        if(currentLine.contains("D".concat(String.format("%03d", pokedexNum)))) {
            int i=1;
            hp=Integer.parseInt(currentLine.substring(((4*i)+1),((4*i))+4));
            i++;
            attack=Integer.parseInt(currentLine.substring(((4*i)+1),((4*i))+4));
            i++;
            defense=Integer.parseInt(currentLine.substring(((4*i)+1),((4*i))+4));
            i++;
            spAttack=Integer.parseInt(currentLine.substring(((4*i)+1),((4*i))+4));
            i++;
            spDefense=Integer.parseInt(currentLine.substring(((4*i)+1),((4*i))+4));
            i++;
            speed=Integer.parseInt(currentLine.substring(((4*i)+1),((4*i))+4));
        }
    }
    
    public int getHP() {
        return hp;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
    public int getSPAttack() {
        return spAttack;
    }
    public int getSPDefense() {
        return spDefense;
    }
    public int getSpeed() {
        return speed;
    }

    /**
     *
     * @param file
     * @param cs
     * @return 
     * @throws IOException
     */
    private  String fileReader(String file) throws IOException {
        // No real need to close the BufferedReader/InputStreamReader
        // as they're only wrapping the stream
        FileInputStream stream = new FileInputStream("C:\\Users\\colek\\Desktop\\NetbeansProjects\\DexBot\\pokemonData\\pokemonStats.txt");
        System.out.println("Starting FIS");
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, "US-ASCII"));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[29];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            // Potential issue here: if this throws an IOException,
            // it will mask any others. Normally I'd use a utility
            // method which would log exceptions and swallow them
            stream.close();
        }        
    }
}
