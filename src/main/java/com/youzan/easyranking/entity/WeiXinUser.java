package com.youzan.easyranking.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
	
	@Column(name="USER_ID")
	long userId;
	
	@Column(name="AVATAR")
	String avatar;
	@Column(name="FOLLOW_TIME")
	Date followTime;
	@Column(name="GENDER")
	String gender;
	@Column(name="PRONVICE")
	String pronvice;
	@Column(name="CITY")
	String city;
	@Column(name="UNION_ID")
	String unionId;
	
    @OneToMany(mappedBy = "weiXinUser", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<WeiXinTag> tags = new HashSet<WeiXinTag>();
	
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

    public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getFollowTime() {
		return followTime;
	}

	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPronvice() {
		return pronvice;
	}

	public void setPronvice(String pronvice) {
		this.pronvice = pronvice;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public Set<WeiXinTag> getTags() {
		return tags;
	}

	public void setTags(Set<WeiXinTag> tags) {
		this.tags = tags;
	}
	
	@Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
          .append(id)
          .append(openId)
          .append(nickName)
          .append(avatar)
          .append(followTime)
          .append(gender)
          .append(pronvice)
          .append(city)
          .append(unionId)
          .toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
    	   if (obj == null) { return false; }
    	   if (obj == this) { return true; }
    	   if (obj.getClass() != getClass()) {
    	     return false;
    	   }

    	   WeiXinUser that = (WeiXinUser) obj;
    	   return new EqualsBuilder()
    		          .append(id, that.id)
    		          .append(openId, that.openId)
    		          .append(nickName,that.nickName)
    		          .append(avatar,that.avatar)
    		          .append(followTime,that.followTime)
    		          .append(gender,that.gender)
    		          .append(pronvice,that.pronvice)
    		          .append(city,that.city)
    		          .append(unionId,that.unionId)
    	              .isEquals();
    }	

    @Override 
    public String toString() { 
            return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).
            	  append("id", id).
  		          append("openId", openId).
  		          append("avatar",avatar).
  		          append("gender", gender).
  		          append("pronvice", pronvice).
  		          append("city", city).
  		          append("unionId", unionId).
  		          append("tags", tags).
                  toString(); 
    }
	
}
