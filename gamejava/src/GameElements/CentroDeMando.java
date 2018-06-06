/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import java.util.ArrayList;

/**
 *
 * @author gerar
 */
public class CentroDeMando {
    private String password;
    public int oro;
    public int combustible;
    public int metal;
    public int vida;
    public TipoRaza type;
    public int costoConsEntre[];
    public int costoConstVehi[];
    public int costoConsRe1[];
    public int costoConsRe2[];
    public int costoConsRe3[];
    ArrayList<Edificacion> construccionesEntrendoras;
    ArrayList<Edificacion> construccionesVehiculos;
    ArrayList<Edificacion> construccionesRecolectora1;
    ArrayList<Edificacion> construccionesRecolectora2;
    ArrayList<Edificacion> construccionesRecolectora3;
    ArrayList<Vehiculo> vehiculos;
    ArrayList<Milicia> milicias;

    public CentroDeMando(String password, int oro, int combustible, int metal, int vida, TipoRaza type) {
        this.password = password;
        this.oro = oro;
        this.combustible = combustible;
        this.metal = metal;
        this.vida = vida;
        this.type = type;
        construccionesEntrendoras = new ArrayList<>();
        construccionesVehiculos = new ArrayList<>();
        construccionesRecolectora1 = new ArrayList<>();
        construccionesRecolectora2 = new ArrayList<>();
        construccionesRecolectora3 = new ArrayList<>();
        vehiculos = new ArrayList<>();
        milicias = new ArrayList<>();
    }
    
    public void getDamage(int ata){
        vida -= ata;
    }

    
     
}
