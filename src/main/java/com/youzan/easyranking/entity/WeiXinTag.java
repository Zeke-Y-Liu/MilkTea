package com.youzan.easyranking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class WeiXinTag {
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	@Column(name="TAG_NAME")
    private String tagName;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "USER_ID")
	private WeiXinUser weiXinUser;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Long getId() {
		return id;
	}

	public WeiXinUser getWeiXinUser() {
		return weiXinUser;
	}

	public void setWeiXinUser(WeiXinUser weiXinUser) {
		this.weiXinUser = weiXinUser;
	}
}
