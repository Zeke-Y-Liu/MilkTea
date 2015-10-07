package com.youzan.easyranking.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.youzan.easyranking.cache.CacheManger;
import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.util.Constants;

public class CandidateAction extends ActionSupport {
	/**
	 *
	 */
	private static Logger logger = Logger.getLogger(CandidateAction.class);
	private static final long serialVersionUID = 1L;
	private String function;
	private String action;
	private String candidateId;
	private String candidateName;
	private String phoneNumber;
	private int age;
	private String gender;
	private String genderDesc;
	private String selfRemark;
	private String job;
	private float height;
	private float weight;
	private File image;
	private String imageContentType;
	private String imageFileName;
	
	private String formToken="";

	// file name saved to images under war folder
	private String showImageFileName;

	private long totalCandidateCount;

	private CacheManger cacheManager;

	public String register() {
		logger.info("CandidateAction:register:begin");
		logger.info("function=" + function + " action=" +action + " candidateId=" + candidateId);
		// String result = INPUT;
		if(Constants.ACTION_ENTRY.equalsIgnoreCase(action)) {
			formToken = generateFormToken();
			logger.info("register:action entry:formToken=" + formToken);
			return INPUT;
		} else if(Constants.ACTION_SAVE.equalsIgnoreCase(action)) {
			// prevent user from resubmitting by F5
			if(!isTokenValid()) { // if F5, stay in the same page, do nothing
				logger.info("invalid token, goto input page");
				formToken = generateFormToken();
				return INPUT;
			}
			if(hasActionErrors()) {
				logger.info("register:has action error");
				formToken = generateFormToken();
				return INPUT;
			}
			Candidate candidate = new Candidate();
			candidate.setCandidateName(candidateName);
			candidate.setPhoneNumber(phoneNumber);
			candidate.setAge(age);
			candidate.setGender(gender);
			candidate.setSelfRemark(selfRemark);
			candidate.setJob(job);
			candidate.setHeight(height);
			candidate.setWeight(weight);

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
				logger.info("save image file error", e);
				e.printStackTrace();
			}

			cacheManager.register(candidate);
			// save candidate, generate new token
			formToken = generateFormToken();
			addActionMessage("恭喜你注册成功!");
			return SUCCESS;
		}
		formToken = generateFormToken();
		logger.info("CandidateAction:register:end:formToken=" + formToken);
		return INPUT;
	}

	@Override
	public void validate() {
		if(Constants.ACTION_ENTRY.equalsIgnoreCase(action)) {
			clearActionErrors();
		} else if(Constants.ACTION_SAVE.equalsIgnoreCase(action)) {

			if(candidateName == null || "".equalsIgnoreCase(candidateName.trim())) {
				addActionError("请填写姓名");
			}
			if(phoneNumber == null || "".equalsIgnoreCase(phoneNumber.trim())) {
				addActionError("请填写电话号码");
			} 
			String phoneRegx = "^1[358]\\d{9}$|^(\\d{4}-?)?\\d{7,8}$";
			if(!phoneNumber.matches(phoneRegx)) {
				addActionError("请输入正确的手机或固话");
			}
			if(age == 0) {
				addActionError("请填写年龄");
			}
			if(job == null || "".equalsIgnoreCase(job.trim())) {
				addActionError("请填写工作");
			}
			if(height < 50 ) {
				addActionError("请输入正确的身高");
			}
			if(selfRemark == null || "".equalsIgnoreCase(selfRemark.trim())) {
				addActionError("请填写参赛宣言");
			}	
			if( image== null) {
				addActionError("请选择照片");
			}
		} else {
			// do nothing
		}
	}
	// prevent user from resubmitting by F5
	/**
	 * generate unique token id and save into session
	 * @return
	 */
	private String generateFormToken() {
		String token = System.currentTimeMillis() + "";
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put(Constants.FORM_TOKEN, token);
		return token;
	}
	
	public boolean isTokenValid() {
		logger.info("CandidateAction:isResubmitByF5:request formToken=" + formToken);
		logger.info("CandidateAction:isResubmitByF5:session formToken=" + ActionContext.getContext().getSession().get(Constants.FORM_TOKEN));
		return (formToken != null && formToken.equals(ActionContext.getContext().getSession().get(Constants.FORM_TOKEN)));
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


	public CacheManger getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManger cacheManager) {
		this.cacheManager = cacheManager;
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
		totalCandidateCount = cacheManager.getAllCandiateList().size();
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

	public String getFormToken() {
		return formToken;
	}

	public void setFormToken(String formToken) {
		this.formToken = formToken;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
