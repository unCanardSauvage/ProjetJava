//package sample;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Affichage extends Parent {

    // une grande quantité astronomique d'attributs

    // on déclare les variables nécéssaires

    Color color; // couleur pour le deuxième joueur
    Color color1; // couleur pour les cases

    int tourJoueur;  // alterne entre 0 et 1. Indique le joueur qui doit bouger sa pièce
    int caseSelectionnee; // enregistre la couleur de la case (joueur) sélectionnée afin de définir les cases légales

    boolean enEchec = false; // savoir si le roi est en échec

    Pion monPion = new Pion(0, 0, 0);
    Fou monFou = new Fou(0, 0, 0);
    Dada monDada = new Dada(0, 0, 0);
    Tour maTour = new Tour(0, 0, 0);
    Dame maDame = new Dame(0, 0, 0);
    Roi monRoi = new Roi(0, 0, 0);
    Vide monVide = new Vide(0,0,2);

    // déclaration de tableaux dynamiques pour stocker objets et panes

    List<Pion> mesPionsBlancs = new ArrayList<Pion>();
    List<Fou> mesFousBlancs = new ArrayList<Fou>();
    List<Dada> mesDadasBlancs = new ArrayList<Dada>();
    List<Tour> mesToursBlanches = new ArrayList<Tour>();
    List<Dame> mesDamesBlanches = new ArrayList<Dame>();
    List<Roi> monSeulEtUniqueRoiBlanc = new ArrayList<Roi>();

    List<Pion> mesPionsNoirs = new ArrayList<Pion>();
    List<Fou> mesFousNoirs = new ArrayList<Fou>();
    List<Dada> mesDadasNoirs = new ArrayList<Dada>();
    List<Tour> mesToursNoires = new ArrayList<Tour>();
    List<Dame> mesDamesNoires = new ArrayList<Dame>();
    List<Roi> monSeulEtUniqueRoiNoir = new ArrayList<Roi>();

    List<Vide> bandeDeVide = new ArrayList<Vide>();


    //enum typePiece va nous servir à initialiser le plateau ainsi que d'afficher à chaque tours l'évolution du jeu dans la console.
    enum typePiece {_vide_, pion_B, fou_B_, dada_B, tour_B, dame_B, roi_B_, pion_N, fou_N_, dada_N, tour_N, dame_N, roi_N_}


    typePiece[][] plateauEnum = new typePiece [8][8];
    public typePiece[][] getPlateauEnum() {
        return plateauEnum;
    }
    public typePiece getPlateauEnum(int x, int y) {
        return plateauEnum[x][y];
    }

    int[][] casesBlanches = new int[8][8];
    int[][] casesNoires = new int[8][8];

    typePiece[][] maPiece = getPlateauEnum();

    Piece[][] tableauDePieces = new Piece[8][8];

    public Piece[][] getTableauDePieces() {
        return tableauDePieces;
    }


    Pane[][] plateau = new Pane[8][8];
    Pane[][] tableauDePTNDeBoutons = new Pane[8][8];
    //Pane[][] TableauPiece = new Pane[8][8];

    List<Pane> listePionsBlancs = new ArrayList<Pane>();
    List<Pane> listePionsNoirs = new ArrayList<Pane>();
    List<Pane> listeFousBlancs = new ArrayList<Pane>();
    List<Pane> listeFousNoirs = new ArrayList<Pane>();
    List<Pane> listeDadasBlancs = new ArrayList<Pane>();
    List<Pane> listeDadasNoirs = new ArrayList<Pane>();
    List<Pane> listeToursBlanches = new ArrayList<Pane>();
    List<Pane> listeToursNoires = new ArrayList<Pane>();
    List<Pane> listeDameBlanche = new ArrayList<Pane>();
    List<Pane> listeDameNoire = new ArrayList<Pane>();
    List<Pane> listeRoiBlanc = new ArrayList<Pane>();
    List<Pane> listeRoiNoir = new ArrayList<Pane>();
    List<Pane> listeDeVide = new ArrayList<Pane>();


    CaseBouton typeBouton = new CaseBouton();

    Class<? extends Piece> typePieceTemp; // Pour stocker le type de de la pièce sélectionnée
    Piece tempPiece;


    // Constructeur

    public Affichage(){};
    public Affichage (Stage primaryStage, Color color1, Color color){

        // limite les proportions de la fenêtre afin de conserver une experience de jeu décente
        // (jouer avec l'entièreté du plateau est mieux)
        this.color = color;
        this.color1 = color1;


        primaryStage.setMinHeight(700);
        primaryStage.setMinWidth(800);
        primaryStage.setMaxHeight(700);
        primaryStage.setMaxWidth(800);



        // dessin des cases sur notre fenêtre

        for (int i = 150; i < 750; i = i + 150) {
            for (int j = 25; j < 625; j = j + 150){
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
                case_noire.setStroke(Color.DARKGRAY);
                case_noire.setStrokeWidth(1);
                //case_noire.setArcHeight(30);
                //case_noire.setArcWidth(30);

                this.getChildren().add(case_noire);
            }
        }

        for (int i = 150; i < 750; i = i + 150) {
            for (int j = 100; j < 625; j = j + 150){
                Rectangle case_noire = new Rectangle();
                case_noire.setX(i);
                case_noire.setY(j);
                case_noire.setWidth(75);
                case_noire.setHeight(75);
                case_noire.setFill(color1);
                case_noire.setStroke(Color.DARKGRAY);
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

        // création de nos objets. On va aussi les placer dans leurs listes réspectives

        for (int i = 0; i < 32; i++) {
            int x, y;
            if (i <= 7) {
                x = 2;
                y = i;
                Vide monVide = new Vide(x, y, 2);
                bandeDeVide.add(monVide);
            }

            if (i >= 8 && i <= 15) {
                x = 3;
                y = i - 8;
                Vide monVide = new Vide(x, y, 2);
                bandeDeVide.add(monVide);
            }
            if (i >= 16 && i <= 23) {
                x = 4;
                y = i - 16;
                Vide monVide = new Vide(x, y, 2);
                bandeDeVide.add(monVide);
            }
            if (i >= 24) {
                x = 5;
                y = i - 24;
                Vide monVide = new Vide(x, y, 2);
                bandeDeVide.add(monVide);
            }


        }

        for (int i = 0; i < 8; i++){
            Pion monPionBlanc = new Pion(6, i, 0);
            mesPionsBlancs.add(monPionBlanc);
            Pion monPionNoir = new Pion(1, i, 1);
            mesPionsNoirs.add(monPionNoir);
        }

        for (int i = 2; i < 6; i = i + 3){
            Fou monFouBlanc = new Fou(7, i, 0);
            mesFousBlancs.add(monFouBlanc);
            Fou monFouNoir = new Fou(0, i, 1);
            mesFousNoirs.add(monFouNoir);
        }

        for (int i = 1; i < 7; i = i + 5){
            Dada monDadaBlanc = new Dada(7, i, 0);
            mesDadasBlancs.add(monDadaBlanc);
            Dada monDadaNoir = new Dada(0, i, 1);
            mesDadasNoirs.add(monDadaNoir);
        }
        System.out.println(mesDadasBlancs.get(1));

        for (int i = 0; i < 8; i = i + 7){
            Tour maTourBlanche = new Tour(7, i, 0);
            mesToursBlanches.add(maTourBlanche);
            this.getChildren().add(maTourBlanche);
            Tour maTourNoire = new Tour(0, i, 1);
            mesToursNoires.add(maTourNoire);
            this.getChildren().add(maTourNoire);
        }

        Dame maDameBlanche = new Dame(7, 3, 0);
        Dame maDameNoire = new Dame(0, 3, 1);
        mesDamesBlanches.add(maDameBlanche);
        mesDamesNoires.add(maDameNoire);

        Roi monRoiBlanc = new Roi(7, 4, 0);
        Roi monRoiNoir = new Roi(0, 4, 1);
        monSeulEtUniqueRoiBlanc.add(monRoiBlanc);
        monSeulEtUniqueRoiNoir.add(monRoiNoir);


        creationPlateau();

        //il faut créer les boutons après le plateau si on ne veut pas que les boutons se retrouvent en dessous

        creationDesBoutons();

        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 8; j++) {
                casesBlanches[i][j] = 0;
            }
        }

        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 8; j++) {
                casesNoires[i][j] = 0;
            }
        }

        Pane tag1 = new Pane();
        tag1.setMinSize(73,73);
        tag1.setPrefSize(74,74);
        tag1.setMaxSize(75,75);
        tag1.setLayoutX(35);
        tag1.setLayoutY(20);
        Text texte = new Text("Joueur :");
        texte.setFont(new Font(15));
        texte.setLayoutX(15);
        texte.setLayoutY(50);
        tag1.getChildren().add(texte);
        this.getChildren().add(tag1);

        indiquerTour(tourJoueur);

        Pane tag2 = new Pane();
        tag2.setMinSize(73,73);
        tag2.setPrefSize(74,74);
        tag2.setMaxSize(75,75);
        tag2.setLayoutX(35);
        tag2.setLayoutY(145);
        Text texte2 = new Text("Echec :");
        texte2.setFont(new Font(15));
        texte2.setLayoutX(15);
        texte2.setLayoutY(50);
        tag2.getChildren().add(texte2);
        this.getChildren().add(tag2);

        Rectangle EchecTemp = new Rectangle();
        EchecTemp.setX(50);
        EchecTemp.setY(200);
        EchecTemp.setWidth(50);
        EchecTemp.setHeight(50);
        EchecTemp.setFill(Color.GHOSTWHITE);
        EchecTemp.setStroke(Color.BLACK);
        EchecTemp.setStrokeWidth(1);
        EchecTemp.setArcHeight(7);
        EchecTemp.setArcWidth(7);

        this.getChildren().add(EchecTemp);

