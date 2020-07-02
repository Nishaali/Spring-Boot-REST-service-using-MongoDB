package com.example.Prestigebank.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="Customer")
public class Customer{

@Id
private String _id;
private int cid;
@JsonIgnore
private String fname;
private String lname;
private String accno;
private String acctype;
private float balance;
private List<Transaction> transac;

public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public String getAccno() {
	return accno;
}

public void setAccno(String accno) {
	this.accno = accno;
}

public String getAcctype() {
	return acctype;
}

public void setAcctype(String acctype) {
	this.acctype = acctype;
}

public float getBalance() {
	return balance;
}

public void setBalance(float balance) {
	this.balance = balance;
}


public Customer(String fname,String lname) {
	this.fname=fname;
	this.lname=lname;
}



public String getId() {
	return _id;
}

public void setId(String _id) {
	this._id = _id;
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public List<Transaction> getTransac() {
	return transac;
}

public void setTransac(List<Transaction> transac) {
	this.transac = transac;
}

@Override
public String toString() {
	return "Customer [id=" + _id + ", cid=" + cid + ", fname=" + fname + ", lname=" + lname + ", accno=" + accno
			+ ", acctype=" + acctype + ", balance=" + balance + ", transac=" + transac + "]";
}

}
