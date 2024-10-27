let navbar = document.querySelector('.navbar');

document.querySelector('#menu-btn').onclick = () =>{
    navbar.classList.toggle('active');
    user.classList.remove('active');
}


let user = document.querySelector('.container');

document.querySelector('#user-btn').onclick = () =>{
    user.classList.toggle('active');
    navbar.classList.remove('active');
}

window.onscroll = () =>{
    navbar.classList.remove('active');
    user.classList.remove('active');
}

