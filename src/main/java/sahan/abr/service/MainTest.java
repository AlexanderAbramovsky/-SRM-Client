package sahan.abr.service;

import sahan.abr.repository.SubscriptionRepository;

import java.sql.*;


public class MainTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SubscriptionRepository subscriptionRepository = new SubscriptionRepository();
        System.out.println(subscriptionRepository.getAll());
    }

}
