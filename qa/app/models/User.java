package models;

import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;


/**A user with name and first-name.
 * 
 * @author dwettstein
 * 
 */
@Entity
public class User extends Model {

	@Required
	public String name;
	
    @Email
    @Required
	public String email;
   
    @Required
	public String password;
	public boolean isAdmin;

	
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.isAdmin = false;
	}
	
	public static User login(String email, String password) {
	    return find("byEmailAndPassword", email, password).first();
	}

	public String toString() {
		return name;
	}
}
