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
public class Milicia {
    public int ataque;
    public int vida;
    public TipoRaza tipo;
    public Territorio territorio;
    public int tiempoEspera;
    int fasetomake;
    int costoSentAndReturn[];

    /**
     *
     * @param ataque
     * @param vida
     * @param tipo
     * @param terri
     */
    public Milicia(int ataque, int vida, TipoRaza tipo,Territorio terri) {
        this.ataque = ataque;
        this.vida = vida;
        this.tipo = tipo;
        this.territorio = terri;
    }
    public Milicia(){
        
    }
    
    public void makeOperations(CentroDeMando cm,Milicia ml){
        if(Juego.rn.nextInt(10) + 1 < 5)
        {
            ml.getDamage((this.ataque * 0.8));
            
                    
        }
        else
        {
            if(Juego.rn.nextInt(10) + 1 < 5)
            {
                ml.getDamage((this.ataque * 0.9));
                
            }
            else
                ml.getDamage(this.ataque);
        }
        
    }
    
    public Milicia returnme(){
        return this;
    }
    
    public int Damage(){
        return ataque; 
    }
    public void getDamage(int ata){
        vida -= ata;
    }
}
