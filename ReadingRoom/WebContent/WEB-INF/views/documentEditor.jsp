<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<section class="container">
	<form:form method="POST" modelAttribute="documentToEdit" class="form-horizontal" enctype="multipart/form-data">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />
		<fieldset>
			<legend>Document Information </legend>

			<div class="form-group">
				<label class="control-label col-lg-2" for="id"> <spring:message code="document.id.label" /> </label>
				<div class="col-lg-10">
					<form:input id="id" path="id" type="text" readonly="true" class="form:input-large" />
					<form:errors path="id" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="title"> <spring:message code="document.title.label" /> </label>
				<div class="col-lg-10">
					<form:input id="title" path="title" type="text" class="form:input-large" />
					<form:errors path="title" cssClass="text-danger" />
				</div>
			</div>		

			<div class="form-group">
				<label class="control-label col-lg-2" for="fileData"> <spring:message code="document.fileData.label"/> </label>
				<div class="col-lg-10">
					<input id="fileData" name="fileData" type="file" />
				</div>				
			</div>

			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnSave" class="btn btn-primary" value="Save" />
				</div>
			</div>	

		</fieldset>
	</form:form>
</section>
