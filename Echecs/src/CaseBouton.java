//package sample;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class CaseBouton extends Parent {
    private int x;
    private int y;
    private Piece etat; // détermine ce que contient la case
    private boolean selection = false; // détermine si on a sélectionner une piece de la bonne coleur
    private int tourJoueur = 0;
    private  boolean jeTeMange = false; // détecter si une pièce à été prise afin de ne pas faire passer selection a true

    // Constructeur
    public CaseBouton () {

    }

    // Acesseurs et Mutateurs
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public Piece getEtat() {
        return etat;
    }
    public void setEtat(Piece etat) {
        this.etat = etat;
    }


    public boolean getSelection() {
        return selection;
    }
    public void setSelection(boolean selection) {
        this.selection = selection;
    }

    public int getTourJoueur() {
        return tourJoueur;
    }
    public void setTourJoueur(int tourJoueur) {
        this.tourJoueur = tourJoueur;
    }

    public boolean isJeTeMange() {
        return jeTeMange;
    }
    public void setJeTeMange(boolean jeTeMange) {
        this.jeTeMange = jeTeMange;
    }


    // Méthodes

    public boolean verifierEtat (int x, int y, Affichage.typePiece piece) {
        boolean etat;
        Affichage.typePiece maPiece = piece;
        if (maPiece == Affichage.typePiece._vide_){
            etat = false;
        }
        else {
            etat = true;
        }
        return etat;
    }

    // permet de savoir si une pièce est bien sélectionnée
    public boolean selectionner (boolean selection) {
        selection = !selection;

        return selection;
    }

    // permet d'indiquer le joueur qui doit jouer
    public int AQuiLeTour (int tourJoueur) {

        if(tourJoueur == 0)
            tourJoueur = 1;
        else
            tourJoueur = 0;

        return tourJoueur;
    }






    public Pane dessinerBouton (int x, int y, int incrementx, int incrementy) {
        this.x = x;
        this.y = y;

        Pane bouton = new Pane();
        bouton.setMinSize(73,73);
        bouton.setPrefSize(74,74);
        bouton.setMaxSize(75,75);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(75 + y + 74.5 * incrementx);
        rectangle.setY(- 50 + x + 74.5 * incrementy);
        rectangle.setWidth(72);
        rectangle.setHeight(72);
        rectangle.setFill(Color.rgb(255,255,255,0.0));
        rectangle.setStroke(Color.BLUEVIOLET);
        rectangle.setStrokeWidth(1);
        this.getChildren().add(rectangle);

        bouton.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.rgb(255,255,255,0.4));
            }
        });
        bouton.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.rgb(255,255,255,0.0));
            }
        });
        bouton.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.rgb(255,255,255,0.7));
            }
        });
        bouton.setOnMouseReleased(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.rgb(255,255,255,0.4));
            }
        });


        System.out.print("boutonsamere");

        return bouton;


    }

}


