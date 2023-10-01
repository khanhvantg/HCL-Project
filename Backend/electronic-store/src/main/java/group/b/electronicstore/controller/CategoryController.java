package group.b.electronicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group.b.electronicstore.model.Category;
import group.b.electronicstore.service.CategoryService;



@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categorySer;

	@GetMapping("/viewall")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public List<Category> getAllCategorys(){
		return categorySer.getAllCategorys();
	}

	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		return new ResponseEntity<Category>(categorySer.createCategory(category), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") long categoryId){
		return new ResponseEntity<Category> (categorySer.getCategoryById(categoryId), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") long categoryId, @RequestBody Category category){
		return new ResponseEntity<Category> (categorySer.updateCategory(category, categoryId), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteSuppiler(@PathVariable("id") long categoryId){
		categorySer.deleteCategory(categoryId);
		return new ResponseEntity<String> ("Delete Category successfully!.", HttpStatus.OK);
	}
}