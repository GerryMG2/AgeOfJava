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
public class factory {

    public static Edificacion Edificar(TipoRaza raza, TipoEdificacion edi) {
        switch (raza) {
            case Constructor:

                break;
            case Tanque:
                break;
            case Atacante:
                break;
        }
    }

    public static Edificacion Edificar(TipoRaza raza, TipoEdificacion edi, Materiales material) {
        switch (raza) {
            case Constructor:

                break;
            case Tanque:
                break;
            case Atacante:
                break;
        }
    }

    public static Vehiculo ConstruirVehiculo(TipoRaza raza, TipoVehiculo vehi, Materiales mat) {
        Vehiculo vehiculo = null;
        switch (raza) {
            case Constructor:
                switch (vehi) {
                    case liviano:
                        vehiculo = new Vehiculo(mat,1,250,50);
                        
                        break;
                    case camion:
                        vehiculo = new Vehiculo(mat,2,350,150);
                        break;

                }
                break;
            case Tanque:
                switch (vehi) {
                    case liviano:
                        vehiculo = new Vehiculo(mat,2,350,50);
                        break;
                    case camion:
                        vehiculo = new Vehiculo(mat,2,550,100);
                        break;

                }
                break;
            case Atacante:
                switch (vehi) {
                    case liviano:

                        break;
                    case camion:
                        break;

                }
                break;
        }
        return vehiculo;
    }

    public static Milicia Entrenar(TipoRaza raza) {
        Milicia ml = null;
        switch (raza) {
            case Constructor:
                ml = new Milicia(40, 200, raza, Territorio.Amigo);
                break;
            case Tanque:
                ml = new Milicia(35, 200, raza, Territorio.Amigo);
                break;
            case Atacante:
                ml = new Milicia(50, 200, raza, Territorio.Amigo);
                break;
        }

        return ml;

    }

    public static CentroDeMando getCentro(TipoRaza raza, String password) {
        CentroDeMando aux = null;
        //aqui hacer cambios por tipo de raza
        switch (raza) {
            case Constructor:
                aux = new CentroDeMando(password, 2000, 2000, 2000, 1000, raza);
                break;
            case Tanque:
                aux = new CentroDeMando(password, 2000, 2000, 2000, 1000, raza);
                break;
            case Atacante:
                aux = new CentroDeMando(password, 2000, 2000, 2000, 1000, raza);
                break;
        }
        return aux;
    }

}
