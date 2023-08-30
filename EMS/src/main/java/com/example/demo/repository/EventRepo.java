package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.EventEntity;

import jakarta.transaction.Transactional;

public interface EventRepo extends JpaRepository<EventEntity, Integer>{
	@Query(value="select * from eventdetails",nativeQuery=true)

	public List<EventEntity>fetchAll(); 

	@Query(value="select * from eventdetails  where customer_id= :pid or customer_name= :pname",nativeQuery=true)

	public List<EventEntity> fetchByNameAndId(@Param("pid") int vendorid,@Param("pname") String name);

	@Transactional

	@Modifying
	

	@Query(value="delete from eventdetails where customer_id= :para",nativeQuery = true )

	public void deletemebyid(@Param("para") int id);

	@Transactional

	@Modifying

	@Query(value="update eventdetails set customer_id= ?2 where customer_id= ?1",nativeQuery = true )

	public void updatemebyid( int oldid,int newid);
}
