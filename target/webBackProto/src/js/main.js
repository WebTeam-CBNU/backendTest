function darkMode() {
  document.body.classList.toggle("body_dark_mode");
  document.getElementById('box').classList.toggle("box_dark_mode");
  document.getElementById('calendar').classList.toggle("calendar_dark_mode");
  document.getElementById('loginbutton').classList.toggle("loginbutton_default_dark_mode");

  const button_default_list = document.getElementsByClassName('button_default');
  const button_default_list_length = button_default_list.length;
  for(let i = 0; i < button_default_list_length; i++)  {
      button_default_list[i].classList.toggle("button_default_dark_mode");
  }

  const button_clicked_list = document.getElementsByClassName('button_clicked');
  const button_clicked_list_length = button_clicked_list.length;
  for(let i = 0; i < button_clicked_list_length; i++)  {
      button_clicked_list[i].classList.toggle("button_clicked_dark_mode");
  }

  const alert_box_list = document.getElementsByClassName('alert_box');
  const alert_box_list_length = alert_box_list.length;
  for(let i = 0; i < alert_box_list_length; i++)  {
      alert_box_list[i].classList.toggle("alert_box_dark_mode");
  }

}

function mouseDown(id) {
  if(document.getElementById(id).classList.contains("button_default_dark_mode")){
      document.getElementById(id).classList.remove("button_default_dark_mode");
      document.getElementById(id).classList.add("button_clicked_dark_mode");
  }
  else if(document.getElementById(id).classList.contains("button_default")){
      document.getElementById(id).classList.remove("button_default");
      document.getElementById(id).classList.add("button_clicked");
  }
  else if(document.getElementById(id).classList.contains("loginbutton_default_dark_mode")){
    document.getElementById(id).classList.remove("loginbutton_default_dark_mode");
    document.getElementById(id).classList.add("loginbutton_clicked_dark_mode");
  }
  else if(document.getElementById(id).classList.contains("loginbutton_default")){
    document.getElementById(id).classList.remove("loginbutton_default");
    document.getElementById(id).classList.add("loginbutton_clicked");
  }
}


function mouseUp(id) {
  if(document.getElementById(id).classList.contains("button_clicked_dark_mode")){
      document.getElementById(id).classList.remove("button_clicked_dark_mode");
      document.getElementById(id).classList.add("button_default_dark_mode");
      
  }
  else if(document.getElementById(id).classList.contains("button_clicked")){
      document.getElementById(id).classList.remove("button_clicked");
      document.getElementById(id).classList.add("button_default");
  }
  else if(document.getElementById(id).classList.contains("loginbutton_clicked_dark_mode")){
    document.getElementById(id).classList.remove("loginbutton_clicked_dark_mode");
    document.getElementById(id).classList.add("loginbutton_default_dark_mode");
    
}
else if(document.getElementById(id).classList.contains("loginbutton_clicked")){
    document.getElementById(id).classList.remove("loginbutton_clicked");
    document.getElementById(id).classList.add("loginbutton_default");
}
}


const navigation = navigator.userAgent;

const c = document.getElementById("clock");
const dpr = window.devicePixelRatio;
const ctx = c.getContext('2d');
c.width =  c.width * dpr;
c.height = c.height * dpr;
ctx.scale(dpr, dpr);
// const clockCenterX = c.width / 2;
// const clockCenterY = c.height / 2;
let radius = c.height / 4;
ctx.translate(radius*2, radius);
radius = radius * 0.90
setInterval(drawClock, 1000);


// 그림자 코드

// ctx.shadowColor = "#aaa";
// ctx.shadowOffsetX = 3;
// ctx.shadowOffsetY = 3;
// ctx.shadowBlur = 7;


function drawClock() {
  drawFace(ctx, radius);
  drawNumbers(ctx, radius);
  drawTime(ctx, radius);
}

function drawFace(ctx, radius) {
  let grad;
  ctx.beginPath();
  ctx.arc(0, 0, radius, 0, 2*Math.PI);
  ctx.fillStyle = 'white';
  ctx.fill();
  grad = ctx.createRadialGradient(0,0,radius*0.85, 0,0,radius*1.05);
  grad.addColorStop(0, '#333');
  grad.addColorStop(0.5, '#999');
  grad.addColorStop(0.75, '#eee');
  grad.addColorStop(1, '#999');
  ctx.strokeStyle = grad;
  ctx.lineWidth = radius*0.1;
  ctx.stroke();
  ctx.beginPath();
  ctx.arc(0, 0, radius*0.1, 0, 2*Math.PI);
  ctx.fillStyle = '#333';
  ctx.fill();
}

function drawNumbers(ctx, radius) {
  let ang;
  let num;
  ctx.font = radius*0.15 + "px arial";
  ctx.textBaseline="middle";
  ctx.textAlign="center";
  for(num = 1; num < 13; num++){
    ang = num * Math.PI / 6;
    ctx.rotate(ang);
    ctx.translate(0, -radius*0.85);
    ctx.rotate(-ang);
    ctx.fillText(num.toString(), 0, 0);
    ctx.rotate(ang);
    ctx.translate(0, radius*0.85);
    ctx.rotate(-ang);
  }
}

function drawTime(ctx, radius){
    let now = new Date();
    let hour = now.getHours();
    let minute = now.getMinutes();
    let second = now.getSeconds();
    //hour
    hour=hour%12;
    hour=(hour*Math.PI/6)+
    (minute*Math.PI/(6*60))+
    (second*Math.PI/(360*60));
    drawHand(ctx, hour, radius*0.5, radius*0.07);
    //minute
    minute=(minute*Math.PI/30)+(second*Math.PI/(30*60));
    drawHand(ctx, minute, radius*0.8, radius*0.07);
    // second
    second=(second*Math.PI/30);
    drawHand(ctx, second, radius*0.9, radius*0.02);
}

function drawHand(ctx, pos, length, width) {
    ctx.beginPath();
    ctx.lineWidth = width;
    ctx.lineCap = "round";
    ctx.moveTo(0,0);
    ctx.rotate(pos);
    ctx.lineTo(0, -length);
    ctx.stroke();
    ctx.rotate(-pos);
}
