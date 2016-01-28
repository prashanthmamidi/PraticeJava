package com.design.patterns.command1;

/**
 * Created by pupsprashu on 28/01/2016.
 */
public class AppClinet {

    public static void main(String[] args) {
        OrderReceiver orderReceiver = new OrderReceiver();

        InsertOrderInitiatedCommand insertOrderInitiatedCommand = new InsertOrderInitiatedCommand(orderReceiver);
        InsertAddEntitlementInitiatedCommand insertAddEntitlementInitiatedCommand = new InsertAddEntitlementInitiatedCommand(orderReceiver);
        CallAddEntitlementServiceCommand callAddEntitlementServiceCommand = new CallAddEntitlementServiceCommand(orderReceiver);

        CommandInvoker invoker = new CommandInvoker();
        invoker.takeOrder(insertOrderInitiatedCommand);
        invoker.takeOrder(insertAddEntitlementInitiatedCommand);
        invoker.takeOrder(callAddEntitlementServiceCommand);

        invoker.placeOrder();
    }
}
