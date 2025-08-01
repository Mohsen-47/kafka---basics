package com.kafka.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Item {

    @Id
    Long id;
    String  name;
    Double price;
    Integer stockQuantity;
}
