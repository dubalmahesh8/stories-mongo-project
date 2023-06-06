package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Items;
import com.example.service.ItemsService;

@RestController
@RequestMapping("/v0/item")
public class ItemsController {
	
	@Autowired
	ItemsService itemService;

	@GetMapping("/top-stories")
	public List<Items> getTopTenStories() {
		return itemService.getTopTenStories();
	}
	
	@GetMapping("/past-stories")
	public List<Items> getAllStories() {
		return itemService.getAllStories();
	}
	
	@GetMapping("/comments/{parentId}")
	public List<Items> getAllStudents(Long parentId) {
		return itemService.getTopTenComments(parentId);
	}
	
	
	@PostMapping("/create")
	public Items createStudent(@RequestBody Items item) {
		return itemService.createItem(item);
	}
	
	@PutMapping("/update")
	public Items updateStudent(@RequestBody Items item) {
		return itemService.updateItem(item);
	}
	
	@GetMapping("/{id}")
	public Items getItembyId(@PathVariable Long id) {
		return itemService.getItembyId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteItem(@PathVariable Long id) {
		return itemService.deleteItem(id);
	}
}
