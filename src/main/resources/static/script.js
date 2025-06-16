'use strict';

const todoList = document.getElementById('todoList');
const doneList = document.getElementById('doneList');

function createNewCheckBox(checked) {
  const newCheckBox = document.createElement("input");
  newCheckBox.type = "checkbox";
  newCheckBox.checked = checked;
  newCheckBox.className = "checkBox"; 
  if (checked) {
    newCheckBox.addEventListener("click", e => clickDoneList(e));
    
  } else {
    newCheckBox.addEventListener("click", e => clickTodoList(e));
    
  }
  return newCheckBox;
}

function submit() {
  const taskInput = document.getElementById("taskInput");
  if(!taskInput.value) {
    return;
  }
  const newTask = document.createElement('li');
  newTask.appendChild(createNewCheckBox(false));
  const newSpan = document.createElement('span');
  newSpan.textContent = taskInput.value;
  newTask.appendChild(newSpan);
  todoList.appendChild(newTask);
  taskInput.value = "";
}

function clickTodoList(e) {
  const node = e.target.parentElement;
  
  const newTask = document.createElement('li');
  newTask.appendChild(createNewCheckBox(true));

  const linkElement = node.querySelector('a');
  newTask.appendChild(linkElement);

  doneList.appendChild(newTask);
  node.remove();
}

function clickDoneList(e) {
  const node = e.target.parentElement;

  const newTask = document.createElement('li');
  newTask.appendChild(createNewCheckBox(false));

  const linkElement = node.querySelector('a');
  newTask.appendChild(linkElement);

  todoList.appendChild(newTask);
  node.remove();
}

function changeColorScheme(scheme) {
    const colors = JSON.parse(scheme);
    document.documentElement.style.setProperty('--main-bg-color', colors.bgColor);
    document.documentElement.style.setProperty('--main-title-color', colors.titleColor);
    document.documentElement.style.setProperty('--main-text-color', colors.textColor);
    document.documentElement.style.setProperty('--main-box-color', colors.boxColor);
    document.documentElement.style.setProperty('--main-home-color', colors.homeColor);
    document.documentElement.style.setProperty('--main-white-color', colors.whiteColor);
    document.documentElement.style.setProperty('--main-label-color', colors.labelColor);

    localStorage.setItem('colorScheme', scheme);
}

window.addEventListener('load', () => {
    const savedScheme = localStorage.getItem('colorScheme');
    if (savedScheme) {
        changeColorScheme(savedScheme);
        document.getElementById('color-scheme-select').value = savedScheme;
    }
});