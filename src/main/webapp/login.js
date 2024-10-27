 

window.addEventListener("scroll", function(){
        var header = document.querySelector("header");
        header.classList.toggle("sticky", window.scrollY > 0);
    })
    function toggle(){
        var header = document.querySelector("header");
        header.classList.toggle("active");
    }



    let password = document.getElementById('password');
    let password1 = document.getElementById('password1');
    let password2 = document.getElementById('password2');
    let tooglePassword = document.getElementById('toggle');
    let tooglePassword1 = document.getElementById('toggle1');
    let tooglePassword2 = document.getElementById('toggle2');

    function showHide(){
      if(password.type === 'password'){
        password.setAttribute('type','text');
        tooglePassword.classList.add('hide');
      }
      else{
        password.setAttribute('type','password');
        tooglePassword.classList.remove('hide');
      }
    }
    function showHide1(){
      if(password1.type === 'password'){
        password1.setAttribute('type','text');
        tooglePassword1.classList.add('hide');
      }
      else{
        password1.setAttribute('type','password');
        tooglePassword1.classList.remove('hide');
      }
    }
    function showHide2(){
      if(password2.type === 'password'){
        password2.setAttribute('type','text');
        tooglePassword2.classList.add('hide');
      }
      else{
        password2.setAttribute('type','password');
        tooglePassword2.classList.remove('hide');
      }
    }


