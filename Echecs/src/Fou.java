//package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;



public class Fou extends Piece {

    // Constructeur
    public Fou (int x, int y, int couleur) {
        super(x, y, couleur);

    }

    // Méthodes
    public Pane dessiner (int x, int y, int couleur, Color color) {

        x = x * 75 + 188;
        y = y * 75 + 62;

        System.out.print("| Fou  ");

        Pane fou = new Pane();

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
        jeton.setRadius(23);
        jeton.setFill(uneCouleur);
        jeton.setStroke(unCoutour);
        jeton.setStrokeWidth(2);
        fou.getChildren().add(jeton);

        Circle circle1 = new Circle();
        circle1.setCenterX(x);
        circle1.setCenterY(y - 15);
        circle1.setRadius(2);
        circle1.setFill(uneCouleur);
        circle1.setStroke(unCoutour);
        circle1.setStrokeWidth(1);
        fou.getChildren().add(circle1);

        Circle circle2 = new Circle();
        circle2.setCenterX(x);
        circle2.setCenterY(y - 7);
        circle2.setRadius(5);
        circle2.setFill(uneCouleur);
        circle2.setStroke(unCoutour);
        circle2.setStrokeWidth(1);
        fou.getChildren().add(circle2);


        Line line1 = new Line(x + 1,y - 1 ,x + 6,y + 13);
        Line line2 = new Line(x - 1,y - 1 ,x - 6,y + 13);
        Line line3 = new Line(x - 6,y + 13,x + 6,y + 13);
        line1.setStroke(unCoutour);
        line2.setStroke(unCoutour);
        line3.setStroke(unCoutour);
        fou.getChildren().addAll(line1, line2, line3);

        Line line4 = new Line(x - 7,y + 13 ,x + 7,y + 13);
        Line line5 = new Line(x + 7,y +13 ,x + 7,y + 16);
        Line line6 = new Line(x + 7,y + 16,x - 7,y + 16);
        Line line7 = new Line(x - 7,y + 16,x - 7,y + 13);
        line4.setStroke(unCoutour);
        line5.setStroke(unCoutour);
        line6.setStroke(unCoutour);
        line7.setStroke(unCoutour);
        fou.getChildren().addAll(line4, line5, line6, line7);

        return fou;
    }

    public void deplacement (int x, int y, Pane pane, Affichage affichage) {
        int X, Y;
        int deltaX;
        int deltaY;

        // System.out.println("fou avant : x = " + x + " ; y = " + y);

        int xtemp, ytemp; // ces variables temporaires servent à stocker les coordonées de la pièce afin de lui réassigner
        // dans le cas où le joueur décide de tenter un mouvement illégal
        xtemp = getX();
        ytemp = getY();

        System.out.println("Je suis fou !");
//        System.out.println("fou avant : getX() = " + getX() + " ; getY() = " + getY());
        //      System.out.println("fou avant : getxGraph() = " + getxGraph() + " ; getyGraph() = " + getyGraph());

        deltaX = getDeltaX();
        deltaY = getDeltaY();

        setX(x);
        setY(y);

        //System.out.println("x = " + x + " y = " + y);
        //System.out.println("dx = " + deltaX + " dy = " + deltaY);

        x -= deltaX;
        y -= deltaY;

        //System.out.println("x - dx = " + x + " y - dy = " + y);

        X = getX() + deltaX;
        Y = getY() + deltaY;
        X = x;
        Y = y;

       // System.out.println("fou avant if : X = " + X + " ; Y = " + Y);

        depX = X;
        depY = Y;

        X = depX;
        Y = depY;


        antiSauteMoutonDiag(deltaX, deltaY, X, Y, affichage);

        //System.out.println("depX = " + depX + " depY = " + depY);
        if((X == Y || X == -Y) && X != 0 && !saut){

            //System.out.println("X = " + X + " Y = " + Y);

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
            //System.out.println("Je me déplace de X = " + X + " et Y = " + Y);
            translate.play();
/*
            System.out.println("fou apres : getX() = " + getX() + " ; getY() = " + getY());
            System.out.println("fou apres : getxGraph() = " + getxGraph() + " ; getyGraph() = " + getyGraph());
            System.out.println("fou : getDeltaX() = " + getDeltaX() + " ; getDeltaY() = " + getDeltaY());

 */
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

        System.out.println("fou isMouvementIllicite : " + isMouvementIllicite());
        //System.out.println("Je suis fou !!");

    }



}
