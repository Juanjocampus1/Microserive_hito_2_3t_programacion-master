package com.empresa.microserviceProductManagement.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "Productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    @Id
    private Long id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
}
