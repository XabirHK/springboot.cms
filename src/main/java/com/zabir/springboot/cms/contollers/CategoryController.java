package com.zabir.springboot.cms.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zabir.springboot.cms.models.Category;
import com.zabir.springboot.cms.services.CategoryService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("category/add")
    public Category addCategory(Category category) {
        return categoryService.saveCategory(category);
    }


    @GetMapping("/categories")
    public List<Category> findAllCategorys() {
        return categoryService.getCategorys();
    }

    @GetMapping("/category/{id}")
    public Category findCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("category/update")
    public Category updateCategory(Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("category/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        return categoryService.deleteCategory(id);
    }
}
