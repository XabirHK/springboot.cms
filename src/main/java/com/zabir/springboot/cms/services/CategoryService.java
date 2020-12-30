package com.zabir.springboot.cms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabir.springboot.cms.models.Category;
import com.zabir.springboot.cms.repositories.CategoryRepository;


@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category saveCategory(Category category) {
		 return categoryRepository.save(category);
    }

    public List<Category> saveCategorys(List<Category> Categorys) {
        return categoryRepository.saveAll(Categorys);
    }

    public List<Category> getCategorys() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

//    public Category getCategoryByName(String name) {
//        return categoryRepository.findByName(name);
//    }

    public String deleteCategory(int id) {
    	categoryRepository.deleteById(id);
        return "Category removed !! " + id;
    }
    
    
    public Category updateCategory(Category Category) {
        Category existingCategory = categoryRepository.findById(Category.getCategoryId()).orElse(null);

        existingCategory.setTitle(Category.getTitle());
        existingCategory.setParent(Category.getParent());
        existingCategory.setPosition(Category.getPosition());
        existingCategory.setStatus(Category.getStatus());
        existingCategory.setLanguage(Category.getLanguage());
       
        return categoryRepository.save(existingCategory);
    }
}
