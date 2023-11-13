package ru.skypro.warehouse_inventory_accounting_at.exceptions;

public class InsufficientQuantityException extends RuntimeException{

    public static final String DEFAULT_MESSAGE = "Insufficient quantity of socks";

    public InsufficientQuantityException() {
        super(DEFAULT_MESSAGE);
    }

}
