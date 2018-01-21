
function filterByName() {
  // Declare variables 
  var input, filter, table, tr, td, i;
  document.getElementById("explanationFilterField").value="";
  input = document.getElementById("nameFilterField");
  filter = input.value.toUpperCase();
  table = document.getElementById("conceptsTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those not matching the filtering pattern.
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}

function filterByExplanation() {
	  // Declare variables 
	  var input, filter, table, tr, td, i;
	  document.getElementById("nameFilterField").value="";
	  input = document.getElementById("explanationFilterField");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("conceptsTable");
	  tr = table.getElementsByTagName("tr");

	  // Loop through all table rows, and hide those not matching the filtering pattern.
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[2];
	    if (td) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    } 
	  }
	}

function sayHello() {
	window.alert("Hello!\nHow are you?");
	
}
