package com.youzan.easyranking.vo;

import com.youzan.easyranking.util.Constants;

public class CandidateVo {

	    private long id;
	    private String openId;
	    private String candidateName;
		private String phoneNumber;
	    private int age;
	    private String selfRemark;
	    private int height;
	    private int poll;
	    private String imageFileName;
	    private boolean voteAllowed;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getOpenId() {
			return openId;
		}
		public void setOpenId(String openId) {
			this.openId = openId;
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
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getSelfRemark() {
			return selfRemark;
		}
		public void setSelfRemark(String selfRemark) {
			this.selfRemark = selfRemark;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getPoll() {
			return poll;
		}
		public void setPoll(int poll) {
			this.poll = poll;
		}
		public String getImageFileName() {
			return imageFileName;
		}
		public void setImageFileName(String imageFileName) {
			this.imageFileName = imageFileName;
		}
		public boolean isVoteAllowed() {
			return voteAllowed;
		}
		public void setVoteAllowed(boolean voteAllowed) {
			this.voteAllowed = voteAllowed;
		}
		public String getShowImageFile() {
			return Constants.WEB_CONTEXT_ROOT + Constants.IMAGE_FILE_RELATIVE_PATH + imageFileName;
		}
	
}
