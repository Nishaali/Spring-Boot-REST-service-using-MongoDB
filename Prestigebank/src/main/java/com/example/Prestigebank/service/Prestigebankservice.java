package com.example.Prestigebank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.stereotype.Service;

import com.example.Prestigebank.model.Customer;
import com.example.Prestigebank.model.Transaction;
import com.example.Prestigebank.repository.Prestigebankrepository;


@Service
public class Prestigebankservice {

@Autowired
private Prestigebankrepository repo;
@Autowired
private MongoTemplate mongoTemplate;

public void updateData(String name)
{
Query query = new Query();
query.addCriteria(
	    new Criteria().andOperator(
	        Criteria.where("fname").is("mani"),
	        Criteria.where("balance").is(500)
	    ));
Update update = new Update();
update.set("fname", "lalala");
mongoTemplate.updateMulti(query, update, Customer.class);
}
public List<Customer> findByFnameAndCid(String fname,int cid,String lname)
{
	return repo.findByFnameAndCidAndLname(fname, cid,lname);
}
public Customer create(Customer cust)
{
	return repo.save(cust);
}
public Iterable<Customer> getAll()
{
	return repo.findAll();
}
public Customer findByFname(String fname)
{
	return repo.findByFname(fname);
}
public Customer findByAccno(String ano)
{
	return repo.findByAccno(ano);
}
public Customer findByCid(int cid)
{
	return repo.findByCid(cid);
}

public void saveOrUpdateCustomer(Customer cust)
{
	repo.save(cust);
}
public void deleteCustomer(Customer cust)
{
	repo.delete(cust);
}
/*public List<Customer> findByLessThanBalance(int amt){
        List<Customer> clist=repo.findAll();
        List<Customer> nlist=new ArrayList<Customer>();
        for(Customer c:clist)
        {
        	if(c.getBalance()<=amt)
        		nlist.add(c);
        }
return nlist;
}*/
public List<Customer> findByBalanceLessThan(int amt)
{
	return repo.findByBalanceLessThan(amt);
}
public List<Customer> findByIncompleteTrans(){
    List<Customer> clist=repo.findAll();
    List<Customer> nlist=new ArrayList<Customer>();
    List<Transaction> tlist=new ArrayList<Transaction>();
    for(Customer c:clist)
    {
    	tlist=c.getTransac();
    	//System.out.println(tlist);
    	if(tlist!=null) {
    	for(Transaction t:tlist)
    	{
    		if(t.getType().equals("incomplete"))
    			nlist.add(c);
    	}
    	}
    		
    }
return nlist;
}
}
