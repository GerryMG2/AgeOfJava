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
public class Edificacion {

    public String name;
    public int vida;
    public int costo[];
    public int tiempoFabricacion;
    public TipoEdificacion tipo;
    public Materiales material;
    public TipoVehiculo vehiculo;
    public TipoRaza raza;
    public int cantidadMateriales;
    public int vidatotal;
    public int faseToMake;
    ArrayList<OrdenesConstr> fase;
    

    public Edificacion(int oro, int gas, int metal, int tiempoFabricacion, int vida, Materiales material, TipoEdificacion tipo, TipoRaza raza, int material2, String name, TipoVehiculo tip) {
        this.vida = vida;
        fase = new ArrayList<>();
        this.vidatotal = vida;
        this.costo = new int[3];
        this.costo[0] = oro;
        this.costo[1] = gas;
        this.costo[2] = metal;
        this.tiempoFabricacion = tiempoFabricacion;
        this.material = material;
        this.raza = raza;
        this.tipo = tipo;
        this.cantidadMateriales = material2;
        this.name = name;
    }

    public void makeProcessMoney(CentroDeMando cm, String name, int cant, Materiales mat) {
        int aux = 0;
        switch (this.tipo) {
            case Vehicular2:
                aux = 0;
                for (OrdenesConstr or : fase) {
                    if (or.fase > Juego.fase) {
                        aux += or.cantidad;
                    }
                }
                if (cm.vehiculos2.size() + cant + aux <= 10) {
                    if (cm.oro >= this.costo[0] && cm.combustible >= this.costo[1] && cm.metal >= this.costo[3]) {
                        cm.oro -= this.costo[0];
                        cm.combustible -= this.costo[1];
                        cm.metal -= this.costo[2];
                        this.fase.add(new OrdenesConstr( cant,null,TipoVehiculo.camion,mat,Juego.fase + this.tiempoFabricacion,name));
                    } else {
                        System.out.println("No tienes suficientes recursos");
                    }
                } else {
                    System.out.println("No puedes tener mas de 10 elementos");
                }
                break;
            case Vehicular:
                aux = 0;
                for (OrdenesConstr or : fase) {
                    if (or.fase > Juego.fase) {
                        aux += or.cantidad;
                    }
                }
                if (cm.vehiculos.size() + cant + aux <= 10) {
                    if (cm.oro >= this.costo[0] && cm.combustible >= this.costo[1] && cm.metal >= this.costo[3]) {
                        cm.oro -= this.costo[0];
                        cm.combustible -= this.costo[1];
                        cm.metal -= this.costo[2];
                        this.fase.add(new OrdenesConstr(cant,null,TipoVehiculo.liviano,mat,Juego.fase + this.tiempoFabricacion,name));
                    } else {
                        System.out.println("No tienes suficientes recursos");
                    }
                } else {
                    System.out.println("No puedes tener mas de 10 elementos");
                }
                break;
            case Entrenadora:
                aux = 0;
                for (OrdenesConstr or : fase) {
                    if (or.fase > Juego.fase) {
                        aux += or.cantidad;
                    }
                }
                if (cm.milicias.size() + cant + aux <= 10) {
                    if (cm.oro >= this.costo[0] && cm.combustible >= this.costo[1] && cm.metal >= this.costo[3]) {
                        cm.oro -= this.costo[0];
                        cm.combustible -= this.costo[1];
                        cm.metal -= this.costo[2];
                        this.fase.add(new OrdenesConstr(Juego.fase + this.tiempoFabricacion, cant));
                    } else {
                        System.out.println("No tienes suficientes recursos");
                    }
                } else {
                    System.out.println("No puedes tener mas de 10 elementos");
                }

                break;
        }
    }

    public void makeProcess(CentroDeMando cm) {
        switch (this.material) {
            case oro:
                if(cm.oro + cantidadMateriales <= cm.totaloro ){
                    cm.oro += cantidadMateriales;
                }else{
                    cm.oro = cm.totaloro;
                }
                
                break;
            case combustible:
                if(cm.combustible + cantidadMateriales <= cm.totalcombustible ){
                    cm.combustible += cantidadMateriales;
                }else{
                    cm.combustible = cm.totalcombustible;
                }
                
                break;
            case metal:
                if(cm.metal + cantidadMateriales <= cm.totalmetal ){
                    cm.metal += cantidadMateriales;
                }else{
                    cm.metal = cm.totalmetal;
                }
                
               
                break;
        }
        faseToMake += tiempoFabricacion;
    }

    public void makeProcess(OrdenesConstr orden,CentroDeMando cm) {
        switch(tipo){
            case Vehicular2:
                cm.vehiculos2.add(factory.ConstruirVehiculo(raza, orden.vehiculo, orden.mat, orden.name));
                break;
                case Vehicular:
                cm.vehiculos.add(factory.ConstruirVehiculo(raza, orden.vehiculo, orden.mat, orden.name));
                break;
                case Entrenadora:
                cm.milicias.add(factory.Entrenar(raza, name));
                break;
        }
    }

    public void getDamage(int ata) {
        vida -= ata;
    }

    public String VidaShow() {
        return vida + "/" + vidatotal;
    }
}
