import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class ChoixPion extends Parent {



    Fou monFou = new Fou(0, 0, 0);
    Dada monDada = new Dada(0, 0, 0);
    Tour maTour = new Tour(0, 0, 0);
    Dame maDame = new Dame(0, 0, 0);

    public ChoixPion(Stage primaryStage, int couleur, Color color, Pion pion) {
        primaryStage.setMinHeight(280);
        primaryStage.setMinWidth(280);
        primaryStage.setMaxHeight(280);
        primaryStage.setMaxWidth(280);



        this.getChildren().add(dessinerFou(primaryStage, couleur, color));
        this.getChildren().add(dessinerDada(primaryStage, couleur, color));
        this.getChildren().add(dessinerTour(primaryStage, couleur, color));
        this.getChildren().add(dessinerDame(primaryStage, couleur, color));

        this.getChildren().add(fou(primaryStage, pion, color));
        this.getChildren().add(dada(primaryStage, pion, color));
        this.getChildren().add(tour(primaryStage, pion, color));
        this.getChildren().add(dame(primaryStage, pion, color));

    }

    public Pane fou(Stage stage, Pion pion, Color color) {
        Pane bouton = new Pane();
        bouton.setMinSize(50,50);
        bouton.setPrefSize(50,50);
        bouton.setMaxSize(50,50);
        bouton.setLayoutX(50);
        bouton.setLayoutY(50);

        Rectangle rectangle = new Rectangle();

        rectangle.setWidth(50);
        rectangle.setHeight(50);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(color);
        rectangle.setStrokeWidth(3);
        bouton.getChildren().add(rectangle);
        bouton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                pion.setChoix(1);
                System.out.println("choix" + pion.getChoix());
                stage.close();
            }
        });

        return bouton;
    }

    public Pane dada(Stage stage, Pion pion, Color color) {
        Pane bouton = new Pane();
        bouton.setMinSize(50,50);
        bouton.setPrefSize(50,50);
        bouton.setMaxSize(50,50);
        bouton.setLayoutX(150);
        bouton.setLayoutY(50);

        Rectangle rectangle = new Rectangle();

        rectangle.setWidth(50);
        rectangle.setHeight(50);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(color);
        rectangle.setStrokeWidth(3);
        bouton.getChildren().add(rectangle);
        bouton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                pion.setChoix(2);
                System.out.println("choix" + pion.getChoix());
                stage.close();
            }
        });

        return bouton;
    }

    public Pane tour(Stage stage, Pion pion, Color color) {
        Pane bouton = new Pane();
        bouton.setMinSize(50,50);
        bouton.setPrefSize(50,50);
        bouton.setMaxSize(50,50);
        bouton.setLayoutX(50);
        bouton.setLayoutY(150);

        Rectangle rectangle = new Rectangle();

        rectangle.setWidth(50);
        rectangle.setHeight(50);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(color);
        rectangle.setStrokeWidth(3);
        bouton.getChildren().add(rectangle);
        bouton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                pion.setChoix(3);
                System.out.println("choix" + pion.getChoix());
                stage.close();
            }
        });

        return bouton;
    }

    public Pane dame(Stage stage, Pion pion, Color color) {
        Pane bouton = new Pane();
        bouton.setMinSize(50,50);
        bouton.setPrefSize(50,50);
        bouton.setMaxSize(50,50);
        bouton.setLayoutX(150);
        bouton.setLayoutY(150);

        Rectangle rectangle = new Rectangle();

        rectangle.setWidth(50);
        rectangle.setHeight(50);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(color);
        rectangle.setStrokeWidth(3);
        bouton.getChildren().add(rectangle);
        bouton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                pion.setChoix(4);
                System.out.println("choix" + pion.getChoix());
                stage.close();
            }
        });

        return bouton;
    }


    public Pane dessinerFou(Stage stage, int couleur, Color color) {
        int x = 75;
        int y =75;

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

    public Pane dessinerDada(Stage stage, int couleur, Color color) {
        int x = 175;
        int y = 75;

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

    public Pane dessinerTour(Stage stage, int couleur, Color color) {
        int x = 75;
        int y = 175;

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

    public Pane dessinerDame(Stage stage, int couleur, Color color) {
        int x = 175;
        int y = 175;
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
}
