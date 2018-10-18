package com.freiheit.trainings.kotlin.challenge;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.freiheit.trainings.kotlin.challenge.fixed.Event;
import com.freiheit.trainings.kotlin.challenge.fixed.IStore;
import com.freiheit.trainings.kotlin.challenge.fixed.Store;

public class EventStore implements IStore<Event> {
    private final Store<Event> store;

    public EventStore() {
        this.store = new Store<>();
    }

    @NotNull @Override public List<Event> load( @NotNull String id ) {
        return store.load( id );
    }

    @Override public void save( @NotNull String id, Event event ) {
        store.save( id, event );
    }

    @Override public void drop() {
        store.drop();
    }
}