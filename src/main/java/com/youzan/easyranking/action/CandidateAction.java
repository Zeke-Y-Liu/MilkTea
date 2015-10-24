package com.youzan.easyranking.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.youzan.easyranking.entity.Candidate;
import com.youzan.easyranking.util.Constants;
import com.youzan.easyranking.util.Helper;
import com.youzan.easyranking.vo.PageView;

public class CandidateAction extends AbstractBean {
	/**
	 *
	 */
	private static Logger logger = Logger.getLogger(CandidateAction.class);
	private static final long serialVersionUID = 1L;

	private File image;
	private String imageContentType;
	private String imageFileName;
	private String formToken="";
	// for edit from other page
	private long candidateId;
	private boolean editable = true; 
	private Candidate candidate = new Candidate();
	private PageView pageView = new PageView();
	// file name saved to images under war folder
	private String showImageFileName;

	public String manageCandidate() {
		logger.info("function=" + function + " action=" +action + " candidateId=" + candidateId);
		String result = INPUT;
		initPageView();
		if(Constants.ACTION_ENTRY.equalsIgnoreCase(action)) {
			result = INPUT;
		} else if(Constants.ACTION_SAVE.equalsIgnoreCase(action)) {
			result = saveCandidate(candidate);
		} else if(Constants.ACTION_EDIT.equalsIgnoreCase(action)) {
			result = editCandidate(candidateId);
		} else if(Constants.ACTION_UPDATE.equalsIgnoreCase(action)) {
			result = updateCandidate(candidate, candidateId);
		} else if(Constants.ACTION_VIEW.equalsIgnoreCase(action)) {
			result = viewCandidate(candidateId);
		}
		formToken = generateFormToken();
		logger.info("CandidateAction:register:end:formToken=" + formToken);
		return result;
	}
	private String saveCandidate(Candidate candidate) {
		// prevent user from resubmitting by F5
		if(!isTokenValid()) { // if F5, stay in the same page, do nothing
			logger.info("invalid token, goto input page");
			return INPUT;
		}
		if(hasActionErrors()) {
			logger.info("saveCandidate::action error");
			return INPUT;
		}
		// save uploaded image file to war/images
		this.showImageFileName = saveImageFile(imageFileName);
		candidate.setImageFileName(showImageFileName);
		candidate.setOpenId(getUserInfo().getOpenId());
		cacheManager.register(candidate);
		addActionMessage("恭喜你注册成功!");
		// there is no any other authentication or authorization on current user 
		// editable only if register successfully
		editable = true;
		return SUCCESS;
	}
	
	private String editCandidate(long candidateId) {
		candidate = cacheManager.getCandidateById(candidateId);
		this.showImageFileName = candidate.getImageFileName();
		return INPUT;
	}
	
	private String updateCandidate(Candidate candidateChanged, long originalCandidateId) {
		if(!isTokenValid()) { // if F5, stay in the same page, do nothing
			logger.info("invalid token, goto input page");
			return INPUT;
		}
		if(hasActionErrors()) {
			logger.info("updateCandidate::action error");
			return INPUT;
		}
		Candidate candidateMerged = cacheManager.getCandidateById(candidateId);
		// when updating, image file is optional
		if(StringUtils.isBlank(imageFileName)) {
			candidate.setImageFileName(candidateMerged.getImageFileName());
		} else {
			// save uploaded image file to war/images
			candidate.setImageFileName(showImageFileName);
		}
		this.showImageFileName = candidate.getImageFileName();
		Helper.copyCandidate(candidateMerged, candidate);
		cacheManager.updateCandidate(candidateMerged);
		candidate = candidateMerged;
		addActionMessage("恭喜你更新信息成功!");
		return SUCCESS;
	}
	
	public String viewCandidate(long candidateId) {
		candidate = cacheManager.getCandidateById(candidateId);
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		if(Constants.ACTION_ENTRY.equalsIgnoreCase(action)) {
			clearActionErrors();
		} else if(Constants.ACTION_SAVE.equalsIgnoreCase(action) || Constants.ACTION_UPDATE.equalsIgnoreCase(action)) {
			if(StringUtils.isBlank(candidate.getCandidateName())) {
				addActionError("请填写姓名");
			}
			if(StringUtils.isBlank(candidate.getPhoneNumber())) {
				addActionError("请填写电话号码");
			} 
			String phoneRegx = "^1[358]\\d{9}$|^(\\d{4}-?)?\\d{7,8}$";
			if(!candidate.getPhoneNumber().matches(phoneRegx)) {
				addActionError("请输入正确的手机或固话");
			}
			if(candidate.getAge()== 0) {
				addActionError("请填写年龄");
			}
			if(candidate.getHeight() < 50 ) {
				addActionError("请输入正确的身高");
			}
			if(StringUtils.isBlank(candidate.getSelfRemark())) {
				addActionError("请填写参赛宣言");
			}	
			// if update, image is NOT required, user already has image file
			if(Constants.ACTION_SAVE.equalsIgnoreCase(action)) {
				if( image== null) {
					addActionError("请选择照片");
				}
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
		getUserInfo().setRequestToken(token);
		return token;
	}
	
	public boolean isTokenValid() {
		logger.info("CandidateAction:isResubmitByF5:request formToken=" + formToken);
		logger.info("CandidateAction:isResubmitByF5:session formToken=" + ActionContext.getContext().getSession().get(Constants.FORM_TOKEN));
		return (formToken != null && formToken.equals(getUserInfo().getRequestToken()));
	}
	
	public String getFormToken() {
		return formToken;
	}
	public void setFormToken(String formToken) {
		this.formToken = formToken;
	}
	private String saveImageFile(String uploadedImageFileName) {
		String savedIageFileName = "";
		try {
			InputStream is;
			is = new FileInputStream(getImage());
			savedIageFileName = "PIC" + System.currentTimeMillis() + uploadedImageFileName.substring(uploadedImageFileName.lastIndexOf("."));
			OutputStream os = new FileOutputStream(getSavePath() + savedIageFileName);
			IOUtils.copy(is, os);
			os.flush();
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		} catch (Exception e) {
			logger.info("save image file error", e);
			e.printStackTrace();
		}
		return savedIageFileName;
	}

	private void initPageView() {
		pageView.setTotalCandidateCount(cacheManager.getAllCandiateList().size());
		pageView.setTotalVoteCount(cacheManager.getAllVoteList().size());
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
	private String getSavePath() {
        return ServletActionContext.getServletContext().getRealPath(Constants.IMAGE_FILE_RELATIVE_PATH);
    }
	// relative path and name of the show image file, for e.g /images/PIC123456.jpg
	public String getShowImageFile() {
		return Constants.WEB_CONTEXT_ROOT + Constants.IMAGE_FILE_RELATIVE_PATH + showImageFileName;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public PageView getPageView() {
		return pageView;
	}
	public void setPageView(PageView pageView) {
		this.pageView = pageView;
	}
}
