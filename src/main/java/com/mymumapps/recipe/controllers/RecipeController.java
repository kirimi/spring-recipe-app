package com.mymumapps.recipe.controllers;

import com.mymumapps.recipe.service.RecipeListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    RecipeListService recipeListService;

    public RecipeController(RecipeListService recipeListService) {
        this.recipeListService = recipeListService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeListService.findById(new Long(id)));
        return "recipe/show";
    }
}
