package com.design.patterns.command;

/**
 * Created by pupsprashu on 28/01/2016.
 */
public class MainAppClient {

    public static void main(String[] args) {
        StockTradeReceiver stockTradeReceiver = new StockTradeReceiver();

        BuyStockOrderCommand buyStockOrderCommand = new BuyStockOrderCommand(stockTradeReceiver);
        SellStockOrderCommand sellStockOrderCommand = new SellStockOrderCommand(stockTradeReceiver);

        AgentInvoker agentInvoker = new AgentInvoker();

        agentInvoker.placeOrder(buyStockOrderCommand);

        agentInvoker.placeOrder(sellStockOrderCommand);
    }
}
