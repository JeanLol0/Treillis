/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.lareyre.treillis;

import java.awt.Color;
import static java.lang.Math.sqrt;
import static java.lang.Math.asin;

/**
 *
 * @author jeanl
 */
public class Barre {
    private Noeud debut;
    private Noeud arrive; 
    private Color couleur; 
    private int Id; 

    public Barre(Noeud debut, Noeud arrive, Color couleur) {
        this.couleur= couleur; 
        this.debut = debut;
        this.arrive = arrive;
        debut.BarreDepart.add(this);
        arrive.BarreArrive.add(this);
        this.Id= Id; 
    }
    
    public Barre(Noeud debut, Noeud arrive){
        this(debut, arrive, Color.blue);
        debut.BarreDepart.add(this);
        arrive.BarreArrive.add(this);
    }

    public Noeud getDebut() {
        return debut;
    }

    public Noeud getArrive() {
        return arrive;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    

    public String toString() {
        return "Barre [" +  debut + "," + arrive+ "]";
    }
     
    public Noeud noeudOppose(Noeud n){
        if (n== this.debut){
            return this.arrive;
        }
        else {
            return this.debut;
        }
    }
    
    public double angle (Noeud n){
        double longueur = sqrt(Math.pow(n.getPx()-noeudOppose(n).getPx(),2)+Math.pow(n.getPy()-noeudOppose(n).getPy(),2));
        if (n.getPx()>noeudOppose(n).getPx()){
            double C= (n.getPy()-noeudOppose(n).getPy())/longueur;
            return Math.asin(C); 
        }
        else{
            double C= (noeudOppose(n).getPy()-n.getPy())/longueur; 
            return Math.asin(C);
        }
    }


}
