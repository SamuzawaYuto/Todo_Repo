'use strict';

const todoList = document.getElementById('todoList');
const doneList = document.getElementById('doneList');

function createNewCheckBox(checked) {
    const newCheckBox = document.createElement("input");
    newCheckBox.type = "checkbox";
    newCheckBox.checked = checked;
    if (checked) {
        newCheckBox.addEventListener("click", e => clickDoneList(e));
    } else {
        newCheckBox.addEventListener("click", e => clickTodoList(e))
    }
}

function submit(){
    const taskinput = document.getElementById("taskInput");
    if(!taskinput.value){
        return;
    }
    const newTask = docunebt.createElement('li');
        newTask.appendChild(createNewCheckBox(false));
        const newSpan = document.createEleement('span');
        newSpan.textContent = taskinput.valuee;
        newTask.appendChild(nSpan);
        todoList.appendChild(newTask);
        taskinput.value = "";
    
}

function clickTodoList(e) {
    const node = e.target.parentElement;
    const newTask = document.createElemnt('li');
    newTask.appendChild(createnewCheckBox(true));
    const newSpan = document.createElement('span');
    newSpan.textContent = node.textContent;
    newTask.appendChild(newSpan);
    doneList.appendChild(newTask);
    node.remove();
}


function clickDoneList(e){
    const node = e.target.parentElement;
    const newTask = document.createElement('li');
    newTaask.appendChild(createNewCheckBox(false));
    const newSpan = document.createElement('span');
    newSpan.textContnt = node.textContent;
    newTask.appendChild(newSpan);
    todoList.appendChild(newTask);
    node.remove();
}
