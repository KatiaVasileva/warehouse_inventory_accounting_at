package ru.skypro.warehouse_inventory_accounting_at.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @io.swagger.v3.oas.annotations.Operation(summary = "Регистрация прихода носков на склад", description = "Добавляет носки в базу данных. " +
            "Если носки с указанными параметрами уже есть в базе данных, увеличивает их количество на соответствующую цифру.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Носки добавлены", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IncomeOrOutcomeSocks.class))}),
            @ApiResponse(
                    responseCode = "400", description = "Некорректный запрос"),
            @ApiResponse(
                    responseCode = "500", description = "Отсутствует доступ к базе данных")
    })
    public void addSocks(@Valid @RequestBody IncomeOrOutcomeSocks incomeOrOutcomeSocks) {
        socksService.addSocks(incomeOrOutcomeSocks);
    }

    @PostMapping("/outcome")
    @io.swagger.v3.oas.annotations.Operation(summary = "Регистрация отпуска носков со склада",
            description = "Удаляет соответствующее количество носков из базы данных. " +
                    "Если количество запрашиваемых носков превышает имеющееся количество, выдает соответствущее сообщение.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Носки удалены", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = IncomeOrOutcomeSocks.class))}),
            @ApiResponse(
                    responseCode = "400", description = "Некорректный запрос"),
            @ApiResponse(
                    responseCode = "404", description = "Носки не найдены или найдено недостаточное количество"),
            @ApiResponse(
                    responseCode = "500", description = "Отсутствует доступ к базе данных")
    })
    public void removeSocks(@Valid @RequestBody IncomeOrOutcomeSocks incomeOrOutcomeSocks) {
        socksService.removeSocks(incomeOrOutcomeSocks);
    }

    @GetMapping
    @io.swagger.v3.oas.annotations.Operation(summary = "Получение информации об общем количестве носков на складе",
            description = "Получение информации об общем количестве носков на складе, соответствующих переданным в параметрах критериям запроса " +
                    "(цвет и процентное содержание хлопка)")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Информация получена"),
            @ApiResponse(
                    responseCode = "400", description = "Некорректный запрос"),
            @ApiResponse(
                    responseCode = "404", description = "Информация не найдена"),
            @ApiResponse(
                    responseCode = "500", description = "Отсутствует доступ к базе данных")
    })
    public String getTotalQuantityOfSocksByParameters(@RequestParam(value = "color") String color,
                                                      @RequestParam(value = "operation") Operation operation,
                                                      @RequestParam(value = "cottonPart") int cottonPart) {
        return socksService.getTotalQuantityOfSocksByParameters(color, operation, cottonPart);
    }
}
