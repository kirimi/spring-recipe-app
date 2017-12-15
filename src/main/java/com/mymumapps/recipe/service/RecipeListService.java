package com.mymumapps.recipe.service;

import com.mymumapps.recipe.domain.Recipe;
import com.mymumapps.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeListService {

    private RecipeRepository recipeRepository;

    public RecipeListService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Set<Recipe> getReceipeList() {
        log.debug("Hi, I'm logger slf4j");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
