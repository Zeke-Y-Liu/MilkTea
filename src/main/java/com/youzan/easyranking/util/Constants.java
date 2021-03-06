package com.youzan.easyranking.util;

import java.text.DateFormat;

public class Constants {

	public static String FUNCTION_MANAGE_CANDIDATE = "manageCandidate";
	public static String FUNCTION_VOTE = "vote";

	public static String ACTION_LOGIN = "login";
	public static String ACTION_ENTRY = "entry";
	public static String ACTION_SAVE = "save";
	public static String ACTION_VIEW_CANDIDATE_LIST= "viewCandidateList";
	public static String ACTION_VOTE= "vote";
	
	public static String ACTION_PREVIOUS_PAGE= "previousPage";
	public static String ACTION_NEXT_PAGE= "nextPage";
	public static String ACTION_SPECIFIED_PAGE= "specifiedPage";
	
	public static String ACTION_VIEW_VOTE_RESULT= "viewVoteResult";
	
	public static String ACTION_EDIT= "edit";
	public static String ACTION_UPDATE= "update";
	public static String ACTION_VIEW= "view";
	public static String ACTION_SEARCH_CANDIDATE = "searchCandidate";
	
	public static String ATTRIBUTE_OPEN_ID = "openId";
	public static String ATTRIBUTE_IP_ADDR = "ipAddr";
	
	public static String RESULT_VOTE_RESULT = "voteResult";
	public static String RESULT_VOTE = "voteResult";
		

	public static String GENDER_FEMALE = "F";
	public static String GENDER_MALE = "M";
	
	public static String GENDER_FEMALE_DESC = "女";
	public static String GENDER_MALE_DESC = "男";
	
	public static DateFormat dateformator = new java.text.SimpleDateFormat("yyyy-MM-dd");
	
	// the folder under war package to save all the image files
	public static String IMAGE_FILE_RELATIVE_PATH = "/images/";
	public static String WEB_CONTEXT_ROOT= "/mm";
	
	public static String FORM_TOKEN = "formKen";
	
}
