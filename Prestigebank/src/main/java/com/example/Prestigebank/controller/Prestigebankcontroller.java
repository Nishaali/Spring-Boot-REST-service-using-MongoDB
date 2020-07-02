package com.example.Prestigebank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prestigebank.exception.NoDataFoundException;
import com.example.Prestigebank.model.Customer;
import com.example.Prestigebank.service.Prestigebankservice;


@RestController
@RequestMapping("/customers")
public class Prestigebankcontroller {
@Autowired
private Prestigebankservice serv;
	
@PostMapping("/create/")
	public String create(@RequestBody Customer cust)
	{
		serv.create(cust);
		return "Created successfully";
	}

@GetMapping("/combo/")
public List<Customer> findByFnameAndCid(@RequestBody Customer cust)
{
	System.out.println(cust.getFname());
	return serv.findByFnameAndCid(cust.getFname(), cust.getCid(),"sun");
}
@GetMapping("/getAll")
public Iterable<Customer> getAll()
{
	return serv.getAll();
}
@GetMapping("/findfname/{fname}")
public Customer findByFname(@PathVariable("fname") String fname) {
	Customer c=serv.findByFname(fname);
	System.out.println(c.getAccno());
	return c;
}
@GetMapping("/findcid/{cid}")
public Customer findByCid(@PathVariable("cid") int cid) {
	Customer c=serv.findByCid(cid);
	System.out.println(c.getFname());
	return c;

}
@GetMapping("/findano/{ano}")
public Customer findByAccno(@PathVariable("ano") String ano) {
	Customer c= serv.findByAccno(ano);
	if(c==null)
		throw new NoDataFoundException("No suitable data found");
	System.out.println(c.getFname());
	return c;
}

@RequestMapping("/updateData/{name}")
public void updateData(@PathVariable("name") String name)
{
	serv.updateData(name);
}

@PutMapping("/update/")
public String saveOrUpdateCustomer(@RequestBody Customer c)
{
	//Customer c=serv.findByCid(cid);
	serv.saveOrUpdateCustomer(c);
	return "Updated successfully";
}
@DeleteMapping("/delete/{cid}")
public String deleteCustomer(@PathVariable("cid") int cid)
{
	Customer c=serv.findByCid(cid);
	serv.deleteCustomer(c);
	return "Deleted successfully";
}
/*@GetMapping("/findminbal/{amt}")
public List<Customer> findByBalanceLessThan(@PathVariable("amt") int amt){
List<Customer> clist=serv.findByLessThanBalance(amt);
return clist;
}*/

@GetMapping("/findminbal/{amt}")
public List<Customer> findByBalanceLessThan(@PathVariable("amt") int amt){
List<Customer> clist=serv.findByBalanceLessThan(amt);
return clist;
}

@GetMapping("/incompletetrans")
public List<Customer> findByIncompleteTransac(){
List<Customer> clist=serv.findByIncompleteTrans();
return clist;
}
}
