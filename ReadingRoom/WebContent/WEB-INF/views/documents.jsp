<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<section class="container">

	<a href="<spring:url value="/documents/edit"/>"  class="btn btn-warning btn-large float-right">
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
					<input type="text" id="titleFilter" onkeyup="filter('documentsTable', 1, 'titleFilter')" placeholder="Filter by title...">
				</th>
				<th/>
				<th/>
			</tr>
		</thead>	
		<tbody>		
			<c:forEach items="${documents}" var="document">
				<tr>
						<td>${document.id}</td>
						<td>${document.title}</td>
						<td>
							<a href="<spring:url value="/documents/edit?documentId=${document.id}"/>"  class="btn btn-info"> Edit Document Info </a>
							<a href="<spring:url value="/documents/delete?documentId=${document.id}"/>"  class="btn btn-info"> Delete </a>
						</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>


</section>