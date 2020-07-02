package com.example.Prestigebank.model;

import java.util.Date;

import org.springframework.stereotype.Component;


public class Transaction {
private int tno;
private String type;
private int amt;
private Date date;
private String status;
private String location;
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getAmt() {
	return amt;
}
public void setAmt(int amt) {
	this.amt = amt;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
@Override
public String toString() {
	return "Transaction [type=" + type + ", amt=" + amt + ", date=" + date + ", status=" + status + ", location="
			+ location + "]";
}

}
