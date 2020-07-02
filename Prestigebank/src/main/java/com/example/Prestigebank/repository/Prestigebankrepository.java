package com.example.Prestigebank.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Prestigebank.model.Customer;

@Repository
public interface Prestigebankrepository extends MongoRepository<Customer,String>{
	public Customer findByFname(String fname);
	public Customer findByCid(int cid);
	public Customer findByAccno(String ano);
	public List<Customer> findByFnameAndCidAndLname(String fname,int cid,String lname);
    public List<Customer> findByBalanceLessThan(int amt);
}
