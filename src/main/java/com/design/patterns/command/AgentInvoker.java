package com.design.patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pupsprashu on 28/01/2016.
 */
public class AgentInvoker {
    private List<OrderCommand> ordersQueue = new ArrayList<>();

    public AgentInvoker() {
    }

    void placeOrder(OrderCommand orderCommand) {
        ordersQueue.add(orderCommand);
        orderCommand.execute();
        //ordersQueue.remove(orderCommand);
    }
}
