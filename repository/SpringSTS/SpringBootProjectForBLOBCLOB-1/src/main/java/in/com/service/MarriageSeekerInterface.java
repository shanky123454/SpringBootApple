package in.com.service;

import in.com.bo.MarriageSeeker;

public interface MarriageSeekerInterface {
	
	public MarriageSeeker registerMarriage(MarriageSeeker marriageSeeker);
	
	public MarriageSeeker getRegisteredMarriage(Integer id);

}
