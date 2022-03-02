package it.unimi.di.prog2.esame;


import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.presenters.FinalRankPresenter;
import it.unimi.di.prog2.esame.presenters.FirstRunPresenter;
import it.unimi.di.prog2.esame.presenters.NextSkierPresenter;
import it.unimi.di.prog2.esame.presenters.SecRunPresenter;
import it.unimi.di.prog2.esame.views.NextSkierView;
import it.unimi.di.prog2.esame.views.RankView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
  final public static int SKIER_NUM = 15;
  final public static int SKIER_NUM_TOTAL_RANK = 5;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    primaryStage.setTitle("2022 - Women's Giant Slalom");

    NextSkierView nextSkier = new NextSkierView();

    RankView firstRun = new RankView("First manche", SKIER_NUM);
    RankView secondRun = new RankView("Second manche", SKIER_NUM);
    RankView totalRun = new RankView("Final ranking (first " + SKIER_NUM_TOTAL_RANK + " skiers)", SKIER_NUM_TOTAL_RANK);


    GridPane gridPane = new GridPane();
    gridPane.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
    gridPane.setPadding(new Insets(10, 10, 10, 10));

    gridPane.add(nextSkier, 0, 0);
    GridPane.setColumnSpan(nextSkier, GridPane.REMAINING);
    gridPane.add(firstRun, 0, 1);
    gridPane.add(secondRun, 1, 1);

    gridPane.add(totalRun, 0, 2);
    GridPane.setColumnSpan(totalRun, GridPane.REMAINING);

    //TODO creare e connettere model e presenters
    Model model = new Model();
    model.readFilePrimaManche();
    new NextSkierPresenter(model,nextSkier);
    new FirstRunPresenter(model,firstRun);
    new SecRunPresenter(model, secondRun);
    new FinalRankPresenter(model, totalRun);

    Scene scene = new Scene(gridPane);
    primaryStage.setScene(scene);
    primaryStage.show();
    model.notifyObservers();
  }
}
