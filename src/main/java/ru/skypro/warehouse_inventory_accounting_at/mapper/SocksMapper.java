package ru.skypro.warehouse_inventory_accounting_at.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.skypro.warehouse_inventory_accounting_at.dto.IncomeOrOutcomeSocks;
import ru.skypro.warehouse_inventory_accounting_at.entity.Socks;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SocksMapper {

    Socks incomeOrOutcomeSocksToSocks(IncomeOrOutcomeSocks incomeOrOutcomeSocks);

}
