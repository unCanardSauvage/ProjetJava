//package sample;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.Random;

public abstract class Piece extends Parent {
    protected int x;  // position de la pièce en x;
    protected int y;  // position de la pièce en y;
    protected int couleur; // 0 pour les blancs et 1 pour les noirs
    protected int xGraph; // coordonnées graphiques en x par rapport à l'emplacement précédent
    protected int yGraph; // coordonnées graphiques en y par rapport à l'emplacement précédent
    protected int deltaX; // permet de définir la différence entre la position actuelle en x et la position future
    protected int deltaY; // permet de définir la différence entre la position actuelle en y et la position future
    protected boolean mouvementIllicite; // défini si le mouvement est autorisé
    protected boolean saut; // indique, pour les pièces pouvant se déplacer de plusieurs cases à la fois,
                            // s'il y a une pièce entre la pièce et la destination souhaitée
    protected int depX, depY;

    protected Color couleurJ1;

    protected boolean aBooleanPion = false;


    // Constructeur
    public Piece (int x, int y, int couleur) {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
        this.xGraph = this.yGraph = 0;
        this.deltaX = this.deltaY = 0;
    }

    // Acesseurs et Mutateurs
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getCouleur() {
        return couleur;
    }
    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }

    public int getxGraph() {
        return xGraph;
    }
    public void setxGraph(int xGraph) {
        this.xGraph = xGraph;
    }

    public int getyGraph() {
        return yGraph;
    }
    public void setyGraph(int yGraph) {
        this.yGraph = yGraph;
    }

    public int getDeltaX() {
        return deltaX;
    }
    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }
    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    public boolean isMouvementIllicite() {
        return mouvementIllicite;
    }
    public void setMouvementIllicite(boolean mouvementIllicite) {
        this.mouvementIllicite = mouvementIllicite;
    }

    public boolean isSaut() {
        return saut;
    }
    public void setSaut(boolean saut) {
        this.saut = saut;
    }

    public int getDepX() {
        return depX;
    }
    public void setDepX(int depX) {
        this.depX = depX;
    }

    public int getDepY() {
        return depY;
    }
    public void setDepY(int depY) {
        this.depY = depY;
    }

    public Color getCouleurJ1() {
        return couleurJ1;
    }
    public void setCouleurJ1(Color couleurJ1) {
        this.couleurJ1 = couleurJ1;
    }

    public boolean isaBooleanPion() {
        return aBooleanPion;
    }
    public void setaBooleanPion(boolean aBooleanPion) {
        this.aBooleanPion = aBooleanPion;
    }

    // Méthodes
    public abstract Pane dessiner (int x, int y, int couleur, Color color);  // permet de dessiner la pièce sur l'interface graphique
    public abstract void deplacement (int x, int y, Pane pane, Affichage affichage); // permet de déplacer la pièce aussi bien graphiquement que dans nos tableaux
    public void manger () {

    }

    // petite animation lorque la pièce se fait prendre
    public void tourDeLaDefaite (Pane pane) {
        System.out.println("tourDeLaDefaite();");

        Random animation = new Random();
        int anim = animation.nextInt(100);

        if (anim < 50 ) {
            Random random = new Random();
            int X = random.nextInt(100);

            TranslateTransition translate = new TranslateTransition();
            translate.setByX(1500);
            translate.setByY(X);
            translate.setDuration(Duration.millis(6000));
            translate.setNode(pane);

            RotateTransition rotate = new RotateTransition();
            rotate.setAxis(Rotate.Y_AXIS);
            rotate.setByAngle(360);
            rotate.setCycleCount(100);
            rotate.setDuration(Duration.millis(1000));
            rotate.setNode(pane);

            translate.play();
            rotate.play();
        }

        if (anim > 49) {

            TranslateTransition translate = new TranslateTransition();
            translate.setByX(1500);
            translate.setByY(0);
            translate.setDuration(Duration.millis(6000));
            translate.setNode(pane);

            RotateTransition rotate = new RotateTransition();
            rotate.setAxis(Rotate.Y_AXIS);
            rotate.setAxis(Rotate.Z_AXIS);
            rotate.setByAngle(180);
            //rotate.setCycleCount(100);
            rotate.setDuration(Duration.millis(6000));
            rotate.setNode(pane);

            translate.play();
            rotate.play();
        }

        this.getChildren().remove(pane);

    }


    // pas de antiSauteMouton en méthode abstraite ici car elle ne sera pas nécessaire pour toutes les filles comme le dada par exemple

    // celle ci sera pour le fou et la dame
    public void antiSauteMoutonDiag (int x, int y, int deltaX, int deltaY, Affichage affichage) {
        setSaut(false);

        int decrement = y;
        if (deltaX > 0 && deltaY > 0) {
            System.out.println("1");
            for (int i = x + 1; i < x + deltaX; i++) {
                System.out.println("i = " + i);
                decrement++;
                System.out.println("decrement = " + decrement);
                for (int j = y + 1; j < y + deltaY; j++) {
                    System.out.println("y = " + y);
                    System.out.println("decrement " + decrement);
                    if (decrement == j) {
                        System.out.println("affichage.plateauEnum[i][j] = " + affichage.plateauEnum[i][j]);
                        if (affichage.plateauEnum[i][j] != Affichage.typePiece._vide_) {
                            System.out.println("mouvement illicite");
                            setSaut(true);
                            mouvementIllicite = true;
                        }
                    }
                }
            }
        }
        decrement = y;
        if (deltaX < 0 && deltaY > 0) {
            System.out.println("2");
            for (int i = x - 1; i > x + deltaX; i--) {
                decrement++;
                for (int j = y + 1; j < y + deltaY; j++) {
                    if (decrement == j) {
                        System.out.println("affichage.plateauEnum[i][j] = " + affichage.plateauEnum[i][j]);
                        if (affichage.plateauEnum[i][j] != Affichage.typePiece._vide_) {
                            System.out.println("mouvement illicite");
                            setSaut(true);
                            mouvementIllicite = true;
                        }
                    }
                }
            }
        }
        decrement = y;
        if (deltaX < 0 && deltaY < 0) {
            System.out.println("3");
            for (int i = x - 1; i > x + deltaX; i--) {
                decrement--;
                for (int j = y - 1; j > y + deltaY; j--) {
                    if (decrement == j) {
                        System.out.println("affichage.plateauEnum[i][j] = " + affichage.plateauEnum[i][j]);
                        if (affichage.plateauEnum[i][j] != Affichage.typePiece._vide_) {
                            System.out.println("mouvement illicite");
                            setSaut(true);
                            mouvementIllicite = true;
                        }
                    }
                }
            }
        }
        decrement = y;
        if (deltaX > 0 && deltaY < 0) {
            System.out.println("4");
            for (int i = x + 1; i < x + deltaX; i++) {
                decrement--;
                for (int j = y - 1; j > y + deltaY; j--) {
                    if (decrement == j) {
                        System.out.println("affichage.plateauEnum[i][j] = " + affichage.plateauEnum[i][j]);
                        if (affichage.plateauEnum[i][j] != Affichage.typePiece._vide_) {
                            System.out.println("mouvement illicite");
                            setSaut(true);
                            mouvementIllicite = true;
                        }
                    }
                }
            }
        }
    }

    // celle ci sera pour la tour et la dame
    public void antiSauteMoutonDroit (int x, int y, int deltaX, int deltaY, Affichage affichage) {
        saut = false;


        if (deltaX > 0) {
            System.out.println("1");
            for (int i = x + 1; i < x + deltaX; i++) {
                System.out.println("affichage.plateauEnum[i][y] = " + affichage.plateauEnum[i][y]);
                if (affichage.plateauEnum[i][y] != Affichage.typePiece._vide_) {
                    System.out.println("mouvement illicite");
                    setSaut(true);
                    mouvementIllicite = true;
                }
            }
        }

        if (deltaX < 0) {
            System.out.println("2");
            for (int i = x - 1; i > x + deltaX; i--) {
                System.out.println("affichage.plateauEnum[i][y] = " + affichage.plateauEnum[i][y]);
                if (affichage.plateauEnum[i][y] != Affichage.typePiece._vide_) {
                    System.out.println("mouvement illicite");
                    setSaut(true);
                    mouvementIllicite = true;
                }
            }
        }

        if (deltaY > 0) {
            System.out.println("3");
            for (int i = y + 1; i < y + deltaY; i++) {
                System.out.println("affichage.plateauEnum[x][i] = " + affichage.plateauEnum[x][i]);
                if (affichage.plateauEnum[x][i] != Affichage.typePiece._vide_) {
                    System.out.println("mouvement illicite");
                    setSaut(true);
                    mouvementIllicite = true;
                }
            }
        }

        if (deltaY < 0) {
            System.out.println("4");
            for (int i = y - 1; i > y + deltaY; i--) {
                System.out.println("affichage.plateauEnum[x][i] = " + affichage.plateauEnum[x][i]);
                if (affichage.plateauEnum[x][i] != Affichage.typePiece._vide_) {
                    System.out.println("mouvement illicite");
                    setSaut(true);
                    mouvementIllicite = true;
                }
            }
        }
    }

    // cette fois-ci, on va essayer de se centrer sur la pièce et non sur l'origne. Voici un algo un peu différent
    public boolean echecDiag (Affichage affichage) {
        boolean bool = false;
        int limiteX = 8 - x;
        int limiteY = 8 - y;
        boolean barrage;
    /*    System.out.println("");
        System.out.println("##############DIAG####################");
        System.out.println(affichage.plateauEnum[x][y]);
        System.out.println("");

        System.out.println("");
        System.out.println("1");

     */
        barrage = false;
        for (int i = 1; i < limiteX; i++) {
            for (int j = 0; j < limiteY; j++) {
                int resX = i + x; int resY = j + y;
                /*if (i == j)
                    System.out.println("i + x = " + resX + " ; j + y = " + resY);*/
                if (i == j && couleur == 0 && !barrage) {
                    affichage.casesBlanches[i + x][j + y] = 1;
                }
                if (i == j && couleur == 1 && !barrage) {
                    affichage.casesNoires[i + x][j + y] = 1;
                }
                if (i == j && ((affichage.plateauEnum[i + x][j + y] == Affichage.typePiece.roi_B_ && couleur == 1) ||
                        affichage.plateauEnum[i + x][j + y] == Affichage.typePiece.roi_N_ && couleur == 0) && !barrage) {
                    bool = echec();
                }
                if (i == j && affichage.plateauEnum[i + x][j + y] != Affichage.typePiece._vide_)
                    barrage = true;
            }
        }

        //System.out.println("");
        //System.out.println("2");
        barrage = false;
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < limiteY; j++) {
                int resX = x - i; int resY = j + y;
                /*if (i == j){
                    System.out.println("x - i = " + resX + " ; j + y = " + resY);
                    System.out.println(affichage.plateauEnum[x - i][j + y]);
                }                                 */
                if (i == j && couleur == 0 && !barrage) {
                    affichage.casesBlanches[x - i][j + y] = 1;
                }
                if (i == j && couleur == 1 && !barrage) {
                    affichage.casesNoires[x - i][j + y] = 1;
                }
                if (i == j && ((affichage.plateauEnum[x - i][j + y] == Affichage.typePiece.roi_B_ && couleur == 1) ||
                        affichage.plateauEnum[x - i][j + y] == Affichage.typePiece.roi_N_ && couleur == 0) && !barrage) {
                    bool = echec();
                }
                if (i == j && affichage.plateauEnum[x - i][j + y] != Affichage.typePiece._vide_)
                    barrage = true;
            }
        }

        //System.out.println("");
        //System.out.println("3");
        barrage = false;
        for (int i = 0; i <= x; i++) {
            for (int j = y; j > 0; j--) {
                int resX = x - i; int resY = y - j;
                /*if (i == j)
                    System.out.println("x - i = " + resX + " ; y - j = " + resY);*/
                if (i == j && couleur == 0 && !barrage) {
                    affichage.casesBlanches[x - i][y - j] = 1;
                }
                if (i == j && couleur == 1 && !barrage) {
                    affichage.casesNoires[x - i][y - j] = 1;
                }
                if (i == j && ((affichage.plateauEnum[x - i][y - j] == Affichage.typePiece.roi_B_ && couleur == 1) ||
                        affichage.plateauEnum[x - i][y - j] == Affichage.typePiece.roi_N_ && couleur == 0) && !barrage) {
                    bool = echec();
                }
                if (i == j && affichage.plateauEnum[x - i][y - j] != Affichage.typePiece._vide_)
                    barrage = true;
            }
        }

        //System.out.println("");
        //System.out.println("4");
        barrage = false;
        for (int i = 0; i < limiteX; i++) {
            for (int j = y; j > 0; j--) {
                int resX = i + x; int resY = y - j;
                /*if (i == j)
                    System.out.println("i + x = " + resX + " ; y - j = " + resY);*/
                if (i == j && couleur == 0 && !barrage) {
                    affichage.casesBlanches[i + x][y - j] = 1;
                }
                if (i == j && couleur == 1 && !barrage) {
                    affichage.casesNoires[i + x][y - j] = 1;
                }
                if (i == j && ((affichage.plateauEnum[i + x][y - j] == Affichage.typePiece.roi_B_ && couleur == 1) ||
                        affichage.plateauEnum[i + x][y - j] == Affichage.typePiece.roi_N_ && couleur == 0) && !barrage) {
                    bool = echec();
                }
                if (i == j && affichage.plateauEnum[i + x][y - j] != Affichage.typePiece._vide_)
                    barrage = true;
            }
        }
        return bool;
    }

    public boolean echecDroit (Affichage affichage) {
        boolean bool = false;
        int limiteX = 8 - x;
        int limiteY = 8 - y;
        boolean barrage;
      /*  System.out.println("");
        System.out.println("##############DROIT####################");
        System.out.println(affichage.plateauEnum[x][y]);
        System.out.println("");

        System.out.println("");
        System.out.println("1");

       */
        barrage = false;
        for (int i = 1; i < limiteX; i++) {
            int resX = i + x; int resY = y;
            //System.out.println("i + x = " + resX + " ; y = " + resY);
            if (couleur == 0 && !barrage) {
                affichage.casesBlanches[i + x][y] = 1;
            }
            if (couleur == 1 && !barrage) {
                affichage.casesNoires[i + x][y] = 1;
            }
            if (((affichage.plateauEnum[i + x][y] == Affichage.typePiece.roi_B_ && couleur == 1) ||
                    affichage.plateauEnum[i + x][y] == Affichage.typePiece.roi_N_ && couleur == 0) && !barrage) {
                bool = echec();
            }
            if (affichage.plateauEnum[i + x][y] != Affichage.typePiece._vide_)
                barrage = true;
        }

        //System.out.println("");
        //System.out.println("2");
        barrage = false;
        for (int i = 1; i <= x; i++) {
            int resX = x - i; int resY = y;
            //System.out.println("x - i = " + resX + " ; y - j = " + resY);
            if (couleur == 0 && !barrage) {
                affichage.casesBlanches[x - i][y] = 1;
            }
            if (couleur == 1 && !barrage) {
                affichage.casesNoires[x - i][y] = 1;
            }
            if (((affichage.plateauEnum[x - i][y] == Affichage.typePiece.roi_B_ && couleur == 1) ||
                    affichage.plateauEnum[x - i][y] == Affichage.typePiece.roi_N_ && couleur == 0) && !barrage) {
                bool = echec();
            }
            if (affichage.plateauEnum[x - i][y] != Affichage.typePiece._vide_)
                barrage = true;
        }

        //System.out.println("");
        //System.out.println("3");
        barrage = false;
        for (int i = 1; i < limiteY; i++) {
            int resX = x; int resY = i + y;
            //System.out.println("x = " + resX + " ; i + y = " + resY);
            if (couleur == 0 && !barrage) {
                affichage.casesBlanches[x][i + y] = 1;
            }
            if (couleur == 1 && !barrage) {
                affichage.casesNoires[x][i + y] = 1;
            }
            if (((affichage.plateauEnum[x][i + y] == Affichage.typePiece.roi_B_ && couleur == 1) ||
                    affichage.plateauEnum[x][i + y] == Affichage.typePiece.roi_N_ && couleur == 0) && !barrage) {
                bool = echec();
            }
            if (affichage.plateauEnum[x][i + y] != Affichage.typePiece._vide_)
                barrage = true;
        }

        //System.out.println("");
        //System.out.println("4");
        barrage = false;
        for (int i = 1; i <= y; i++) {
            int resX = x; int resY = y - i;
            //System.out.println("x = " + resX + " ; y - i = " + resY);
            if (couleur == 0 && !barrage) {
                affichage.casesBlanches[x][y - i] = 1;
            }
            if (couleur == 1 && !barrage) {
                affichage.casesNoires[x][y - i] = 1;
            }
            if (((affichage.plateauEnum[x][y - i] == Affichage.typePiece.roi_B_ && couleur == 1) ||
                    affichage.plateauEnum[x][y - i] == Affichage.typePiece.roi_N_ && couleur == 0) && !barrage) {
                bool = echec();
            }
            if (affichage.plateauEnum[x][y - i] != Affichage.typePiece._vide_)
                barrage = true;
        }

        return bool;
    }

    public boolean echecDada (Affichage affichage) {
        boolean bool = false;
        /*System.out.println("");
        System.out.println("##############DADA####################");
        System.out.println(affichage.plateauEnum[x][y]);
        System.out.println("");

         */

        if (x > 1 && y < 7){
            if (couleur == 0) {
                affichage.casesBlanches[x - 2][y + 1] = 1;
            }
            if (couleur == 1) {
                affichage.casesNoires[x - 2][y + 1] = 1;
            }
            if (affichage.plateauEnum[x - 2][y + 1] == Affichage.typePiece.roi_B_ && couleur == 1
            || affichage.plateauEnum[x - 2][y + 1] == Affichage.typePiece.roi_N_ && couleur == 0) {
                bool = echec();
            }
        }

        if (x > 0 && y < 6){
            if (couleur == 0) {
                affichage.casesBlanches[x - 1][y + 2] = 1;
            }
            if (couleur == 1) {
                affichage.casesNoires[x - 1][y + 2] = 1;
            }
            if (affichage.plateauEnum[x - 1][y + 2] == Affichage.typePiece.roi_B_ && couleur == 1
                    || affichage.plateauEnum[x - 1][y + 2] == Affichage.typePiece.roi_N_ && couleur == 0) {
                bool = echec();
            }
        }

        if (x < 7 && y < 6){
            if (couleur == 0) {
                affichage.casesBlanches[x + 1][y + 2] = 1;
            }
            if (couleur == 1) {
                affichage.casesNoires[x + 1][y + 2] = 1;
            }
            if (affichage.plateauEnum[x + 1][y + 2] == Affichage.typePiece.roi_B_ && couleur == 1
                    || affichage.plateauEnum[x + 1][y + 2] == Affichage.typePiece.roi_N_ && couleur == 0) {
                bool = echec();
            }
        }

        if (x < 6 && y < 7){
            if (couleur == 0) {
                affichage.casesBlanches[x + 2][y + 1] = 1;
            }
            if (couleur == 1) {
                affichage.casesNoires[x + 2][y + 1] = 1;
            }
            if (affichage.plateauEnum[x + 2][y + 1] == Affichage.typePiece.roi_B_ && couleur == 1
                    || affichage.plateauEnum[x + 2][y + 1] == Affichage.typePiece.roi_N_ && couleur == 0) {
                bool = echec();
            }
        }

        if (x < 6 && y > 0){
            if (couleur == 0) {
                affichage.casesBlanches[x + 2][y - 1] = 1;
            }
            if (couleur == 1) {
                affichage.casesNoires[x + 2][y - 1] = 1;
            }
            if (affichage.plateauEnum[x + 2][y - 1] == Affichage.typePiece.roi_B_ && couleur == 1
                    || affichage.plateauEnum[x + 2][y - 1] == Affichage.typePiece.roi_N_ && couleur == 0) {
                bool = echec();
            }
        }

        if (x < 7 && y > 1){
            if (couleur == 0) {
                affichage.casesBlanches[x + 1][y - 2] = 1;
            }
            if (couleur == 1) {
                affichage.casesNoires[x + 1][y - 2] = 1;
            }
            if (affichage.plateauEnum[x + 1][y - 2] == Affichage.typePiece.roi_B_ && couleur == 1
                    || affichage.plateauEnum[x + 1][y - 2] == Affichage.typePiece.roi_N_ && couleur == 0) {
                bool = echec();
            }
        }

        if (x > 0 && y > 1){
            if (couleur == 0) {
                affichage.casesBlanches[x - 1][y - 2] = 1;
            }
            if (couleur == 1) {
                affichage.casesNoires[x - 1][y - 2] = 1;
            }
            if (affichage.plateauEnum[x - 1][y - 2] == Affichage.typePiece.roi_B_ && couleur == 1
                    || affichage.plateauEnum[x - 1][y - 2] == Affichage.typePiece.roi_N_ && couleur == 0) {
                bool = echec();
            }
        }

        if (x > 1 && y > 0){
            if (couleur == 0) {
                affichage.casesBlanches[x - 2][y - 1] = 1;
            }
            if (couleur == 1) {
                affichage.casesNoires[x - 2][y - 1] = 1;
            }
            if (affichage.plateauEnum[x - 2][y - 1] == Affichage.typePiece.roi_B_ && couleur == 1
                    || affichage.plateauEnum[x - 2][y - 1] == Affichage.typePiece.roi_N_ && couleur == 0) {
                bool = echec();
            }
        }

/*
        if ((affichage.plateauEnum[x - 2][y + 1] == Affichage.typePiece.roi_B_ && couleur == 1 && x > 1 && y < 7)
                || (affichage.plateauEnum[x - 2][y + 1] == Affichage.typePiece.roi_N_ && couleur == 0 && x > 1 && y < 7) ||
                (affichage.plateauEnum[x - 1][y + 2] == Affichage.typePiece.roi_B_ && couleur == 1 && x > 0 && y < 6)
                || (affichage.plateauEnum[x - 1][y + 2] == Affichage.typePiece.roi_N_ && couleur == 0 && x > 0 && y < 6) ||
                (affichage.plateauEnum[x + 1][y + 2] == Affichage.typePiece.roi_B_ && couleur == 1 && x < 7 && y < 6)
                || (affichage.plateauEnum[x + 1][y + 2] == Affichage.typePiece.roi_N_ && couleur == 0 && x < 7 && y < 6) ||
                (affichage.plateauEnum[x + 2][y + 1] == Affichage.typePiece.roi_B_ && couleur == 1 && x < 6 && y < 7)
                || (affichage.plateauEnum[x + 2][y + 1] == Affichage.typePiece.roi_N_ && couleur == 0 && x < 6 && y < 7) ||
                (affichage.plateauEnum[x + 2][y - 1] == Affichage.typePiece.roi_B_ && couleur == 1 && x < 6 && y > 0)
                || (affichage.plateauEnum[x + 2][y - 1] == Affichage.typePiece.roi_N_ && couleur == 0 && x < 6 && y > 0) ||
                (affichage.plateauEnum[x + 1][y - 2] == Affichage.typePiece.roi_B_ && couleur == 1 && x < 7 && y > 1)
                || (affichage.plateauEnum[x + 1][y - 2] == Affichage.typePiece.roi_N_ && couleur == 0 && x < 7 && y > 1) ||
                (affichage.plateauEnum[x - 1][y - 2] == Affichage.typePiece.roi_B_ && couleur == 1 && x > 0 && y > 1)
                || (affichage.plateauEnum[x - 1][y - 2] == Affichage.typePiece.roi_N_ && couleur == 0 && x > 0 && y > 1) ||
                (affichage.plateauEnum[x - 2][y - 1] == Affichage.typePiece.roi_B_ && couleur == 1 && x > 1 && y > 0)
                || (affichage.plateauEnum[x - 2][y - 1] == Affichage.typePiece.roi_N_ && couleur == 0 && x > 1 && y > 0)) {
            echec();
        }

 */
        return bool;
    }

    public boolean echecPion (Affichage affichage) {
        boolean bool = false;
     /*   System.out.println("");
        System.out.println("##############PION####################");
        System.out.println(affichage.plateauEnum[x][y]);
        System.out.println("");
*/
        // pions blancs
        if (couleur == 0 && x > 0) {
            if (y > 0) {
                affichage.casesBlanches[x - 1][y - 1] = 1;
                if (affichage.plateauEnum[x - 1][y - 1] == Affichage.typePiece.roi_N_) {
                    bool = echec();
                }
            }
            if (y < 7) {
                affichage.casesBlanches[x - 1][y + 1] = 1;
                if(affichage.plateauEnum[x - 1][y + 1] == Affichage.typePiece.roi_N_) {
                    bool = echec();
                }
            }
        }

        // pions noirs
        if (couleur == 1 && x < 7) {
            if (y > 0) {
                affichage.casesNoires[x + 1][y - 1] = 1;
                if (affichage.plateauEnum[x + 1][y - 1] == Affichage.typePiece.roi_B_) {
                    bool = echec();
                }
            }
            if (y < 7) {
                affichage.casesNoires[x + 1][y + 1] = 1;
                if(affichage.plateauEnum[x + 1][y + 1] == Affichage.typePiece.roi_B_) {
                    bool = echec();
                }
            }
        }
        return bool;
    }

    // nom un peu moins explicite
    // on détecte les cases menacées par le roi mais il ne peut pas mettre le roi adverse en échec mais juste le bloquer
    public void envahisseur (Affichage affichage) {
        if (couleur == 0) {
            if (x > 0 && y < 7)
                affichage.casesBlanches[x - 1][y + 1] = 1;
            if (y < 7)
                affichage.casesBlanches[x][y + 1] = 1;
            if (x < 7 && y < 7)
                affichage.casesBlanches[x + 1][y + 1] = 1;
            if (x < 7)
                affichage.casesBlanches[x + 1][y] = 1;
            if (x < 7 && y > 0)
                affichage.casesBlanches[x + 1][y - 1] = 1;
            if (y > 0)
                affichage.casesBlanches[x][y - 1] = 1;
            if (x > 0 && y > 0)
                affichage.casesBlanches[x - 1][y - 1] = 1;
            if (x > 0)
                affichage.casesBlanches[x - 1][y] = 1;
        }

        if (couleur == 1) {
            if (x > 0 && y < 7)
                affichage.casesNoires[x - 1][y + 1] = 1;
            if (y < 7)
                affichage.casesNoires[x][y + 1] = 1;
            if (x < 7 && y < 7)
                affichage.casesNoires[x + 1][y + 1] = 1;
            if (x < 7)
                affichage.casesNoires[x + 1][y] = 1;
            if (x < 7 && y > 0)
                affichage.casesNoires[x + 1][y - 1] = 1;
            if (y > 0)
                affichage.casesNoires[x][y - 1] = 1;
            if (x > 0 && y > 0)
                affichage.casesNoires[x - 1][y - 1] = 1;
            if (x > 0)
                affichage.casesNoires[x - 1][y] = 1;
        }
    }

    public boolean echec() {
        //System.out.println("Echec !");
        return true;
    }
}

