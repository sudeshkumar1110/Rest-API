package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {
	@Autowired
	ApiService a;
	
	@PostMapping("addbook")
	public List<Book> add(@RequestBody List<Book> b)
	{
		return a.savedetails(b);
	}
	@GetMapping("showdetails")
	public List<Book> show(){
		return a.showinfo();
	}
	
	@GetMapping("showid/{id}")
	public Optional<Book> showid(@PathVariable int id)
	{
		return a.showbyid(id);
	}
	
	@DeleteMapping("del/{id}")
	public void del(@PathVariable int id)
	{
		a.deleteid(id);
	}
	
	@PutMapping("updatebyid/{id}")
	public String change(@PathVariable int id , @RequestBody Book b) 
	{
		return a.updateinfobyid(id,b);
	}
	
	

}
