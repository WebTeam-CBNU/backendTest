const favDialog = document.getElementById('favDialog');
const loginBtn = document.getElementById('loginbutton')
const closeBtn = document.getElementsByClassName('closeModal')[0]

if ( typeof favDialog.showModal !== 'function' ) {
    favDialog.hidden = true;
    /* a fallback script to allow this dialog/form to function
       for legacy browsers that do not support <dialog>
       could be provided here.
    */
  }

  loginBtn.addEventListener('click', ()=> {
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
  })

  closeBtn.addEventListener('click', ()=> {
    favDialog.close();
    // closeBtn.focus();
    // document.getElementsByTagName("body")[0].style.overflow = "auto";
  });

  favDialog.addEventListener('close', ()=>{
    
  })