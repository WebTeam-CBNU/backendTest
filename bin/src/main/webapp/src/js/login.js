const favDialog = document.getElementById('favDialog');
const favDialog_register = document.getElementById('favDialog_register');
const loginBtn = document.getElementById('loginbutton');
const registerBtn=document.getElementById('registerbutton');
const closeBtn = document.getElementsByClassName('closeModal')[0];

if ( typeof favDialog.showModal !== 'function' ) {
    favDialog.hidden = true;
    /* a fallback script to allow this dialog/form to function
       for legacy browsers that do not support <dialog>
       could be provided here.
    */
  }

function login(){
    console.log("this is login")
    if (typeof favDialog.showModal === "function") {
        favDialog.showModal();
        // Cancel button
        document.querySelectorAll(".user-box input").forEach((elememt)=>{
            elememt.defaultValue = "test"
        })
        // Confirm button
    } else {

    }
    console.log("fuck")
}

function logout(){
    console.log("this is logout")
    document.cookie = 'JSESSIONID=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

  closeBtn.addEventListener('click', ()=> {
    favDialog.close();
    // closeBtn.focus();
    // document.getElementsByTagName("body")[0].style.overflow = "auto";
  });

  favDialog.addEventListener('close', ()=>{
    
  })




  if ( typeof favDialog_register.showModal !== 'function' ) {
    favDialog_register.hidden = true;
    /* a fallback script to allow this dialog/form to function
       for legacy browsers that do not support <dialog>
       could be provided here.
    */
  }

registerBtn.addEventListener('click', ()=> {
    if (typeof favDialog_register.showModal === "function") {
      favDialog_register.showModal();
      // Cancel button
      document.querySelectorAll(".user-registerbox input").forEach((elememt)=>{
          elememt.defaultValue = "test"
      })
      // Confirm button
    } else {

    }
    console.log("fuck")
  })

  closeBtn.addEventListener('click', ()=> {
    favDialog_register.close();
    // closeBtn.focus();
    // document.getElementsByTagName("body")[0].style.overflow = "auto";
  });

  favDialog_register.addEventListener('close', ()=>{
    
  })