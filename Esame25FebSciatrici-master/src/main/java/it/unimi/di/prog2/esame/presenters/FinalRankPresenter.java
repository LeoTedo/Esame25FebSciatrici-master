package it.unimi.di.prog2.esame.presenters;

import it.unimi.di.prog2.esame.Main;
import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.model.Observable;
import it.unimi.di.prog2.esame.model.Skier;
import it.unimi.di.prog2.esame.views.RankView;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FinalRankPresenter implements Presenter{

    private final Model m;
    private final RankView view;
    int max=Main.SKIER_NUM-1;
    int tot = Main.SKIER_NUM_TOTAL_RANK;

    public FinalRankPresenter(@NotNull Model m,@NotNull RankView view) {
        this.m = m;
        this.view = view;
        m.addObserver(this);
    }

    @Override
    public void update(@NotNull Observable<List<Skier>> subject, @NotNull List<Skier> state) {
        List<Skier> finale = m.getFinale();
        List<Skier> primo = m.getState();
        List<Skier> secondo = m.getGara();
        finale.sort(Comparator.comparing(a -> a.getTime()));
        if(finale.size()>0){
            for (int i=0; i< tot; i++ ) {
                try {
                    view.set(i,finale.get(i).getName()+" "+finale.get(i).getTime()/60.0+" "+primo.get(max-i).getTime()+" "+secondo.get(i).getTime());
                } catch (Exception e){
                    System.err.println();
                }
            }
        }
}





    @Override
    public void action(String text1, String text2) {
//NULLA
    }
}
