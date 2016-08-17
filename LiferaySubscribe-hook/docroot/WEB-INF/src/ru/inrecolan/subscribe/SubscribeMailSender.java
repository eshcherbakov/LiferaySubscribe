package ru.inrecolan.subscribe;

import java.util.List;
import java.util.Locale;
import javax.mail.internet.InternetAddress;
import ru.inrecolan.subscribe.model.model.Subscribe;
import ru.inrecolan.subscribe.model.service.SubscribeLocalServiceUtil;
import com.liferay.portal.NoSuchVirtualHostException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.VirtualHost;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.VirtualHostLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.util.mail.MailEngine;

public class SubscribeMailSender {
	public static void sendMails(JournalArticle journalArticle) {
		List<Subscribe> subscribes = SubscribeLocalServiceUtil
				.getActiveSubscribes();
		sendMail(subscribes, journalArticle);
	}

	private static void sendMail(List<Subscribe> subscribes,
			JournalArticle journalArticle) {
		if (subscribes.size() == 0) {
			return;
		}
		// Определяем тему письма
		String subject = LanguageUtil.get(Locale.getDefault(),
				"subscribe-mail-subject");
		try {
			// Формируем письмо
			MailMessage mailMessage = new MailMessage();
			mailMessage.setHTMLFormat(true);
			mailMessage.setSubject(subject);
			mailMessage.setBody(getMailContent(journalArticle));
			// Формируем массив адресатов письма
			InternetAddress[] addressees = new InternetAddress[subscribes
					.size()];
			for (int i = 0; i < subscribes.size(); i++) {
				Subscribe subscribe = subscribes.get(i);
				addressees[i] = new InternetAddress(subscribe.getEmail());
			}
			mailMessage.setTo(addressees);
			MailEngine.send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Возвращает содержимое письма
	private static String getMailContent(JournalArticle journalArticle) {
		StringBuilder msg = new StringBuilder(LanguageUtil.get(
				Locale.getDefault(), "subscribe-mail-body"));

		String articleUrl = "";
		try {
			String ASSET_PUBLISHER_INSTANCE_PREFIX = "101_INSTANCE_";
			Group group = GroupLocalServiceUtil.getGroup(journalArticle
					.getGroupId());
			List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(
					journalArticle.getGroupId(), false);
			for (Layout layout : layouts) {
				String typeSettings = layout.getTypeSettings();
				if (typeSettings.contains(ASSET_PUBLISHER_INSTANCE_PREFIX)) {

					String friendlyUrl = layout.getFriendlyURL();
					typeSettings = typeSettings.substring(typeSettings
							.indexOf(ASSET_PUBLISHER_INSTANCE_PREFIX));

					String delimiter = ",";
					if (typeSettings.contains(","))
						if (typeSettings.contains("\n"))
							delimiter = typeSettings.indexOf(",") < typeSettings
									.indexOf("\n") ? "," : "\n";
						else
							delimiter = ",";
					else if (typeSettings.contains("\n"))
						delimiter = "\n";

					String portletId = typeSettings.substring(0,
							typeSettings.indexOf(delimiter)).replace(
							ASSET_PUBLISHER_INSTANCE_PREFIX, "");

					LayoutSet layoutSet = LayoutSetLocalServiceUtil
							.getLayoutSet(journalArticle.getGroupId(), false);
					if (layoutSet != null) {
						VirtualHost virtualHost = null;
						try {
							virtualHost = VirtualHostLocalServiceUtil
									.getVirtualHost(
											journalArticle.getCompanyId(),
											layoutSet.getLayoutSetId());
						} catch (NoSuchVirtualHostException e) {
							virtualHost = VirtualHostLocalServiceUtil
									.getVirtualHost(
											journalArticle.getCompanyId(), 0);
						}
						if (virtualHost != null) {
							String host = virtualHost.getHostname();
							String port = String.valueOf(PortalUtil
									.getPortalPort());
							if (port != null && !"".equals(port))
								host += ":" + port;
							articleUrl = "http://" + host + "/ru/web"
									+ group.getFriendlyURL() + friendlyUrl
									+ "/-/asset_publisher/" + portletId
									+ "/content/"
									+ journalArticle.getUrlTitle();
						} else
							throw new PortalException(
									"Article view URL construction error: virtualHost is null");
					} else
						throw new PortalException(
								"Article view URL construction error: layoutSet is null");
					break;
				}
			}
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		String title = "";
		try {
			Document document = SAXReaderUtil.read(journalArticle.getTitle());
			Node node = document.selectSingleNode("/root/Title");
			title = node.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String
				.format(msg.toString(), new Object[] { articleUrl, title });
	}
}
