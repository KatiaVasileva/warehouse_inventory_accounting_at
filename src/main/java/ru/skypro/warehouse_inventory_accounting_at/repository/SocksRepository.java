package ru.skypro.warehouse_inventory_accounting_at.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.skypro.warehouse_inventory_accounting_at.entity.Socks;

public interface SocksRepository extends CrudRepository<Socks, Integer> {

    Socks findSocksByColorAndCottonPart(String color, int cottonPart);

    @Query(value = "SELECT SUM(s.quantity) FROM Socks s " +
            "WHERE s.color = ?1 AND s.cottonPart > ?2")
    Integer findQuantityOfSocksMoreThan(String color, int cottonPart);

    @Query(value = "SELECT SUM(s.quantity) FROM Socks s " +
            "WHERE s.color = ?1 AND s.cottonPart < ?2")
    Integer findQuantityOfSocksLessThan(String color, int cottonPart);

    @Query(value = "SELECT SUM(s.quantity) FROM Socks s " +
            "WHERE s.color = ?1 AND s.cottonPart = ?2")
    Integer findQuantityOfSocksEqual(String color, int cottonPart);

}
