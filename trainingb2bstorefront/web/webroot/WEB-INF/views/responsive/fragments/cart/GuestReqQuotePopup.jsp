<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:theme code="text.addToCart" var="addToCartText"/>
<spring:theme code="text.popupCartTitle" var="popupCartTitleText"/>
<c:url value="/cart" var="cartUrl"/>
<c:url value="/cart/checkout" var="checkoutUrl"/>
<c:url value="/quote/create" var="createQuoteUrl" scope="session" />
	<c:url value="/quote/guestCreate" var="guestQuoteUrl" scope="session" />

<c:choose>
	<c:when test="${not empty cartData.quoteData}">
		<c:set var="miniCartProceed" value="quote.view"/>
	</c:when>
	<c:otherwise>
		<c:set var="miniCartProceed" value="checkout.checkout"/>
	</c:otherwise>
</c:choose>
			
<div><p>mahesh  Yadav</p></div>