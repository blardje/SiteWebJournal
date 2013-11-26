package com.sdzee.beans;


import java.sql.Timestamp;


public class User {
	private Long      id;
	private String fyname;
	private String ftname;
	private String address;
	private String telephone;
	private String email;
	private Timestamp dateInscription;
	
    public Long getId() {
        return id;
        
    }
    
        
        public Timestamp getDateInscription() {
            return dateInscription;
        }
	
	public String getFyName() {
		return this.fyname;
	}

	public String getFtName() {
		return this.ftname;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	
    public void setId( Long id ) {
        this.id = id;
    }

	public void setFyName( String fyname ) {
		this.fyname = fyname;
	}

	public void setFtname( String ftname ) {
		this.ftname = ftname;
	}
	
	public void setAddress( String address ) {
		this.address = address;
	}
	
	public void setTelephone( String telephone ) {
		this.telephone = telephone;
	}
	
	public void setEmail( String email ) {
		this.email = email;
	}
	
    public void setDateInscription( Timestamp dateInscription ) {
        this.dateInscription = dateInscription;
    }
}


