import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Menu extends Parent {

    Color color1 = Color.BLACK;
    Color color = Color.DARKGRAY;

    public Menu(Stage primaryStage) {



        // limite les proportions de la fenêtre afin de conserver une experience de jeu décente
        // (jouer avec l'entièreté du plateau est mieux)

        primaryStage.setMinHeight(635);
        primaryStage.setMinWidth(615);
        primaryStage.setMaxHeight(635);
        primaryStage.setMaxWidth(615);

        backgroundMenu();

        this.getChildren().add(jouer());
        this.getChildren().add(couleur());

    }

    public void backgroundMenu() {

        this.getChildren().removeAll();

        for (int i = 0; i < 600; i = i + 150) {
            for (int j = 0; j < 600; j = j + 150){
                Rectangle case_blanche = new Rectangle();
                case_blanche.setX(i);
                case_blanche.setY(j);
                case_blanche.setWidth(75);
                case_blanche.setHeight(75);
                case_blanche.setFill(Color.BLANCHEDALMOND);
                case_blanche.setStroke(color1);
                case_blanche.setStrokeWidth(1);
                //case_blanche.setArcHeight(30);
                //case_blanche.setArcWidth(30);

                this.getChildren().add(case_blanche);

                Rectangle case_noire = new Rectangle();
                case_noire.setX(i + 75);
                case_noire.setY(j);
                case_noire.setWidth(75);
                case_noire.setHeight(75);
                case_noire.setFill(color1);
                case_noire.setStroke(Color.BLANCHEDALMOND);
                case_noire.setStrokeWidth(1);
                //case_noire.setArcHeight(30);
                //case_noire.setArcWidth(30);

                this.getChildren().add(case_noire);
            }
        }

        for (int i = 0; i < 600; i = i + 150) {
            for (int j = 75; j < 600; j = j + 150) {
                Rectangle case_noire = new Rectangle();
                case_noire.setX(i);
                case_noire.setY(j);
                case_noire.setWidth(75);
                case_noire.setHeight(75);
                case_noire.setFill(color1);
                case_noire.setStroke(Color.BLANCHEDALMOND);
                case_noire.setStrokeWidth(1);
                //case_noire.setArcHeight(30);
                //case_noire.setArcWidth(30);

                this.getChildren().add(case_noire);

                Rectangle case_blanche = new Rectangle();
                case_blanche.setX(i + 75);
                case_blanche.setY(j);
                case_blanche.setWidth(75);
                case_blanche.setHeight(75);
                case_blanche.setFill(Color.BLANCHEDALMOND);
                case_blanche.setStroke(color1);
                case_blanche.setStrokeWidth(1);
                //case_blanche.setArcHeight(30);
                //case_blanche.setArcWidth(30);

                this.getChildren().add(case_blanche);
            }
        }

        // M
        int x = 150; int y = 38;
        Line line1 = new Line(x, y,x + 19, y);
        Line line2 = new Line(x + 19, y,x + 38,y + 19);
        Line line3 = new Line(x + 38,y + 19,x + 57 , y);
        Line line4 = new Line(x + 57, y,x + 76, y);
        Line line5 = new Line (x + 76, y, x + 76, y + 76);
        Line line6 = new Line (x + 76, y + 76, x + 57, y + 76);
        Line line7 = new Line(x + 57,y + 76,x + 57, y + 28);
        Line line8 = new Line(x + 57,y + 28,x + 38 , y + 47);
        Line line9 = new Line(x + 38,y + 47,x + 19,y + 28);
        Line line10 = new Line(x + 19, y + 28,x + 19, y + 76);
        Line line11 = new Line(x + 19, y + 76, x, y + 76);
        Line line12 = new Line(x, y + 76, x, y);
        line1.setStroke(color);
        line2.setStroke(color);
        line3.setStroke(color);
        line4.setStroke(color);
        line5.setStroke(color);
        line6.setStroke(color);
        line7.setStroke(color);
        line8.setStroke(color);
        line9.setStroke(color);
        line10.setStroke(color);
        line11.setStroke(color);
        line12.setStroke(color);
        line1.setStrokeWidth(4);
        line2.setStrokeWidth(4);
        line3.setStrokeWidth(4);
        line4.setStrokeWidth(4);
        line5.setStrokeWidth(4);
        line6.setStrokeWidth(4);
        line7.setStrokeWidth(4);
        line8.setStrokeWidth(4);
        line9.setStrokeWidth(4);
        line10.setStrokeWidth(4);
        line11.setStrokeWidth(4);
        line12.setStrokeWidth(4);
        this.getChildren().addAll(line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11, line12);

        // E
        x = 235; y = 38;
        Line line21 = new Line(x, y,x + 57, y);
        Line line22 = new Line(x + 57, y,x + 57,y + 19);
        Line line23 = new Line(x + 57,y + 19,x + 19 , y + 19);
        Line line24 = new Line(x + 19, y + 19,x + 19, y + 29);
        Line line25 = new Line (x + 19, y + 29, x + 57, y + 29);
        Line line26 = new Line (x + 57, y + 29, x + 57, y + 48);
        Line line27 = new Line(x + 57,y + 48,x + 19, y + 48);
        Line line28 = new Line(x + 19,y + 48,x + 19 , y + 57);
        Line line29 = new Line(x + 19,y + 57,x + 57,y + 57);
        Line line30 = new Line(x + 57, y + 57,x + 57, y + 76);
        Line line31 = new Line(x + 57, y + 76, x, y + 76);
        Line line32 = new Line(x, y + 76, x, y);
        line21.setStroke(color);
        line22.setStroke(color);
        line23.setStroke(color);
        line24.setStroke(color);
        line25.setStroke(color);
        line26.setStroke(color);
        line27.setStroke(color);
        line28.setStroke(color);
        line29.setStroke(color);
        line30.setStroke(color);
        line31.setStroke(color);
        line32.setStroke(color);
        line21.setStrokeWidth(4);
        line22.setStrokeWidth(4);
        line23.setStrokeWidth(4);
        line24.setStrokeWidth(4);
        line25.setStrokeWidth(4);
        line26.setStrokeWidth(4);
        line27.setStrokeWidth(4);
        line28.setStrokeWidth(4);
        line29.setStrokeWidth(4);
        line30.setStrokeWidth(4);
        line31.setStrokeWidth(4);
        line32.setStrokeWidth(4);
        this.getChildren().addAll(line21, line22, line23, line24, line25, line26, line27, line28, line29, line30, line31, line32);

        // N
        x = 310; y = 38;
        Line line41 = new Line(x, y,x + 19, y);
        Line line42 = new Line(x + 19, y,x + 38,y + 38);
        Line line43 = new Line(x + 38,y + 38,x + 38 , y);
        Line line40 = new Line(x + 38, y,x + 57 , y);
        Line line44 = new Line(x + 57, y,x + 57, y + 76);
        Line line45 = new Line (x + 57, y + 76, x + 38, y + 76);
        Line line46 = new Line (x + 38, y + 76, x + 19, y + 38);
        Line line47 = new Line(x + 19,y + 38,x + 19, y + 76);
        Line line48 = new Line(x + 19,y + 76, x, y + 76);
        Line line49 = new Line(x,y + 76, x, y);
        line41.setStroke(color);
        line42.setStroke(color);
        line43.setStroke(color);
        line44.setStroke(color);
        line45.setStroke(color);
        line46.setStroke(color);
        line47.setStroke(color);
        line48.setStroke(color);
        line49.setStroke(color);
        line40.setStroke(color);
        line41.setStrokeWidth(4);
        line42.setStrokeWidth(4);
        line43.setStrokeWidth(4);
        line44.setStrokeWidth(4);
        line45.setStrokeWidth(4);
        line46.setStrokeWidth(4);
        line47.setStrokeWidth(4);
        line48.setStrokeWidth(4);
        line49.setStrokeWidth(4);
        line40.setStrokeWidth(4);
        this.getChildren().addAll(line41, line42, line43, line40, line44, line45, line46, line47, line48, line49);

        // U
        x = 385; y = 38;
        Line line51 = new Line(x, y,x + 19, y);
        Line line52 = new Line(x + 19, y,x + 19,y + 57);
        Line line53 = new Line(x + 19,y + 57,x + 38 , y + 57);
        Line line54 = new Line(x + 38, y + 57,x + 38, y);
        Line line55 = new Line (x + 38, y, x + 57, y);
        Line line56 = new Line (x + 57, y, x + 57, y + 76);
        Line line57 = new Line(x + 57,y + 76, x, y + 76);
        Line line58 = new Line(x,y + 76, x, y);
        line51.setStroke(color);
        line52.setStroke(color);
        line53.setStroke(color);
        line54.setStroke(color);
        line55.setStroke(color);
        line56.setStroke(color);
        line57.setStroke(color);
        line58.setStroke(color);
        line51.setStrokeWidth(4);
        line52.setStrokeWidth(4);
        line53.setStrokeWidth(4);
        line54.setStrokeWidth(4);
        line55.setStrokeWidth(4);
        line56.setStrokeWidth(4);
        line57.setStrokeWidth(4);
        line58.setStrokeWidth(4);
        this.getChildren().addAll(line51, line52, line53, line54, line55, line56, line57, line58);

        Rectangle titre = new Rectangle();
        titre.setX(150);
        titre.setY(142);
        titre.setWidth(300);
        titre.setHeight(10);
        titre.setStroke(color);
        titre.setFill(color);
        titre.setStrokeWidth(4);

        this.getChildren().add(titre);

        this.getChildren().add(jouer());
        this.getChildren().add(couleur());

    }

    public Pane jouer() {
        Pane bouton = new Pane();
        bouton.setMinSize(73,73);
        bouton.setPrefSize(74,74);
        bouton.setMaxSize(75,75);
        bouton.setLayoutX(225);
        bouton.setLayoutY(250);

        Rectangle rectangle = new Rectangle();

        rectangle.setWidth(150);
        rectangle.setHeight(75);
        rectangle.setFill(Color.BURLYWOOD);
        rectangle.setStroke(Color.BLUEVIOLET);
        rectangle.setStrokeWidth(3);
        bouton.getChildren().add(rectangle);

        Text texte = new Text("Jouer");
        texte.setFont(new Font(50));
        texte.setLayoutX(15);
        texte.setLayoutY(50);

        bouton.getChildren().add(texte);
        bouton.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.rgb(255,255,255,0.4));
            }
        });
        bouton.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.BURLYWOOD);
            }
        });
        bouton.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.rgb(255,255,255,0.4));
                Stage jeu = new Stage();
                Affichage affichage = new Affichage(jeu, color1, color);
                jeu.setTitle("Echecs");
                jeu.setScene(new Scene(affichage, 800, 640, Color.GHOSTWHITE));
                jeu.show();
            }
        });
        bouton.setOnMouseReleased(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.BURLYWOOD);
            }
        });

        return bouton;
    }


    public Pane couleur() {
        Pane bouton = new Pane();
        bouton.setMinSize(73,73);
        bouton.setPrefSize(74,74);
        bouton.setMaxSize(75,75);
        bouton.setLayoutX(225);
        bouton.setLayoutY(350);

        Rectangle rectangle = new Rectangle();

        rectangle.setWidth(150);
        rectangle.setHeight(75);
        rectangle.setFill(Color.BURLYWOOD);
        rectangle.setStroke(Color.BLUEVIOLET);
        rectangle.setStrokeWidth(3);
        bouton.getChildren().add(rectangle);

        Text texte = new Text("Changer");
        texte.setFont(new Font(35));
        texte.setLayoutX(8);
        texte.setLayoutY(30);
        Text texte2 = new Text("couleur");
        texte2.setFont(new Font(35));
        texte2.setLayoutX(15);
        texte2.setLayoutY(60);

        bouton.getChildren().add(texte);
        bouton.getChildren().add(texte2);
        bouton.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.rgb(255,255,255,0.4));
            }
        });
        bouton.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.BURLYWOOD);
            }
        });
        bouton.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.rgb(255,255,255,0.7));
                if (color1 != Color.CHOCOLATE) {
                    if (color1 == Color.DARKOLIVEGREEN) {
                        color1 = Color.CHOCOLATE;
                        color = Color.BURLYWOOD;
                    }
                    if (color1 == Color.DARKSLATEBLUE) {
                        color1 = Color.DARKOLIVEGREEN;
                        color = Color.OLIVE;
                    }
                    if (color1 == Color.DARKRED) {
                        color1 = Color.DARKSLATEBLUE;
                        color = Color.LIGHTSTEELBLUE;
                    }
                    if (color1 == Color.DARKGOLDENROD) {
                        color1 = Color.DARKRED;
                        color = Color.RED;
                      }
                    if (color1 == Color.DARKGREEN) {
                        color1 = Color.DARKGOLDENROD;
                        color = Color.GOLD;
                      }
                    if (color1 == Color.DARKBLUE) {
                        color1 = Color.DARKGREEN;
                        color = Color.FORESTGREEN;
                     }
                    if (color1 == Color.DARKCYAN) {
                        color1 = Color.DARKBLUE;
                        color = Color.LIGHTSTEELBLUE;
                    }
                    if (color1 == Color.BLACK) {
                        color1 = Color.DARKCYAN;
                        color = Color.DARKTURQUOISE;
                    }
                }
                else {
                    color1 = Color.BLACK;
                    color = Color.DARKGRAY;
                }






                backgroundMenu();
            }

        });
        bouton.setOnMouseReleased(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.BURLYWOOD);
            }
        });


        return bouton;
    }

}