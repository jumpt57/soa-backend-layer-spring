package soa.backend.layer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import soa.backend.layer.data.entity.Category;
import soa.backend.layer.data.repository.CategoryRepository;

@RestController
@RequestMapping("/categ")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(method = RequestMethod.POST, params = "name")
	public Category create(@RequestParam(value = "name") String name){
		return categoryRepository.save(new Category(name));
	}
	
	@RequestMapping(method = RequestMethod.GET, params = "id")
	public Category get(@RequestParam(value = "id") Long id){
		return categoryRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Category> list(){
		return categoryRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT, params = {"id", "name"})
	public Category modify(@RequestParam(value = "id") Long id, @RequestParam(value = "name") String name){
		Category category = categoryRepository.findOne(id);
		category.setName(name);
		return categoryRepository.save(category);
	}  
	
	@RequestMapping(method = RequestMethod.DELETE)
	public boolean delete(@RequestParam(value = "id") Long id){
		categoryRepository.delete(categoryRepository.findOne(id));
		return categoryRepository.findOne(id) == null;
	}  
}
