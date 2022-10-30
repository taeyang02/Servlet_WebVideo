package Model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "favorite",uniqueConstraints = {@UniqueConstraint(columnNames = {"iduser","idvideo"})})
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;  
	@ManyToOne @JoinColumn(name = "iduser")
	private User iduser;
	@ManyToOne @JoinColumn(name = "idvideo")
	private Video idvideo;
	@Temporal(value = TemporalType.DATE)
	private Date likedate;
	private boolean islike;
	
	
	public Favorite() {
		
	}

	public Favorite(Long id, User iduser, Video idvideo, Date likedate) {
		super();
		this.id = id;
		this.iduser = iduser;
		this.idvideo = idvideo;
		this.likedate = likedate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getIduser() {
		return iduser;
	}


	public void setIduser(User iduser) {
		this.iduser = iduser;
	}


	public Video getIdvideo() {
		return idvideo;
	}


	public void setIdvideo(Video idvideo) {
		this.idvideo = idvideo;
	}


	public Date getLikedate() {
		return likedate;
	}


	public void setLikedate(Date likedate) {
		this.likedate = likedate;
	}


	public boolean getIslike() {
		return islike;
	}

	public void setIslike(boolean islike) {
		this.islike = islike;
	}
}
