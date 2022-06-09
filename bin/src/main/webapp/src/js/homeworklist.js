

//체크리스트 만드는 함수
function createHomework(subjectId) {
    const newHomework = document.createElement('div'); 

    let homeworkIndex = document.querySelectorAll(`#${subjectId} .homework`)
    let fuck = document.getElementsByClassName("add-homework")[0]
    const homeworkNum='homework'+(homeworkIndex.length+1)
    fuck.innerHTML = homeworkNum

    newHomework.setAttribute("class", "homework");
    
    newHomework.innerHTML = 
          `<input type='checkbox' name='${subjectId}' value='${homeworkNum}' style='margin:6px;'/><p contenteditable='true'>새로운 과제~</p>`;

    document.getElementById(`${subjectId}`).appendChild(newHomework);
  } 

  function createSubject() {

    const deletedPlusSubject = document.getElementById('subject-plus');
    deletedPlusSubject.remove();


    const newSubject = document.createElement('div'); 

    let SubjectIndex = document.querySelectorAll(`#subject-list .subject-block`)
    const subjectNum='subject'+(SubjectIndex.length+1)

    newSubject.setAttribute("class", "subject-block");
    newSubject.innerHTML = `
    <div class="subject-title" contenteditable='true'>과목 이름</div>
    <div id='${subjectNum}'>
    </div>
    <div class="add-homework" onclick="createHomework('${subjectNum}')">+</div>`;          
    document.getElementById("subject-list").appendChild(newSubject);


    const createPlusBlock = document.createElement('div'); 
    createPlusBlock.setAttribute("id", "subject-plus");
    createPlusBlock.setAttribute("class", "subject-block");
    createPlusBlock.innerHTML = `<div class='subject-plus' onclick='createSubject()'>+</div>`;          
    document.getElementById("subject-list").appendChild(createPlusBlock);
  } 


  
  /* drag and drop*/

const draggables = document.querySelectorAll('.draggable')
const containers = document.querySelectorAll('.container')

draggables.forEach(draggable => {
  draggable.addEventListener('dragstart', () => {
    draggable.classList.add('dragging')
  })

  draggable.addEventListener('dragend', () => {
    draggable.classList.remove('dragging')
  })
})

containers.forEach(container => {
  container.addEventListener('dragover', e => {
    e.preventDefault()
    const afterElement = getDragAfterElement(container, e.clientY)
    const draggable = document.querySelector('.dragging')
    if (afterElement == null) {
      container.appendChild(draggable)
    } else {
      container.insertBefore(draggable, afterElement)
    }
  })
})

function getDragAfterElement(container, y) {
  const draggableElements = [...container.querySelectorAll('.draggable:not(.dragging)')]

  return draggableElements.reduce((closest, child) => {
    const box = child.getBoundingClientRect()
    const offset = y - box.top - box.height / 2
    if (offset < 0 && offset > closest.offset) {
      return { offset: offset, element: child }
    } else {
      return closest
    }
  }, { offset: Number.NEGATIVE_INFINITY }).element
}