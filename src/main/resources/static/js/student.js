/**
 * Chaitanya Gidijala
 */
function openNav() {
  document.getElementById("sidebar").style.width = "250px";
}

function closeNav() {
  document.getElementById("sidebar").style.width = "0";
}

/*Deletion conformation*/
function confirmAction(){
  if(prompt("Type 'YeS' to confirm, this action is irreversible.", '') == 'YeS')
  {
      return true;
  }
  else
  {
      return false;
  }
}


