package com.design.patterns.command1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pupsprashu on 28/01/2016.
 */
public class CommandInvoker {
    private List<OrderCommand> orderCommands = new ArrayList<>();

    public void takeOrder(OrderCommand orderCommand) {
        orderCommands.add(orderCommand);
    }
    public void placeOrder() {
        for (OrderCommand orderCommand : orderCommands ) {
            try {
                orderCommand.execute();
            } catch (Exception ex) {
                orderCommand.rollback();
                break;
            }
        }
        orderCommands.clear();
        System.out.println("Out of loop....");

    }

}
