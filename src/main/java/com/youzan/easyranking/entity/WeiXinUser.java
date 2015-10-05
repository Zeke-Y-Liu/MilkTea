package com.youzan.easyranking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.youzan.easyranking.util.EntityStatus;

@Entity
@Table(name="WEIXIN_USER")
public class WeiXinUser {
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="OPEN_ID")
    private String openId;
	
	@Column(name="NICK_NAME")
    private String nickName;
	
	@Transient
	private EntityStatus status;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Long getId() {
		return id;
	}

	public EntityStatus getStatus() {
		return status;
	}

	public void setStatus(EntityStatus status) {
		this.status = status;
	}

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).
          append(id).
          append(openId).
          append(nickName).
          toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
    	   if (obj == null) { return false; }
    	   if (obj == this) { return true; }
    	   if (obj.getClass() != getClass()) {
    	     return false;
    	   }
    	   WeiXinUser that = (WeiXinUser) obj;
    	   return new EqualsBuilder().
    		          append(id, that.id).
    		          append(openId, that.openId).
    		          append(nickName,that.nickName)
    	              .isEquals();
    }	
	
}
