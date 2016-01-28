package com.design.patterns.command;

/**
 * Created by pupsprashu on 28/01/2016.
 */
public class BuyStockOrderCommand implements OrderCommand {
    private StockTradeReceiver stockTradeReceiver;

    public BuyStockOrderCommand(StockTradeReceiver stockTradeReceiver) {
        this.stockTradeReceiver = stockTradeReceiver;
    }

    @Override
    public void execute() {
        stockTradeReceiver.buy();
    }
}
