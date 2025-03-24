/* This method will add a new row */
function showcontent(){
	if(document.getElementById("pwdPolicySet").checked == true){
		
		document.getElementById("fieldsetpwd").style.display = "block";
		document.getElementById("pwdPolicySet").value="1";
	}else{
		document.getElementById("fieldsetpwd").style.display = "none";
		document.getElementById("pwdPolicySet").value="0";

	}
}
var rowcount=2;
       function addNewRow(){
           var table = document.getElementById("rp-table");
           var rowCount = table.rows.length;
           var cellCount = table.rows[0].cells.length; 
           var row = table.insertRow(rowCount);
           for(var i =0; i < cellCount; i++){
               var cell = row.insertCell(i);
			   
			   switch (i) {
				 case 0:
						cell.innerHTML=''+rowcount;
						break;
				 case 1:
						cell.innerHTML='<td><input type="text" class="form-control" /></td>';
						break;
				 case 2:
						cell.innerHTML='<td><input type="text" class="form-control" /></td>';
						break;
				 case 3:
						cell.innerHTML='<td><input type="text" class="form-control" /></td>';
						break;
				 case 4:
						cell.innerHTML='<td><input type="text" class="form-control" /></td>';
						break;
				case 5:
						cell.innerHTML='<td><input type="text" class="form-control" /></td>';
						break;
				default:
						cell.innerHTML='<td><input class="btn btn-danger" type="button"	value="Add" onclick="addNewRow()"></td><td><input class="btn btn-danger"  type="button" value="Delete" onclick="deleteRow(this)" /></td><td><input class="btn btn-danger" type="button"	value="Save" onclick="save()"></td>';
						break; 
			   }
			   
			  
           }
		   rowcount++;

       }
        
       /* This method will delete a row */
       function deleteRow(ele){
           var table = document.getElementById('rp-table');
           var rowCount = table.rows.length;
           if(rowCount <= 1){
               alert("There is no row available to delete!");
               return;
           }
           if(ele){
               //delete specific row
               ele.parentNode.parentNode.remove();
			   rowcount--;
			   
           }

       }