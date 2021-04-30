package com.zabir.springboot.cms.services.frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabir.springboot.cms.models.Category;
import com.zabir.springboot.cms.repositories.CategoryRepository;

@Service
public class TopMenuService {
	@Autowired
	private CategoryRepository categoryRepository;
	
    public List<Category> getAllItems() {
        return categoryRepository.findAll();
    }
    
    public List<Category> getTopMenuItems(String position, Integer status, Integer language) {
        return categoryRepository.findByPositionAndStatusAndLanguage(position, status, language);
    }

	public Category getItemById(int id) {
		return categoryRepository.findById(id).orElse(null);
	}
}
