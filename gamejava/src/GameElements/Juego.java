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
        while (this.isLive(jugador1) && this.isLive(jugador2)) {
            System.out.println("#####################################################");
            System.out.println("Es tu turno jugador 1");
            this.Turno(jugador1, jugador2, fase);
            System.out.println("#####################################################");
            System.out.println("Es tu turno jugador 2");
            this.Turno(jugador2, jugador1, fase);
            fase++;
        }
        if (this.isLive(jugador1)) {
            System.out.println("Has Ganado jugador 1");
        } else {
            System.out.println("Has Ganado jugador 2");
        }

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
        while (opcion != 6) {
            System.out.println("------------------------------------");
            this.subMenu1_1(opcion, cm1, cm2, fase);
            System.out.println("------------------------------------");
            this.Menu(cm1);
            opcion = Reader.consola.nextInt();
        }

    }

    public void VerifyAtack(CentroDeMando cm1, CentroDeMando cm2, int fase) {
        for (Milicia ml : cm1.milicias) {
            if (ml.fasetomake == fase) {
                switch (ml.atacando[0]) {
                    case 0:
                        if (this.onlyCentre(cm2)) {
                            ml.makeOperations(cm1, cm2);
                            ml.estado = MiliciaEstado.ataque;
                            ml.fasetomake = Juego.fase + 1;
                        } else {
                            ml.estado = MiliciaEstado.esperando;
                        }

                        break;
                    case 1:
                        int aux = 0;
                        boolean kill = false;
                        for (Edificacion edi : cm2.construccionesEntrendoras) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                ml.estado = MiliciaEstado.ataque;
                                ml.territorio = Territorio.Enemigo;
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

                            ml.fasetomake = 0;
                            if (this.onlyCentre(cm2)) {
                                cm2.JustCentro = true;
                            }
                        } else {
                            ml.fasetomake = Juego.fase + 1;
                        }

                        break;
                    case 2:
                        aux = 0;
                        kill = false;
                        for (Edificacion edi : cm2.construccionesVehiculos) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                ml.estado = MiliciaEstado.ataque;
                                ml.territorio = Territorio.Enemigo;
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
                            ml.fasetomake = 0;
                            if (this.onlyCentre(cm2)) {
                                cm2.JustCentro = true;
                            }
                        } else {
                            ml.fasetomake = Juego.fase + 1;
                        }
                        break;
                    case 3:
                        aux = 0;
                        kill = false;
                        for (Edificacion edi : cm2.construccionesVehiculos2) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                ml.estado = MiliciaEstado.ataque;
                                ml.territorio = Territorio.Enemigo;
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
                            ml.fasetomake = 0;
                            if (this.onlyCentre(cm2)) {
                                cm2.JustCentro = true;
                            }
                        } else {
                            ml.fasetomake = Juego.fase + 1;
                        }
                        break;
                    case 4:
                        aux = 0;
                        kill = false;
                        for (Edificacion edi : cm2.construccionesRecolectora1) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                ml.estado = MiliciaEstado.ataque;
                                ml.territorio = Territorio.Enemigo;
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
                            ml.fasetomake = 0;
                            if (this.onlyCentre(cm2)) {
                                cm2.JustCentro = true;
                            }
                        } else {
                            ml.fasetomake = Juego.fase + 1;
                        }
                        break;
                    case 5:
                        aux = 0;
                        kill = false;
                        for (Edificacion edi : cm2.construccionesRecolectora2) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                ml.estado = MiliciaEstado.ataque;
                                ml.territorio = Territorio.Enemigo;
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
                            ml.fasetomake = 0;
                            if (this.onlyCentre(cm2)) {
                                cm2.JustCentro = true;
                            }
                        } else {
                            ml.fasetomake = Juego.fase + 1;
                        }
                        break;
                    case 6:
                        aux = 0;
                        kill = false;
                        for (Edificacion edi : cm2.construccionesRecolectora3) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                ml.estado = MiliciaEstado.ataque;
                                ml.territorio = Territorio.Enemigo;
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
                            ml.fasetomake = 0;
                            if (this.onlyCentre(cm2)) {
                                cm2.JustCentro = true;
                            }
                        } else {
                            ml.fasetomake = Juego.fase + 1;
                        }
                        break;
                    case 7:
                        aux = 0;
                        kill = false;
                        for (Vehiculo edi : cm2.vehiculos) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                ml.estado = MiliciaEstado.ataque;
                                ml.territorio = Territorio.Enemigo;
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
                            ml.fasetomake = 0;
                            if (this.onlyCentre(cm2)) {
                                cm2.JustCentro = true;
                            }
                        } else {
                            ml.fasetomake = Juego.fase + 1;
                        }
                        break;
                    case 8:
                        aux = 0;
                        kill = false;
                        for (Vehiculo edi : cm2.vehiculos2) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                ml.estado = MiliciaEstado.ataque;
                                ml.territorio = Territorio.Enemigo;
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
                            ml.fasetomake = 0;
                            if (this.onlyCentre(cm2)) {
                                cm2.JustCentro = true;
                            }
                        } else {
                            ml.fasetomake = Juego.fase + 1;
                        }
                        break;
                    case 9:
                        aux = 0;
                        kill = false;
                        for (Milicia edi : cm2.milicias) {
                            if (edi.hashCode() == ml.atacando[1]) {
                                ml.makeOperations(cm1, edi);
                                ml.estado = MiliciaEstado.ataque;
                                if (edi.territorio == Territorio.Enemigo) {
                                    ml.territorio = Territorio.Amigo;
                                } else {
                                    ml.territorio = Territorio.Enemigo;
                                }
                                if (edi.vida <= 0) {
                                    ml.estado = MiliciaEstado.esperando;
                                    kill = true;
                                    if (this.onlyCentre(cm2)) {
                                        cm2.JustCentro = true;
                                    }
                                }

                                break;
                            }
                            aux++;
                        }
                        if (kill) {
                            cm2.milicias.remove(aux);
                            ml.fasetomake = 0;
                            if (this.onlyCentre(cm2)) {
                                cm2.JustCentro = true;
                            }
                        } else {
                            ml.fasetomake = Juego.fase + 1;
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

    public boolean onlyCentre(CentroDeMando cm) {
        if (!cm.construccionesEntrendoras.isEmpty() || !cm.construccionesRecolectora1.isEmpty() || !cm.construccionesRecolectora2.isEmpty() || !cm.construccionesRecolectora3.isEmpty() || !cm.construccionesVehiculos.isEmpty() || !cm.construccionesVehiculos2.isEmpty() || !cm.milicias.isEmpty() || !cm.vehiculos.isEmpty() || !cm.vehiculos2.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void VerifyConst(CentroDeMando cm) {
        for (OrdenesConstr or : cm.constrEntre) {
            if (Juego.fase == or.fase) {
                cm.constr(or);
                cm.JustCentro = false;
            }
        }
        for (OrdenesConstr or : cm.constrVehi) {
            if (Juego.fase == or.fase) {
                cm.constr(or);
                cm.JustCentro = false;
            }
        }
        for (OrdenesConstr or : cm.constrVehi2) {
            if (Juego.fase == or.fase) {
                cm.constr(or);
                cm.JustCentro = false;
            }
        }
        for (OrdenesConstr or : cm.constrRe1) {
            if (Juego.fase == or.fase) {
                cm.constr(or);
                cm.JustCentro = false;
            }
        }
        for (OrdenesConstr or : cm.constrRe2) {
            if (Juego.fase == or.fase) {
                cm.constr(or);
                cm.JustCentro = false;
            }
        }
        for (OrdenesConstr or : cm.constrRe3) {
            if (Juego.fase == or.fase) {
                cm.constr(or);
                cm.JustCentro = false;
            }
        }
        //edificaciones
        for (Edificacion edi : cm.construccionesEntrendoras) {
            if (edi.tipo != TipoEdificacion.Recolectora) {
                for (OrdenesConstr or : edi.fase) {
                    if (Juego.fase == or.fase) {
                        edi.makeProcess(or, cm);
                        cm.JustCentro = false;
                    }
                }
            } else {
                if (edi.faseToMake == Juego.fase) {
                    edi.makeProcess(cm);
                    cm.JustCentro = false;
                }
            }
        }

        for (Edificacion edi : cm.construccionesVehiculos) {
            if (edi.tipo != TipoEdificacion.Recolectora) {
                for (OrdenesConstr or : edi.fase) {
                    if (Juego.fase == or.fase) {
                        edi.makeProcess(or, cm);
                        cm.JustCentro = false;
                    }
                }
            } else {
                if (edi.faseToMake == Juego.fase) {
                    edi.makeProcess(cm);
                    cm.JustCentro = false;
                }
            }
        }

        for (Edificacion edi : cm.construccionesVehiculos2) {
            System.out.println(edi.name);
            if (edi.tipo != TipoEdificacion.Recolectora) {
                for (OrdenesConstr or : edi.fase) {
                    if (Juego.fase == or.fase) {
                        edi.makeProcess(or, cm);
                        cm.JustCentro = false;
                    }
                }
            } else {
                if (edi.faseToMake == Juego.fase) {
                    edi.makeProcess(cm);
                    cm.JustCentro = false;
                }
            }
        }
        for (Edificacion edi : cm.construccionesRecolectora1) {
            if (edi.tipo != TipoEdificacion.Recolectora) {
                for (OrdenesConstr or : edi.fase) {
                    if (Juego.fase == or.fase) {
                        edi.makeProcess(or, cm);
                        cm.JustCentro = false;
                    }
                }
            } else {
                if (edi.faseToMake == Juego.fase) {
                    edi.makeProcess(cm);
                    cm.JustCentro = false;
                }
            }
        }
        for (Edificacion edi : cm.construccionesRecolectora2) {
            if (edi.tipo != TipoEdificacion.Recolectora) {
                for (OrdenesConstr or : edi.fase) {
                    if (Juego.fase == or.fase) {
                        edi.makeProcess(or, cm);
                        cm.JustCentro = false;
                    }
                }
            } else {
                if (edi.faseToMake == Juego.fase) {
                    edi.makeProcess(cm);
                    cm.JustCentro = false;
                }
            }
        }
        for (Edificacion edi : cm.construccionesRecolectora3) {
            if (edi.tipo != TipoEdificacion.Recolectora) {
                for (OrdenesConstr or : edi.fase) {
                    if (Juego.fase == or.fase) {
                        edi.makeProcess(or, cm);
                        cm.JustCentro = false;
                    }
                }
            } else {
                if (edi.faseToMake == Juego.fase) {
                    edi.makeProcess(cm);
                    cm.JustCentro = false;
                }
            }
        }

        for (Vehiculo vehi : cm.vehiculos) {
            if (vehi.fasetomake == Juego.fase) {
                vehi.makeOperations(cm);
                cm.JustCentro = false;
            }
        }
        for (Vehiculo vehi : cm.vehiculos2) {
            if (vehi.fasetomake == Juego.fase) {
                vehi.makeOperations(cm);
                cm.JustCentro = false;
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
                + " 2.Atacar y Defender 4.Construir 5.Mejorar 6.Terminar Turno");
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
                                for (Edificacion edi : cm.construccionesEntrendoras) {
                                    System.out.println(edi.name + " " + edi.VidaShow());
                                }
                                break;
                            case 2:
                                for (Edificacion edi : cm.construccionesVehiculos) {
                                    System.out.println(edi.name + " " + edi.VidaShow());
                                }
                                break;
                            case 3:
                                for (Edificacion edi : cm.construccionesVehiculos2) {
                                    System.out.println(edi.name + " " + edi.VidaShow());
                                }
                                break;
                            case 4:
                                for (Edificacion edi : cm.construccionesRecolectora1) {
                                    System.out.println(edi.name + " " + edi.VidaShow());
                                }
                                break;
                            case 5:
                                for (Edificacion edi : cm.construccionesRecolectora2) {
                                    System.out.println(edi.name + " " + edi.VidaShow());
                                }
                                break;
                            case 6:
                                for (Edificacion edi : cm.construccionesRecolectora3) {
                                    System.out.println(edi.name + " " + edi.VidaShow());
                                }
                                break;

                        }
                }
                break;
            case 2:
                System.out.println("Elige una Milicia");
                this.subMenu2(cm);
                elec = Reader.consola.nextInt();
                System.out.println("0.Centro de Mando 1.Entrenadora 2.Edi-Vehiculos-Tipo-Liviano 3.Edi-Vehiculos-Tipo-Camion 4.Edi-Recolectora-1 5.Edi-Recolectora-2 6.Edi-Recolectora-1 ");
                System.out.println("7.Vehiculos-livianos 8.Vehiculos-Camiones 9.Milicias");
                int elec2 = Reader.consola.nextInt();
                System.out.println("si esta vacio ingresa -1");
                if (elec2 == 0) {
                    cm.milicias.get(elec).atacando[0] = 0;
                    if (cm.milicias.get(elec).territorio == Territorio.Enemigo) {
                        cm.milicias.get(elec).fasetomake = Juego.fase + 1;

                    } else {
                        cm.milicias.get(elec).fasetomake = Juego.fase + cm.milicias.get(elec).tiempoEspera;

                    }
                } else {
                    if (elec2 != -1) {
                        try {
                            this.showForAtack(cm2, elec2);
                            int elec3 = Reader.consola.nextInt();
                            cm.milicias.get(elec).atacando[0] = elec2;

                            cm.milicias.get(elec).atacando[1] = this.showForAtack(cm2, elec2, elec3);
                            if (cm.milicias.get(elec).territorio == Territorio.Enemigo && this.showForAtackter(cm2, elec2, elec3) == Territorio.Amigo) {
                                cm.milicias.get(elec).fasetomake = Juego.fase + 1;
                            } else {
                                if (cm.milicias.get(elec).territorio == Territorio.Enemigo) {
                                    if (this.showForAtackter(cm2, elec2, elec3) == Territorio.Enemigo) {
                                        cm.milicias.get(elec).fasetomake = Juego.fase + cm.milicias.get(elec).tiempoEspera;
                                    }
                                } else {
                                    if (this.showForAtackter(cm2, elec2, elec3) == Territorio.Amigo) {
                                        cm.milicias.get(elec).fasetomake = Juego.fase + cm.milicias.get(elec).tiempoEspera;
                                    } else {
                                        cm.milicias.get(elec).fasetomake = Juego.fase + 1;
                                    }
                                }
                            }
                            System.out.println("Se ha mandado la orden de atacar");
                        } catch (Exception unerrorcito) {
                        }

                    }
                }
                break;
            case 3:
                this.subMenu3(cm2, cm);
                System.out.println("A cual desea atacar: ");
                int defensa = Reader.consola.nextInt();
                System.out.println("Con que Milicia quieres defender:(Si eliges una que este en territorio enemigo tardara mas)");
                this.subMenu2(cm);
                int ataquedefensa = Reader.consola.nextInt();
                if (cm.milicias.get(ataquedefensa - 1).territorio == Territorio.Amigo) {
                    cm.milicias.get(ataquedefensa - 1).atacando[0] = 9;
                    cm.milicias.get(ataquedefensa - 1).atacando[1] = this.showForAtack(cm2, 9, defensa);
                    cm.milicias.get(ataquedefensa - 1).fasetomake = Juego.fase + 1;
                } else {
                    if (cm.milicias.get(ataquedefensa - 1).territorio == Territorio.Enemigo) {
                        cm.milicias.get(ataquedefensa - 1).atacando[0] = 9;
                        cm.milicias.get(ataquedefensa - 1).atacando[1] = this.showForAtack(cm2, 9, defensa);
                        cm.milicias.get(ataquedefensa - 1).fasetomake = Juego.fase + cm.milicias.get(elec).tiempoEspera;
                    }
                }
                System.out.println("Se ha mandado la orden de defender.");
                break;
            case 4:
                cm.getMaterials();
                this.subMenu4(cm);
                int aux4 = Reader.consola.nextInt();
                switch (aux4) {
                    case 1:
                        System.out.println("1.Recolectora1 2.Recolectora2  3.Recolectora3 4.Vehiculo liviano 5. Vehiculo camion 6. Entrenadora");
                        aux4 = Reader.consola.nextInt();
                        switch (aux4) {
                            case 1:
                                System.out.println("Costo: material 1: " + cm.costoConsRe1[0] + " Material 2: " + cm.costoConsRe1[1] + " Material 3: " + cm.costoConsRe1[2]);
                                System.out.println("Ingresa 1 para comprar");
                                aux4 = 0;
                                aux4 = Reader.consola.nextInt();
                                if (aux4 == 1) {
                                    System.out.println("Ingresa un nombre para reconocer la construccion(Sin espacios): ");
                                    String auxS = Reader.consola.next();
                                    System.out.println("Ingresa la cantidad de objetos que quieres comprar: ");
                                    aux4 = Reader.consola.nextInt();
                                    cm.CreateOrders(TipoEdificacion.Recolectora, Materiales.oro, auxS, aux4);
                                }
                                break;
                            case 2:
                                System.out.println("Costo: material 1: " + cm.costoConsRe2[0] + " Material 2: " + cm.costoConsRe2[1] + " Material 3: " + cm.costoConsRe2[2]);
                                System.out.println("Ingresa 1 para comprar");
                                aux4 = 0;
                                aux4 = Reader.consola.nextInt();
                                if (aux4 == 1) {
                                    System.out.println("Ingresa un nombre para reconocer la construccion(Sin espacios): ");
                                    String auxS = Reader.consola.next();
                                    System.out.println("Ingresa la cantidad de objetos que quieres comprar: ");
                                    aux4 = Reader.consola.nextInt();
                                    cm.CreateOrders(TipoEdificacion.Recolectora, Materiales.combustible, auxS, aux4);
                                }
                                break;
                            case 3:
                                System.out.println("Costo: material 1: " + cm.costoConsRe3[0] + " Material 2: " + cm.costoConsRe3[1] + " Material 3: " + cm.costoConsRe3[2]);
                                System.out.println("Ingresa 1 para comprar");
                                aux4 = 0;
                                aux4 = Reader.consola.nextInt();
                                if (aux4 == 1) {
                                    System.out.println("Ingresa un nombre para reconocer la construccion(Sin espacios): ");
                                    String auxS = Reader.consola.next();
                                    System.out.println("Ingresa la cantidad de objetos que quieres comprar: ");
                                    aux4 = Reader.consola.nextInt();
                                    cm.CreateOrders(TipoEdificacion.Recolectora, Materiales.metal, auxS, aux4);
                                }
                                break;
                            case 4:
                                System.out.println("Costo: material 1: " + cm.costoConstVehi[0] + " Material 2: " + cm.costoConstVehi[1] + " Material 3: " + cm.costoConstVehi[2]);
                                System.out.println("Ingresa 1 para comprar");
                                aux4 = 0;
                                aux4 = Reader.consola.nextInt();
                                if (aux4 == 1) {
                                    System.out.println("Ingresa un nombre para reconocer la construccion(Sin espacios): ");
                                    String auxS = Reader.consola.next();
                                    System.out.println("Ingresa la cantidad de objetos que quieres comprar: ");
                                    aux4 = Reader.consola.nextInt();
                                    System.out.println("Ingrese el tipo de material(1,2 o 3): ");
                                    int materialaux = Reader.consola.nextInt();
                                    Materiales mataux = Materiales.oro;
                                    switch (materialaux) {
                                        case 1:
                                            mataux = Materiales.oro;
                                            break;
                                        case 2:
                                            mataux = Materiales.combustible;

                                            break;
                                        case 3:
                                            mataux = Materiales.metal;

                                            break;
                                    }
                                    cm.CreateOrders(TipoEdificacion.Vehicular, mataux, auxS, aux4);
                                }
                                break;
                            case 5:
                                System.out.println("Costo: material 1: " + cm.costoConstVehi2[0] + " Material 2: " + cm.costoConstVehi2[1] + " Material 3: " + cm.costoConstVehi2[2]);
                                System.out.println("Ingresa 1 para comprar");
                                aux4 = 0;
                                aux4 = Reader.consola.nextInt();
                                if (aux4 == 1) {
                                    System.out.println("Ingresa un nombre para reconocer la construccion(Sin espacios): ");
                                    String auxS = Reader.consola.next();
                                    System.out.println("Ingresa la cantidad de objetos que quieres comprar: ");
                                    aux4 = Reader.consola.nextInt();
                                    System.out.println("Ingrese el tipo de material(1,2 o 3): ");
                                    int materialaux = Reader.consola.nextInt();
                                    Materiales mataux = Materiales.oro;
                                    switch (materialaux) {
                                        case 1:
                                            mataux = Materiales.oro;
                                            break;
                                        case 2:
                                            mataux = Materiales.combustible;

                                            break;
                                        case 3:
                                            mataux = Materiales.metal;

                                            break;
                                    }
                                    cm.CreateOrders(TipoEdificacion.Vehicular2, mataux, auxS, aux4);
                                }
                                break;
                            case 6:
                                System.out.println("Costo: material 1: " + cm.costoConsEntre[0] + " Material 2: " + cm.costoConsEntre[1] + " Material 3: " + cm.costoConsEntre[2]);
                                System.out.println("Ingresa 1 para comprar");
                                aux4 = 0;
                                aux4 = Reader.consola.nextInt();
                                if (aux4 == 1) {
                                    System.out.println("Ingresa un nombre para reconocer la construccion(Sin espacios): ");
                                    String auxS = Reader.consola.next();
                                    System.out.println("Ingresa la cantidad de objetos que quieres comprar: ");
                                    aux4 = Reader.consola.nextInt();
                                    cm.CreateOrders(TipoEdificacion.Entrenadora, Materiales.metal, auxS, aux4);
                                }
                                break;
                        }
                        break;
                    case 2:
                        aux4 = 0;
                        for (Edificacion edi : cm.construccionesEntrendoras) {
                            System.out.println(aux4 + "." + edi.name + " vida: " + edi.VidaShow());
                        }
                        System.out.println("Ingresa la edificacion con la que quieres construir");
                        int ediconstru = Reader.consola.nextInt();
                        System.out.println("Costo: material 1: " + cm.construccionesEntrendoras.get(aux4).costo[0] + " Material 2: " + cm.construccionesEntrendoras.get(aux4).costo[1] + " Material 3: " + cm.construccionesEntrendoras.get(aux4).costo[2]);

                        System.out.println("Ingresa 1 para comprar");
                        aux4 = 0;
                        aux4 = Reader.consola.nextInt();
                        if (aux4 == 1) {
                            System.out.println("Ingresa un nombre para reconocer la construccion(Sin espacios): ");
                            String auxS = Reader.consola.next();
                            System.out.println("Ingresa la cantidad de objetos que quieres comprar: ");
                            aux4 = Reader.consola.nextInt();
                            cm.construccionesEntrendoras.get(ediconstru).makeProcessMoney(cm, auxS, aux4, Materiales.oro);
                        }
                        break;

                    case 3:
                        aux4 = 0;
                        for (Edificacion edi : cm.construccionesVehiculos) {
                            System.out.println(aux4 + "." + edi.name + " vida: " + edi.VidaShow());
                        }
                        System.out.println("Ingresa la edificacion con la que quieres construir");
                        ediconstru = Reader.consola.nextInt();
                        System.out.println("Costo: material 1: " + cm.construccionesVehiculos.get(aux4).costo[0] + " Material 2: " + cm.construccionesVehiculos.get(aux4).costo[1] + " Material 3: " + cm.construccionesVehiculos.get(aux4).costo[2]);

                        System.out.println("Ingresa 1 para comprar");
                        aux4 = 0;
                        aux4 = Reader.consola.nextInt();
                        if (aux4 == 1) {
                            System.out.println("Ingrese el tipo de material(1,2 o 3): ");
                            int materialaux = Reader.consola.nextInt();
                            Materiales mataux = Materiales.oro;
                            switch (materialaux) {
                                case 1:
                                    mataux = Materiales.oro;
                                    break;
                                case 2:
                                    mataux = Materiales.combustible;

                                    break;
                                case 3:
                                    mataux = Materiales.metal;

                                    break;
                            }
                            System.out.println("Ingresa un nombre para reconocer la construccion(Sin espacios): ");
                            String auxS = Reader.consola.next();
                            System.out.println("Ingresa la cantidad de objetos que quieres comprar: ");
                            aux4 = Reader.consola.nextInt();
                            cm.construccionesVehiculos.get(ediconstru).makeProcessMoney(cm, auxS, aux4, mataux);
                        }
                        break;
                    case 4:
                        aux4 = 0;
                        for (Edificacion edi : cm.construccionesVehiculos2) {
                            System.out.println(aux4 + "." + edi.name + " vida: " + edi.VidaShow());
                        }
                        System.out.println("Ingresa la edificacion con la que quieres construir");
                        ediconstru = Reader.consola.nextInt();
                        System.out.println("Costo: material 1: " + cm.construccionesVehiculos2.get(aux4).costo[0] + " Material 2: " + cm.construccionesVehiculos.get(aux4).costo[1] + " Material 3: " + cm.construccionesVehiculos.get(aux4).costo[2]);

                        System.out.println("Ingresa 1 para comprar");
                        aux4 = 0;
                        aux4 = Reader.consola.nextInt();
                        if (aux4 == 1) {
                            System.out.println("Ingrese el tipo de material(1,2 o 3): ");
                            int materialaux = Reader.consola.nextInt();
                            Materiales mataux = Materiales.oro;
                            switch (materialaux) {
                                case 1:
                                    mataux = Materiales.oro;
                                    break;
                                case 2:
                                    mataux = Materiales.combustible;

                                    break;
                                case 3:
                                    mataux = Materiales.metal;

                                    break;
                            }
                            System.out.println("Ingresa un nombre para reconocer la construccion(Sin espacios): ");
                            String auxS = Reader.consola.next();
                            System.out.println("Ingresa la cantidad de objetos que quieres comprar: ");
                            aux4 = Reader.consola.nextInt();
                            cm.construccionesVehiculos2.get(ediconstru).makeProcessMoney(cm, auxS, aux4, mataux);
                        }
                        break;
                }

                break;
            case 5:
                this.subMenu5(cm);
                aux4 = 0;
                System.out.println("Ingrese 1 para Mejorar");
                aux4 = Reader.consola.nextInt();
                if (aux4 == 1) {
                    cm.Mejorar();
                }
                break;
            case 6:

                break;
        }

    }

    public void showForAtack(CentroDeMando cm, int lista) {
        int aux = 0;
        switch (lista) {
            case 1:
                for (Edificacion edi : cm.construccionesEntrendoras) {
                    System.out.println(aux + "." + edi.name + edi.VidaShow());
                    aux++;
                }
                break;
            case 2:
                for (Edificacion edi : cm.construccionesVehiculos) {
                    System.out.println(aux + "." + edi.name + edi.VidaShow());
                    aux++;
                }
                break;
            case 3:
                for (Edificacion edi : cm.construccionesVehiculos2) {
                    System.out.println(aux + "." + edi.name + edi.VidaShow());
                    aux++;
                }
                break;
            case 4:
                for (Edificacion edi : cm.construccionesRecolectora1) {
                    System.out.println(aux + "." + edi.name + edi.VidaShow());
                    aux++;
                }
                break;
            case 5:
                for (Edificacion edi : cm.construccionesRecolectora2) {
                    System.out.println(aux + "." + edi.name + edi.VidaShow());
                    aux++;
                }
                break;
            case 6:
                for (Edificacion edi : cm.construccionesRecolectora3) {
                    System.out.println(aux + "." + edi.name + edi.VidaShow());
                    aux++;
                }
                break;
            case 7:
                for (Vehiculo edi : cm.vehiculos) {
                    System.out.println(aux + "." + edi.name + edi.VidaShow());
                    aux++;
                }
                break;
            case 8:
                for (Vehiculo edi : cm.vehiculos2) {
                    System.out.println(aux + "." + edi.name + edi.VidaShow());
                    aux++;
                }
                break;
            case 9:
                for (Milicia edi : cm.milicias) {
                    System.out.println(aux + "." + edi.name + edi.VidaShow());
                    aux++;
                }
                break;
        }
    }

    public int showForAtack(CentroDeMando cm, int lista, int elemento) {

        int has = 0;
        switch (lista) {
            case 1:
                return cm.construccionesEntrendoras.get(elemento).hashCode();
            case 2:
                return cm.construccionesVehiculos.get(elemento).hashCode();
            case 3:
                return cm.construccionesVehiculos2.get(elemento).hashCode();
            case 4:
                return cm.construccionesRecolectora1.get(elemento).hashCode();
            case 5:
                return cm.construccionesRecolectora2.get(elemento).hashCode();
            case 6:
                return cm.construccionesRecolectora3.get(elemento).hashCode();

            case 7:
                return cm.vehiculos.get(elemento).hashCode();
            case 8:
                return cm.vehiculos2.get(elemento).hashCode();
            case 9:
                return cm.milicias.get(elemento).hashCode();
        }
        return has;
    }

    public Territorio showForAtackter(CentroDeMando cm, int lista, int elemento) {

        int has = 0;
        switch (lista) {
            case 1:
                return Territorio.Enemigo;
            case 2:
                return Territorio.Enemigo;
            case 3:
                return Territorio.Enemigo;
            case 4:
                return Territorio.Enemigo;
            case 5:
                return Territorio.Enemigo;
            case 6:
                return Territorio.Enemigo;

            case 7:
                return Territorio.Enemigo;
            case 8:
                return Territorio.Enemigo;
            case 9:
                return cm.milicias.get(elemento).territorio;
        }
        return Territorio.Enemigo;
    }

    public void subMenu1(CentroDeMando cm) {
        System.out.println("1.Vehiculos 2.Milicias 3. Edificaciones");
    }

    public void subMenu2(CentroDeMando cm1) {
        int aux = 0;
        for (Milicia ml : cm1.milicias) {
            System.out.println(aux + "." + ml.name + " vida:" + ml.VidaShow() + " Estado:" + ml.estado + " En territorio:" + ml.territorio);
            aux++;
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

                            break;
                        case 2:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.construccionesVehiculos.get(ml.atacando[1]).name + " Base Constructora de Vehiculos tipo liviano" + " con vida " + cm.construccionesVehiculos.get(ml.atacando[1]).VidaShow());

                            break;
                        case 3:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.construccionesVehiculos2.get(ml.atacando[1]).name + " Base Constructora de Vehiculos tipo camion" + " con vida " + cm.construccionesVehiculos2.get(ml.atacando[1]).VidaShow());

                            break;
                        case 4:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.construccionesRecolectora1.get(ml.atacando[1]).name + " Base Recolectora de material 1" + " con vida " + cm.construccionesRecolectora1.get(ml.atacando[1]).VidaShow());

                            break;
                        case 5:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.construccionesRecolectora2.get(ml.atacando[1]).name + " Base Recolectora de material 2" + " con vida " + cm.construccionesRecolectora2.get(ml.atacando[1]).VidaShow());

                            break;
                        case 6:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.construccionesRecolectora3.get(ml.atacando[1]).name + " Base Recolectora de material 3" + " con vida " + cm.construccionesRecolectora3.get(ml.atacando[1]).VidaShow());

                            break;
                        case 7:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.vehiculos.get(ml.atacando[1]).name + " Vehiculo liviano" + " con vida " + cm.vehiculos.get(ml.atacando[1]).VidaShow());

                            break;
                        case 8:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.vehiculos2.get(ml.atacando[1]).name + " Vehiculo tipo camion" + " con vida " + cm.vehiculos2.get(ml.atacando[1]).VidaShow());

                            break;
                        case 9:
                            System.out.println(aux + 1 + " " + ml.name + "Esta atancando a " + cm.milicias.get(ml.atacando[1]).name + " Milicia" + " con vida " + cm.milicias.get(ml.atacando[1]).VidaShow());

                            break;
                    }
                } catch (Exception error2) {

                } finally {
                    aux++;
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
        System.out.println("Nivel " + cm.level);
        cm.getMaterials();
        int gasto = (int) (0.25 * (cm.totaloro + cm.totalcombustible + cm.totalmetal)) / 3;
        System.out.println("Costo: " + gasto + " de cada Material");
    }
}
