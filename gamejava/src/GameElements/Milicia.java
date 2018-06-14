/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import Utilities.Reader;

/**
 *
 * @author gerar
 */
public class Milicia {

    public String name;
    public int ataque;
    public int vida;
    public TipoRaza tipo;
    public Territorio territorio;
    public int tiempoEspera;
    public int fasetomake;
    int costoSentAndReturn[];
    public int atacando[];
    public MiliciaEstado estado;
    public int vidatotal;

    /**
     *
     * @param ataque
     * @param vida
     * @param tipo
     * @param terri
     * @param tiempo
     * @param name
     */
    public Milicia(int ataque, int vida, TipoRaza tipo, Territorio terri, int tiempo, String name) {
        this.ataque = ataque;
        this.vida = vida;
        this.vidatotal = vida;
        this.tipo = tipo;
        this.territorio = terri;
        this.tiempoEspera = tiempo;
        this.name = name;
        atacando = new int[2];
        fasetomake = 0;
    }

    public Milicia() {

    }

    public void makeOperations(CentroDeMando cm, Milicia ml) {
        if (Reader.consola.nextInt(2) == 1) {
            ml.getDamage((int) (this.ataque * 0.8));
            System.out.println("Has hecho " + (int) (this.ataque * 0.8) + " de dannio");

        } else {
            if (Reader.consola.nextInt(2) == 1) {
                ml.getDamage((int) (this.ataque * 0.9));
                System.out.println("Has hecho " + (int) (this.ataque * 0.9) + " de dannio");

            } else {
                ml.getDamage((int) this.ataque);
                System.out.println("Has hecho " + (int) (this.ataque) + " de dannio");

            }
        }
    }
     public void makeOperations(CentroDeMando cm, CentroDeMando ml) {
        if (Reader.consola.nextInt(2) == 1) {
            ml.getDamage((int) (this.ataque * 0.8));
            System.out.println("Has hecho " + (int) (this.ataque * 0.8) + " de dannio");

        } else {
            if (Reader.consola.nextInt(2) == 1) {
                ml.getDamage((int) (this.ataque * 0.9));
                System.out.println("Has hecho " + (int) (this.ataque * 0.9) + " de dannio");

            } else {
                ml.getDamage((int) this.ataque);
                System.out.println("Has hecho " + (int) (this.ataque) + " de dannio");

            }
        }
    }

    public void makeOperations(CentroDeMando cm, Edificacion ml) {
        if (Reader.consola.nextInt(2) == 1) {
            ml.getDamage((int) (this.ataque * 0.8));
            System.out.println("Has hecho " + (int) (this.ataque * 0.8) + " de dannio");

        } else {
            if (Reader.consola.nextInt(2) == 1) {
                ml.getDamage((int) (this.ataque * 0.9));
                System.out.println("Has hecho " + (int) (this.ataque * 0.9) + " de dannio");
            } else {
                ml.getDamage((int) this.ataque);
                System.out.println("Has hecho " + (int) (this.ataque) + " de dannio");

            }
        }

    }

    public void makeOperations(CentroDeMando cm, Vehiculo ml) {
        if (Reader.consola.nextInt(2) == 1) {
            ml.getDamage((int) (this.ataque * 0.8));

        } else {
            if (Reader.consola.nextInt(2) == 1) {
                ml.getDamage((int) (this.ataque * 0.9));

            } else {
                ml.getDamage((int) this.ataque);
            }
        }

    }

    public Milicia returnme() {
        return this;
    }

    public int Damage() {
        return ataque;
    }

    public void getDamage(int ata) {
        vida -= ata;
    }

    public String VidaShow() {
        return vida + "/" + vidatotal;
    }
}
