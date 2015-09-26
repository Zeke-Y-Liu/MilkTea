package com.youzan.easyranking.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.youzan.easyranking.dao.ICandidateDao;
import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.util.Constants;

public class CandidateAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String function;
	private String action;
	private String candidateId;
	private String candidateName;
	private String phoneNumber;
	private String candidateBirthday;
	private String city;
	private String gender;
	private String genderDesc;
	private String selfRemark;
	private String job;
	private float height;
	private float weight;
	private File image;
	private String imageContentType;
	private String imageFileName;
	private String showImageFile;
	
	private int totalCandateCount;
	
	private ICandidateDao candidateDao;

	public String register() {
		if(Constants.ACTION_ENTRY.equalsIgnoreCase(action)) {
			return Constants.ACTION_RESULT_INPUT;
		} else if(Constants.ACTION_SAVE.equalsIgnoreCase(action)){
			
			Candidate candidate = new Candidate();
			candidate.setCandidateName(candidateName);
			candidate.setPhoneNumber(phoneNumber);
			try {
				candidate.setCandidateBirthday(Constants.dateformator.parse(candidateBirthday));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			candidate.setCity(city);
			candidate.setCandidateId(candidateId);
			candidate.setGender(gender);
			candidate.setSelfRemark(selfRemark);
			candidate.setJob(job);
			candidate.setHeight(height);
			candidate.setWeight(weight);
			
			if (image != null) {  	  
				try {
					InputStream is;
					is = new FileInputStream(getImage());
					String imageFilePath = getSavePath() + "/" + getFileFileName();
		            OutputStream os = new FileOutputStream(getSavePath() + "/" + getFileFileName());  
		            IOUtils.copy(is, os);  
		            os.flush();  
		            IOUtils.closeQuietly(is);  
		            IOUtils.closeQuietly(os);  
		            candidate.setImageFilePath(imageFilePath);
		            showImageFile = imageFilePath.substring(imageFilePath.lastIndexOf("images"));
		            System.out.println("showImageFile=" + showImageFile);
				} catch (Exception e) {
					e.printStackTrace();
				}  
			} else {
				return Constants.ACTION_RESULT_INPUT;
			}
			candidateDao.save(candidate);
			return Constants.ACTION_RESULT_SUCCESS;
		} 
		return Constants.ACTION_RESULT_INPUT;
	}
	
	@Override 
	public void validate() { 
		if(Constants.ACTION_ENTRY.equalsIgnoreCase(action)) {
			clearActionErrors();
		} else if(Constants.ACTION_SAVE.equalsIgnoreCase(action)) { // validate
			
		} else {
			// do nothing
		}
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCandidateBirthday() {
		return candidateBirthday;
	}

	public void setCandidateBirthday(String candidateBirthday) {
		this.candidateBirthday = candidateBirthday;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public float getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public ICandidateDao getCandidateDao() {
		return candidateDao;
	}

	public void setCandidateDao(ICandidateDao candidateDao) {
		this.candidateDao = candidateDao;
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

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getGenderDesc() {
		if(Constants.GENDER_FEMALE.equalsIgnoreCase(gender)) {
			genderDesc = Constants.GENDER_FEMALE_DESC;
		} else {
			genderDesc = Constants.GENDER_MALE_DESC;
		}
		return genderDesc;
	}

	public void setGenderDesc(String genderDesc) {
		this.genderDesc = genderDesc;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}


	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	private String getFileFileName() {
		return "PIC" + System.currentTimeMillis() + imageFileName.substring(imageFileName.lastIndexOf("."));
	}
	
	private String getSavePath() {  
        return ServletActionContext.getServletContext().getRealPath("/images");  
    }

	public String getShowImageFile() {
		return showImageFile;
	}

	public int getTotalCandateCount() {
		return totalCandateCount + 188;
	}

	public void setTotalCandateCount(int totalCandateCount) {
		this.totalCandateCount = totalCandateCount;
	}
}
