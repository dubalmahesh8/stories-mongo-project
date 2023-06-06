package com.example.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "items")
public class Items {

	@Id
	private String _id;
	
	private Long id;

	@Field(name = "deleted")
	private Boolean deleted;

	@Field(name = "type")
	private String type;
	
	@Field(name = "by")
	private String by;
	
	@Field(name = "time")
	private Long time;
	
	@Field(name = "text")
	private String text;
	
	@Field(name = "dead")
	private Boolean dead;
	
	@Field(name = "parent")
	private Long parent;
	
	@Field(name = "poll")
	private Long poll;
	
	@Field(name = "kids")
	private List<String> kids;
	
	@Field(name = "url")
	private String url;
	
	@Field(name = "score")
	private Long score;
	
	@Field(name = "title")
	private String title;
	
	@Field(name = "parts")
	private List<String> parts;
	
	@Field(name = "descendants")
	private Long descendants;

}