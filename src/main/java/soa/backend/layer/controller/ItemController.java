package soa.backend.layer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import soa.backend.layer.data.entity.Category;
import soa.backend.layer.data.entity.Item;
import soa.backend.layer.data.repository.CategoryRepository;
import soa.backend.layer.data.repository.ItemRepository;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;

    @RequestMapping(method = RequestMethod.POST, params =  {"name","description","price","keywords","pic","idcateg"})
    public Item create(@RequestParam(value = "name") String name,
                       @RequestParam(value = "description") String description,
                       @RequestParam(value = "price") float price,
                       @RequestParam(value = "keywords") String[] keywords,
                       @RequestParam(value = "pic") String pic,
                       @RequestParam(value = "idcateg") long idcateg)
    {
        Category category = categoryRepository.findOne(idcateg);
        return itemRepository.save(new Item(name,description,price,keywords,pic,category));
    }

    @RequestMapping(method = RequestMethod.GET, params = "id")
    public Item get(@RequestParam(value = "id") Long id){
        return itemRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Item> list(){
        return itemRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT, params = {"id","name","description","price","keywords","pic","idcateg"})
    public Item modify(@RequestParam(value = "id") Long id,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "description") String description,
                           @RequestParam(value = "price") float price,
                           @RequestParam(value = "keywords") String[] keywords,
                           @RequestParam(value = "pic") String pic,
                           @RequestParam(value = "idcateg") long idcateg)
    {
        Category category = categoryRepository.findOne(idcateg);
        Item item = itemRepository.findOne(id);
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setKeywords(keywords);
        item.setPic(pic);
        item.setCateg(category);
        return itemRepository.save(item);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "id") Long id){
        itemRepository.delete(itemRepository.findOne(id));
        return itemRepository.findOne(id) == null;
    }
}