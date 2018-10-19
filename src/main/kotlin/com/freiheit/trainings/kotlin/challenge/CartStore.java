package com.freiheit.trainings.kotlin.challenge;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.freiheit.trainings.kotlin.challenge.approved.IStore;
import com.freiheit.trainings.kotlin.challenge.approved.Store;

public class CartStore implements IStore<Cart> {
    private final Store<Cart> store;

    public CartStore() {
        this.store = new Store<>();
    }

    @Nullable @Override public Cart load( @NotNull String id ) {
        return store.load( id );
    }

    @Override public void save( @NotNull String id, Cart cart ) {
        store.save( id, cart );
    }

    @Override public void drop() {
        store.drop();
    }
}