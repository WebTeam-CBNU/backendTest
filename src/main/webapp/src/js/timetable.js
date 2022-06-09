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


let nowWeekDay = new Date().getDay()



function confirm(){
  const selectedWeekDay=document.getElementById("weekDay");
  const selectedClassStartTime=document.getElementById("classStartTime");
  const selectedClassEndTime=document.getElementById("classEndTime");
  const professor = document.getElementById("professor").value;
  const building = document.getElementById("building").value;
  const classRoom = document.getElementById("classRoom").value;


  const hour=document.getElementsByClassName("hour");
  const hourStartIndex=selectedWeekDay.selectedIndex * 9+selectedClassStartTime.selectedIndex;
  const hourEndIndex=selectedWeekDay.selectedIndex * 9+selectedClassEndTime.selectedIndex;
  for(i=hourStartIndex; i<hourEndIndex;i++){
    
    hour[i].innerHTML="";

    if(i==hourStartIndex){
      hour[i].innerHTML=professor+"<br>"+building+"<br>"+classRoom;
      hour[i].classList.add('firstBlock');
    }

    
    if(i==hourEndIndex-1){
      hour[i].classList.add('lastBlock');
    }

    if(hourEndIndex-hourStartIndex==1)
    hour[i].classList.add('oneBlock');

  document.getElementsByClassName('hour')[i].classList.add("classNotToday");
  if(parseInt(i/9)+1==nowWeekDay){
    document.getElementsByClassName('hour')[i].classList.add("classToday");
  }
  }

}

var i = 0

for(i=0;i<45;i++){
  document.getElementsByClassName('hour')[i].ondragstart = function(e) {
    for(j=0;j<45;j++){
      if(document.getElementsByClassName('hour')[j]==this) e.dataTransfer.setData('data', j);
    }
  };

  document.getElementsByClassName('hour')[i].ondragover = function(e) {
    e.preventDefault(); // 필수 이 부분이 없으면 ondrop 이벤트가 발생하지 않습니다.
  };
}


for(i=0;i<45;i++){
  document.getElementsByClassName('hour')[i].ondrop = function(e) {


    for(j=0;j<45;j++){
      if(document.getElementsByClassName('hour')[j]==this) {
        startIndex = e.dataTransfer.getData('data')
        const EndInnerHTML = document.getElementsByClassName('hour')[j].innerHTML;
        
        document.getElementsByClassName('hour')[j].innerHTML=document.getElementsByClassName('hour')[startIndex].innerHTML;
        document.getElementsByClassName('hour')[startIndex].innerHTML=EndInnerHTML;

        while(document.getElementsByClassName('hour')[startIndex].classList.contains('classNotToday')!=document.getElementsByClassName('hour')[j].classList.contains('classNotToday')){
            document.getElementsByClassName('hour')[startIndex].classList.toggle("classNotToday");
            document.getElementsByClassName('hour')[j].classList.toggle("classNotToday");

            if(document.getElementsByClassName('hour')[startIndex].classList.contains('firstBlock')!=document.getElementsByClassName('hour')[j].classList.contains('firstBlock')){
              document.getElementsByClassName('hour')[startIndex].classList.toggle("firstBlock");
              document.getElementsByClassName('hour')[j].classList.toggle("firstBlock");
            }

            if(document.getElementsByClassName('hour')[startIndex].classList.contains('lastBlock')!=document.getElementsByClassName('hour')[j].classList.contains('lastBlock')){
              document.getElementsByClassName('hour')[startIndex].classList.toggle("lastBlock");
              document.getElementsByClassName('hour')[j].classList.toggle("lastBlock");
            }

            if(document.getElementsByClassName('hour')[startIndex].classList.contains('oneBlock')!=document.getElementsByClassName('hour')[j].classList.contains('oneBlock')){
              document.getElementsByClassName('hour')[startIndex].classList.toggle("oneBlock");
              document.getElementsByClassName('hour')[j].classList.toggle("oneBlock");
            }
                
            if(parseInt(j/9)+1==nowWeekDay&&document.getElementsByClassName('hour')[j].classList.contains('classNotToday')){
              document.getElementsByClassName('hour')[j].classList.add("classToday");
            }
                
            if(parseInt(startIndex/9)+1==nowWeekDay&&document.getElementsByClassName('hour')[startIndex].classList.contains('classToday')){
              document.getElementsByClassName('hour')[startIndex].classList.remove("classToday");
            }

          startIndex++;
          j++;
        }
        
        //nowWeekDay

        }

      }
    }
  }
