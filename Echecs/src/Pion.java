//package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pion extends Piece {
    boolean MesPremiersPas; // permet au pion de pouvoir avancer de deux cases uniquement lors de son premier mouvement
    boolean PeutManger; // permet au pion de pouvoir prendre une pièce adverse en diagonale
    boolean EstKeblo; // permet au pion de ne pas pouvoir prendre une pièce adverse en colonne
    private int choix;

    // Constructeur
    public Pion (int x, int y, int couleur) {
        super(x, y, couleur);
        this.MesPremiersPas = true;
    }

    // Acesseurs et Mutateurs
    public boolean isMesPremiersPas() {
        return MesPremiersPas;
    }
    public void setMesPremiersPas(boolean mesPremiersPas) {
        MesPremiersPas = mesPremiersPas;
    }

    public boolean isPeutManger() {
        return PeutManger;
    }
    public void setPeutManger(boolean peutManger) {
        PeutManger = peutManger;
    }

    public boolean isEstKeblo() {
        return EstKeblo;
    }
    public void setEstKeblo(boolean estKeblo) {
        EstKeblo = estKeblo;
    }


    // Méthodes
    public Pane dessiner (int x, int y, int couleur, Color color){
        x = x * 75 + 188;
        y = y * 75 + 62;

        //System.out.print("yolooo");
        System.out.print("| Pion ");

        Pane pion = new Pane();

        Color uneCouleur;
        Color unCoutour;

        if (couleur == 1) {
            uneCouleur = color;
            unCoutour = Color.WHITE;
        }

        else{
            uneCouleur = Color.WHITE;
            unCoutour = color;
        }


        //uneCouleur = Color.DARKCYAN;

        Circle jeton = new Circle();
        jeton.setCenterX(x);
        jeton.setCenterY(y);
        jeton.setRadius(15);
        jeton.setFill(uneCouleur);
        jeton.setStroke(unCoutour);
        jeton.setStrokeWidth(1);
        pion.getChildren().add(jeton);


        Circle dessin1 = new Circle();
        dessin1.setCenterX(x);
        dessin1.setCenterY(y - 7);
        dessin1.setRadius(4);
        dessin1.setFill(uneCouleur);
        dessin1.setStroke(unCoutour);
        dessin1.setStrokeWidth(1);
        pion.getChildren().add(dessin1);

        Line line1 = new Line(x + 2,y - 2 ,x + 6,y + 8);
        Line line2 = new Line(x - 2,y - 2 ,x - 6,y + 8);
        Line line3 = new Line(x - 6,y + 8,x + 6,y + 8);
        line1.setStroke(unCoutour);
        line2.setStroke(unCoutour);
        line3.setStroke(unCoutour);
        pion.getChildren().addAll(line1, line2, line3);


        return pion;

    }

    public void deplacement (int x, int y, Pane pane, Affichage affichage) {
        int X, Y;
        int deltaX;
        int deltaY;

        int xtemp, ytemp;
        xtemp = getX();
        ytemp = getY();

        deltaX = getDeltaX();
        deltaY = getDeltaY();

        setX(x);
        setY(y);

        x -= deltaX;
        y -= deltaY;

        X = getX() + deltaX;
        Y = getY() + deltaY;
        X = x;
        Y = y;
/*
        System.out.println("MesPremiersPas : " + isMesPremiersPas());
        System.out.println("X = " + X + " ; Y = " + Y);


        System.out.println("PeutManger = " + PeutManger);
        System.out.println("EstKeblo = " + EstKeblo);

 */

        if(((MesPremiersPas && (getCouleur() == 1 && ( X == 1 || X == 2) || getCouleur() == 0 && (X == -1 || X == -2)) || !MesPremiersPas && ((getCouleur() == 1 &&  X == 1) || (getCouleur() == 0 && X == -1 ))) && Y == 0
                || getCouleur() == 1 && X == 1 && (Y == 1 || Y == -1) && PeutManger || getCouleur() == 0 && X == -1 && (Y == 1 || Y == -1) && PeutManger) && !EstKeblo){

            setDeltaX(X);
            setDeltaY(Y);

            X = getxGraph() + 75 * X;
            Y = getyGraph() + 75 * Y;
            setxGraph(X);
            setyGraph(Y);

            TranslateTransition translate = new TranslateTransition();
            translate.setByX(Y);
            translate.setByY(X);
            translate.setDuration(Duration.millis(1000));
            translate.setNode(pane);
            translate.play();

            setxGraph(0);
            setyGraph(0);

            setMouvementIllicite(false);
            System.out.println("pion pas bloque");
        }

        else {
            System.out.println("tri aguin");
            setX(xtemp);
            setY(ytemp);
            setMouvementIllicite(true);
        }

        if (MesPremiersPas)
            MesPremiersPas = false;
    }

    // lorsqu'un pion arrive de l'autre côté du plateau, il se transforme
    public Pane transformationPion(Affichage affichage, int couleur, int x, int y) {
        if (couleur == 1)
            couleur = 0;
        else
            couleur = 1;

        if (couleur == 0 && this.x == 0) {
            affichage.supprimerPane(x, y);
            Stage stage = new Stage();
            ChoixPion choixPion = new ChoixPion(stage, couleur, affichage.color, this);
            stage.setTitle("Transformez votre pion");
            stage.setScene(new Scene(choixPion, 200, 200, Color.GHOSTWHITE));
            stage.show();
            System.out.println("choix " + choix);
            if (choix == 1) {
                affichage.plateauEnum[x][y] = Affichage.typePiece.fou_B_;
                Fou nouveauFou = new Fou(x, y, 0);
                affichage.mesFousBlancs.add(nouveauFou);
                Pane pane = nouveauFou.dessiner(y, x, 0, affichage.color);
                affichage.tableauDePieces[x][y] = nouveauFou;
                affichage.listeFousBlancs.add(pane);
                int taille = affichage.listeFousBlancs.size();
                affichage.plateau[x][y] = affichage.listeFousBlancs.get(taille - 1);
            }

            if (choix == 2) {
                affichage.plateauEnum[x][y] = Affichage.typePiece.dada_B;
                Dada nouveauDada = new Dada(x, y, 0);
                affichage.mesDadasBlancs.add(nouveauDada);
                Pane pane = nouveauDada.dessiner(y, x, 0, affichage.color);
                affichage.tableauDePieces[x][y] = nouveauDada;
                affichage.listeDadasBlancs.add(pane);
                int taille = affichage.listeDadasBlancs.size();
                affichage.plateau[x][y] = affichage.listeDadasBlancs.get(taille - 1);
            }

            if (choix == 3) {
                affichage.plateauEnum[x][y] = Affichage.typePiece.tour_B;
                Tour nouvelleTour = new Tour(x, y, 0);
                affichage.mesToursBlanches.add(nouvelleTour);
                Pane pane = nouvelleTour.dessiner(y, x, 0, affichage.color);
                affichage.tableauDePieces[x][y] = nouvelleTour;
                affichage.listeToursBlanches.add(pane);
                int taille = affichage.listeToursBlanches.size();
                affichage.plateau[x][y] = affichage.listeToursBlanches.get(taille - 1);

            }

            //if (choix == 4) {
            else {
                affichage.plateauEnum[x][y] = Affichage.typePiece.dame_B;
                Dame nouvelleDame = new Dame(x, y, 0);
                affichage.mesDamesBlanches.add(nouvelleDame);
                Pane pane = nouvelleDame.dessiner(y, x, 0, affichage.color);
                affichage.tableauDePieces[x][y] = nouvelleDame;
                affichage.listeDameBlanche.add(pane);
                int taille = affichage.listeDameBlanche.size();
                affichage.plateau[x][y] = affichage.listeDameBlanche.get(taille - 1);
            }
        }

        if (couleur == 1 && this.x == 7) {
            affichage.supprimerPane(x, y);
            Stage stage = new Stage();
            ChoixPion choixPion = new ChoixPion(stage, couleur, affichage.color, this);
            stage.setTitle("Transformez votre pion");
            stage.setScene(new Scene(choixPion, 200, 200, Color.GHOSTWHITE));
            stage.show();
            System.out.println("choix " + choix);
            if (choix == 1) {
                affichage.plateauEnum[x][y] = Affichage.typePiece.fou_N_;
                Fou nouveauFou = new Fou(x, y, 1);
                affichage.mesFousNoirs.add(nouveauFou);
                Pane pane = nouveauFou.dessiner(y, x, 1, affichage.color);
                affichage.tableauDePieces[x][y] = nouveauFou;
                affichage.listeFousNoirs.add(pane);
                int taille = affichage.listeFousNoirs.size();
                affichage.plateau[x][y] = affichage.listeFousNoirs.get(taille - 1);
            }

            if (choix == 2) {
                affichage.plateauEnum[x][y] = Affichage.typePiece.dada_N;
                Dada nouveauDada = new Dada(x, y, 1);
                affichage.mesDadasNoirs.add(nouveauDada);
                Pane pane = nouveauDada.dessiner(y, x, 1, affichage.color);
                affichage.tableauDePieces[x][y] = nouveauDada;
                affichage.listeDadasNoirs.add(pane);
                int taille = affichage.listeDadasNoirs.size();
                affichage.plateau[x][y] = affichage.listeDadasNoirs.get(taille - 1);
            }

            if (choix == 3) {
                affichage.plateauEnum[x][y] = Affichage.typePiece.tour_N;
                Tour nouvelleTour = new Tour(x, y, 1);
                affichage.mesToursNoires.add(nouvelleTour);
                Pane pane = nouvelleTour.dessiner(y, x, 1, affichage.color);
                affichage.tableauDePieces[x][y] = nouvelleTour;
                affichage.listeToursNoires.add(pane);
                int taille = affichage.listeToursNoires.size();
                affichage.plateau[x][y] = affichage.listeToursNoires.get(taille - 1);
            }

            //if (choix == 4) {
            else {
                affichage.plateauEnum[x][y] = Affichage.typePiece.dame_N;
                Dame nouvelleDame = new Dame(x, y, 1);
                affichage.mesDamesNoires.add(nouvelleDame);
                Pane pane = nouvelleDame.dessiner(y, x, 1, affichage.color);
                affichage.tableauDePieces[x][y] = nouvelleDame;
                affichage.listeDameNoire.add(pane);
                int taille = affichage.listeDameNoire.size();
                affichage.plateau[x][y] = affichage.listeDameNoire.get(taille - 1);
            }
        }
        return affichage.plateau[x][y];
    }


    public int getChoix() {
        return choix;
    }
    public void setChoix(int choix) {
        this.choix = choix;
    }
}
