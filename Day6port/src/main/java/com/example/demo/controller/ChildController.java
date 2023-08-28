package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Child;
import com.example.demo.service.ChildService;

import jakarta.persistence.Table;

@RestController
@Table(name="child_details")
public class ChildController {
	@Autowired
	ChildService cser;
	
	//Read
	@GetMapping("getChild")
	public List<Child> show(){
		return cser.read();
	}
	
	//Create
	@PostMapping("addChild")
	public String add(@RequestBody Child bk) {
		return cser.create(bk);
	}
	
	//Read sorted
	@GetMapping("getSortedChild/{s}")
	public List<Child> readSorted(@PathVariable String s){
		return cser.readSorted(s);
	}
	
	//Read by Pages
	@GetMapping("/getPages/pgsize{size}/pgno{page}")
	public List<Child> readPages(@PathVariable int page, @PathVariable int size){
		return cser.readPages(page, size);
	}
	
	//Read by Sorted pages
	@GetMapping("/getSortedPages/sortby{s}/pgsize{size}/pgno{page}")
	public List<Child> readSortedPages(@PathVariable int page, @PathVariable int size, @PathVariable String s){
		return cser.readSortedPages(page, size, s);
	}
}