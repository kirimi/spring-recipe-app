package com.mymumapps.recipe.bootstrap;


import com.mymumapps.recipe.domain.Ingredient;
import com.mymumapps.recipe.domain.Recipe;
import com.mymumapps.recipe.repositories.RecipeRepository;
import com.mymumapps.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public Bootstrap(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        log.info("Loading data...");

        Recipe r1 = new Recipe();
        r1.setDescription("How to Make Perfect Guacamole");
        r1.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");

        Set<Ingredient> r1Ing = new HashSet<Ingredient>();
        for(int i=0; i<3; i++){
            Ingredient ing = new Ingredient();
            ing.setDescription("Ingredient " + i);
            ing.setRecipe(r1);
            r1Ing.add(ing);
        }

        r1.setIngredients(r1Ing);
        recipeRepository.save(r1);

        Recipe r2 = new Recipe();
        r2.setDescription("How how to make");
        r2.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");

        Set<Ingredient> r2Ing = new HashSet<Ingredient>();
        for(int i=0; i<5; i++){
            Ingredient ing = new Ingredient();
            ing.setDescription("Ingredient " + i);
            ing.setRecipe(r2);
            r2Ing.add(ing);
        }

        r2.setIngredients(r2Ing);
        recipeRepository.save(r2);

    }
}
