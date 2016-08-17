<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/dependencies/common/init.jsp" %>

<portlet:defineObjects />
<div class="portlet-msg-info">
	<liferay-ui:message key="subscribe-success" /> <%=request.getParameter("email")%>.
</div>