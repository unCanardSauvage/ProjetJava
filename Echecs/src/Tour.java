//package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Tour extends Piece {

    // Constructeur
    public Tour (int x, int y, int couleur) {

        super(x, y, couleur);
    }

    // Méthodes
    public Pane dessiner (int x, int y, int couleur, Color color) {

        x = x * 75 + 188;
        y = y * 75 + 62;

        System.out.print("| Tour ");

        Pane tour = new Pane();

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
        jeton.setRadius(22);
        jeton.setFill(uneCouleur);
        jeton.setStroke(unCoutour);
        jeton.setStrokeWidth(2);
        tour.getChildren().add(jeton);

        Circle circle = new Circle();
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setRadius(27);
        circle.setFill(Color.rgb(0, 0, 0, 0.0));
        circle.setStroke(unCoutour);
        circle.setStrokeWidth(1);
        tour.getChildren().add(circle);


        Line line1 = new Line(x - 11,y + 7,x + 11,y + 7);
        Line line2 = new Line(x + 11,y + 7,x + 11,y + 14);
        Line line3 = new Line(x + 11,y + 14,x - 11,y + 14);
        Line line4 = new Line(x - 11,y + 14,x - 11,y + 7);
        line1.setStroke(unCoutour);
        line2.setStroke(unCoutour);
        line3.setStroke(unCoutour);
        line4.setStroke(unCoutour);
        tour.getChildren().addAll(line1, line2, line3, line4);

        Line line5 = new Line(x - 8,y + 7,x + 8,y + 7);
        Line line6 = new Line(x + 8,y + 7,x + 8,y - 7);
        Line line7 = new Line(x + 8,y - 7,x - 8,y - 7);
        Line line8 = new Line(x - 8,y - 7,x - 8,y + 7);
        line5.setStroke(unCoutour);
        line6.setStroke(unCoutour);
        line7.setStroke(unCoutour);
        line8.setStroke(unCoutour);
        tour.getChildren().addAll(line5, line6, line7, line8);

        Line line25 = new Line(x - 8,y + 3.5,x + 8,y + 3.5);
        Line line26 = new Line(x - 8, y,x + 8, y);
        Line line27 = new Line(x - 8,y -3.5,x + 8,y -3.5);
        line25.setStroke(unCoutour);
        line26.setStroke(unCoutour);
        line27.setStroke(unCoutour);
        tour.getChildren().add(line25);
        tour.getChildren().add(line26);
        tour.getChildren().add(line27);

        Line line9  = new Line(x + 11,y - 7,x - 11,y - 7);
        Line line10 = new Line(x - 11,y - 7,x - 11,y - 10);
        Line line11 = new Line(x - 11,y - 10,x + 11,y - 10);
        Line line12 = new Line(x + 11,y - 10,x + 11,y - 7);
        line9.setStroke(unCoutour);
        line10.setStroke(unCoutour);
        line11.setStroke(unCoutour);
        line12.setStroke(unCoutour);
        tour.getChildren().addAll(line9, line10, line11, line12);

        Line line13 = new Line(x - 13,y - 10,x - 13,y - 13);
        Line line14 = new Line(x - 13,y - 13,x - 8,y - 13);
        Line line15 = new Line(x - 8,y - 13,x - 8,y - 10);
        Line line16 = new Line(x - 8,y - 10,x - 13,y - 10);
        line13.setStroke(unCoutour);
        line14.setStroke(unCoutour);
        line15.setStroke(unCoutour);
        line16.setStroke(unCoutour);
        tour.getChildren().addAll(line13, line14, line15, line16);

        Line line17 = new Line(x - 3,y - 10,x - 3,y - 13);
        Line line18 = new Line(x - 3,y - 13,x + 3,y - 13);
        Line line19 = new Line(x + 3,y - 13,x + 3,y - 10);
        Line line20 = new Line(x + 3,y - 10,x - 3,y - 10);
        line17.setStroke(unCoutour);
        line18.setStroke(unCoutour);
        line19.setStroke(unCoutour);
        line20.setStroke(unCoutour);
        tour.getChildren().addAll(line17, line18, line19, line20);

        Line line21 = new Line(x + 13,y - 10,x + 13,y - 13);
        Line line22 = new Line(x + 13,y - 13,x + 8,y - 13);
        Line line23 = new Line(x + 8,y - 13,x + 8,y - 10);
        Line line24 = new Line(x + 8,y - 10,x + 13,y - 10);
        line21.setStroke(unCoutour);
        line22.setStroke(unCoutour);
        line23.setStroke(unCoutour);
        line24.setStroke(unCoutour);
        tour.getChildren().addAll(line21, line22, line23, line24);


        return tour;
    }

    public void deplacement (int x, int y, Pane pane, Affichage affichage) {
        int X, Y;
        int deltaX;
        int deltaY;
        int sauteMoutonX = x;
        int sauteMoutonY = y;

        int xtemp, ytemp;
        xtemp = getX();
        ytemp = getY();

        System.out.println("Je suis tour !");
/*
        System.out.println("fou avant : getX() = " + getX() + " ; getY() = " + getY());
        System.out.println("fou avant : getxGraph() = " + getxGraph() + " ; getyGraph() = " + getyGraph());

 */

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

        antiSauteMoutonDroit(deltaX, deltaY, X, Y, affichage);

        if(((X != 0 && Y == 0) || (X == 0 && Y != 0)) && !saut){

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

        System.out.println("couleur : " + getCouleur());

    }

}
