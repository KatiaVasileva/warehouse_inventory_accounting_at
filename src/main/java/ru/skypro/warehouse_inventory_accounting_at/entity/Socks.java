package ru.skypro.warehouse_inventory_accounting_at.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class Socks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int sockId;

    String color;

    @Column(name = "cotton_part")
    int cottonPart;

    int quantity;

}