/*
        Stage stage = new Stage();
        ChoixPion choixPion = new ChoixPion(stage, 0, color);
        stage.setTitle("Transformez votre pion");
        stage.setScene(new Scene(choixPion, 200, 200, Color.GHOSTWHITE));
        stage.show();

 */



    }

    // Méthodes

    // à chaque case, un bouton. Grâce à cette fontion, nous allons pouvoir créer les boutons qui nous permetteront
    // d'interagir avec le plateau
    public void creationDesBoutons() {

        // increments seront nécessaires car sans quoi, nos boutons se trouveraient décalés
        int incrementx = 0;
        int incrementy = 0;
        //int incrementtab = 0;
        for (int i = 0; i < 8; i++) {
            incrementy ++;
            incrementx = 0;
            for (int j = 0; j < 8; j++) {
                incrementx ++;
                /*tableauDePTNDeBoutons[incrementtab] = caseBouton(i, j, incrementx, incrementy);
                this.getChildren().add(tableauDePTNDeBoutons[incrementtab]);
                incrementtab ++;*/

                tableauDePTNDeBoutons[i][j] = caseBouton(i, j, incrementx, incrementy, this);
                this.getChildren().add(tableauDePTNDeBoutons[i][j]);
            }
        }
        //tableauDePTNDeBoutons[9].setBackground(new Background(new BackgroundFill(Color.web("#2231fd"), null, null)));

    }

    // c'est ici qu'on va disposer nos objets à leur place.
    public void creationPlateau() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                plateauEnum[i][j] = typePiece._vide_;
            }
        }

        for (int i = 0; i < 8; i++) {
            plateauEnum[1][i] = typePiece.pion_N;
            plateauEnum[6][i] = typePiece.pion_B;
        }

        plateauEnum[0][2] = plateauEnum[0][5] = typePiece.fou_N_; plateauEnum[7][2] = plateauEnum[7][5] = typePiece.fou_B_;
        plateauEnum[0][1] = plateauEnum[0][6] = typePiece.dada_N; plateauEnum[7][1] = plateauEnum[7][6] = typePiece.dada_B;
        plateauEnum[0][0] = plateauEnum[0][7] = typePiece.tour_N; plateauEnum[7][0] = plateauEnum[7][7] = typePiece.tour_B;
        plateauEnum[0][3] = typePiece.dame_N; plateauEnum[7][3] = typePiece.dame_B;
        plateauEnum[0][4] = typePiece.roi_N_; plateauEnum[7][4] = typePiece.roi_B_;

        System.out.println("+-------------------------------------------------------+ ");
        System.out.println("|                  Mon Plateau d'Echec                  | ");
        System.out.println("+------+------+------+------+------+------+------+------+ ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //System.out.print(" | " + plateauEnum [i][j]);
                creationPiece(i, j, plateauEnum [i][j]);
            }
            System.out.println("| ");
            System.out.println("+------+------+------+------+------+------+------+------+ ");
        }

        for (int i = 0; i < 8; i++) {
            plateau[1][i] = listePionsNoirs.get(i);
            this.getChildren().add(listePionsNoirs.get(i));
            plateau[6][i] = listePionsBlancs.get(i);
            this.getChildren().add(listePionsBlancs.get(i));
            plateau[2][i] = listeDeVide.get(i);
            plateau[3][i] = listeDeVide.get(i + 8);
            plateau[4][i] = listeDeVide.get(i + 16);
            plateau[5][i] = listeDeVide.get(i + 24);
            this.getChildren().addAll(listeDeVide.get(i), listeDeVide.get(i + 8), listeDeVide.get(i + 16), listeDeVide.get(i + 24));
        }

        plateau[0][2] = listeFousNoirs.get(0);
        plateau[0][5] = listeFousNoirs.get(1);
        plateau[7][2] = listeFousBlancs.get(0);
        plateau[7][5] = listeFousBlancs.get(1);
        this.getChildren().addAll(plateau[0][2], plateau[0][5], plateau[7][2], plateau[7][5]);


        plateau[0][1] = listeDadasNoirs.get(0);
        plateau[0][6] = listeDadasNoirs.get(1);
        plateau[7][1] = listeDadasBlancs.get(0);
        plateau[7][6] = listeDadasBlancs.get(1);
        this.getChildren().addAll(plateau[0][1], plateau[0][6], plateau[7][1], plateau[7][6]);

        plateau[0][0] = listeToursNoires.get(0);
        plateau[0][7] = listeToursNoires.get(1);
        plateau[7][0] = listeToursBlanches.get(0);
        plateau[7][7] = listeToursBlanches.get(1);
        this.getChildren().addAll(plateau[0][0], plateau[0][7], plateau[7][0], plateau[7][7]);

        plateau[0][3] = listeDameNoire.get(0); plateau[7][3] = listeDameBlanche.get(0);
        plateau[0][4] = listeRoiNoir.get(0); plateau[7][4] = listeRoiBlanc.get(0);
        this.getChildren().addAll(plateau[0][3], plateau[7][3]);
        this.getChildren().addAll(plateau[0][4], plateau[7][4]);

    }

    // en fonction de typePiece sur la case correspondante, on va y dessiner un pane qui représentera la pièce souhaitée
    public void creationPiece (int x, int y, typePiece piece) {
        int abs, ord;
        int temp = 0;
        Pane pane/* = dessinerVide(x, y)*/;
        if (x == 0 || x == 1) {
            switch (piece) {
                case pion_N:
                    //pane = dessinerPion(y, x, 1);
                    Pion monPionNoir = mesPionsNoirs.get(y);
                    pane = monPionNoir.dessiner(y, x, 1, color);
                    tableauDePieces[x][y] = monPionNoir;
                    listePionsNoirs.add(pane);
                    //this.getChildren().add(pane);
                    break;

                case fou_N_:
                    //pane = dessinerFou(y, x, 1);
                    temp = y;
                    if (y < 4)
                        y = 0;
                    else
                        y = 1;
                    Fou monFouNoir = mesFousNoirs.get(y);
                    y = temp;
                    pane = monFouNoir.dessiner(y, x, 1, color);
                    tableauDePieces[x][y] = monFouNoir;
                    listeFousNoirs.add(pane);
                    //this.getChildren().add(pane);
                    break;

                case dada_N:
                    //pane = dessinerDada(y, x, 1);
                    temp = y;
                    if (y < 4)
                        y = 0;
                    else
                        y = 1;
                    Dada monDadaNoir = mesDadasNoirs.get(y);
                    y = temp;
                    pane = monDadaNoir.dessiner(y, x, 1, color);
                    tableauDePieces[x][y] = monDadaNoir;
                    listeDadasNoirs.add(pane);
                    //this.getChildren().add(pane);
                    break;

                case tour_N:
                    //pane =dessinerTour(y, x, 1);
                    temp = y;
                    if (y < 4)
                        y = 0;
                    else
                        y = 1;
                    Tour maTourNoire = mesToursNoires.get(y);
                    y = temp;
                    pane = maTourNoire.dessiner(y, x, 1, color);
                    tableauDePieces[x][y] = maTourNoire;
                    listeToursNoires.add(pane);
                    //this.getChildren().add(pane);
                    break;

                case dame_N:
                    //pane = dessinerDame(y, x, 1);
                    Dame maDameNoire = mesDamesNoires.get(0);
                    pane = maDameNoire.dessiner(y, x, 1, color);
                    tableauDePieces[x][y] = maDameNoire;
                    listeDameNoire.add(pane);
                    //this.getChildren().add(pane);
                    break;

                case roi_N_:
                    //pane = dessinerRoi(y, x, 1);
                    Roi monRoiNoir = monSeulEtUniqueRoiNoir.get(0);
                    pane = monRoiNoir.dessiner(y, x, 1, color);
                    tableauDePieces[x][y] = monRoiNoir;
                    listeRoiNoir.add(pane);
                    //this.getChildren().add(pane);
                    break;
            }
        }

        if (x == 2 || x == 3 || x == 4 || x == 5){
            if (piece == typePiece._vide_) {
                int nbr = (x - 1) * y;
                nbr = nbr / 4;
                //System.out.println("nbr = " + nbr);
                Vide unVide = bandeDeVide.get(nbr);
                pane = unVide.dessiner(y,x, 2, color);
                tableauDePieces[x][y] = unVide;
                listeDeVide.add(pane);

            }
        }

        if (x == 6 || x == 7) {
            switch (piece) {
                case pion_B:
                    //pane = dessinerPion(y, x, 0);
                    Pion monPionBlanc = mesPionsBlancs.get(y);
                    pane = monPionBlanc.dessiner(y, x, 0, color);
                    tableauDePieces[x][y] = monPionBlanc;
                    listePionsBlancs.add(pane);
                    //this.getChildren().add(pane);
                    break;

                case fou_B_:
                    //pane = dessinerFou(y, x, 0);
                    temp = y;
                    if (y < 4)
                        y = 0;
                    else
                        y = 1;
                    Fou monFouBlanc = mesFousBlancs.get(y);
                    y = temp;
                    pane = monFouBlanc.dessiner(y, x, 0, color);
                    tableauDePieces[x][y] = monFouBlanc;
                    listeFousBlancs.add(pane);
                    //this.getChildren().add(pane);
                    break;

                case dada_B:
                    //pane = dessinerDada(y, x, 0);
                    temp = y;
                    if (y < 4)
                        y = 0;
                    else
                        y = 1;
                    Dada monDadaBlanc = mesDadasBlancs.get(y);
                    y = temp;
                    pane =  monDadaBlanc.dessiner(y, x, 0, color);
                    tableauDePieces[x][y] = monDadaBlanc;
                    listeDadasBlancs.add(pane);
                    //this.getChildren().add(pane);
                    break;

                case tour_B:
                    //pane = dessinerTour(y, x, 0);
                    temp = y;
                    if (y < 4)
                        y = 0;
                    else
                        y = 1;
                    Tour maTourBlanche = mesToursBlanches.get(y);
                    y = temp;
                    pane = maTourBlanche.dessiner(y, x, 0, color);
                    tableauDePieces[x][y] = maTourBlanche;
                    listeToursBlanches.add(pane);
                    //this.getChildren().add(pane);
                    break;

                case dame_B:
                    //pane = dessinerDame(y, x, 0);
                    Dame maDameBlanche = mesDamesBlanches.get(0);
                    pane = maDameBlanche.dessiner(y, x, 0, color);
                    tableauDePieces[x][y] = maDameBlanche;
                    listeDameBlanche.add(pane);
                    //this.getChildren().add(pane);
                    break;

                case roi_B_:
                    //pane = dessinerRoi(y, x, 0);
                    Roi monRoiBlanc = monSeulEtUniqueRoiBlanc.get(0);
                    pane = monRoiBlanc.dessiner(y, x, 0, color);
                    tableauDePieces[x][y] = monRoiBlanc;
                    listeRoiBlanc.add(pane);
                    //this.getChildren().add(pane);
                    break;
            }
        }

       // return pane;
    }

    // grâce à cette fonction, notre souris sera intérprêtée. Eh oui ! sans notre souris les boutons ne nous seront pas
    // d'une grande utilité.
    public Pane caseBouton (int x, int y, int incrementx, int incrementy, Affichage affichage) {

        Pane bouton = new Pane();
        bouton.setMinSize(73,73);
        bouton.setPrefSize(74,74);
        bouton.setMaxSize(75,75);
        bouton.setLayoutX(75 + y + 74.2 * incrementx);
        bouton.setLayoutY(- 50 + x + 74.2 * incrementy);

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(75);
        rectangle.setHeight(75);
        rectangle.setFill(Color.rgb(255,255,255,0.0));
        rectangle.setStroke(Color.BLUEVIOLET);
        rectangle.setStrokeWidth(0);
        bouton.getChildren().add(rectangle);

        // quand la souris arrive sur le bouton, part du bouton, appuie sur le bouton puis relâche le bouton
        // on va pouvoir mettre en évidence le bouton qui sera sous notre curseur et le mettre davantage en évidence
        // quand le clic sera enfoncé. Il est important de dissocer les deux dernières fonctions (ne pas utiliser
        // setOnMouseClicked) car sinon le bouton paraîtra toujours enfoncé.
        bouton.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
               rectangle.setFill(Color.rgb(255,255,255,0.4));
            }
        });
        bouton.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.rgb(255,255,255,0.0));
            }
        });
        bouton.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.rgb(255,255,255,0.7));

                // on prend la pièce aux coordonnées correspondantes
                Piece maPiece = tableauDePieces[x][y];

                // si un joueur souhaite prendre une pièce adverse // un joueur ne peut pas prendre sa propre pièce
                if ((maPiece.getCouleur() == 0 && caseSelectionnee == 1) || (maPiece.getCouleur() == 1 && caseSelectionnee == 0)){
                    if (typeBouton.getSelection()) {
                        System.out.println("cas mouv 1");
                        festinDePions(x, y, typeBouton.getEtat());
                    /*    enEchec = false;
                        if (tourJoueur == 0) {
                            enEchec = monSeulEtUniqueRoiBlanc.get(0).estEchec(affichage);
                        }
                        if (tourJoueur == 1) {
                            enEchec = monSeulEtUniqueRoiNoir.get(0).estEchec(affichage);
                        }

                        if (enEchec) {
                            typeBouton.getEtat().mouvementIllicite = enEchec;
                        }

                     */
                        if (!typeBouton.getEtat().isMouvementIllicite()/* && !enEchec*/) {
                            typeBouton.setSelection(typeBouton.selectionner(typeBouton.getSelection()));
                            typeBouton.setJeTeMange(true);
                            indiquerTour(tourJoueur);
                        }
                        else {
                            System.out.println("1. mouvement illicite !!!");
                            typeBouton.setSelection(typeBouton.selectionner(typeBouton.getSelection()));
                        }
                    }
                }

                // si un joueur se déplace sur une case vide
                if (maPiece.getClass() == monVide.getClass()) {
                    if (typeBouton.getSelection()) {
                        System.out.println("cas mouv 2");
                        armeeDePions(x, y, typeBouton.getEtat());
                    /*    enEchec = false;
                        if (tourJoueur == 0) {
                            enEchec = monSeulEtUniqueRoiBlanc.get(0).estEchec(affichage);
                        }
                        if (tourJoueur == 1) {
                            enEchec = monSeulEtUniqueRoiNoir.get(0).estEchec(affichage);
                        }

                     */
                        if (!typeBouton.getEtat().isMouvementIllicite()/* && !enEchec*/) {
                            typeBouton.setSelection(typeBouton.selectionner(typeBouton.getSelection()));
                            indiquerTour(tourJoueur);
                        }
                        else {
                            System.out.println("2. mouvement illicite !!!");
                            typeBouton.setSelection(typeBouton.selectionner(typeBouton.getSelection()));
                        }
                    }
                }

                // avant de déplacer une pièce, il faut d'abord la sélectionner. On considère une pièce
                // sélectionnée quand le joueur sélectionne une pièce de sa couleur. Ne pas considèrer une pièce
                // prise pour une pièce sélectionnée
                else {
                    if ((typeBouton.getTourJoueur() == maPiece.getCouleur() && !typeBouton.isJeTeMange()) || maPiece.getCouleur() == caseSelectionnee) {
                        typePieceTemp = maPiece.getClass();
                        tempPiece = maPiece;

                        maPiece.setDeltaX(x);
                        maPiece.setDeltaY(y);
                        System.out.println("caseSelectionnee" + caseSelectionnee + " ; maPiece.getCouleur()" + maPiece.getCouleur());

                        System.out.println("Did I eat ya? " + typeBouton.isJeTeMange());
                        typeBouton.setEtat(tableauDePieces[x][y]);
                        typeBouton.setSelection(typeBouton.selectionner(typeBouton.getSelection()));

                        caseSelectionnee = tourJoueur;
                        tourJoueur = typeBouton.AQuiLeTour(tourJoueur);
                        typeBouton.setTourJoueur(tourJoueur);
                        // on applique cette fonction si la pièce sélectionnée est un pion
                        if (maPiece.getClass() == monPion.getClass()){
                            pionLeMangeur(x, y, typeBouton.getEtat());
                            //pionLeKeblo(x, y, typeBouton.getEtat());
                        }
                    }
                }
            }
        });
        bouton.setOnMouseReleased(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                rectangle.setFill(Color.rgb(255,255,255,0.4));
                typeBouton.setJeTeMange(false);
            }
        });

        return bouton;
    }

    // grâce à cette fonction, nos pièces pourront aller sur le front !
    public void armeeDePions (int x, int y, Piece piece) {
        Pane bouton = tableauDePTNDeBoutons[x][y];

        //piece = creationPiece(x, y, typePiece.pion);
        Pane pane;
        Piece temp;
        Pane paneTemp;
        typePiece enumTemp;
        int X, Y;
        X = Y = 0;
        int a = piece.getX();
        int b = piece.getY();

        //System.out.println("a = " + a + " ; b = " + b);

        pane = plateau[a][b];

        Piece maPiece;
        //tableauDePieces[1][1] = new Dada(x, y, 1);
        //maPiece = tableauDePieces[1][1];
        maPiece = tableauDePieces[x][y];
        maPiece = piece;


        //System.out.println("armee de pions : " + maPiece.getClass());


        maPiece.deplacement(x, y, pane, this);
        if (!maPiece.mouvementIllicite /*&& !enEchec*/) {
            X = maPiece.getxGraph();
            Y = maPiece.getyGraph();
            maPiece.setxGraph(0);
            maPiece.setyGraph(0);

            temp = tableauDePieces[maPiece.getX()][maPiece.getY()];
            tableauDePieces[maPiece.getX()][maPiece.getY()] = tableauDePieces[a][b];
            tableauDePieces[a][b] = temp;

            //System.out.println("tableauDePieces[a][b].getClass() = " + tableauDePieces[a][b].getClass());

            paneTemp = plateau[maPiece.getX()][maPiece.getY()];
            plateau[maPiece.getX()][maPiece.getY()] = plateau[a][b];
            plateau[a][b] = paneTemp;

            tableauDePieces[a][b].deplacement(maPiece.getDeltaX(), maPiece.getDeltaY(), plateau[a][b], this);
            tableauDePieces[a][b].setxGraph(0);
            tableauDePieces[a][b].setyGraph(0);

            enumTemp = plateauEnum[maPiece.getX()][maPiece.getY()];
            plateauEnum[maPiece.getX()][maPiece.getY()] = plateauEnum[a][b];
            plateauEnum[a][b] = enumTemp;

            System.out.println("x = " + x + " ; tour joueur = " + tourJoueur);
            if (tempPiece.getClass() == monPion.getClass() && (x == 0 && tourJoueur == 1 || x == 7 && tourJoueur == 0)) {
                System.out.println("transformation");
                //this.getChildren().add(((Pion) tempPiece).transformationPion(this, tourJoueur, maPiece.getX(), maPiece.getY()));
            }
        }
        afficher(x, y);
    }

    // celle-ci est quand une pièce avance mais prend une pièce au passage !
    public void festinDePions (int x, int y, Piece piece) {
        Pane bouton = tableauDePTNDeBoutons[x][y];

        Pane pane;
        Pane paneTemp;

        int X, Y;
        X = Y = 0;
        int a = piece.getX();
        int b = piece.getY();
        Vide nouveauVide = new Vide(a, b, 2);


        pane = plateau[a][b];

        Piece maPiece;

        maPiece = tableauDePieces[x][y];
        maPiece = piece;

        //System.out.println("festin de pions : " + maPiece.getClass());
        //System.out.println("dans festin de pion, mouv = " + maPiece.mouvementIllicite);
        maPiece.deplacement(x, y, pane, this);
        //System.out.println("dans festin de pion, mouv = " + maPiece.mouvementIllicite);
        if (!maPiece.mouvementIllicite/* && !enEchec*/) {
            X = maPiece.getxGraph();
            Y = maPiece.getyGraph();
            maPiece.setxGraph(0);
            maPiece.setyGraph(0);

            tableauDePieces[maPiece.getX()][maPiece.getY()] = tableauDePieces[a][b];
            tableauDePieces[a][b] = nouveauVide;

            paneTemp = plateau[maPiece.getX()][maPiece.getY()];
            plateau[maPiece.getX()][maPiece.getY()] = plateau[a][b];
            plateau[a][b] = paneTemp;

            tableauDePieces[a][b].deplacement(maPiece.getDeltaX(), maPiece.getDeltaY(), plateau[a][b], this);
            tableauDePieces[a][b].setxGraph(0);
            tableauDePieces[a][b].setyGraph(0);

            maPiece.tourDeLaDefaite(plateau[a][b]);

            plateauEnum[maPiece.getX()][maPiece.getY()] = plateauEnum[a][b];
            plateauEnum[a][b] = typePiece._vide_;


            System.out.println("x = " + x + " ; tour joueur = " + tourJoueur);
            if (tempPiece.getClass() == monPion.getClass() && (x == 0 && tourJoueur == 1 || x == 7 && tourJoueur == 0)) {
                System.out.println("transformation");
                //this.getChildren().add(((Pion) tempPiece).transformationPion(this, tourJoueur, maPiece.getX(), maPiece.getY()));
            }

        }

        afficher(x, y);

    }

    public void supprimerPane (int x, int y) {
        System.out.println("je supprime : " + x + " " + y);
        this.getChildren().remove(plateau[x][y]);
    }

    // on va pouvoir afficher la progression du jeu tour par tour dans la console
    public void afficher(int a, int b) {
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("|                           tableau de pieces                           |");
        System.out.println("+--------+--------+--------+--------+--------+--------+--------+--------+");
        for (int i = 0; i < 8; i ++){
            for (int j = 0; j < 8; j++){
                System.out.print("| " + plateauEnum[i][j] +" ");
                if (i == a && j == b)
                    System.out.print("x ");
            }
            System.out.println("| ");
            System.out.println("+--------+--------+--------+--------+--------+--------+--------+--------+");
        }


        System.out.println();
        System.out.println("#########################################################################");
        System.out.println("#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Tour suivant~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#");
        System.out.println("#########################################################################");
        System.out.println();
        System.out.println("Tour de joueur : " + tourJoueur);
        System.out.println();
        System.out.println("#########################################################################");

        verifEchec(tourJoueur);


        Rectangle Echec = new Rectangle();
        this.getChildren().remove(Echec);
        Color couleur = Color.GHOSTWHITE;
        if (enEchec) {
            couleur = Color.RED;
            indiquerTour(tourJoueur);
        }

        Echec.setX(50);
        Echec.setY(200);
        Echec.setWidth(50);
        Echec.setHeight(50);
        Echec.setFill(couleur);
        Echec.setStroke(Color.BLACK);
        Echec.setStrokeWidth(1);
        Echec.setArcHeight(7);
        Echec.setArcWidth(7);

        this.getChildren().add(Echec);
    }

    public void verifEchec (int tourJoueur) {
        if (tourJoueur == 1) {
            for (int i = 0; i < 8 ; i++) {
                for (int j = 0; j < 8; j++) {
                    casesBlanches[i][j] = 0;
                }
            }
            echecB();
/*            System.out.println("+-----------------------------------------------+");
            System.out.println("|                    BLANCS                     |");
            System.out.println("+-----+-----+-----+-----+-----+-----+-----+-----+");
            for (int i = 0; i < 8 ; i++) {
                System.out.print("|");
                for (int j = 0; j < 8; j++) {
                    System.out.print("  " + casesBlanches[i][j] + "  |");
                }
                System.out.println();
                System.out.println("+-----+-----+-----+-----+-----+-----+-----+-----+");
            }
 */


        }

        if (tourJoueur == 0) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    casesNoires[i][j] = 0;
                }
            }
            echecN();
  /*          System.out.println("+-----------------------------------------------+");
            System.out.println("|                     NOIRS                     |");
            System.out.println("+-----+-----+-----+-----+-----+-----+-----+-----+");
            for (int i = 0; i < 8; i++) {
                System.out.print("|");
                for (int j = 0; j < 8; j++) {
                    System.out.print("  " + casesNoires[i][j] + "  |");
                }
                System.out.println();
                System.out.println("+-----+-----+-----+-----+-----+-----+-----+-----+");
            }

   */
        }
    }

    public void indiquerTour (int tourJoueur) {
            Rectangle J1 = new Rectangle();
            J1.setX(50);
            J1.setY(75);
            J1.setWidth(50);
            J1.setHeight(50);
            J1.setFill(Color.BLANCHEDALMOND);
            J1.setStroke(Color.BLACK);
            J1.setStrokeWidth(1);
            J1.setArcHeight(7);
            J1.setArcWidth(7);

            Rectangle J2 = new Rectangle();
            J2.setX(50);
            J2.setY(75);
            J2.setWidth(50);
            J2.setHeight(50);
            J2.setFill(color);
            J2.setStroke(Color.BLACK);
            J2.setStrokeWidth(1);
            J2.setArcHeight(7);
            J2.setArcWidth(7);

            if (tourJoueur == 0) {
                this.getChildren().add(J1);
                this.getChildren().remove(J2);
            }
            if (tourJoueur == 1) {
                this.getChildren().add(J2);
                this.getChildren().remove(J1);
            }
    }

    // va permettre de vérifier si un pion peut prendre un pièce adverse
    public void pionLeMangeur(int x, int y, Piece piece) {

        System.out.println("pion le mangeur");

        int y1 = y - 1;
        int y2 = y + 1;


        // on vérifie si notre pion est sur un bord
        if (y == 0)
            y1 = y2;

        if (y == 7)
            y2 = y1;

        if(piece.getCouleur() == 0)
            x--;

        else
            x++;

        Piece piece1 = tableauDePieces[x][y1];
        Piece piece2 = tableauDePieces[x][y2];

        //System.out.println("piece1 : " + piece1.getClass());
        //System.out.println("piece2 : " + piece2.getClass());

        if(monPion.getClass() == piece.getClass()) {
            ((Pion) piece).setPeutManger(false);

            if(piece.getCouleur() == 0 && (piece1.getCouleur() == 1 || piece2.getCouleur() == 1)
            || piece.getCouleur() == 1 && (piece1.getCouleur() == 0 || piece2.getCouleur() == 0)) {
                ((Pion) piece).setPeutManger(true);
                //System.out.println("true");
            }
            //else
              //  pionLeKeblo(x, y, piece);
            //System.out.println("peut manger :" + ((Pion) piece).isPeutManger());
        }
    }

    public void pionLeKeblo(int x, int y, Piece piece) {
        //System.out.println("pion le keblo");

        if(piece.getCouleur() == 0)
            x--;

        else
            x++;

        Piece piece1 = tableauDePieces[x][y];

        //System.out.println("piece1 : " + piece1.getClass());

        if(monPion.getClass() == piece.getClass()) {
            ((Pion) piece).setEstKeblo(false);

            if(piece.getCouleur() == 0 && piece1.getCouleur() == 1 || piece.getCouleur() == 1 && piece1.getCouleur() == 0) {
                ((Pion) piece).setEstKeblo(true);
                //System.out.println("true");
            }
            //System.out.println("est keblo :" + ((Pion) piece).isEstKeblo());
        }
    }

    public void echecB() {
        int taille;
        boolean enEchecDDiag, enEchecDDroit, enEchecFou, enEchecTour, enEchecDada, enEchecPion;
        enEchecDDiag = enEchecDDroit = enEchecFou = enEchecTour = enEchecDada = enEchecPion = false;
        enEchec = false;

        taille = mesDamesBlanches.size();
        for (int i = 0; i < taille; i++){
            if (!enEchecDDiag && !enEchecDDroit) {
                System.out.println("i = " + i);
                enEchecDDiag = mesDamesBlanches.get(i).echecDiag(this);
                enEchecDDroit = mesDamesBlanches.get(i).echecDroit(this);
            }
        }

        taille = mesFousBlancs.size();
        for (int i = 0; i < taille; i++){
            if (!enEchecFou)
                enEchecFou = mesFousBlancs.get(i).echecDiag(this);
        }

        taille = mesToursBlanches.size();
        for (int i = 0; i < taille; i++){
            if (!enEchecTour)
                enEchecTour = mesToursBlanches.get(i).echecDroit(this);
        }

        taille = mesDadasBlancs.size();
        for (int i = 0; i < taille; i++){
            if (!enEchecDada)
                enEchecDada = mesDadasBlancs.get(i).echecDada(this);
        }

        taille = mesPionsBlancs.size();
        for (int i = 0; i < taille; i++){
            if (!enEchecPion)
                enEchecPion = mesPionsBlancs.get(i).echecPion(this);
        }

        //System.out.println(enEchecDDiag + " " + enEchecDDroit + " " + enEchecFou + " " + enEchecTour + " " + enEchecDada + " " + enEchecPion);
        if (enEchecDDiag || enEchecDDroit || enEchecFou || enEchecTour || enEchecDada || enEchecPion)
            enEchec = true;
        else
            enEchec = false;

        //System.out.println(enEchec);
        monSeulEtUniqueRoiBlanc.get(0).envahisseur(this);
    }

    public void echecN() {
        int taille;
        boolean enEchecDDiag, enEchecDDroit, enEchecFou, enEchecTour, enEchecDada, enEchecPion;
        enEchecDDiag = enEchecDDroit = enEchecFou = enEchecTour = enEchecDada = enEchecPion = false;
        enEchec = false;

        taille = mesDamesNoires.size();
        for (int i = 0; i < taille; i++){
            if (!enEchecDDiag && !enEchecDDroit) {
                System.out.println("i = " + i);
                enEchecDDiag = mesDamesNoires.get(i).echecDiag(this);
                enEchecDDroit = mesDamesNoires.get(i).echecDroit(this);
            }
        }

        taille = mesFousNoirs.size();
        for (int i = 0; i < taille; i++){
            if (!enEchecFou)
                enEchecFou = mesFousNoirs.get(i).echecDiag(this);
        }

        taille = mesToursNoires.size();
        for (int i = 0; i < taille; i++){
            if (!enEchecTour)
                enEchecTour = mesToursNoires.get(i).echecDroit(this);
        }

        taille = mesDadasNoirs.size();
        for (int i = 0; i < taille; i++){
            if (!enEchecDada)
                enEchecDada = mesDadasNoirs.get(i).echecDada(this);
        }

        taille = mesPionsNoirs.size();
        for (int i = 0; i < taille; i++){
            if (!enEchecPion)
                enEchecPion = mesPionsNoirs.get(i).echecPion(this);
        }

        if (enEchecDDiag || enEchecDDroit || enEchecFou || enEchecTour || enEchecDada || enEchecPion)
            enEchec = true;
        else
            enEchec = false;

        monSeulEtUniqueRoiNoir.get(0).envahisseur(this);
    }

}


