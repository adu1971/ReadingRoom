<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<nav class="nav justify-content-end">
  <a class="nav-link active" href="<spring:url value="/home"/>">Home</a>
  <a class="nav-link" href="<spring:url value="/concepts"/>">Concepts</a>
  <a class="nav-link" href="<spring:url value="/documents"/>">Documents</a>
  <a class="nav-link" href="#">Help</a>
  <a class="nav-link" href="<spring:url value="/todo"/>">ToDo</a>
</nav>
