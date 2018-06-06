/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

/**
 *
 * @author gerar
 */
public class Vehiculo {
    public Materiales mat;
    public int TiempoEspera;
    public int vida;
    public int fasetomake;
    public int cantidadMateriales;
    public Vehiculo(Materiales mat, int TiempoEspera, int vida,int materiales) {
        this.mat = mat;
        this.TiempoEspera = TiempoEspera;
        this.vida = vida;
        this.cantidadMateriales = materiales;
    }
    
    public void makeOperations(CentroDeMando cm){
        
        switch(mat){
            case oro:
                cm.oro += cantidadMateriales;
                break;
            case combustible:
                cm.combustible += cantidadMateriales;
                break;
            case metal:
                cm.metal += cantidadMateriales;
                break;
        }
        fasetomake += TiempoEspera;
    }
    
    public void getDamage(int ata){
        vida -= ata;
    }
}
