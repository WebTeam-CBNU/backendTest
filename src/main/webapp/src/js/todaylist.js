let plsBtn = document.getElementsByClassName("plsBtn")[0];
let checklist = document.getElementsByClassName("checklist")[0];
const testtt = document.getElementsByClassName("left")

function addCheck() {
    checklist.innerHTML = "fuck!"
}

// for (let i = 0; i < tempArray.length; i++) {
//     console.log([i].innerHTML);
//     document.querySelectorAll("#amBox div")[i].innerHTML=tempArray[i];
// }  

function mouseDown() {
    if(!document.getElementsByClassName(Monday)[0].classList.contains("clicked")){
        document.getElementsByClassName(Monday)[0].classList.add("clicked");
    }
  }


  function mouseUp() {
    document.getElementsByClassName(Monday)[0].classList.add("clicked");
}   

function showSchedule(daynum)
{

    const removedAmBox=document.getElementById('amBox');
    removedAmBox.remove();
    const leftBox = document.getElementsByClassName('leftBox');
    const amBox = document.createElement('div');
    amBox.setAttribute("id" , "amBox");
    leftBox[0].appendChild(amBox)
    


    for (i = 0; i < 12; i++) {
        const ToDoByAmTime = document.createElement('div');
        ToDoByAmTime.innerHTML =
            `<input type='checkbox' name='amBox' value='am` + i + `' style='margin:6px;'/><p>&nbsp오전할일` + i + `~</p><br><br>     `;
        document.getElementById(`amBox`).appendChild(ToDoByAmTime);


    }


    const removedPmBox=document.getElementById('pmBox');
    removedPmBox.remove();
    const rightBox = document.getElementsByClassName('rightBox');
    const pmBox = document.createElement('div');
    pmBox.setAttribute("id" , "pmBox");
    rightBox[0].appendChild(pmBox)

    for(i=0;i<12;i++){
    const ToDoByPmTime = document.createElement('div');
    ToDoByPmTime.innerHTML =
          `<input type='checkbox' name='pmBox' value='pm`+i+`' style='margin:6px;'/><p>&nbsp오후할일`+i+`~</p><br><br>     `;
    document.getElementById(`pmBox`).appendChild(ToDoByPmTime);
    }




    let nowWeekDay = new Date().getDay()
            
    var a = new Date()
    var aa = new Date(a.setDate(a.getDate()-nowWeekDay+daynum))
    var year = aa.getFullYear()
    var month = aa.getMonth()+1
    var date = aa.getDate()
    var dayLabel = aa.getDay()
    var week = new Array('Sun','Mon','Tue','Wed','Thur','Fri','Sat');

    document.getElementById('printDay').innerHTML=""+year+"."+month+"."+date+" "+week[dayLabel]

}

// function Sunday_onmouseover(){
//      const day=document.getElementsByClassName("Sunday");
//     day[0].innerText="일요일 입니다";
//      day[0].style.color="red";
//     }

//  function Sunday_onmouseout(){
//      const day=document.getElementsByClassName("Sunday");
//     day[0].innerText="Sun";
//     day[0].style.color="red";
//     }

// function Monday_onmouseover(){
//     const day=document.getElementsByClassName("Monday");
//     day[0].innerText="월요일 입니다";
//     }

// function Monday_onmouseout(){
//     const day=document.getElementsByClassName("Monday");
//     day[0].innerText="Mon";
//     }

// function Tuesday_onmouseover(){
// const day=document.getElementsByClassName("Tuesday");
// day[0].innerText="화요일 입니다";
// }

// function Tuesday_onmouseout(){
//     const day=document.getElementsByClassName("Tuesday");
//     day[0].innerText="Tue";
//     }

// function Wednesday_onmouseover(){
//     const day=document.getElementsByClassName("Wednesday");
//     day[0].innerText="수요일 입니다";
// }

// function Wednesday_onmouseout(){
//     const day=document.getElementsByClassName("Wednesday");
//     day[0].innerText="Wed";
// }

// function Thursday_onmouseover(){
//     const day=document.getElementsByClassName("Thursday");
//     day[0].innerText="목요일 입니다";
// }

// function Thursday_onmouseout(){
//     const day=document.getElementsByClassName("Thursday");
//     day[0].innerText="Thu";
// }

//     function Friday_onmouseover(){
//     const day=document.getElementsByClassName("Friday");
//     day[0].innerText="금요일 입니다";
//     }

// function Friday_onmouseout(){
//     const day=document.getElementsByClassName("Friday");
//     day[0].innerText="Fri";
//     }

//     function Saturday_onmouseover(){
//     const day=document.getElementsByClassName("Saturday");
//     day[0].innerText="토요일 입니다";
//     }

// function Saturday_onmouseout(){
//     const day=document.getElementsByClassName("Saturday");
//     day[0].innerText="Sat";
//     day[0].style.color="blue";
//     }

