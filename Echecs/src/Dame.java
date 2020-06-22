//package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Dame extends Piece {

    // Constructeur
    public Dame (int x, int y, int couleur) {
        super(x, y, couleur);
    }

    // Méthodes
    public Pane dessiner (int x, int y, int couleur, Color color) {

        x = x * 75 + 188;
        y = y * 75 + 62;

        System.out.print("| Dame ");

        Pane dame = new Pane();

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
        jeton.setRadius(30);
        jeton.setFill(uneCouleur);
        jeton.setStroke(unCoutour);
        jeton.setStrokeWidth(3);
        dame.getChildren().add(jeton);


        Circle circle1 = new Circle();
        circle1.setCenterX(x);
        circle1.setCenterY(y - 15);
        circle1.setRadius(3);
        circle1.setFill(uneCouleur);
        circle1.setStroke(unCoutour);
        circle1.setStrokeWidth(1);
        dame.getChildren().add(circle1);

        Circle circle2 = new Circle();
        circle2.setCenterX(x + 16);
        circle2.setCenterY(y - 10);
        circle2.setRadius(2);
        circle2.setFill(uneCouleur);
        circle2.setStroke(unCoutour);
        circle2.setStrokeWidth(1);
        dame.getChildren().add(circle2);

        Circle circle3 = new Circle();
        circle3.setCenterX(x - 16);
        circle3.setCenterY(y - 10);
        circle3.setRadius(2);
        circle3.setFill(uneCouleur);
        circle3.setStroke(unCoutour);
        circle3.setStrokeWidth(1);
        dame.getChildren().add(circle3);

        Line line1 = new Line(x + 13,y + 13,x - 13,y + 13);
        Line line2 = new Line(x - 13,y + 13,x - 16,y - 7);
        Line line3 = new Line(x - 16,y - 7,x - 7,y + 2);
        Line line4 = new Line(x - 7,y + 2, x,y - 12);
        Line line5 = new Line(x,y - 12,x + 7,y + 2);
        Line line6 = new Line(x + 7,y + 2,x + 16,y - 7);
        Line line7 = new Line(x + 16,y - 7,x + 13,y + 13);
        line1.setStroke(unCoutour);
        line2.setStroke(unCoutour);
        line3.setStroke(unCoutour);
        line4.setStroke(unCoutour);
        line5.setStroke(unCoutour);
        line6.setStroke(unCoutour);
        line7.setStroke(unCoutour);
        dame.getChildren().addAll(line1, line2, line3, line4, line5, line6, line7);


        return dame;
    }

    public void deplacement (int x, int y, Pane pane, Affichage affichage) {
        int X, Y;
        int deltaX;
        int deltaY;

        int xtemp, ytemp;
        xtemp = getX();
        ytemp = getY();

        System.out.println("Je suis dame !");

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

        // il faut vérifier la direction de la dame
        if ((X != 0 && Y == 0) || (X == 0 && Y != 0))
            antiSauteMoutonDroit(deltaX, deltaY, X, Y, affichage);
        else
            antiSauteMoutonDiag(deltaX, deltaY, X, Y, affichage);

        if((((X == Y || X == -Y) && X != 0) || ((X != 0 && Y == 0) || (X == 0 && Y != 0))) && !saut){

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
            System.out.println("ECHEC TEST");
            //echecDiag(affichage);
            System.out.println("ECHEC TEST FIN");
        }

        else {
            System.out.println("tri aguin");
            setX(xtemp);
            setY(ytemp);
            setMouvementIllicite(true);
        }

    }
}
