package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Child;
import com.example.demo.repository.ChildRepo;

@Service
public class ChildService {
	@Autowired
	ChildRepo c;
	
	public String create(Child ch) {
		if(!c.existsById(ch.getBabyId())){
			c.save(ch);
			return "Record inserted successfully";
		}
		else
			return "A record is already found with book id "+ch.getBabyId()+". Please enter record with a different book id.";
	}
	
	public List<Child> read(){
		return c.findAll();
	}
	
	public List<Child> readSorted(String s){
		return c.findAll(Sort.by(Sort.DEFAULT_DIRECTION, s));
	}
	
	public List<Child> readPages(int pno, int psize){
		Page<Child> p = c.findAll(PageRequest.of(pno, psize));
		return p.getContent();
	}
	
	public List<Child> readSortedPages(int pno, int psize, String s){
		Sort st = Sort.by(s).ascending();
		Page<Child> p = c.findAll(PageRequest.of(pno, psize, st));
		return p.getContent();
	}
}
