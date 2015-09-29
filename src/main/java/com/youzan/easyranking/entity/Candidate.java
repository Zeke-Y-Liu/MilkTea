package  com.youzan.easyranking.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="CANDIDATE")
public class Candidate {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
      
    @Column(name="CANDIDATE_NAME")
    private String candidateName;
    
    @Column(name="PHONE_NUMBER")
	private String phoneNumber;
        
    @Column(name="GENDER")
    private String gender;
    
    @Column(name="AGE")
    private Integer age;
    
    @Column(name="JOB")
    private String job;
  
    @Column(name="SELF_REMARK")
    private String selfRemark;
      
    @Column(name="WEIGHT")
    private float weight;
    
    @Column(name="HEIGHT")
    private float height;
    
    @Column(name="POLL")
    private int poll;
    
    @Column(name="IMAGE_FILE_NAME")
    private String imageFileName;

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSelfRemark() {
		return selfRemark;
	}

	public void setSelfRemark(String selfRemark) {
		this.selfRemark = selfRemark;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPoll() {
		return poll;
	}

	public void setPoll(int poll) {
		this.poll = poll;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}		
}