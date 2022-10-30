package Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class Video {
	@Id
	private String id;
	private String title;
	private String link;
	private String poster;
	private int views;
	private String depscription;
	private boolean active;
	
	@OneToMany(mappedBy = "iduser")
	List<Favorite> favorite;
	@OneToMany(mappedBy = "idusers")
	List<Share> share;

	public Video() {

	}

	public Video(String id, String title, String link, String poster, int views, String depscription, boolean active) {
		this.id = id;
		this.title = title;
		this.link = link;
		this.poster = poster;
		this.views = views;
		this.depscription = depscription;
		this.active = active;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getDepscription() {
		return depscription;
	}

	public void setDepscription(String depscription) {
		this.depscription = depscription;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

}
