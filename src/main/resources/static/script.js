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

function D_createNewCheckBox(checked) {
  const newCheckBox = document.createElement("input");
  newCheckBox.type = "checkbox";
  newCheckBox.checked = checked;
  newCheckBox.className = "checkBox"; 
  if (checked) {
    newCheckBox.addEventListener("click", e => D_clickDoneList(e));
    
  } else {
    newCheckBox.addEventListener("click", e => D_clickTodoList(e));
    
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





function D_clickTodoList(e) {
  const node = e.target.parentElement;

  // 新しいリスト項目を作成
  const newTask = document.createElement('li');

  // チェックボックスを追加
  newTask.appendChild(D_createNewCheckBox(true));

  // リンク要素を追加
  const linkElement = node.querySelector('a');
  newTask.appendChild(linkElement);

  // フォーム要素を追加
  const formElement = node.querySelector('form');
  newTask.appendChild(formElement);

  // Doneリストに新しいタスクを追加
  doneList.appendChild(newTask);

  // 元のノードを削除
  node.remove();
}

function D_clickDoneList(e) {
  const node = e.target.parentElement;

  // 新しいリスト項目を作成
  const newTask = document.createElement('li');

  // チェックボックスを追加
  newTask.appendChild(D_createNewCheckBox(false));

  // リンク要素を追加
  const linkElement = node.querySelector('a');
  newTask.appendChild(linkElement);

  // フォーム要素を追加
  const formElement = node.querySelector('form');
  newTask.appendChild(formElement);

  // Todoリストに新しいタスクを追加
  todoList.appendChild(newTask);

  // 元のノードを削除
  node.remove();
}

function changeColorScheme(scheme) {
    const colors = JSON.parse(scheme);
    document.documentElement.style.setProperty('--main-bg-color', colors.bgColor);
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

function updateCustomColor() {
    const customColors = {
        bgColor: document.getElementById('custom-bgColor').value,
        textColor: document.getElementById('custom-textColor').value,
        boxColor: document.getElementById('custom-boxColor').value,
        homeColor: document.getElementById('custom-homeColor').value,
        whiteColor: document.getElementById('custom-whiteColor').value,
        labelColor: document.getElementById('custom-labelColor').value,
        // 他の色も同様に取得
    };
    changeColorScheme(JSON.stringify(customColors));
}

function getCheckboxes() {
  return document.querySelectorAll('.checkBox');
}

function savecheck() {
  var messageDiv = document.getElementById("successMessage");
  messageDiv.style.display = "block"; // メッセージを表示
  const checkboxes = document.querySelectorAll('.checkBox');
  checkboxes.forEach((checkbox) => {
    const taskText = checkbox.parentElement.querySelector('span')?.textContent;
    if (taskText) {
      localStorage.setItem(`checkbox_${taskText}`, checkbox.checked);
    }
  });
  // 2秒後にメッセージを非表示に
    setTimeout(function() {
        messageDiv.style.display = "none";
    }, 2000); // 1000ミリ秒 = 1秒
}

function loadcheck() {
  const checkboxes = document.querySelectorAll('.checkBox');
  console.log(checkboxes);

  checkboxes.forEach((checkbox) => {
    const taskText = checkbox.parentElement.querySelector('span')?.textContent;
    if (taskText) {
      const isChecked = localStorage.getItem(`checkbox_${taskText}`) === 'true';
      checkbox.checked = isChecked; // チェックボックスの状態を更新

      // 状態更新後にイベントを追加
if (isChecked) {
      // 擬似的にクリックイベントを作成して渡します
      const event = new Event('click');
      checkbox.dispatchEvent(event);
    }
    }
  });

  console.log("チェックボックスの状態が復元されました！");
}

window.onload = function() {
  setTimeout(loadcheck, 10);
}
