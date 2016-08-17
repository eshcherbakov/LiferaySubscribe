package ru.inrecolan.subscribe;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ResourceRequest;

import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.util.mail.MailEngine;

public class SubscribePortletMailSender {

	public static Boolean sendRegistrationMail(String email, String confirmUrl,
			String unsubscribeUrl, String subscribeApproveSubject, String subscribeApproveBody) {
		
		// Определяем заголовок письма
		String subject = subscribeApproveSubject;
		// Определяем тело письма
		StringBuilder mailContent = 
			new StringBuilder(subscribeApproveBody);
		String body = String.format(mailContent.toString(), new Object[] {
			confirmUrl, unsubscribeUrl });
		
		try {
			// Формируем письмо
			MailMessage mailMessage = new MailMessage();
			mailMessage.setHTMLFormat(true);
			mailMessage.setSubject(subject);
			mailMessage.setBody(body);
			mailMessage.setTo(new InternetAddress(email));
			MailEngine.send(mailMessage);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
			return false;
		}		
	}
}
