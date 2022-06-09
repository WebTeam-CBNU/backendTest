const updateButton = document.querySelectorAll('.schedule');
const favDialog = document.getElementById('favDialog');
const outputBox = document.querySelector('output');
const selectEl = favDialog.querySelector('select');
const confirmBtn = favDialog.querySelector('#confirmBtn');

// If a browser doesn't support the dialog, then hide the
// dialog contents by default.
if ( typeof favDialog.showModal !== 'function' ) {
  favDialog.hidden = true;
  /* a fallback script to allow this dialog/form to function
     for legacy browsers that do not support <dialog>
     could be provided here.
  */
}
// "Update details" button opens the <dialog> modally
updateButton.forEach((items) => {
    items.addEventListener('click', function onOpen() {
        if (typeof favDialog.showModal === "function") {
          favDialog.showModal();
          // Cancel button
          document.querySelectorAll('#box_button button')[0].style.color ="#778899"
          document.querySelectorAll('#box_button button')[0].style.fontweight="50000"
          // Confirm button
          document.querySelectorAll('#box_button button')[1].style.color = "#778899"
        } else {
    
        }
      })
});
// "Favorite animal" input sets the value of the submit button
selectEl.addEventListener('change', function onSelect(e) {
  confirmBtn.value = selectEl.value;
});
// "Confirm" button of form triggers "close" on dialog because of [method="dialog"]
// favDialog.addEventListener('close', function onClose() {
// });