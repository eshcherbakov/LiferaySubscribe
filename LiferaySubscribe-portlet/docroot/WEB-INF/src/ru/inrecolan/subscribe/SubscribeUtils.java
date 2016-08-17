package ru.inrecolan.subscribe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.portlet.PortletRequest;

public class SubscribeUtils {
	
	public static  boolean validateEmail(String email)
	{
		final String EMAIL_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static String[] getDisplayTags(PortletRequest request)
	{
		String tags = request.getPreferences().getValue("subscribetags", "");
		return tags.split(",");
	}

}
