package com.raouf.demo.notification;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;
import java.util.Date;

@Document("notification")
public class Notification {
	@Id
	private String ID;
	@NonNull
	private String titre;
	@NonNull
	private String content;
	
	public Notification() {
		
	}
	public Notification(String iD, String titre, String content) {
		super();
		ID = iD;
		this.titre = titre;
		this.content = content;
		this.createdAt=new Date();
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	private Date createdAt;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
