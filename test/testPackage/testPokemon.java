/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPackage;

import dexbot.Pokemon;
/**
 *
 * @author colek
 */
public class testPokemon {
    public static void main(String[] args) {
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 001, false);
        if(bulbasaur.getHP()!=1) {
            System.out.println("Bulbasaurs HP is wrong: "+bulbasaur.getHP());
        }
        if(bulbasaur.getAttack()!=2) {
            System.out.println("Bulbasaurs Attack is wrong: "+bulbasaur.getAttack());
        }
        if(bulbasaur.getDefense()!=3) {
            System.out.println("Bulbasaurs Defense is wrong: "+bulbasaur.getDefense());
        }
        if(bulbasaur.getSPAttack()!=4) {
            System.out.println("Bulbasaurs SPAttack is wrong: "+bulbasaur.getSPAttack());
        }
        if(bulbasaur.getSPDefense()!=5) {
            System.out.println("Bulbasaurs SPDefense is wrong: "+bulbasaur.getSPDefense());
        }
        if(bulbasaur.getSpeed()!=6) {
            System.out.println("Bulbasaurs Speed is wrong: "+bulbasaur.getSpeed());
        }
    }
}
