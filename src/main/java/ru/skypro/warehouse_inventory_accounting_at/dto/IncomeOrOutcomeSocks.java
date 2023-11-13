package ru.skypro.warehouse_inventory_accounting_at.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class IncomeOrOutcomeSocks {

    @NotBlank(message = "This field cannot be empty")
    String color;

    @Min(value = 0)
    @Max(value = 100)
    int cottonPart;

    @Min(value = 1)
    int quantity;

}
