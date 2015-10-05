package com.youzan.easyranking.entity;

import java.util.Date;

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

/**
 * 
 * @author Administrator
 * many to many relationship between users and candidates
 * a user can vote a candidate more then one time?
 * time stamp of last vote and total count
 *
 */
@Entity
@Table(name="VOTE")
public class Vote {
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="CANDIDATE_ID")
	private Long candidateId;
	
	@Column(name="USER_OPEN_ID")
	private String userOpenId;
	
	@Column(name="VOTE_TIME")
	private Date voteTime;
	
	@Transient
	private EntityStatus status;

	public long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}

	public String getUserOpenId() {
		return userOpenId;
	}

	public void setUserOpenId(String userOpenId) {
		this.userOpenId = userOpenId;
	}

	public Date getVoteTime() {
		return voteTime;
	}

	public void setVoteTime(Date voteTime) {
		this.voteTime = voteTime;
	}

	public long getId() {
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
          append(candidateId).
          append(userOpenId).
          append(voteTime).
          toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
    	   if (obj == null) { return false; }
    	   if (obj == this) { return true; }
    	   if (obj.getClass() != getClass()) {
    	     return false;
    	   }
    	   Vote that = (Vote) obj;
    	   return new EqualsBuilder().
    		          append(id, that.id).
    		          append(candidateId, that.candidateId).
    		          append(userOpenId,that.userOpenId).
    		          append(voteTime, that.voteTime)
    	              .isEquals();
    }	
}
