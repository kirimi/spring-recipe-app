package com.mymumapps.recipe.controllers;

import com.mymumapps.recipe.domain.Category;
import com.mymumapps.recipe.domain.UnitOfMeasure;
import com.mymumapps.recipe.repositories.CategoryRepository;
import com.mymumapps.recipe.repositories.UnitOfMeasureRepository;
import com.mymumapps.recipe.service.RecipeListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeListService recipeListService;


    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeListService recipeListService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeListService = recipeListService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat id: " + categoryOptional.get().getId());
        System.out.println("UoN id: " + unitOfMeasureOptional.get().getId());

        model.addAttribute("recipes", recipeListService.getReceipeList());

        return "index";
    }

}
