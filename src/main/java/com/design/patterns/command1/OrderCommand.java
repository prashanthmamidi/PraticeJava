package com.design.patterns.command1;

/**
 * Created by pupsprashu on 28/01/2016.
 */
public interface OrderCommand {
    void execute();

    void rollback();
}
