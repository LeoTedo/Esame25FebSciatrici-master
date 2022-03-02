package it.unimi.di.prog2.esame.presenters;

import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.model.Observable;
import it.unimi.di.prog2.esame.model.Skier;
import it.unimi.di.prog2.esame.views.RankView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FirstRunPresenter implements Presenter{

    private final Model m;
    private final RankView view;

    public FirstRunPresenter(@NotNull Model m,@NotNull RankView view) {
        this.m = m;
        this.view = view;
        m.addObserver(this);
    }

    @Override
    public void update(@NotNull Observable<List<Skier>> subject, @NotNull List<Skier> state) {
        int i =0;
        for (Skier s : state) {
            view.set(i, s.getName()+" "+s.getTime());
            i++;
        }
    }

    @Override
    public void action(String text1, String text2) {
//NULLA
    }
}
