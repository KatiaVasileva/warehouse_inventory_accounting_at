package ru.skypro.warehouse_inventory_accounting_at.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.warehouse_inventory_accounting_at.dto.IncomeOrOutcomeSocks;
import ru.skypro.warehouse_inventory_accounting_at.dto.Operation;
import ru.skypro.warehouse_inventory_accounting_at.entity.Socks;
import ru.skypro.warehouse_inventory_accounting_at.exceptions.InsufficientQuantityException;
import ru.skypro.warehouse_inventory_accounting_at.exceptions.SocksNotFoundException;
import ru.skypro.warehouse_inventory_accounting_at.mapper.SocksMapper;
import ru.skypro.warehouse_inventory_accounting_at.repository.SocksRepository;

@Service
@RequiredArgsConstructor
public class SocksServiceImpl implements SocksService{

    public final SocksRepository socksRepository;
    public final SocksMapper socksMapper;

    public void addSocks(IncomeOrOutcomeSocks incomeOrOutcomeSocks) {
        Socks socks = socksRepository.findSocksByColorAndCottonPart(incomeOrOutcomeSocks.getColor(),
                incomeOrOutcomeSocks.getCottonPart());
        if (socks == null) {
            socks = socksMapper.incomeOrOutcomeSocksToSocks(incomeOrOutcomeSocks);
        } else {
            socks.setQuantity(socks.getQuantity() + incomeOrOutcomeSocks.getQuantity());
        }
        socksRepository.save(socks);
    }

    public void removeSocks(IncomeOrOutcomeSocks incomeOrOutcomeSocks) {
        Socks socks = socksRepository.findSocksByColorAndCottonPart(incomeOrOutcomeSocks.getColor(),
                incomeOrOutcomeSocks.getCottonPart());
        if (socks == null) {
            throw new SocksNotFoundException();
        }
        int newQuantity = socks.getQuantity() - incomeOrOutcomeSocks.getQuantity();
        if (newQuantity < 0) {
            throw new InsufficientQuantityException();
        }
        socks.setQuantity(newQuantity);
        socksRepository.save(socks);
    }

    public String getTotalQuantityOfSocksByParameters(String color, Operation operation, int cottonPart) {
        Integer totalQuantity;
        if (operation.equals(Operation.moreThan)) {
            totalQuantity = socksRepository.findQuantityOfSocksMoreThan(color, cottonPart);
        } else if (operation.equals(Operation.lessThan)) {
            totalQuantity = socksRepository.findQuantityOfSocksLessThan(color, cottonPart);
        } else {
            totalQuantity = socksRepository.findQuantityOfSocksEqual(color, cottonPart);
        }
        if (totalQuantity == null) {
            throw new SocksNotFoundException();
        }
        return Integer.toString(totalQuantity);
    }
}
