<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<section class="container">

	<a href="<spring:url value="/concepts/edit"/>"  class="btn btn-warning btn-large float-right">
		<span class="glyphicon glyphicon-hand-right"></span> Add New Concept 
	</a>
	<table  id="conceptsTable" class="table table-bordered table-hover">	
		<thead class="thead thead-dark">
			<tr>
				<th>CONCEPT ID</th>
				<th>CONCEPT NAME</th>
				<th>CONCEPT EXPLANATION</th>
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
			<c:forEach items="${concepts}" var="concept">
				<tr>
						<td>${concept.id}</td>
						<td>${concept.name}</td>
 						<td>${concept.description}</td> 
						<td>
							<a href="<spring:url value="/concepts/edit?conceptId=${concept.id}"/>"  class="btn btn-info"> Edit </a>
							<a href="<spring:url value="/concepts/delete?conceptId=${concept.id}"/>"  class="btn btn-info"> Delete </a>
						</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>


</section>