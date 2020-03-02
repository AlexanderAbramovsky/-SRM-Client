package sahan.abr.repository;

import sahan.abr.entities.Subscription;

import java.util.List;

public class SubscriptionRepository implements CRUDRepository<Subscription> {
    @Override
    public boolean save(Subscription data) {
        return false;
    }

    @Override
    public boolean update(Subscription data) {
        return false;
    }

    @Override
    public boolean delete(Subscription data) {
        return false;
    }

    @Override
    public Subscription findById(int id) {
        return null;
    }

    @Override
    public List<Subscription> findAll() {
        return null;
    }
}
