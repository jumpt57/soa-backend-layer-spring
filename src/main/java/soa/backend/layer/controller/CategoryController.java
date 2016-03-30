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
	
	@RequestMapping(method=RequestMethod.POST)
	public Category create(@RequestParam(value = "name") String name){
		return categoryRepository.save(new Category(name));
	}
	
	@RequestMapping(method=RequestMethod.GET, name = "get", params = "id")
	public Category get(@RequestParam(value = "id") Long id){
		return categoryRepository.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, name = "list", params = "")
	public Iterable<Category> list(){
		return categoryRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Category modify(){
		return null;
	}  
	
	@RequestMapping(method=RequestMethod.DELETE)
	public String delete(@RequestParam(value = "id") Long id){
		return "OK";
	}  
}
