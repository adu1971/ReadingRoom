<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<section class="container">
	<form:form method="POST" modelAttribute="conceptToEdit" class="form-horizontal">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />
		<fieldset>
			<legend>Concept Editor</legend>

			<div class="form-group">
				<label class="control-label col-lg-2" for="id"> <spring:message code="concept.id.label" /> </label>
				<div class="col-lg-10">
					<form:input id="id" path="id" type="text" readonly="true" class="form:input-large" />
					<form:errors path="id" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="name"> <spring:message code="concept.name.label" /> </label>
				<div class="col-lg-10">
					<form:input id="name" path="name" type="text" class="form:input-large" />
					<form:errors path="name" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="description"> <spring:message code="concept.description.label" /> </label>
				<div class="col-lg-10">
					<form:textarea id="description" path="description" rows="3" />
					<form:errors path="description" cssClass="text-danger" />
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

