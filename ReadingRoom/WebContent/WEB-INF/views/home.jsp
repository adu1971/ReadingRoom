<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="container">
	<p>
		The purpose of this web site/project is to provide an environment for
		a <b>"Concept Based Library"</b>.
	</p>

	<p>
		Even though I started this project for my own needs, it may hopefully become a
		useful tool for the similar needs of others as well.
	</p>
	
	<p>	
		A rough description of the project is below: 
	</p>

	<h3>Project Outline</h3>
	<ul>
		<li>The term <i>"library"</i> is used in the regular sense of a
			document library. (with the exception of being an electronic one.)
		</li>

		<li>The site will provide a functionality to the users for 
			uploading/downloading <b>e-documents</b> to/from the library.</li>

		<li>Other than a document, the second main concept is <b>"concept"</b>.
			A user will be able to define his/her areas of interest in terms of
			concepts.
		</li>

		<li>The user will be able to record his <b>comments</b> about the docs (a
			complete document itself or a certain part of it such as a chapter,
			paragraph, sentence, etc.).
		</li>

		<li>The main point of this library is being concept-based.
			This means, establishing <b>relations</b> between the docs and concepts
			is crucial.	Only by means of these concept-doc relations, will it be 
			possible to make semantic queries. 
		</li>
			
		<li>The site will provide a functionality to manage <b>access privileges</b>.
			A user will authorize others to access his/her own (1)
			documents, (2) concepts, (3) comments or (4) relations.
		</li>

		<li>
			The success of a semantic search will be basically dependent on 
			three user factors:
			<ul>
				<li>the correctness of concept definitions</li>
				<li>the granularity of document-concept relations established</li>
				<li>the document/concept/comment sharing habits of the users</li>
			</ul>
		</li>
	</ul>


	<p style="color:red;">The server time is ${serverTime}.</p>
	<p style="color:green;">The client time is <span id="ct"></span> </p>
	<p id="clientTime"/>
	
	<script>
		document.getElementById("ct").innerHTML = new Date();
	
	</script>
</section>