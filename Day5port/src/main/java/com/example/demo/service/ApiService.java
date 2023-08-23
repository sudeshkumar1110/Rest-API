package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;

@Service
public class ApiService {
	@Autowired
	BookRepo br;
	
	public List<Book> savedetails(@RequestBody List<Book>   b)
	{
		return (List<Book>)br.saveAll(b);
		//eturn "happy";
	}
	public List<Book> showinfo(){
		return br.findAll();
	} 
	
	public Optional<Book> showbyid(int id){
		return br.findById(id);
	}
	
	public Book changeinfo(Book b)
	{
		return br.saveAndFlush(b);
	}
	
	public void deleteid(int id)
	{
		br.deleteById(id);
	}
	
	public String updateinfobyid(int id,Book b)
	{
		br.saveAndFlush(b);
		if(br.existsById(id))
		{
			return "Updated";
		}
		else
		{
			return "Enter valid id";
		}
	}
}
