/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");
btn.addEventListener("click", aparecer);
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
span.addEventListener("click", sumir);
// When the user clicks on the button, open the modal
function aparecer (){
  modal.style.display = "block";
};

// When the user clicks on <span> (x), close the modal
function sumir() {
  modal.style.display = "none";
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target === modal) {
    modal.style.display = "none";
  }
};
