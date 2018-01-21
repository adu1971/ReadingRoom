<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<section class="container">

	<a href="<spring:url value="/documents/add"/>"  class="btn btn-warning btn-large float-right">
		<span class="glyphicon glyphicon-hand-right"></span> Add New Document 
	</a>
	<table  id="documentsTable" class="table table-bordered table-hover">	
		<thead class="thead thead-dark">
			<tr>
				<th>DOCUMENT ID</th>
				<th>DOCUMENT TITLE</th>
				<th>DOCUMENT</th>
				<th/>
			</tr>
			<tr>
				<th/>
				<th>
					<input type="text" id="nameFilterField" onkeyup="filterByName()" placeholder="Filter by name...">
				</th>
				<th>
					<input type="text" id="explanationFilterField" onkeyup="filterByExplanation()" placeholder="Filter by explanation...">
				</th>
				<th/>
			</tr>
		</thead>	
		<tbody>		
			<c:forEach items="${documents}" var="document">
				<tr>
						<td>${document.id}</td>
						<td>${document.title}</td>
						<td>
							<a href="<spring:url value="/concepts/edit?conceptId=${concept.id}"/>"  class="btn btn-info"> Edit </a>
						</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>


</section>