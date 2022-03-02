package it.unimi.di.prog2.esame.presenters;

import it.unimi.di.prog2.esame.Main;
import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.model.Observable;
import it.unimi.di.prog2.esame.model.Skier;
import it.unimi.di.prog2.esame.views.NextSkierView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NextSkierPresenter implements Presenter{

    private final Model m;
    private final NextSkierView view;
    private int i =Main.SKIER_NUM-1;
    public NextSkierPresenter(@NotNull Model m,@NotNull NextSkierView view) {
        this.m = m;
        this.view = view;
        view.addHandlers(this);
        m.addObserver(this);
    }

    @Override
    public void action(String text1, String text2) {
        try {
            Double tempo = Double.parseDouble(text2);
            if (tempo < 60.00){
                m.addTempo(text1,tempo);
            }else{
                view.setName(text1);
            }
        } catch (NumberFormatException e){
            view.setName(text1);
            System.err.println("Formato errato");
        }
    }

    @Override
    public void update(@NotNull Observable<List<Skier>> subject, @NotNull List<Skier> state) {
        List<Skier> s = m.getState();
        if (i==s.size()){
            view.setName("INIZIO");
        }else if(i >= 0) {
            view.setName(s.get(i).getName());
            i--;
        } else {
            view.setName("END OF SLALOM");
        }
    }
}
