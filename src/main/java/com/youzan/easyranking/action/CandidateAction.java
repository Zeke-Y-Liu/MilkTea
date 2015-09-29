package com.youzan.easyranking.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;

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
	private Integer age;
	private String gender;
	private String genderDesc;
	private String selfRemark;
	private String job;
	private float height;
	private float weight;
	private File image;
	private String imageContentType;
	private String imageFileName;

	// file name saved to images under war folder
	private String showImageFileName;

	private long totalCandidateCount;

	private ICandidateDao candidateDao;

	public String register() {
		if(Constants.ACTION_ENTRY.equalsIgnoreCase(action)) {
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAA");
			return INPUT;
		} else if(Constants.ACTION_SAVE.equalsIgnoreCase(action)) {
			System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBB");
			Candidate candidate = new Candidate();
			candidate.setCandidateName(candidateName);
			candidate.setPhoneNumber(phoneNumber);
			candidate.setAge(age);
			candidate.setGender(gender);
			candidate.setSelfRemark(selfRemark);
			candidate.setJob(job);
			candidate.setHeight(height);
			candidate.setWeight(weight);

			if (image != null) {
				try {
					InputStream is;
					is = new FileInputStream(getImage());
					this.showImageFileName = getShowImageFileName();
		            OutputStream os = new FileOutputStream(getSavePath() + showImageFileName);
		            IOUtils.copy(is, os);
		            os.flush();
		            IOUtils.closeQuietly(is);
		            IOUtils.closeQuietly(os);
		            candidate.setImageFileName(showImageFileName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				return INPUT;
			}
			candidateDao.save(candidate);
			return SUCCESS;
		}
		System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
		return INPUT;
	}

	@Override
	public void validate() {
		if(Constants.ACTION_ENTRY.equalsIgnoreCase(action)) {
			clearActionErrors();
		} else if(Constants.ACTION_SAVE.equalsIgnoreCase(action)) {
			// validate
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

	// generate unique file name for the candidate
	private String getShowImageFileName() {
		return  "PIC" + System.currentTimeMillis() + imageFileName.substring(imageFileName.lastIndexOf("."));
	}

	private String getSavePath() {
		System.err.println("servletpath=" + ServletActionContext.getServletContext().getRealPath(Constants.IMAGE_FILE_RELATIVE_PATH));
        return ServletActionContext.getServletContext().getRealPath(Constants.IMAGE_FILE_RELATIVE_PATH);
    }

	// relative path and name of the show image file, for e.g /images/PIC123456.jpg
	public String getShowImageFile() {
		return Constants.WEB_CONTEXT_ROOT + Constants.IMAGE_FILE_RELATIVE_PATH + showImageFileName;
	}

	public long getTotalCandidateCount() {
		System.out.println("totalCandidateCount=" + totalCandidateCount);
		totalCandidateCount = candidateDao.getTotalCandidateCount();
		return totalCandidateCount + 188;
	}

	public void setTotalCandidateCount(long totalCandidateCount) {
		this.totalCandidateCount = totalCandidateCount;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}	
}
