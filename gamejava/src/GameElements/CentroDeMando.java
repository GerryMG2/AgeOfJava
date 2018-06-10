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
public class CentroDeMando {
    
    private final String password;
    public int oro;
    public int combustible;
    public int metal;
    public int vida;
    public TipoRaza type;
    public int costoConsEntre[];
    public int costoConstVehi[];
    public int costoConstVehi2[];
    public int costoConsRe1[];
    public int costoConsRe2[];
    public int costoConsRe3[];
    ArrayList<OrdenesConstr> constrEntre;
    ArrayList<OrdenesConstr> constrVehi;
    ArrayList<OrdenesConstr> constrVehi2;
    ArrayList<OrdenesConstr> constrRe1;
    ArrayList<OrdenesConstr> constrRe2;
    ArrayList<OrdenesConstr> constrRe3;
    boolean JustCentro = true;
    ArrayList<Edificacion> construccionesEntrendoras;
    ArrayList<Edificacion> construccionesVehiculos;
    ArrayList<Edificacion> construccionesVehiculos2;
    ArrayList<Edificacion> construccionesRecolectora1;
    ArrayList<Edificacion> construccionesRecolectora2;
    ArrayList<Edificacion> construccionesRecolectora3;
    ArrayList<Vehiculo> vehiculos;
    ArrayList<Vehiculo> vehiculos2;
    ArrayList<Milicia> milicias;
    
    public CentroDeMando(String password, int oro, int combustible, int metal, int vida, TipoRaza type) {
        this.password = password;
        this.oro = oro;
        this.combustible = combustible;
        this.metal = metal;
        this.vida = vida;
        this.type = type;
        construccionesEntrendoras = new ArrayList<>();
        construccionesVehiculos = new ArrayList<>();
        construccionesVehiculos2 = new ArrayList<>();
        construccionesRecolectora1 = new ArrayList<>();
        construccionesRecolectora2 = new ArrayList<>();
        construccionesRecolectora3 = new ArrayList<>();
        constrEntre = new ArrayList<>();
        constrVehi = new ArrayList<>();
        constrVehi2 = new ArrayList<>();
        constrRe1 = new ArrayList<>();
        constrRe2 = new ArrayList<>();
        constrRe3 = new ArrayList<>();
        vehiculos = new ArrayList<>();
        vehiculos2 = new ArrayList<>();
        milicias = new ArrayList<>();
    }
    
    public void getDamage(int ata) {
        vida -= ata;
    }
    
    public void constr(OrdenesConstr orden) {
        switch (orden.edi) {
            case Entrenadora:
                for (int i = 0; i < orden.cantidad; i++) {
                    construccionesEntrendoras.add(factory.Edificar(type, orden.edi, null, orden.name, null));
                    JustCentro = false;
                }
                
                break;
            case Vehicular:
                for (int i = 0; i < orden.cantidad; i++) {
                    construccionesVehiculos.add(factory.Edificar(type, orden.edi, null, orden.name, orden.vehiculo));
                    JustCentro = false;
                }
                break;
            case Vehicular2:
                for (int i = 0; i < orden.cantidad; i++) {
                    construccionesVehiculos2.add(factory.Edificar(type, orden.edi, null, orden.name, orden.vehiculo));
                    JustCentro = false;
                }
                break;
            case Recolectora:
                switch (orden.mat) {
                    case oro:
                        for (int i = 0; i < orden.cantidad; i++) {
                            construccionesRecolectora1.add(factory.Edificar(type, orden.edi, orden.mat, orden.name, null));
                            JustCentro = false;
                        }
                        break;
                    case metal:
                        for (int i = 0; i < orden.cantidad; i++) {
                            construccionesRecolectora2.add(factory.Edificar(type, orden.edi, orden.mat, orden.name, null));
                            JustCentro = false;
                        }
                        
                        break;
                    case combustible:
                        for (int i = 0; i < orden.cantidad; i++) {
                            construccionesRecolectora3.add(factory.Edificar(type, orden.edi, orden.mat, orden.name, null));
                            JustCentro = false;
                        }
                        break;
                }
                break;
        }
    }
    
