
// Object
var image_source = document.getElementById("image_source")


// Function
function dashboard() {
    document.getElementById("userID").style.display = 'none';
    document.getElementById("dashboardID").style.display = 'block';
}
function user() {
    document.getElementById("userID").style.display = 'block';
    document.getElementById("dashboardID").style.display = 'none';
}




//animation
document.addEventListener("DOMContentLoaded", function(event) {

    const showNavbar = (toggleId, navId, bodyId, headerId) =>{
        const toggle = document.getElementById("header-toggle"),
            nav = document.getElementById("nav-bar"),
            bodypd = document.getElementById("body-pd"),
            headerpd = document.getElementById("header")

// Validate that all variables exist
        if(toggle && nav && bodypd && headerpd){
            toggle.addEventListener('click', ()=>{
// show navbar
                nav.classList.toggle('show')
// change icon
                toggle.classList.toggle('bx-x')
// add padding to body
                bodypd.classList.toggle('body-pd')
// add padding to header
                headerpd.classList.toggle('body-pd')
            })

        }
    }

    showNavbar('header-toggle','nav-bar','body-pd','header')

    /*===== LINK ACTIVE =====*/
    const linkColor = document.querySelectorAll('.nav_link')

    function colorLink(){
        if(linkColor){
            linkColor.forEach(l=> l.classList.remove('active'))
            this.classList.add('active')
        }
    }
    linkColor.forEach(l=> l.addEventListener('click', colorLink))

    // Your code to run since DOM is loaded and ready
});


