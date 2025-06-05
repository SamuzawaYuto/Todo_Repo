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

function submit() {
    const taskInput = document.getElementById("taskInput");
    if (!taskInput.value) {
        return;
    }

    const newTask = document.createElement('li');
    newTask.style.display = 'flex'; // フレックスボックスで配置
    newTask.style.alignItems = 'center'; // 垂直方向の中央揃え

    const newCheckBox = createNewCheckBox(false);
    newTask.appendChild(newCheckBox);

    const newSpan = document.createElement('span');
    newSpan.textContent = taskInput.value;
    newSpan.style.flexGrow = '1'; // スパンが可能な限り幅を取るようにする
    newTask.appendChild(newSpan);

    // 削除ボタンの追加
    const deleteButton = document.createElement('button');
    deleteButton.textContent = '削除';
    deleteButton.onclick = function() {
        todoList.removeChild(newTask);
    };
    newTask.appendChild(deleteButton);

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

    todoList.appendChild(newTask);
    node.remove();
}
