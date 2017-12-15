package com.mymumapps.recipe.domain;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne  // Тут нет Cascade - не удалять записть по связи при удалении объекта
    private Recipe recipe;

    @Lob  //  Для больших объектов > 255
    private String recipeNotes;

}
