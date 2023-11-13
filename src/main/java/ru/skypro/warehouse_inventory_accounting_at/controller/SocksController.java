package ru.skypro.warehouse_inventory_accounting_at.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.warehouse_inventory_accounting_at.dto.IncomeOrOutcomeSocks;
import ru.skypro.warehouse_inventory_accounting_at.dto.Operation;
import ru.skypro.warehouse_inventory_accounting_at.service.SocksService;

@RestController
@RequestMapping("/api/socks")
@RequiredArgsConstructor
public class SocksController {

    private final SocksService socksService;

    @PostMapping("/income")
    public void addSocks(@Valid @RequestBody IncomeOrOutcomeSocks incomeOrOutcomeSocks) {
        socksService.addSocks(incomeOrOutcomeSocks);
    }

    @PostMapping("/outcome")
    public void removeSocks(@Valid @RequestBody IncomeOrOutcomeSocks incomeOrOutcomeSocks) {
        socksService.removeSocks(incomeOrOutcomeSocks);
    }

    @GetMapping
    public String getTotalQuantityOfSocksByParameters(@RequestParam(value = "color") String color,
                                                      @RequestParam(value = "operation") Operation operation,
                                                      @RequestParam(value = "cottonPart") int cottonPart) {
        return socksService.getTotalQuantityOfSocksByParameters(color, operation, cottonPart);
    }
}
