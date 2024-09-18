<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/responsive/user"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>

<c:url value="/quote/guestCreate" var="guestQuoteUrl" />
<c:url value="/login/checkout" var="doCheckoutLoginUrl"  />
<!--  link to trigger the popup -->
<a href="javascript:void(0);" class="btn btn-primary" onclick="createQuoteUrl()"> Click here To get a Guest Quote Pop up</a>
<!-- popup form -->
<div id="quotePopup" class="popup-form js-popup-form" style="display:none;">
    <div class="popup-content">
        <span class="close" onclick="closePopup()">&times;</span>
        <div class="content">
            <div class="form-container">
                <h3 class="popup-heading"><spring:theme code="popup.form.title" /></h3>
                <form:form action="${guestQuoteUrl}" method="post" modelAttribute="customGuestForm">
                    <!-- Form fields go here -->
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
                        <button type="button" class="btn btn-primary"
                            onclick="location.href='${doCheckoutLoginUrl}'">Login</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>


<!-- Add external JavaScript files -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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

.btn-primary {
    background-color: #007bff;
    border-color: #007bff;
    color: white;
    padding: 10px 20px;
    font-size: 16px;
    border-radius: 4px;
    cursor: pointer;
}

.btn-primary:hover {
    background-color: #0056b3;
    border-color: #0056b3;
}

.form-control {
    width: 80%;
    padding: 10px;
    margin: 5px 0 20px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

</style>

<%-- <%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/responsive/user"%>

<%@ taglib prefix="formElement"
	tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<c:url value="/quote/guestCreate" var="guestQuoteUrl" />
<c:url value="/login/checkout" var="doCheckoutLoginUrl"  />


<div class="popup-form js-popup-form">


	<!-- Main Content Area -->
	<div class="content">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-8 col-md-6 col-md-offset-3">
					<div class="form-container">
						<h3>
							<spring:theme code="popup.form.title" />
						</h3>

						<form:form action="${guestQuoteUrl}" method="post"
							modelAttribute="customGuestForm">
							<div class="form-group">
								<label for="name"><spring:theme code="form.label.name" /></label>
								<input type="text" id="name" name="name" class="form-control"
									required="required" />
							</div>

							<div class="form-group">
								<label for="contactNum"><spring:theme
										code="form.label.contactNum" /></label> <input type="text"
									id="contactNum" name="contactNum" class="form-control"
									required="required" pattern="^[7-9][0-9]{9}$"
									title="Phone number must start with 7-9 and be exactly 10 digits long." />
							</div>

							<div class="form-group">
								<label for="comments"><spring:theme
										code="form.label.comments" /></label>
								<textarea id="comments" name="comments" class="form-control"
									required="required"></textarea>
							</div>

							<div class="form-group">
								<label for="company"><spring:theme
										code="form.label.company" /></label> <input type="text" id="company"
									name="company" class="form-control" required="required" />
							</div>

							<div class="form-group">
								<label for="email"><spring:theme code="form.label.email" /></label>
								<input type="email" id="email" name="email" class="form-control"
									required="required" />
							</div>

							<div class="form-actions">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>

							<div class="form-actions">
								<button type="button" class="btn btn-primary"
									onclick="location.href='${doCheckoutLoginUrl}'">Login</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div> --%>

<%-- 	<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product"%>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/responsive/user"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme"%>

<spring:htmlEscape defaultHtmlEscape="true" />
<spring:url value="/quote/{/quoteCode}/submit/" var="submitQuoteUrl" htmlEscape="false">
    <spring:param name="quoteCode" value="${quoteData.code}"/>
</spring:url> 
<c:url value="/quote/guestCreate" var="guestQuoteUrl" />

<div class="popup-form js-popup-form">
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-8 col-md-6 col-md-offset-3">
                    <div class="form-container">
                        <h3><spring:theme code="popup.form.title" /></h3>

                        <form:form action="${guestQuoteUrl}" method="post" modelAttribute="customGuestForm">
                        <input type="hidden" name="quoteCode" value="${quoteData.code}" />
                            <div class="form-group">
                                <label for="name"><spring:theme code="form.label.name" /></label>
                                <input type="text" id="name" name="name" class="form-control" required="required" />
                            </div>

                            <div class="form-group">
                                <label for="contactNum"><spring:theme code="form.label.contactNum" /></label>
                                <input type="text" id="contactNum" name="contactNum" class="form-control"
                                    required="required" pattern="^[7-9][0-9]{9}$"
                                    title="Phone number must start with 7-9 and be exactly 10 digits long." />
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
                            </div>

                            <div class="form-actions">
                                <button type="button" class="btn btn-primary" onclick="location.href='${doCheckoutLoginUrl}'">Login</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> --%>