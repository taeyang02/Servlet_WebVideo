package Model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "share",uniqueConstraints = {@UniqueConstraint(columnNames = {"idusers","idvideos"})})
public class Share {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne @JoinColumn(name = "idusers")
	private User idusers;
	@ManyToOne @JoinColumn(name = "idvideos")
	private Video idvideos;
	private String emails;
	private Date sharedate;
	public Share() {
		
	}
	public Share(Long id, User idusers, Video idvideos, String emails, Date sharedate) {
		this.id = id;
		this.idusers = idusers;
		this.idvideos = idvideos;
		this.emails = emails;
		this.sharedate = sharedate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getIdusers() {
		return idusers;
	}
	public void setIdusers(User idusers) {
		this.idusers = idusers;
	}
	public Video getIdvideos() {
		return idvideos;
	}
	public void setIdvideos(Video idvideos) {
		this.idvideos = idvideos;
	}
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	public Date getSharedate() {
		return sharedate;
	}
	public void setSharedate(Date sharedate) {
		this.sharedate = sharedate;
	}
	
}
