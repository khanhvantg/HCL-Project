package group.b.electronicstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.b.electronicstore.exception.ResourceNotFoundException;
import group.b.electronicstore.model.Category;
import group.b.electronicstore.repository.CategoryRepository;
import group.b.electronicstore.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public List<Category> getAllCategorys() {
		return categoryRepo.findAll();
	}

	@Override
	public Category getCategoryById(long id) {
		return categoryRepo.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Category", "Id", id));
	}

	@Override
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	@Override
	public Category updateCategory(Category category, long id) {
		Category existingCategory = categoryRepo.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Category", "Id", id));
		if(!category.getName().equals("")){
			existingCategory.setName(category.getName());
		}
		if(!category.getStatus().equals("")){
			existingCategory.setStatus(category.getStatus());
		}
		if(!category.getDescription().equals("")){
			existingCategory.setDescription(category.getDescription());
		}
		categoryRepo.save(existingCategory);
		return existingCategory;
	}

	
	@Override
	public void deleteCategory(long id) {
		categoryRepo.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Category", "Id", id));
		categoryRepo.deleteById(id);
	}
}
