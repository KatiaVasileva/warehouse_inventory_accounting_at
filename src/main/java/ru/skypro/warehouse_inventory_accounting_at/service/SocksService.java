package ru.skypro.warehouse_inventory_accounting_at.service;

import ru.skypro.warehouse_inventory_accounting_at.dto.IncomeOrOutcomeSocks;
import ru.skypro.warehouse_inventory_accounting_at.dto.Operation;

public interface SocksService {

    void addSocks(IncomeOrOutcomeSocks incomeOrOutcomeSocks);

    void removeSocks(IncomeOrOutcomeSocks incomeOrOutcomeSocks);

    String getTotalQuantityOfSocksByParameters(String color, Operation operation, int cottonPart);

}
