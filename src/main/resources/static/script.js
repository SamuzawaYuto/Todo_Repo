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
        newCheckBox.addEventListener("click", e => clickTodoList(e));
    }
    return newCheckBox;
}

// function createDeleteButton() {
//     const deleteButton = document.createElement('button');
//     deleteButton.textContent = '削除';
//     deleteButton.addEventListener('click', function(e) {
//         const taskItem = e.target.parentElement;
//         taskItem.remove();
//     });
//     return deleteButton;
// }

function Delete() {
    const taskInput = document.getElementById("taskInput");
    if (!taskInput.value) {
        return;
    }
    const newTask = document.createElement('li');
    newTask.appendChild(createNewCheckBox(false));
    const newSpan = document.createElement('span');
    newSpan.textContent = taskInput.value;
    newTask.appendChild(newSpan);
    // newTask.appendChild(createDeleteButton()); // ここで削除ボタンを追加
    todoList.appendChild(newTask);
    taskInput.value = "";
}

function submit() {
    const taskInput = document.getElementById("taskInput");
    if (!taskInput.value) {
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
    const newSpan = document.createElement('span');
    newSpan.textContent = node.textContent;
    newTask.appendChild(newSpan);
    // newTask.appendChild(createDeleteButton());
    doneList.appendChild(newTask);
    node.remove();
}

function clickDoneList(e) {
    const node = e.target.parentElement;
    const newTask = document.createElement('li');
    newTask.appendChild(createNewCheckBox(false));
    const newSpan = document.createElement('span');
    newSpan.textContent = node.textContent;
    newTask.appendChild(newSpan);
    // newTask.appendChild(createDeleteButton());
    todoList.appendChild(newTask);
    node.remove();
}