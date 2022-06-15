package it.unimi.di.prog2.esame.model;

import it.unimi.di.prog2.esame.Main;
import it.unimi.di.prog2.esame.presenters.Observer;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.util.*;

public class Model implements Observable<List<Skier>> {
  private final List<Observer<List<Skier>>> observers = new ArrayList<>();
  private ArrayList<Skier> sciatrici = new ArrayList<>();
  private ArrayList<Skier> gara = new ArrayList<>();
  private ArrayList<Skier> finale = new ArrayList<>();
  //TODO completare la classe

  public void readFilePrimaManche() {
    int i =0;
    InputStream is = Main.class.getResourceAsStream("/first");
    assert is != null;
    Scanner s = new Scanner(is);

    while (s.hasNextLine()) {
      String linea = s.nextLine();
      String[] el = linea.split(";");
      String name = el[0];
      double time = Double.parseDouble(el[1]);

      System.out.printf("time: [%g] name: [%s]\n", time, name);
      //TODO memorizzare opportunamente
      sciatrici.add(new Skier(name,time));
      i++;
      notifyObservers();
    }
  }

  @Override
  public void notifyObservers() {
    for (Observer<List<Skier>> observer : observers) {
      observer.update(this, new ArrayList<>(sciatrici));
    }
  }

  @Override
  public void addObserver(@NotNull Observer<List<Skier>> observer) {
    observers.add(observer);
  }

  @Override
  public @NotNull List<Skier> getState() {
    return sciatrici;
  }

  public void addTempo(String s, Double t){
    int i = Main.SKIER_NUM;
    i = Main.SKIER_NUM-i;
    gara.add(new Skier(s,t));
    finale.add(new Skier(s,t+sciatrici.get(i).getTime()));
    i--;
    notifyObservers();
  }

  public @NotNull List<Skier> getGara(){
    ArrayList<Skier> garaC = gara;
    return garaC;
  }

  public @NotNull List<Skier> getFinale(){
    ArrayList<Skier> finaleC = finale;
    return finaleC;
  }
}
