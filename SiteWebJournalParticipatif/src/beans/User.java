package beans;

import java.io.Serializable;
import java.sql.Timestamp;


public class User implements Serializable{
	private static final long serialVersionUID = 34176869499274002L;
	private Long      id;
	private String fyname;
	private String ftname;
	private String address;
	private String telephone;
	private String email;
	private Timestamp dateInscription;
	private String image;
	private String password;
	
	
    public User() {
		super();
	}

	public Long getId() {
        return id;
        
    }
        
    public Timestamp getDateInscription() {
        return dateInscription;
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
	
    public String getImage() {
        return this.image;
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
    
    public void setImage( String image ) {
        this.image = image;
    }

	public String getFyname() {
		return this.fyname;
	}

	public void setFyname(String fyname) {
		this.fyname = fyname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFtname() {
		return this.ftname;
	}
    
}




