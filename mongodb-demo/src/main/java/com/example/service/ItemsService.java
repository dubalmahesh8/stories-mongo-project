package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.CacheConfig;
import com.example.entity.Items;
import com.example.repository.ItemsRepository;

@Service
public class ItemsService {

	@Autowired
	ItemsRepository itemsRepository;
	
	@Cacheable(CacheConfig.CACHE_STORIES)
	public List<Items> getTopTenStories(){
		return itemsRepository.findFirst10ByTypeOrderByScoreDesc("story");
	}
	
	public List<Items> getAllStories(){
		return itemsRepository.findByType("story");
	}
	
	public List<Items> getTopTenComments(Long parentId){
		if(parentId != null)
			return itemsRepository.findFirst10ByTypeAndParentOrderByIdDesc("comment", parentId);
		else
			return itemsRepository.findFirst10ByTypeOrderByIdDesc("comment");
	}
	
	public Items createItem (Items item) {
		return itemsRepository.save(item);
	}
	
	public Items updateItem (Items item) {
		return itemsRepository.save(item);
	}
	
	public Items getItembyId(Long id) {
		return itemsRepository.findById(id).get();
	}
	
	public String deleteItem (Long id) {
		itemsRepository.deleteById(id);
		return "Item has been deleted.";
	}
}
