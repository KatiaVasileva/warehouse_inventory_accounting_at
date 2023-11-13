package ru.skypro.warehouse_inventory_accounting_at.service;

import ru.skypro.warehouse_inventory_accounting_at.dto.IncomeOrOutcomeSocks;
import ru.skypro.warehouse_inventory_accounting_at.dto.Operation;

public interface SocksService {

    /**
     * Добавление носков в базу данных
     *
     * @param incomeOrOutcomeSocks {@link IncomeOrOutcomeSocks}
     */
    void addSocks(IncomeOrOutcomeSocks incomeOrOutcomeSocks);

    /**
     * Удаление носков из базы данных
     *
     * @param incomeOrOutcomeSocks {@link IncomeOrOutcomeSocks}
     */
    void removeSocks(IncomeOrOutcomeSocks incomeOrOutcomeSocks);

    /**
     * Получение информации об общем количестве носков в зависимости от параметров
     *
     * @param color {@link String}
     * @param operation {@link Operation}
     * @param cottonPart {@link Integer}
     * @return строка {@link String}
     */
    String getTotalQuantityOfSocksByParameters(String color, Operation operation, int cottonPart);

}
