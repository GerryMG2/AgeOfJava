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
    
    public void ReStart(){
        
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

}
