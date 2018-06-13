/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import Utilities.Reader;
import java.util.Random;

/**
 *
 * @author gerar
 */
public class Juego {

    public static int fase;
    CentroDeMando jugador1;
    CentroDeMando jugador2;
    private static Juego MiJuego = null;

    public void config() {
        String Pass1 = null;
        String Pass2 = null;
        TipoRaza tip1 = null;
        TipoRaza tip2 = null;
        int verify;
        while (true) {
            try {
                System.out.print("Ingrese una contraseña para el juegador 1: ");
                Pass1 = Reader.consola.next();
                System.out.print("Ingrese su raza, jugador 1, segun el numero: 1. Constructor 2.Tanque 3. Soldado: ");
                switch (Reader.consola.nextInt()) {
                    case 1:
                        tip1 = TipoRaza.Constructor;
                        break;
                    case 2:
                        tip1 = TipoRaza.Tanque;
                        break;
                    case 3:
                        tip1 = TipoRaza.Atacante;
                        break;

                }
                System.out.print("Ingrese una contraseña para el juegador 2: ");
                Pass2 = Reader.consola.next();
                System.out.print("Ingrese su raza, jugador 2, segun el numero: 1. Constructor 2.Tanque 3. Soldado: ");
                switch (Reader.consola.nextInt()) {
                    case 1:
                        tip2 = TipoRaza.Constructor;
                        break;
                    case 2:
                        tip2 = TipoRaza.Tanque;
                        break;
                    case 3:
                        tip2 = TipoRaza.Atacante;
                        break;

                }
                verify = 1;
            } catch (Exception error) {
                verify = 0;
            }
            if (verify == 1) {
                jugador1 = factory.getCentro(tip1, Pass1);
                jugador2 = factory.getCentro(tip2, Pass2);
                break;
            }

        }

    }

    public static Juego ini() {

        if (MiJuego == null) {
            MiJuego = new Juego();
        }
        return MiJuego;
    }

    private Juego() {
        this.config();

    }

    public void start() {
        fase = 1;

    }

    public void Turno(CentroDeMando cm1, CentroDeMando cm2, int fase) {
        while (!this.Matchpassword(cm1)) {
            //nada
        }
        this.VerifyConst(cm1);
        this.VerifyAtack(cm1, cm2, fase);
        this.Menu(cm1);
        int opcion;
        opcion = Reader.consola.nextInt();

    }

    public void VerifyAtack(CentroDeMando cm1, CentroDeMando cm2, int fase) {
        for (Milicia ml : cm1.milicias) {
            if (ml.fasetomake == fase) {
                switch (ml.atacando[0]) {
                    case 0:
                        ml.makeOperations(cm1, cm2);
                        break;
                    case 1:
                        int aux = 0;
                        boolean kill = false;
                        for (Edificacion edi : cm2.construccionesEntrendoras) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                if (edi.vida <= 0) {
                                    ml.estado = MiliciaEstado.esperando;
                                    kill = true;
                                }

                                break;
                            }
                            aux++;
                        }
                        if (kill) {
                            cm2.construccionesEntrendoras.remove(aux);
                        }

                        break;
                    case 2:
                        aux = 0;
                        kill = false;
                        for (Edificacion edi : cm2.construccionesVehiculos) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                if (edi.vida <= 0) {
                                    ml.estado = MiliciaEstado.esperando;
                                    kill = true;
                                }

                                break;
                            }
                            aux++;
                        }
                        if (kill) {
                            cm2.construccionesVehiculos.remove(aux);
                        }
                        break;
                    case 3:
                        aux = 0;
                        kill = false;
                        for (Edificacion edi : cm2.construccionesVehiculos2) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                if (edi.vida <= 0) {
                                    ml.estado = MiliciaEstado.esperando;
                                    kill = true;
                                }

