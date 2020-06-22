//package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class Dada extends Piece {

    // Constructeur
    public Dada (int x, int y, int couleur) {
        super(x, y, couleur);
    }

    // Méthodes
    public Pane dessiner (int x, int y, int couleur, Color color) {

        x = x * 75 + 188;
        y = y * 75 + 62;

        System.out.print("| Dada ");

        Pane dada = new Pane();

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
        jeton.setStrokeWidth(1);
        dada.getChildren().add(jeton);

        Circle circle1 = new Circle();
        circle1.setCenterX(x);
        circle1.setCenterY(y);
        circle1.setRadius(24);
        circle1.setFill(Color.rgb(0,0,0,0.0));
        circle1.setStroke(unCoutour);
        circle1.setStrokeWidth(1);
        dada.getChildren().add(circle1);

        Circle circle2 = new Circle();
        circle2.setCenterX(x);
        circle2.setCenterY(y);
        circle2.setRadius(23);
        circle2.setFill(Color.rgb(0,0,0,0.0));
        circle2.setStroke(uneCouleur);
        circle2.setStrokeWidth(1);
        dada.getChildren().add(circle2);


        Line line1 = new Line(x - 12,y + 18,x + 12,y + 18);
        Line line2 = new Line(x + 12,y + 18,x + 12,y + 12);
        Line line3 = new Line(x + 12,y + 12,x - 12,y + 12);
        Line line4 = new Line(x - 12,y + 12,x - 12,y + 18);
        line1.setStroke(unCoutour);
        line2.setStroke(unCoutour);
        line3.setStroke(unCoutour);
        line4.setStroke(unCoutour);
        dada.getChildren().addAll(line1, line2, line3, line4);

        Line line5 = new Line(x - 9,y + 12,x - 9,y + 9);
        Line line6 = new Line(x - 9,y + 9,x - 3,y);
        Line line7 = new Line(x - 3,y,x - 3,y - 6);
        Line line8 = new Line(x - 3,y - 6,x,y - 7);
        Line line26 = new Line(x,y - 7,x + 2,y - 9);
        line5.setStroke(unCoutour);
        line6.setStroke(unCoutour);
        line7.setStroke(unCoutour);
        line8.setStroke(unCoutour);
        line26.setStroke(unCoutour);
        dada.getChildren().addAll(line5, line6, line7, line8, line26);

        Line line9  = new Line(x + 13,y + 9,x + 13,y - 10);
        Line line10 = new Line(x + 13,y - 10,x + 9,y - 18);
        Line line11 = new Line(x + 9,y - 18,x + 5,y - 18);
        Line line12 = new Line(x + 5,y - 18,x + 9,y - 10);
        Line line13 = new Line(x + 9,y - 10,x + 9,y + 12);
        Line line14 = new Line(x + 9,y + 12,x + 13,y + 9);
        line9.setStroke(unCoutour);
        line10.setStroke(unCoutour);
        line11.setStroke(unCoutour);
        line12.setStroke(unCoutour);
        line13.setStroke(unCoutour);
        line14.setStroke(unCoutour);
        dada.getChildren().addAll(line9, line10, line11, line12, line13, line14);
        // oreilles
        Line line15 = new Line(x + 5,y - 18,x + 1,y - 24);
        Line line16 = new Line(x + 1,y - 24,x - 1,y - 18);
        line15.setStroke(unCoutour);
        line16.setStroke(unCoutour);
        dada.getChildren().addAll(line15, line16);

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(x - 0.0, y - 20.0, x - 5.0, y - 19.0, x - 2.0, y - 24.0);
        polygon.setFill(unCoutour);
        dada.getChildren().add(polygon);

        Line line17 = new Line(x - 1,y - 20,x - 6,y - 18);
        Line line18 = new Line(x - 6,y - 18,x - 9 ,y - 12);
        Line line19 = new Line(x - 9,y - 12,x - 13,y - 9);
        Line line20 = new Line(x - 13,y - 9,x - 15 ,y - 6);
        Line line21 = new Line(x - 15,y - 6,x - 9,y - 1);
        Line line22 = new Line(x - 9,y - 1,x - 5 ,y - 5);
        Line line23 = new Line(x - 5,y - 5,x - 3,y - 6);
        line17.setStroke(unCoutour);
        line18.setStroke(unCoutour);
        line19.setStroke(unCoutour);
        line20.setStroke(unCoutour);
        line21.setStroke(unCoutour);
        line22.setStroke(unCoutour);
        line23.setStroke(unCoutour);
        dada.getChildren().addAll(line17, line18, line19, line20, line21, line22, line23);

        Line line24 = new Line(x - 12,y - 4,x - 9,y - 5);
        Line line25 = new Line(x - 9,y - 5,x - 8,y - 6);
        line24.setStroke(unCoutour);
        line25.setStroke(unCoutour);
        dada.getChildren().addAll(line24, line25);

        Circle circle3 = new Circle();
        circle3.setCenterX(x - 3);
        circle3.setCenterY(y - 15);
        circle3.setRadius(0.75);
        circle3.setFill(unCoutour);
        dada.getChildren().add(circle3);


        return dada;
    }

    public void deplacement (int x, int y, Pane pane, Affichage affichage) {
        int X, Y;
        int deltaX;
        int deltaY;

        int xtemp, ytemp;
        xtemp = getX();
        ytemp = getY();

        System.out.println("Je suis dada !");

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

        if((X == 2 * Y || X == -2 * Y || 2 * X == Y || -2 * X == Y) && X != 0){

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
}
