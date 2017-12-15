package com.mymumapps.recipe.service;

import com.mymumapps.recipe.domain.Recipe;
import com.mymumapps.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class RecipeListServiceTest {

    RecipeListService recipeListService;

    @Mock
    RecipeRepository recipeRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeListService = new RecipeListService(recipeRepository);
    }

    @Test
    public void getReceipeList() {
        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        when(recipeListService.getReceipeList()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeListService.getReceipeList();
        assertEquals(1, recipes.size());
    }
}