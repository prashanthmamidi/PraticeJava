package com.design.patterns.command1;


/**
 * Created by pupsprashu on 28/01/2016.
 */
public class InsertOrderInitiatedCommand implements OrderCommand {
    private OrderReceiver orderReceiver;

    public InsertOrderInitiatedCommand(OrderReceiver orderReceiver) {
        this.orderReceiver = orderReceiver;
    }

    @Override
    public void execute() {
        orderReceiver.insertOrderInitiatedState();
    }

    @Override
    public void rollback() {
        orderReceiver.rollbackInsertOrderInitiatedState();
    }
}
