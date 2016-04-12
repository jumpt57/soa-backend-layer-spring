package soa.backend.layer.data.repository;

import org.springframework.data.repository.CrudRepository;

import soa.backend.layer.data.entity.Category;
import soa.backend.layer.data.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

	
}
