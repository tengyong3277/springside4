package org.springside.examples.showcase.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the water_message database table.
 * 
 */
@Entity
@Table(name="water_message")
public class Message extends IdEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String content;


	private String title;

    public Message() {
    }

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}