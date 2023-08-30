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

import com.example.demo.model.EventEntity;
import com.example.demo.service.EventService;

@RestController
public class EventController {
		@Autowired
		EventService ss;
		@PostMapping("addevent")
		public EventEntity add(@RequestBody EventEntity de)
		{
			return ss.savedonor(de);
		}
		@GetMapping("showevent")
		public List<EventEntity> show()
		{
			return ss.showinfo();
		}
		@GetMapping("showbyid/{donorId}")
		public Optional<EventEntity> showid(@PathVariable int eventId)
		{
			return ss.showbyid(eventId);
		}
		@PostMapping("addnevent")
		public List<EventEntity> addndetails(@RequestBody List <EventEntity> de)
		{
			return ss.savedetails(de);
		}
		@PutMapping("update")
		
		public EventEntity modify(@RequestBody EventEntity de)

		{

			return ss.changeinfo(de);

		}

		@DeleteMapping("del")

		public String del(@RequestBody EventEntity de)

		{

			ss.deleteinfo(de);

			return "Deleted successfully";

		}

		@DeleteMapping("delid/{id}")

		public String delid (@PathVariable int id)

		{

			ss.deleteid(id);

			return "Deleted Successfully";

		}
		@GetMapping("showeventbyjpqa")

		public List<EventEntity> show1(){

			return ss.retrivebyjpqa();

		}

		@GetMapping("showeventbynameandid/{id}/{name}")

		public List<EventEntity> show2(@PathVariable int id,@PathVariable String name){

			return ss.retrivebynameandid(id,name);

		}

	@DeleteMapping("erasebyjpqa/{id}")

		public void del4(@PathVariable int id) {

			ss.deletebyjpqa(id);

			return ;

		}

		@PutMapping("updatebyjpqa/{id1}/{id2}")

		public void modifybyjpqa(@PathVariable int id1,@PathVariable int id2) {

			ss.changebyjpqa(id1, id2);

			return ;

		}
}
