<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/responsive/cart"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:url value="/quote/guestCreate" var="guestQuoteUrl" />
<c:url value="/login/checkout" var="doCheckoutLoginUrl" />
<div class="cart-header border">
	<div class="row">
		<div class="col-xs-12 col-sm-5">
			<h1 class="cart-headline">
				<spring:theme code="text.cart" />
				<c:if test="${not empty cartData.code}">
					<span class="cart__id--label"> <spring:theme
							code="basket.page.cartIdShort" /><span class="cart__id">${fn:escapeXml(cartData.code)}</span>
					</span>
				</c:if>
			</h1>
		</div>
		<div class="col-xs-12 col-sm-7">

			<sec:authorize
				access="hasAnyRole('ROLE_ANONYMOUS','ROLE_CUSTOMERGROUP')">
				<c:if test="${not empty savedCartCount and savedCartCount ne 0}">
					<spring:url value="/my-account/saved-carts" var="listSavedCartUrl"
						htmlEscape="false" />
					<a href="${fn:escapeXml(listSavedCartUrl)}"
						class="save__cart--link cart__head--link"> <spring:theme
							code="saved.cart.total.number" arguments="${savedCartCount}" />
					</a>
					<c:if test="${not empty quoteCount and quoteCount ne 0}">
						<spring:url value="/my-account/my-quotes" var="listQuotesUrl"
							htmlEscape="false" />
						<a href="${fn:escapeXml(listQuotesUrl)}"
							class="cart__quotes--link cart__head--link"> <spring:theme
								code="saved.quote.total.number" arguments="${quoteCount}" />
						</a>
					</c:if>

				</c:if>
			</sec:authorize>
			<cart:saveCart />
		</div>
	</div>
</div>