                                break;
                            }
                            aux++;
                        }
                        if (kill) {
                            cm2.construccionesVehiculos2.remove(aux);
                        }
                        break;
                    case 4:
                        aux = 0;
                        kill = false;
                        for (Edificacion edi : cm2.construccionesRecolectora1) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                if (edi.vida <= 0) {
                                    ml.estado = MiliciaEstado.esperando;
                                    kill = true;
                                }

                                break;
                            }
                            aux++;
                        }
                        if (kill) {
                            cm2.construccionesRecolectora1.remove(aux);
                        }
                        break;
                    case 5:
                        aux = 0;
                        kill = false;
                        for (Edificacion edi : cm2.construccionesRecolectora2) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                if (edi.vida <= 0) {
                                    ml.estado = MiliciaEstado.esperando;
                                    kill = true;
                                }

                                break;
                            }
                            aux++;
                        }
                        if (kill) {
                            cm2.construccionesRecolectora2.remove(aux);
                        }
                        break;
                    case 6:
                        aux = 0;
                        kill = false;
                        for (Edificacion edi : cm2.construccionesRecolectora3) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                if (edi.vida <= 0) {
                                    ml.estado = MiliciaEstado.esperando;
                                    kill = true;
                                }

                                break;
                            }
                            aux++;
                        }
                        if (kill) {
                            cm2.construccionesRecolectora3.remove(aux);
                        }
                        break;
                    case 7:
                        aux = 0;
                        kill = false;
                        for (Vehiculo edi : cm2.vehiculos) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                if (edi.vida <= 0) {
                                    ml.estado = MiliciaEstado.esperando;
                                    kill = true;
                                }

                                break;
                            }
                            aux++;
                        }
                        if (kill) {
                            cm2.vehiculos.remove(aux);
                        }
                        break;
                    case 8:
                        aux = 0;
                        kill = false;
                        for (Vehiculo edi : cm2.vehiculos2) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                if (edi.vida <= 0) {
                                    ml.estado = MiliciaEstado.esperando;
                                    kill = true;
                                }

                                break;
                            }
                            aux++;
                        }
                        if (kill) {
                            cm2.vehiculos2.remove(aux);
                        }
                        break;
                    case 9:
                        aux = 0;
                        kill = false;
                        for (Milicia edi : cm2.milicias) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                if (edi.vida <= 0) {
                                    ml.estado = MiliciaEstado.esperando;
                                    kill = true;
                                }

                                break;
                            }
                            aux++;
                        }
                        if (kill) {
                            cm2.milicias.remove(aux);
                        }
                        break;
                }
            }
        }
    }

    public boolean Matchpassword(CentroDeMando cm) {
        System.out.println("Ingrese su contrasennia:");
        String pass = Reader.consola.next();
        return pass.equals(cm.getPass());

    }

    public void ReStart() {

    }

    public void VerifyConst(CentroDeMando cm) {
        for (OrdenesConstr or : cm.constrEntre) {
            if (Juego.fase == or.fase) {
                cm.constr(or);
            }
        }
        for (OrdenesConstr or : cm.constrVehi) {
            if (Juego.fase == or.fase) {
                cm.constr(or);
            }
        }
        for (OrdenesConstr or : cm.constrVehi2) {
            if (Juego.fase == or.fase) {
                cm.constr(or);
            }
        }
        for (OrdenesConstr or : cm.constrRe1) {
            if (Juego.fase == or.fase) {
                cm.constr(or);
            }
        }
        for (OrdenesConstr or : cm.constrRe2) {
            if (Juego.fase == or.fase) {
                cm.constr(or);
            }
        }
        for (OrdenesConstr or : cm.constrRe3) {
            if (Juego.fase == or.fase) {
                cm.constr(or);
            }
        }
        //edificaciones
        for (Edificacion edi : cm.construccionesEntrendoras) {
            if (edi.tipo != TipoEdificacion.Recolectora) {
                for (OrdenesConstr or : edi.fase) {
                    if (Juego.fase == or.fase) {
                        edi.makeProcess(or, cm);
                    }
                }
            } else {
                if (edi.faseToMake == Juego.fase) {
                    edi.makeProcess(cm);
                }
            }
        }

        for (Edificacion edi : cm.construccionesVehiculos) {
            if (edi.tipo != TipoEdificacion.Recolectora) {
                for (OrdenesConstr or : edi.fase) {
                    if (Juego.fase == or.fase) {
                        edi.makeProcess(or, cm);
                    }
                }
            } else {
                if (edi.faseToMake == Juego.fase) {
                    edi.makeProcess(cm);
                }
            }
        }

        for (Edificacion edi : cm.construccionesVehiculos2) {
            if (edi.tipo != TipoEdificacion.Recolectora) {
                for (OrdenesConstr or : edi.fase) {
                    if (Juego.fase == or.fase) {
                        edi.makeProcess(or, cm);
                    }
                }
            } else {
                if (edi.faseToMake == Juego.fase) {
                    edi.makeProcess(cm);
                }
            }
        }
        for (Edificacion edi : cm.construccionesRecolectora1) {
            if (edi.tipo != TipoEdificacion.Recolectora) {
                for (OrdenesConstr or : edi.fase) {
                    if (Juego.fase == or.fase) {
                        edi.makeProcess(or, cm);
                    }
                }
            } else {
                if (edi.faseToMake == Juego.fase) {
                    edi.makeProcess(cm);
                }
            }
        }
        for (Edificacion edi : cm.construccionesRecolectora2) {
            if (edi.tipo != TipoEdificacion.Recolectora) {
                for (OrdenesConstr or : edi.fase) {
                    if (Juego.fase == or.fase) {
                        edi.makeProcess(or, cm);
                    }
                }
            } else {
                if (edi.faseToMake == Juego.fase) {
                    edi.makeProcess(cm);
                }
            }
        }
        for (Edificacion edi : cm.construccionesRecolectora3) {
            if (edi.tipo != TipoEdificacion.Recolectora) {
                for (OrdenesConstr or : edi.fase) {
                    if (Juego.fase == or.fase) {
                        edi.makeProcess(or, cm);
                    }
                }
            } else {
                if (edi.faseToMake == Juego.fase) {
                    edi.makeProcess(cm);
                }
            }
        }

    }

    public boolean isLive(CentroDeMando cm) {
        if (cm.vida <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public void Menu(CentroDeMando cm) {
        System.out.println("Centro De Mando: " + cm.VidaShow());
        cm.getMaterials();
        System.out.println("1.Elementos(Vehiculos, milicias,edificaciones)"
                + "\n2.Atacar 3.Defender 4.Construir 5.Mejorar");
    }

    public void subMenu1_1(int opcion, CentroDeMando cm, CentroDeMando cm2, int fase) {
        int elec = 0;
        switch (opcion) {
            case 1:
                this.subMenu1(cm);
                elec = Reader.consola.nextInt();
                switch (elec) {
                    case 1:
                        System.out.println("Vehiculos Livianos");
                        for (Vehiculo vehi : cm.vehiculos) {
                            System.out.println(vehi.name + " :" + vehi.VidaShow());
                        }
                        System.out.println("Vehiculos Camiones");
                        for (Vehiculo vehi : cm.vehiculos2) {
                            System.out.println(vehi.name + " :" + vehi.VidaShow());
                        }
                        break;
                    case 2:
                        System.out.println("Milicias: ");
                        for (Milicia ml : cm.milicias) {
                            System.out.println(ml.name + " " + ml.VidaShow());
                        }
                        break;
                    case 3:
                        System.out.println("1.Entrenadoras 2.Vehicular1 3.Vehicular2 4.Recolectora1 5.Recolectora2 6.Recolectora3");
                        int aux = Reader.consola.nextInt();
                        switch (aux) {
                            case 1:
                                for(Edificacion edi: cm.construccionesEntrendoras){
                                    System.out.println(edi.name +" " + edi.VidaShow());
                                }
                                break;
                            case 2:
                                for(Edificacion edi: cm.construccionesVehiculos){
                                    System.out.println(edi.name +" " + edi.VidaShow());
                                }
                                break;
                            case 3:
                                for(Edificacion edi: cm.construccionesVehiculos2){
                                    System.out.println(edi.name +" " + edi.VidaShow());
                                }
                                break;
                            case 4:
                                for(Edificacion edi: cm.construccionesRecolectora1){
                                    System.out.println(edi.name +" " + edi.VidaShow());
                                }
                                break;
                            case 5:
                                for(Edificacion edi: cm.construccionesRecolectora2){
                                    System.out.println(edi.name +" " + edi.VidaShow());
                                }
                                break;
                            case 6:
                                for(Edificacion edi: cm.construccionesRecolectora3){
                                    System.out.println(edi.name +" " + edi.VidaShow());
                                }
                                break;

                        }
                }
                break;
            case 2:
                this.subMenu2(cm);
                elec = Reader.consola.nextInt();
                
                break;
            case 3:
                
                break;
            case 4:

                break;
        }
    }

    public void subMenu1(CentroDeMando cm) {
        System.out.println("1.Vehiculos 2.Milicias 3. Edificaciones");
    }

    public void subMenu2(CentroDeMando cm1) {
        for (Milicia ml : cm1.milicias) {
            System.out.println(ml.name + " " + ml.VidaShow() + " " + ml.estado + " " + ml.territorio);
        }
    }

    public void subMenu3(CentroDeMando cm, CentroDeMando cm2) {
        int aux = 0;
        for (Milicia ml : cm2.milicias) {
            if (ml.estado == MiliciaEstado.ataque) {
                try {
                    switch (ml.atacando[0]) {
                        case 1:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.construccionesEntrendoras.get(ml.atacando[1]).name + " Base Entrenadora" + " con vida " + cm.construccionesEntrendoras.get(ml.atacando[1]).VidaShow());
                            aux++;
                            break;
                        case 2:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.construccionesVehiculos.get(ml.atacando[1]).name + " Base Constructora de Vehiculos tipo liviano" + " con vida " + cm.construccionesVehiculos.get(ml.atacando[1]).VidaShow());
                            aux++;
                            break;
                        case 3:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.construccionesVehiculos2.get(ml.atacando[1]).name + " Base Constructora de Vehiculos tipo camion" + " con vida " + cm.construccionesVehiculos2.get(ml.atacando[1]).VidaShow());
                            aux++;
                            break;
                        case 4:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.construccionesRecolectora1.get(ml.atacando[1]).name + " Base Recolectora de material 1" + " con vida " + cm.construccionesRecolectora1.get(ml.atacando[1]).VidaShow());
                            aux++;
                            break;
                        case 5:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.construccionesRecolectora2.get(ml.atacando[1]).name + " Base Recolectora de material 2" + " con vida " + cm.construccionesRecolectora2.get(ml.atacando[1]).VidaShow());
                            aux++;
                            break;
                        case 6:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.construccionesRecolectora3.get(ml.atacando[1]).name + " Base Recolectora de material 3" + " con vida " + cm.construccionesRecolectora3.get(ml.atacando[1]).VidaShow());
                            aux++;
                            break;
                        case 7:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.vehiculos.get(ml.atacando[1]).name + " Vehiculo liviano" + " con vida " + cm.vehiculos.get(ml.atacando[1]).VidaShow());
                            aux++;
                            break;
                        case 8:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.vehiculos2.get(ml.atacando[1]).name + " Vehiculo tipo camion" + " con vida " + cm.vehiculos2.get(ml.atacando[1]).VidaShow());
                            aux++;
                            break;
                        case 9:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.milicias.get(ml.atacando[1]).name + " Milicia" + " con vida " + cm.milicias.get(ml.atacando[1]).VidaShow());
                            aux++;
                            break;
                    }
                } catch (Exception error2) {

                }

            }
        }
    }

    public void subMenu4(CentroDeMando cm) {
        System.out.println("1.Con el centro de mano(Edificaciones Recolectoras, Entrenadoras y de Vehiculos)");
        System.out.println("Ten en cuenta que si te destruyen la edificacion donde mandas a construir el objeto no se construira");
        if (!cm.construccionesEntrendoras.isEmpty()) {
            System.out.println("2.Con Edificacion Entrenadora");

        }

        if (!cm.construccionesVehiculos.isEmpty()) {
            System.out.println("3. Con Edificacion Vehicular tipo liviano");
        }

        if (!cm.construccionesVehiculos2.isEmpty()) {
            System.out.println("4. Con Edificacion Vehicular tipo camion");
        }
    }

    public void subMenu5(CentroDeMando cm) {
        cm.getMaterials();
        int gasto = (int) (0.25 * (cm.totaloro + cm.totalcombustible + cm.totalmetal)) / 3;
        System.out.println("Costo: " + gasto + " de cada Material");
    }
}
