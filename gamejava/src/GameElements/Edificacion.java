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
public class Edificacion {

    public int vida;
    public int costo[];
    public int tiempoFabricacion;
    public TipoEdificacion tipo;
    public Materiales material;
    int fase;

    public Edificacion(int oro, int gas, int metal, int tiempoFabricacion, int vida, Materiales material, TipoEdificacion tipo) {
        this.vida = vida;
        this.costo = new int[3];
        this.costo[0] = oro;
        this.costo[1] = gas;
        this.costo[2] = metal;
        this.tiempoFabricacion = tiempoFabricacion;
        this.material = material;
        this.tipo = tipo;
    }
    
    public void getDamage(int ata){
        vida -= ata;
    }

}
