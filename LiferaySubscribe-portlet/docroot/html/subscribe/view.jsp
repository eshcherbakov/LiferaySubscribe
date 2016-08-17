<%@page import="ru.inrecolan.subscribe.SubscribeUtils"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/dependencies/common/init.jsp" %>

<portlet:defineObjects />

 <portlet:resourceURL var="subscribeActionURL">  
 </portlet:resourceURL> 
 <portlet:resourceURL var="unsubscribeActionURL">  
 </portlet:resourceURL>  

<script type="text/javascript">
	function <%=renderResponse.getNamespace() + "submit"%>() {
		// Считываем адрес электронной почты
		var email = document.<portlet:namespace />fm.<portlet:namespace />email.value;
		// Определяем тему письма
		var subscribeApproveSubject = 
			document.<portlet:namespace />fm.<portlet:namespace />subscribeApproveSubject.value;
		// Определяем сообщение письма
		var subscribeApproveBody = 
			document.<portlet:namespace />fm.<portlet:namespace />subscribeApproveBody.value;
		
		// Проверяем адрес электронной почты на корректность
		var validateDiv = document.getElementById('<portlet:namespace />validateError');
		var arr = email.match("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        if(arr == null || email==null || email=="") {
        	validateDiv.innerHTML='<span style="color:red">*<liferay-ui:message key="subscribe-email-error"/></span>';
            return false;
        }
        // Формируем AJAX-запрос серверу
	    AUI().use('aui-io-request', function(A){
	        A.io.request('<%=subscribeActionURL.toString()%>', {
	        	method: 'post',
	        	data: {
	        		// Отправляем данные
	        		email: email,
	        		"subscribe-approve-subject": subscribeApproveSubject,
	        		"subscribe-approve-body": subscribeApproveBody
	        	},
	        	on: {
	        		success: function(event, id, obj) {
	        			// Отображаем страницу
	        			var instance = this;
                        var message = instance.get('responseData');
	        			AUI().one('#<portlet:namespace/>contentview').html(message);
	        		},
	        		start: function() {
	        			// Отображаем индикатор загрузки
	        			AUI().use('aui-loading-mask',
       		                function(A) {
       		                    if (A.one('#<portlet:namespace/>contentview').loadingmask == null) {
       		                        A.one('#<portlet:namespace/>contentview').plug(A.LoadingMask, {background: '#333'});
       		                        A.one('#<portlet:namespace/>contentview').loadingmask.show();
       		                    }
       		                }
	        		    );
	        		},
	        		end: function() {
	        			// Скрываем индикатор загрузки
	        		    AUI().use('aui-loading-mask',
	       	                function(A){
	       	                    A.one('#<portlet:namespace/>contentview').loadingmask.hide();
	       	                    A.one('#<portlet:namespace/>contentview').unplug();
	       	                }
	        	    	);
	        		}
	        	}
	        });
	    });
	}
</script>

<div id="<portlet:namespace/>subscribe" class="subscribe">
	<liferay-ui:message key="subscribe-head" />
	<aui:form action="<%= subscribeActionURL.toString() %>" method="post" name="fm" onSubmit='<%= "event.preventDefault();" %>'>
		<div id = "<portlet:namespace />validateError"></div>
		<aui:fieldset>
			<aui:input inlineField="<%= true %>" label='<%= LanguageUtil.get(pageContext, "subscribe-email") %>' name="email" value="" />
			<aui:input inlineField="<%= true %>" label="" name="unsubscribeURL" size="50" value="<%=unsubscribeActionURL.toString() %>" type="hidden"/>
			<aui:input inlineField="<%= true %>" name="subscribeApproveSubject" value='<%= LanguageUtil.get(pageContext, "subscribe-approve-subject") %>' type="hidden"/>
			<aui:input inlineField="<%= true %>" name="subscribeApproveBody" value='<%= LanguageUtil.get(pageContext, "subscribe-approve-body") %>' type="hidden"/>
			<aui:button align="absmiddle" border="0" type="submit" name="subscribe" title="subscribe" value = '<%=LanguageUtil.get(pageContext, "subscribe-subscribe")%>' onClick='<%= renderResponse.getNamespace() + "submit();" %>' />		
		</aui:fieldset>
	</aui:form>
</div>