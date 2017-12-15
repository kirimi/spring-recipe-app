package com.mymumapps.recipe.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)  // Дефолтное поведение, но тут для ясности.  Т.е. запрашивает UnitOfMeasure при каждом запросе Ingredient
    private UnitOfMeasure unitOfMeasure;

    @ManyToOne
    private Recipe recipe;

}
