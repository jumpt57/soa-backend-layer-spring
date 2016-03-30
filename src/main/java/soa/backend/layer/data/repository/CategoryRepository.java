package soa.backend.layer.data.repository;

import org.springframework.data.repository.CrudRepository;

import soa.backend.layer.data.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}