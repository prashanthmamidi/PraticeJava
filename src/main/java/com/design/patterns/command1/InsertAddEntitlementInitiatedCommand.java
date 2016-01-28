package com.design.patterns.command1;


/**
 * Created by pupsprashu on 28/01/2016.
 */
public class InsertAddEntitlementInitiatedCommand implements OrderCommand {
    private OrderReceiver orderReceiver;

    public InsertAddEntitlementInitiatedCommand(OrderReceiver orderReceiver) {
        this.orderReceiver = orderReceiver;
    }

    @Override
    public void execute() {
        orderReceiver.insertAddEntitlementInitiatedState();
    }

    @Override
    public void rollback() {
        orderReceiver.rollbackAddEntitlementInitiatedState();

    }
}
