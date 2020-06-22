//package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Roi extends Piece {

    // Constructeur
    public Roi (int x, int y, int couleur) {
        super(x, y, couleur);
    }

    // Méthodes
    public Pane dessiner (int x, int y, int couleur, Color color) {

        x = x * 75 + 188;
        y = y * 75 + 62;

        System.out.print("| Roi  ");

        Pane roi = new Pane();

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

        Circle jeton = new Circle();
        jeton.setCenterX(x);
        jeton.setCenterY(y);
        jeton.setRadius(35);
        jeton.setFill(Color.rgb(0,0,0,0.0));
        jeton.setStroke(unCoutour);
        jeton.setStrokeWidth(2);
        roi.getChildren().add(jeton);

        Circle circle1 = new Circle();
        circle1.setCenterX(x);
        circle1.setCenterY(y);
        circle1.setRadius(31);
        circle1.setFill(uneCouleur);
        circle1.setStroke(unCoutour);
        circle1.setStrokeWidth(1);
        roi.getChildren().add(circle1);

        Circle circle2 = new Circle();
        circle2.setCenterX(x);
        circle2.setCenterY(y);
        circle2.setRadius(26);
        circle2.setFill(uneCouleur);
        circle2.setStroke(unCoutour);
        circle2.setStrokeWidth(2);
        roi.getChildren().add(circle2);


        Line line1 = new Line(x - 1,y - 22,x + 1,y - 22);
        Line line2 = new Line(x + 1,y - 22,x + 1,y - 19);
        Line line3 = new Line(x + 1,y - 19,x + 3,y - 19);
        Line line4 = new Line(x + 3,y - 19,x + 3,y - 17);
        Line line5 = new Line(x + 3,y - 17,x + 1,y - 17);
        Line line6 = new Line(x + 1,y - 17,x + 1,y - 10);
        line1.setStroke(unCoutour);
        line2.setStroke(unCoutour);
        line3.setStroke(unCoutour);
        line4.setStroke(unCoutour);
        line5.setStroke(unCoutour);
        line6.setStroke(unCoutour);
        roi.getChildren().addAll(line1, line2, line3, line4, line5, line6);

        Line line7  = new Line(x - 1,y - 22,x - 1,y - 19);
        Line line8  = new Line(x - 1,y - 19,x - 3,y - 19);
        Line line9  = new Line(x - 3,y - 19,x - 3,y - 17);
        Line line10 = new Line(x - 3,y - 17,x - 1,y - 17);
        Line line11 = new Line(x - 1,y - 17,x - 1,y - 10);
        Line line12 = new Line(x - 1,y - 10,x + 1,y - 10);
        line7.setStroke(unCoutour);
        line8.setStroke(unCoutour);
        line9.setStroke(unCoutour);
        line10.setStroke(unCoutour);
        line11.setStroke(unCoutour);
        line12.setStroke(unCoutour);
        roi.getChildren().addAll(line7, line8, line9, line10, line11, line12);

        Line line13 = new Line(x + 2,y - 10, x + 8, y - 10);
        Line line14 = new Line(x + 8,y - 10, x + 12, y - 8);
        Line line15 = new Line(x + 12,y - 8, x + 14, y - 6);
        Line line16 = new Line(x + 14,y - 6, x + 14, y + 1);
        line13.setStroke(unCoutour);
        line14.setStroke(unCoutour);
        line15.setStroke(unCoutour);
        line16.setStroke(unCoutour);
        roi.getChildren().addAll(line13, line14, line15, line16);

        Line line17 = new Line(x - 2,y - 10, x - 8, y - 10);
        Line line18 = new Line(x - 8,y - 10, x - 12, y - 8);
        Line line19 = new Line(x - 12,y - 8, x - 14, y - 6);
        Line line20 = new Line(x - 14,y - 6, x - 14, y + 1);
        line17.setStroke(unCoutour);
        line18.setStroke(unCoutour);
        line19.setStroke(unCoutour);
        line20.setStroke(unCoutour);
        roi.getChildren().addAll(line17, line18, line19, line20);

        Line line21 = new Line(x - 2,y - 10, x - 2, y + 1);
        Line line22 = new Line(x + 2,y - 10, x + 2, y + 1);
        line21.setStroke(unCoutour);
        line22.setStroke(unCoutour);
        roi.getChildren().addAll(line21, line22);

        Line line23 = new Line(x - 2,y - 6,x + 2,y - 6);
        Line line24 = new Line(x - 2,y - 8,x + 2,y - 8);
        line23.setStroke(unCoutour);
        line24.setStroke(unCoutour);
        roi.getChildren().addAll(line23, line24);

        Line line25 = new Line(x - 14,y + 1, x + 14, y + 1);
        Line line26 = new Line(x + 14,y + 1, x + 14, y + 3);
        Line line27 = new Line(x +14,y + 3, x - 14, y + 3);
        Line line28 = new Line(x - 14,y + 3, x - 14, y + 1);
        line25.setStroke(unCoutour);
        line26.setStroke(unCoutour);
        line27.setStroke(unCoutour);
        line28.setStroke(unCoutour);
        roi.getChildren().addAll(line25, line26, line27, line28);

        Line line29 = new Line(x - 15,y + 10, x + 15, y + 10);
        Line line30 = new Line(x + 15,y + 10, x + 15, y + 3);
        Line line31 = new Line(x +15,y + 3, x - 15, y + 3);
        Line line32 = new Line(x - 15,y + 3, x - 15, y + 10);
        line29.setStroke(unCoutour);
        line30.setStroke(unCoutour);
        line31.setStroke(unCoutour);
        line32.setStroke(unCoutour);
        roi.getChildren().addAll(line29, line30, line31, line32);

        Line line33 = new Line(x - 15,y + 10, x + 15, y + 10);
        Line line34 = new Line(x + 15,y + 10, x + 15, y + 13);
        Line line35 = new Line(x +15,y + 13, x - 15, y + 13);
        Line line36 = new Line(x - 15,y + 13, x - 15, y + 10);
        line33.setStroke(unCoutour);
        line34.setStroke(unCoutour);
        line35.setStroke(unCoutour);
        line36.setStroke(unCoutour);
        roi.getChildren().addAll(line33, line34, line35, line36);


        return roi;
    }

    public void deplacement (int x, int y, Pane pane, Affichage affichage) {
        int X, Y;
        int deltaX;
        int deltaY;

        int xtemp, ytemp;
        xtemp = getX();
        ytemp = getY();

        System.out.println("Je suis roi !");

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

        boolean enEchec = false;
        if (couleur == 0) {
            if (affichage.casesNoires[xtemp + X][ytemp + Y] == 1) {
                enEchec = true;
                echec();
            }
        }

        if (couleur == 1) {
            if (affichage.casesBlanches[xtemp + X][ytemp + Y] == 1) {
                enEchec = true;
                echec();
            }
        }

        if(((X == Y || X == -Y) && (X == 1 || X == -1) || (X == 1 && Y == 0) || (X == 0 && Y == 1)|| (X == -1 && Y == 0) || (X == 0 && Y == -1))
        && !enEchec){

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
        }

        else {
            System.out.println("tri aguin");
            setX(xtemp);
            setY(ytemp);
            setMouvementIllicite(true);
        }

    }

    public boolean estEchec (Affichage affichage) {
        boolean enEchec = false;
/*        System.out.println("");
        System.out.println("##############ROI####################");
        System.out.println(affichage.plateauEnum[x][y]);
        System.out.println("");

 */

        //affichage.verifEchec(affichage.tourJoueur);

        // il faut regarder si le roi est en position d'échec ou s'il y va
        if (couleur == 0) {
            if (affichage.casesNoires[x][y] == 1) {
                //System.out.println("##############ROI ECHEC####################");
                enEchec = true;
                echec();
            }
        }

        if (couleur == 1) {
            if (affichage.casesBlanches[x][y] == 1) {
                //System.out.println("##############ROI ECHEC####################");
                enEchec = true;
                echec();
            }
        }

        return enEchec;
    }

}
