package it.unimi.di.prog2.esame.presenters;

import it.unimi.di.prog2.esame.model.Observable;
import org.jetbrains.annotations.NotNull;

public interface Observer<T>{
    void update(@NotNull Observable<T> subject, @NotNull T state);

}