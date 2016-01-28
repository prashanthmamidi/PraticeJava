package com.design.patterns.command1;

/**
 * Created by pupsprashu on 28/01/2016.
 */
public class OrderReceiver {

    public void insertOrderInitiatedState() {
        System.out.println("Inserting Order state as Initiated...");
    //    throw new RuntimeException();
    }

    public void insertAddEntitlementInitiatedState() {
        System.out.println("Inserting Add Entitlement state as Initiated...");
        throw new RuntimeException();
    }

    public void callAddEntitlementservice() {
        System.out.println("call Add Entitlement service ...");
        //throw new RuntimeException();
    }

    public void insertAddEntitlementCompletedState() {
        System.out.println("Inserting Add Entitlement state as Completed...");
    }

    public void rollbackInsertOrderInitiatedState() {

        System.out.println("Rollbck ....Inserting Order state as Initiated...");
    }

    public void rollbackAddEntitlementInitiatedState() {
        System.out.println("Roll back....Inserting Add Entitlement state as Initiated...");
    }
}
