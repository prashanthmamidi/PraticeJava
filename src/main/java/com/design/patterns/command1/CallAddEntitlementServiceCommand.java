package com.design.patterns.command1;


/**
 * Created by pupsprashu on 28/01/2016.
 */
public class CallAddEntitlementServiceCommand implements OrderCommand {
    private OrderReceiver orderReceiver;

    public CallAddEntitlementServiceCommand(OrderReceiver orderReceiver) {
        this.orderReceiver = orderReceiver;
    }

    @Override
    public void execute() {
        orderReceiver.callAddEntitlementservice();
    }

    @Override
    public void rollback() {

    }
}
