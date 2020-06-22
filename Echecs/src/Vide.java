import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Vide extends Piece {

    // Constructeur
    public Vide (int x, int y, int couleur) {
        super(x, y, couleur);
    }


    // Méthodes
    public Pane dessiner (int x, int y, int couleur, Color color) {

        x = x * 75 + 150;
        y = y * 75 + 25;

        //System.out.println("Je suis vide !");

        System.out.print("| Vide ");

        Pane vide = new Pane();

        Rectangle case_vide = new Rectangle();
        case_vide.setX(x);
        case_vide.setY(y);
        case_vide.setWidth(75);
        case_vide.setHeight(75);
        case_vide.setFill(Color.rgb(0,123,0,0.0));
        vide.getChildren().add(case_vide);

        setxGraph(0);
        setyGraph(0);

        return vide;
    }

    public void deplacement(int x, int y, Pane pane, Affichage affichage){
        int X, Y;
        int deltaX;
        int deltaY;

        System.out.println("Je suis vide !");
      //  System.out.println("vide avant : getX() = " + getX() + " ; getY() = " + getY());
        //System.out.println("vide avant : getxGraph() = " + getxGraph() + " ; getyGraph() = " + getyGraph());

        setX(x);
        setY(y);


        deltaX = getDeltaX();
        deltaY = getDeltaY();

        x -= deltaX;
        y -= deltaY;


        X = getX() + deltaX;
        Y = getY() + deltaY;
        X = -x;
        Y = -y;

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

  /*      System.out.println("vide apres : getX() = " + getX() + " ; getY() = " + getY());
        System.out.println("vide apres : getxGraph() = " + getxGraph() + " ; getyGraph() = " + getyGraph());
        System.out.println("vide : getDeltaX() = " + getDeltaX() + " ; getDeltaY() = " + getDeltaY());

   */

    }
}
