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
public class OrdenesConstr {
    int fase;
    int cantidad;
    String name;
    TipoEdificacion edi;
    TipoVehiculo vehiculo;
    Materiales mat;

    public OrdenesConstr(int cantidad, TipoEdificacion edi, TipoVehiculo vehiculo,Materiales mat,int fase, String name) {
        this.cantidad = cantidad;
        this.edi = edi;
        this.vehiculo = vehiculo;
        this.mat = mat;
        this.name = name;
        this.fase = fase;
    }
    public OrdenesConstr(int fase, int cantidad,TipoEdificacion edi,String name) {
        this.fase = fase;
        this.cantidad = cantidad;
        this.edi = edi;
        this.name = name;
    }
    public OrdenesConstr(int fase, int cantidad,TipoEdificacion edi,TipoVehiculo vehiculo,String name) {
        this.fase = fase;
        this.cantidad = cantidad;
        this.edi = edi;
        this.vehiculo = vehiculo;
        this.name = name;
    }
    public OrdenesConstr(int fase, int cantidad,TipoEdificacion edi,Materiales mat,String name) {
        this.fase = fase;
        this.cantidad = cantidad;
        this.edi = edi;
        this.mat = mat;
        this.name = name;
    }
    public OrdenesConstr(int fase, int cantidad, String name) {
        this.fase = fase;
        this.cantidad = cantidad;
        this.name = name;
        
    }
    
    
}
