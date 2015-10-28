package com.youzan.easyranking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name="WEIXIN_TAG")
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
	
    @Override 
    public String toString() { 
    		long userId = -1;
    		if(weiXinUser != null) {
    			userId = weiXinUser.getUserId();
    		}
            return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).
            	  append("id", id).
  		          append("tagName", tagName).
  		          append("userId", userId).
                  toString(); 
    }
	
}
