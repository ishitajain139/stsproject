package com.sks.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.sks.entity.Drink;

public interface DrinkRepository extends CrudRepository<Drink, Integer>{

	List<Drink> findByName(String name);
	List<Drink> findByType(String type);
}
