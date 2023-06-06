package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Items;

@Repository
public interface ItemsRepository extends MongoRepository<Items, Long> {

	List<Items> findFirst10ByTypeOrderByScoreDesc(String type);
	
	List<Items> findByType(String type);
	
	List<Items> findFirst10ByTypeOrderByIdDesc(String type);
	
	List<Items> findFirst10ByTypeAndParentOrderByIdDesc(String type, Long parentId);
	
}
