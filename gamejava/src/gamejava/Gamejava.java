/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamejava;

import GameElements.Juego;

/**
 *
 * @author gerar
 */
public class Gamejava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Juego game = Juego.ini();
        game.start();
        
    }
    
}