<c:if test="${not empty cartData.rootGroups}">
	<c:url value="/cart/checkout" var="checkoutUrl" scope="session" />
	<c:url value="/quote/create" var="createQuoteUrl" />
	<c:url value="/quote/guestCreate" var="guestQuoteUrl" />
	<c:url value="${continueUrl}" var="continueShoppingUrl" scope="session" />
	<c:set var="showTax" value="false" />

	<div class="row">
		<div class="col-xs-12 pull-right cart-actions--print">
			<div class="cart__actions border">
				<div class="row">
					<!-- Checkout Button -->
					<div class="col-sm-4 col-md-3 col-lg-3 pull-right">
						<ycommerce:testId code="checkoutButton">
							<button
								class="btn btn-primary btn-block btn--continue-checkout js-continue-checkout-button"
								data-checkout-url="${fn:escapeXml(checkoutUrl)}">
								<spring:theme code="checkout.checkout" />
							</button>
						</ycommerce:testId>
					</div>
					<%-- <c:if test="${not empty siteQuoteEnabled and siteQuoteEnabled eq 'true'}">
						<div class="col-sm-4 col-md-3 col-lg-3 pull-right">
							<button
								class="btn btn-default btn-block btn-create-quote js-create-quote-button"
								data-create-quote-url="${fn:escapeXml(createQuoteUrl)}">
								<spring:theme code="quote.create" />
							</button>
						</div>
					</c:if> --%>
					<c:if
						test="${not empty siteQuoteEnabled and siteQuoteEnabled eq 'true'}">
						<div class="col-sm-4 col-md-3 col-lg-3 pull-right">
							<c:choose>
								<c:when test="${isGuest}">
									<button
										class="btn btn-primary btn-block btn-create-quote js-create-quote-button"
										onclick="openPopup()">Request a Quote</button>
								</c:when>
								<c:otherwise>
									<%-- 	<button
										class="btn btn-primary btn-block btn-create-quote js-create-quote-button"
										data-create-quote-url="${fn:escapeXml(createQuoteUrl)}">
										<spring:theme code="quote.create" />
									</button> --%>
									<!-- Button to trigger the popup -->
									<button type="button"
										class="btn btn-primary btn-block btn-create-quote"
										onclick="createQuoteUrl()">
										<spring:theme code="quote.create" />
									</button>

								</c:otherwise>
							</c:choose>
						</div>
					</c:if>

					<div id="quotePopup" class="popup-form js-popup-form" style="display: none;">
    <div class="popup-content">
        <span class="close" onclick="closePopup()">&times;</span>
        <div class="content">
            <div class="form-container">
                <h3 class="popup-heading"><spring:theme code="popup.form.title" /></h3>
                <form:form action="${guestQuoteUrl}" method="post" modelAttribute="customGuestForm">
                    <div class="form-group">
                        <label for="name"><spring:theme code="form.label.name" /></label>
                        <input type="text" id="name" name="name" class="form-control" required="required" />
                    </div>
                    <div class="form-group">
                        <label for="contactNum"><spring:theme code="form.label.contactNum" /></label>
                        <input type="text" id="contactNum" name="contactNum" class="form-control" required="required" pattern="^[7-9][0-9]{9}$" title="Phone number must start with 7-9 and be exactly 10 digits long." />
                    </div>
                    <div class="form-group">
                        <label for="comments"><spring:theme code="form.label.comments" /></label>
                        <textarea id="comments" name="comments" class="form-control" required="required"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="company"><spring:theme code="form.label.company" /></label>
                        <input type="text" id="company" name="company" class="form-control" required="required" />
                    </div>
                    <div class="form-group">
                        <label for="email"><spring:theme code="form.label.email" /></label>
                        <input type="email" id="email" name="email" class="form-control" required="required" />
                    </div>
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <button type="button" class="btn btn-primary" onclick="location.href='${doCheckoutLoginUrl}'">Login</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

					<!-- Continue Shopping Button -->
					<div class="col-sm-4 col-md-3 col-lg-3 pull-right">
						<button
							class="btn btn-default btn-block btn--continue-shopping js-continue-shopping-button"
							data-continue-shopping-url="${fn:escapeXml(continueShoppingUrl)}">
							<spring:theme code="cart.page.continue" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>



	<div class="row">
		<cart:exportCart />

		<div class="col-sm-12 col-md-4 col-md-push-5">
			<div class="js-cart-top-totals cart__top--totals">
				<c:choose>
					<c:when
						test="${fn:length(cartData.entries) > 1 or fn:length(cartData.entries) == 0}">
						<spring:theme code="basket.page.totals.total.items"
							arguments="${fn:length(cartData.entries)}" />
					</c:when>
					<c:otherwise>
						<spring:theme code="basket.page.totals.total.items.one"
							arguments="${fn:length(cartData.entries)}" />
					</c:otherwise>
				</c:choose>
				<ycommerce:testId code="cart_totalPrice_label">
					<span class="cart__top--amount"> <c:choose>
							<c:when test="${showTax}">
								<format:price priceData="${cartData.totalPriceWithTax}" />
							</c:when>
							<c:otherwise>
								<format:price priceData="${cartData.totalPrice}" />
							</c:otherwise>
						</c:choose>
					</span>
				</ycommerce:testId>
			</div>
		</div>
	</div>

	<cart:cartItems cartData="${cartData}" />

	<div class="row">
		<cart:exportCart />
	</div>
</c:if>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
	function createQuoteUrl() {
		document.getElementById('quotePopup').style.display = 'block';
	}

	function closePopup() {
		document.getElementById('quotePopup').style.display = 'none';
	}

	window.onclick = function(event) {
		var popup = document.getElementById('quotePopup');
		if (event.target == popup) {
			popup.style.display = 'none';
		}
	}
</script>

<style>
.popup-form {
    display: none;
    position: fixed;
    z-index: 1000;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.6);
    overflow: auto;
}

.popup-content {
    background-color: #fff;
    margin: 10% auto;
    padding: 20px;
    border: 1px solid #888;
    width: 50%;
    box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    position: relative;
}

.popup-heading {
    color: #007bff; /* Blue color for the heading */
    font-size: 24px;
    margin-bottom: 20px;
    text-align: center;
}

.close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

.form-container {
    max-width: 600px;
    margin: auto;
}

.form-group {
    margin-bottom: 15px;
}

.form-group label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
}

.form-control {
    width: 100%;
    padding: 10px;
    margin: 0;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

.form-actions {
    text-align: center;
    margin-top: 20px;
}

.btn-primary {
    background-color: #007bff;
    border-color: #007bff;
    color: white;
    padding: 10px 20px;
    font-size: 16px;
    border-radius: 4px;
    cursor: pointer;
    margin: 0 10px;
}

.btn-primary:hover {
    background-color: #0056b3;
    border-color: #0056b3;
}

.btn-default {
    background-color: #f8f9fa;
    border-color: #ced4da;
    color: #495057;
}

.btn-default:hover {
    background-color: #e2e6ea;
    border-color: #dae0e5;
}

</style>

<cart:ajaxCartTopTotalSection />
