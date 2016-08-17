package ru.inrecolan.subscribe;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portlet.journal.model.JournalArticle;

public class JournalArticleListener extends BaseModelListener<JournalArticle> {

	@Override
	public void onAfterCreate(JournalArticle model)
			throws ModelListenerException {
		sendEmails(model);
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterUpdate(JournalArticle model)
			throws ModelListenerException {
		sendEmails(model);
		super.onAfterUpdate(model);
	}
	
	// Отсылает сообщение по подписке
	private void sendEmails(JournalArticle model) {
		try {
			if (model.getStatus() == 0 && model.getVersion() == 1D) {
				SubscribeMailSender.sendMails(model);
			}
		} catch(Exception exp) {
			Log log = LogFactoryUtil.getLog(JournalArticleListener.class);
			log.error("ќшибка отправки сообщени¤ после добавлени¤ новости");
			exp.printStackTrace();
		}
	}
}