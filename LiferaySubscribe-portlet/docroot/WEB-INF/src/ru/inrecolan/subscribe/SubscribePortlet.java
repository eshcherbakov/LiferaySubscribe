package ru.inrecolan.subscribe;

import java.io.IOException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import ru.inrecolan.subscribe.model.model.Subscribe;
import ru.inrecolan.subscribe.model.service.SubscribeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.Http.Response;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SubscribePortlet
 */
public class SubscribePortlet extends MVCPortlet {
	
	public void unsubscribe(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws IOException, PortletException, PortalException, SystemException {
		try {
			String subscribeId = actionRequest.getParameter("subscribeId");
			Subscribe subscribe = SubscribeLocalServiceUtil.getSubscribe(Long.parseLong(subscribeId));
			if(subscribe != null) {
				// Отписываемся от новостей
				SubscribeLocalServiceUtil.unsubscribe(subscribeId);
				actionResponse.setRenderParameter("mvcPath","/html/subscribe/unsubscribed.jsp");
			} else {
				actionResponse.setRenderParameter("mvcPath","/html/subscribe/view.jsp");
			}
		}
		catch (Exception e) {
			actionResponse.setRenderParameter("mvcPath","/html/subscribe/view.jsp");
		}
		
	}
	
	//TODO create URL on server side
	public void confirmSubscribe(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws IOException, PortletException, PortalException, SystemException {
		try {
			String subscribeId = actionRequest.getParameter("subscribeId");
			Subscribe subscribe = SubscribeLocalServiceUtil.getSubscribe(Long.parseLong(subscribeId));
			if(subscribe != null) {
				// Подтверждаем подписку на новости
				SubscribeLocalServiceUtil.confirmSubscribe(subscribeId);
				actionResponse.setRenderParameter("mvcPath", "/html/subscribe/confirmed.jsp");
			} else {
				actionResponse.setRenderParameter("mvcPath","/html/subscribe/view.jsp");
			}
		} catch (Exception e) {
			actionResponse.setRenderParameter("mvcPath","/html/subscribe/view.jsp");			
		}
	} 
	
	@Override
    public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException,
            PortletException {
        // Получаем адрес электронной почты
        String email = ParamUtil.getString(resourceRequest, "email");
        resourceResponse.setProperty("email", email);
        
        String subscribeApproveSubject = ParamUtil.getString(resourceRequest, "subscribe-approve-subject");
        String subscribeApproveBody = ParamUtil.getString(resourceRequest, "subscribe-approve-body");
        
		try {
			long subscribeId = -1;
			Subscribe subscribe = null;

			subscribe = SubscribeLocalServiceUtil.getSubscribe(email);
			if(subscribe == null) {
				// Если подписка не добавлена в БД, то добавляем
				subscribe = SubscribeLocalServiceUtil.addSubscribe(email, false);
			}
			subscribeId = subscribe.getSubscribeId();
			if (subscribe.getIsActivated()) {
				// Подписка на новости уже подтверждена
				include("/html/subscribe/confirmed.jsp", resourceRequest, 
						resourceResponse, PortletRequest.RESOURCE_PHASE);					
			} else {
				// Подписка на новости требует подтверждения
				PortletResponse portletResponse = (PortletResponse)resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);
				LiferayPortletResponse liferayPortletResponse = PortalUtil.getLiferayPortletResponse(portletResponse);
				
				// Создаём ссылку для подтверждения подписки
				PortletURL confirmActionUrl = liferayPortletResponse.createActionURL();
				confirmActionUrl.setParameter(ActionRequest.ACTION_NAME, "confirmSubscribe");
				confirmActionUrl.setParameter("subscribeId", String.valueOf(subscribeId));
				
				// Создаём ссылку для отказа от подписки
				PortletURL unsubscribeActionUrl = liferayPortletResponse.createActionURL();
				unsubscribeActionUrl.setParameter(ActionRequest.ACTION_NAME, "unsubscribe");
				unsubscribeActionUrl.setParameter("subscribeId", String.valueOf(subscribeId));				
				
				Boolean isMailSend = SubscribePortletMailSender.sendRegistrationMail(email, 
						confirmActionUrl.toString(), 
						unsubscribeActionUrl.toString(),
						subscribeApproveSubject, subscribeApproveBody);
				if(isMailSend) {
					include("/html/subscribe/success.jsp", resourceRequest, 
							resourceResponse, PortletRequest.RESOURCE_PHASE);					
				} else {
					include("/html/subscribe/error.jsp", resourceRequest, 
							resourceResponse, PortletRequest.RESOURCE_PHASE);					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			include("/html/subscribe/error.jsp", resourceRequest, 
					resourceResponse, PortletRequest.RESOURCE_PHASE);
		}
    }	
}
