package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EventEntity;
import com.example.demo.repository.EventRepo;

@Service
public class EventService {
		@Autowired
		EventRepo r;
		public EventEntity savedonor(EventEntity de)
		{
			return r.save(de);
		}
		public List<EventEntity> savedetails(List<EventEntity> de)
		{
			return (List<EventEntity>)r.saveAll(de);
		}
		public List<EventEntity> showinfo()
		{
			return r.findAll();
		}
		public Optional<EventEntity> showbyid(int id)
		{
			return r.findById(id);
		}
		public EventEntity changeinfo(EventEntity de)

		{

			return r.saveAndFlush(de);

		}

		public void deleteinfo(EventEntity de)

		{

			r.delete(de);

		}

		public void deleteid(int id)

		{

			r.deleteById(id);

		}
		public List<EventEntity> retrivebyjpqa(){

			return r.fetchAll();

		}

		public List<EventEntity> retrivebynameandid(int id,String name){

			return r.fetchByNameAndId(id,name);

		}

	public void deletebyjpqa(int id) {

			r.deletemebyid(id);

			return;

		}

		public void changebyjpqa(int id1,int id2) {

			r.updatemebyid(id1, id2);

			return;

		}
}
