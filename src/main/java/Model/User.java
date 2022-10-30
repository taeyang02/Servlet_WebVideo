package Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	private String id;
	private String password;
	private String email;
	private String fullname;
	private boolean admin;
	private boolean active;
	
	@OneToMany(mappedBy = "iduser")
	List<Favorite> favorite;
	@OneToMany(mappedBy = "idusers")
	List<Share> share;
	
	public User() {
		
	}
	
	public User(String id, String password, String email, String fullname, boolean admin, boolean active) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.admin = admin;
		this.active = active;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public List<Favorite> getFavorite() {
		return favorite;
	}
	public void setFavorite(List<Favorite> favorite) {
		this.favorite = favorite;
	}
	public List<Share> getShare() {
		return share;
	}
	public void setShare(List<Share> share) {
		this.share = share;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	
}
