package it.unimi.di.prog2.esame.presenters;

import it.unimi.di.prog2.esame.model.Skier;

import java.util.List;

public interface Presenter extends Observer<List<Skier>>{
  void action(String text1, String text2);
}
