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
    
    @Column(name="CANDIDATE_BIRTHDAY")
	private Date candidateBirthday;
    
    @Column(name="CITY")
	private String city;
    
    @Column(name="CANDIDATE_ID")
    private String candidateId;
    
    @Column(name="GENDER")
    private String gender;
    
    @Column(name="JOB")
    private String job;
  
    @Column(name="SELF_REMARK")
    private String selfRemark;
      
    @Column(name="WEIGHT")
    private float weight;
    
    @Column(name="HEIGHT")
    private float height;
    
    @Column(name="IMAGE_FILE_PATH")
    private String imageFilePath;

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

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
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

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCandidateBirthday() {
		return candidateBirthday;
	}

	public void setCandidateBirthday(Date candidateBirthday) {
		this.candidateBirthday = candidateBirthday;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}	
}