    public void CreateOrders(TipoEdificacion tipo, Materiales mat, String name, int cantidad) {
        switch (tipo) {
            case Entrenadora:
                int aux = 0;
                for (OrdenesConstr ord : constrEntre) {
                    if (ord.fase > Juego.fase) {
                        aux += ord.cantidad;
                    }
                }
                if (aux + construccionesEntrendoras.size() + cantidad <= 10) {
                    if (this.oro >= this.costoConsEntre[0] * cantidad && this.combustible >= this.costoConsEntre[1] * cantidad && this.metal >= this.costoConsEntre[2] * cantidad) {
                        this.oro -= this.costoConsEntre[0] * cantidad;
                        this.combustible -= this.costoConsEntre[1] * cantidad;
                        this.metal -= this.costoConsEntre[2] * cantidad;
                        constrEntre.add(new OrdenesConstr(Juego.fase + this.costoConsEntre[3], cantidad, tipo));
                    } else {
                        System.out.println("No tiene suficientes recursos");
                    }
                } else {
                    System.out.println("No puede construir mas de 10 de este tipo de elemento");
                }
                break;
            case Vehicular:
                int aux2 = 0;
                for (OrdenesConstr ord : constrVehi) {
                    if (ord.fase > Juego.fase) {
                        aux2  += ord.cantidad;
                    }
                }
                if (aux2 + construccionesVehiculos.size() + cantidad <= 10) {
                    if (this.oro >= this.costoConstVehi[0] * cantidad && this.combustible >= this.costoConstVehi[1] * cantidad && this.metal >= this.costoConstVehi[2] * cantidad) {
                        this.oro -= this.costoConstVehi[0] * cantidad;
                        this.combustible -= this.costoConstVehi[1] * cantidad;
                        this.metal -= this.costoConstVehi[2] * cantidad;
                        constrVehi.add(new OrdenesConstr(Juego.fase + this.costoConstVehi[3], cantidad, tipo));
                    } else {
                        System.out.println("No tiene suficientes recursos");
                    }
                } else {
                    System.out.println("No puede construir mas de 10 de este tipo de elemento");
                }
                break;
            case Vehicular2:
                int aux6 = 0;
                for (OrdenesConstr ord : constrVehi2) {
                    if (ord.fase > Juego.fase) {
                        aux6 += ord.cantidad;
                    }
                }
                if (aux6 + construccionesVehiculos2.size() + cantidad <= 10) {
                    if (this.oro >= this.costoConstVehi2[0] * cantidad && this.combustible >= this.costoConstVehi2[1] * cantidad && this.metal >= this.costoConstVehi[2] * cantidad) {
                        this.oro -= this.costoConstVehi2[0] * cantidad;
                        this.combustible -= this.costoConstVehi2[1] * cantidad;
                        this.metal -= this.costoConstVehi2[2] * cantidad;
                        constrVehi2.add(new OrdenesConstr(Juego.fase + this.costoConstVehi2[3], cantidad, tipo));
                    } else {
                        System.out.println("No tiene suficientes recursos");
                    }
                } else {
                    System.out.println("No puede construir mas de 10 de este tipo de elemento");
                }
                break;
            case Recolectora:
                switch (mat) {
                    case oro:
                        int aux3 = 0;
                        for (OrdenesConstr ord : constrRe1) {
                            if (ord.fase > Juego.fase) {
                                aux3 += ord.cantidad;
                            }
                        }
                        if (aux3 + construccionesRecolectora1.size() + cantidad <= 10) {
                            if (this.oro >= this.costoConsRe1[0] * cantidad && this.combustible >= this.costoConsRe1[1] * cantidad && this.metal >= this.costoConsRe1[2] * cantidad) {
                                this.oro -= this.costoConsRe1[0] * cantidad;
                                this.combustible -= this.costoConsRe1[1] * cantidad;
                                this.metal -= this.costoConsRe1[2] * cantidad;
                                constrRe1.add(new OrdenesConstr(Juego.fase + this.costoConsRe1[3], cantidad, tipo));
                            } else {
                                System.out.println("No tiene suficientes recursos");
                            }
                        } else {
                            System.out.println("No puede construir mas de 10 de este tipo de elemento");
                        }
                        break;
                    case combustible:
                        int aux4 = 0;
                        for (OrdenesConstr ord : constrRe2) {
                            if (ord.fase > Juego.fase) {
                                aux4 += ord.cantidad;
                            }
                        }
                        if (aux4 + construccionesRecolectora2.size() + cantidad <= 10) {
                            if (this.oro >= this.costoConsRe2[0] * cantidad && this.combustible >= this.costoConsRe1[1] * cantidad && this.metal >= this.costoConsRe1[2] * cantidad) {
                                this.oro -= this.costoConsRe2[0] * cantidad;
                                this.combustible -= this.costoConsRe2[1] * cantidad;
                                this.metal -= this.costoConsRe2[2] * cantidad;
                                constrRe2.add(new OrdenesConstr(Juego.fase + this.costoConsRe2[3], cantidad, tipo));
                            } else {
                                System.out.println("No tiene suficientes recursos");
                            }
                        } else {
                            System.out.println("No puede construir mas de 10 de este tipo de elemento");
                        }
                        break;
                    case metal:
                        int aux5 = 0;
                        for (OrdenesConstr ord : constrRe3) {
                            if (ord.fase > Juego.fase) {
                                aux5 += ord.cantidad;
                            }
                        }
                        if (aux5 + construccionesRecolectora3.size() + cantidad <= 10) {
                            if (this.oro >= this.costoConsRe3[0] * cantidad && this.combustible >= this.costoConsRe3[1] * cantidad && this.metal >= this.costoConsRe3[2] * cantidad) {
                                this.oro -= this.costoConsRe3[0] * cantidad;
                                this.combustible -= this.costoConsRe3[1] * cantidad;
                                this.metal -= this.costoConsRe3[2] * cantidad;
                                constrRe3.add(new OrdenesConstr(Juego.fase + this.costoConsRe3[3], cantidad, tipo));
                            } else {
                                System.out.println("No tiene suficientes recursos");
                            }
                        } else {
                            System.out.println("No puede construir mas de 10 de este tipo de elemento");
                        }
                        break;
                    
                }
                break;
        }
    }
    
}
