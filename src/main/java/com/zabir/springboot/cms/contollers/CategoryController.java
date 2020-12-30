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

//    @PostMapping("/category/addall")
//    public List<Category> addCategorys(@RequestBody List<Category> categorys) {
//        return categoryService.saveCategorys(categorys);
//    }

    @GetMapping("/categories")
    public List<Category> findAllCategorys() {
        return categoryService.getCategorys();
    }

    @GetMapping("/categoy/{id}")
    public Category findCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

//    @GetMapping("/category/{name}")
//    public Category findCategoryByName(@PathVariable String name) {
//        return categoryService.getCategoryByName(name);
//    }

    @PutMapping("category/update")
    public Category updateCategory(Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("category/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        return categoryService.deleteCategory(id);
    }
}
