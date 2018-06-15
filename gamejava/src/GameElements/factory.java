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

    public static Edificacion Edificar(TipoRaza raza, TipoEdificacion edi, Materiales material, String name, TipoVehiculo tip) {
        Edificacion edif = null;
        switch (raza) {
            case Constructor:
                switch (edi) {
                    case Entrenadora:
                        edif = new Edificacion(100, 50, 50, 2, 200, material, edi, raza, 0, name, tip);

                        break;
                    case Recolectora:
                        edif = new Edificacion(0, 0, 0, 1, 150, material, edi, raza, 50, name, tip);
                        edif.faseToMake = Juego.fase + edif.tiempoFabricacion;
                        break;
                    case Vehicular:
                        edif = new Edificacion(50, 50, 50, 2, 250, material, edi, raza, 0, name, tip);
                        break;
                    case Vehicular2:
                        edif = new Edificacion(50, 50, 50, 2, 300, material, edi, raza, 0, name, tip);
                        break;
                }
                break;
            case Tanque:
                switch (edi) {
                    case Entrenadora:
                        edif = new Edificacion(50, 50, 50, 2, 300, material, edi, raza, 0, name, tip);
                        break;
                    case Recolectora:
                        edif = new Edificacion(50, 50, 50, 2, 150, material, edi, raza, 0, name, tip);
                        edif.faseToMake = Juego.fase + edif.tiempoFabricacion;
                        break;
                    case Vehicular:
                        edif = new Edificacion(50, 50, 50, 2, 500, material, edi, raza, 0, name, tip);
                        break;
                    case Vehicular2:
                        edif = new Edificacion(50, 50, 50, 2, 500, material, edi, raza, 0, name, tip);
                        break;
                }
                break;
            case Atacante:
                switch (edi) {
                    case Entrenadora:
                        edif = new Edificacion(50, 50, 50, 2, 150, material, edi, raza, 0, name, tip);
                        break;
                    case Recolectora:
                        edif = new Edificacion(50, 50, 50, 2, 200, material, edi, raza, 0, name, tip);
                        edif.faseToMake = Juego.fase + edif.tiempoFabricacion;
                        break;
                    case Vehicular:
                        edif = new Edificacion(50, 50, 50, 2, 200, material, edi, raza, 0, name, tip);
                        break;
                    case Vehicular2:
                        edif = new Edificacion(50, 50, 50, 2, 200, material, edi, raza, 0, name, tip);
                        break;
                }
                break;
        }
        return edif;
    }

    public static Vehiculo ConstruirVehiculo(TipoRaza raza, TipoVehiculo vehi, Materiales mat, String name) {
        Vehiculo vehiculo = null;
        switch (raza) {
            case Constructor:
                switch (vehi) {
                    case liviano:
                        vehiculo = new Vehiculo(mat, 1, 250, 50, name);

                        break;
                    case camion:
                        vehiculo = new Vehiculo(mat, 2, 350, 150, name);
                        break;

                }
                break;
            case Tanque:
                switch (vehi) {
                    case liviano:
                        vehiculo = new Vehiculo(mat, 2, 350, 50, name);
                        break;
                    case camion:
                        vehiculo = new Vehiculo(mat, 2, 550, 100, name);
                        break;

                }
                break;
            case Atacante:
                switch (vehi) {
                    case liviano:
                        vehiculo = new Vehiculo(mat, 2, 350, 50, name);
                        break;
                    case camion:
                        vehiculo = new Vehiculo(mat, 2, 350, 50, name);
                        break;

                }
                break;
        }
        return vehiculo;
    }

    public static Milicia Entrenar(TipoRaza raza, String name) {
        Milicia ml = null;
        switch (raza) {
            case Constructor:
                ml = new Milicia(40, 200, raza, Territorio.Amigo, 2, name);
                ml.costoSentAndReturn = new int[3];
                ml.costoSentAndReturn[0] = 200;
                ml.costoSentAndReturn[1] = 200;
                ml.costoSentAndReturn[2] = 0;
                ml.estado = MiliciaEstado.esperando;
                break;
            case Tanque:
                ml = new Milicia(35, 200, raza, Territorio.Amigo, 2, name);
                ml.costoSentAndReturn = new int[3];
                ml.costoSentAndReturn[0] = 200;
                ml.costoSentAndReturn[1] = 100;
                ml.costoSentAndReturn[2] = 0;
                ml.estado = MiliciaEstado.esperando;
                break;
            case Atacante:
                ml = new Milicia(50, 200, raza, Territorio.Amigo, 1, name);
                ml.costoSentAndReturn = new int[3];
                ml.costoSentAndReturn[0] = 100;
                ml.costoSentAndReturn[1] = 100;
                ml.costoSentAndReturn[2] = 20;
                ml.estado = MiliciaEstado.esperando;
                break;
        }

        return ml;

    }

    public static CentroDeMando getCentro(TipoRaza raza, String password) {
        CentroDeMando aux = null;
        //aqui hacer cambios por tipo de raza
        switch (raza) {
            case Constructor:
                aux = new CentroDeMando(password, 800, 800, 800, 1000, raza);
                aux.costoConsEntre = new int[4];
                aux.costoConsEntre[0] = 100;
                aux.costoConsEntre[1] = 100;
                aux.costoConsEntre[2] = 110;
                aux.costoConsEntre[3] = 2;
                aux.costoConsRe1 = new int[4];
                aux.costoConsRe1[0] = 100;
                aux.costoConsRe1[1] = 100;
                aux.costoConsRe1[2] = 0;
                aux.costoConsRe1[3] = 2;
                aux.costoConstVehi = new int[4];
                aux.costoConstVehi[0] = 100;
                aux.costoConstVehi[1] = 100;
                aux.costoConstVehi[2] = 150;
                aux.costoConstVehi[3] = 3;
                aux.costoConsRe2 = new int[4];
                aux.costoConsRe2[0] = 0;
                aux.costoConsRe2[1] = 100;
                aux.costoConsRe2[2] = 150;
                aux.costoConsRe2[3] = 2;
                aux.costoConsRe3 = new int[4];
                aux.costoConsRe3[0] = 0;
                aux.costoConsRe3[1] = 100;
                aux.costoConsRe3[2] = 150;
                aux.costoConsRe3[3] = 2;
                aux.costoConstVehi2 = new int[4];
                aux.costoConstVehi2[0] = 200;
                aux.costoConstVehi2[1] = 100;
                aux.costoConstVehi2[2] = 150;
                aux.costoConstVehi2[3] = 3;
                break;
            case Tanque:
                aux = new CentroDeMando(password, 800, 800, 800, 1000, raza);
                aux.costoConsEntre = new int[4];
                aux.costoConsEntre[0] = 100;
                aux.costoConsEntre[1] = 100;
                aux.costoConsEntre[2] = 110;
                aux.costoConsEntre[3] = 3;
                aux.costoConsRe1 = new int[4];
                aux.costoConsRe1[0] = 100;
                aux.costoConsRe1[1] = 100;
                aux.costoConsRe1[2] = 0;
                aux.costoConsRe1[3] = 2;
                aux.costoConstVehi = new int[4];
                aux.costoConstVehi[0] = 100;
                aux.costoConstVehi[1] = 100;
                aux.costoConstVehi[2] = 150;
                aux.costoConstVehi[3] = 2;
                aux.costoConsRe2 = new int[4];
                aux.costoConsRe2[0] = 0;
                aux.costoConsRe2[1] = 100;
                aux.costoConsRe2[2] = 150;
                aux.costoConsRe2[3] = 1;
                aux.costoConsRe3 = new int[4];
                aux.costoConsRe3[0] = 0;
                aux.costoConsRe3[1] = 100;
                aux.costoConsRe3[2] = 150;
                aux.costoConsRe3[3] = 2;
                aux.costoConstVehi2 = new int[4];
                aux.costoConstVehi2[0] = 200;
                aux.costoConstVehi2[1] = 100;
                aux.costoConstVehi2[2] = 150;
                aux.costoConstVehi2[3] = 3;
                break;
            case Atacante:
                aux = new CentroDeMando(password, 800, 800, 800, 1000, raza);
                aux.costoConsEntre = new int[4];
                aux.costoConsEntre[0] = 100;
                aux.costoConsEntre[1] = 100;
                aux.costoConsEntre[2] = 110;
                aux.costoConsEntre[3] = 2;
                aux.costoConsRe1 = new int[4];
                aux.costoConsRe1[0] = 100;
                aux.costoConsRe1[1] = 100;
                aux.costoConsRe1[2] = 0;
                aux.costoConsRe1[3] = 2;
                aux.costoConstVehi = new int[4];
                aux.costoConstVehi[0] = 100;
                aux.costoConstVehi[1] = 100;
                aux.costoConstVehi[2] = 150;
                aux.costoConstVehi[3] = 3;
                aux.costoConsRe2 = new int[4];
                aux.costoConsRe2[0] = 0;
                aux.costoConsRe2[1] = 100;
                aux.costoConsRe2[2] = 150;
                aux.costoConsRe2[3] = 2;
                aux.costoConsRe3 = new int[4];
                aux.costoConsRe3[0] = 0;
                aux.costoConsRe3[1] = 100;
                aux.costoConsRe3[2] = 150;
                aux.costoConsRe3[3] = 1;
                aux.costoConstVehi2 = new int[4];
                aux.costoConstVehi2[0] = 200;
                aux.costoConstVehi2[1] = 100;
                aux.costoConstVehi2[2] = 150;
                aux.costoConstVehi2[3] = 3;
                break;
        }
        return aux;
    }

}
