let tasks = JSON.parse(localStorage.getItem("tasks") || "[]");

function saveTasks() {
  localStorage.setItem("tasks", JSON.stringify(tasks));
}

function render() {
  const todoList = document.getElementById("todo-list");
  const doneList = document.getElementById("done-list");
  todoList.innerHTML = "";
  doneList.innerHTML = "";

  tasks.forEach((task, index) => {
    const div = document.createElement("div");
    div.className = "task";
    div.textContent = task.title;
    div.onclick = () => showDetail(index);
    if (task.done) {
      doneList.appendChild(div);
    } else {
      todoList.appendChild(div);
    }
  });
}

function showView(id) {
  document.querySelectorAll(".view").forEach(v => v.classList.add("hidden"));
  document.getElementById(id).classList.remove("hidden");
}

function showDetail(index) {
  const task = tasks[index];
  document.getElementById("detail-title").textContent = task.title;
  document.getElementById("detail-note").textContent = task.note;
  showView("detail-view");
}

document.getElementById("go-add").onclick = () => showView("add-view");
document.getElementById("back-home").onclick = () => showView("home-view");
document.getElementById("back-detail-home").onclick = () => showView("home-view");

document.getElementById("add-task").onclick = () => {
  const title = document.getElementById("new-title").value.trim();
  const note = document.getElementById("new-note").value.trim();
  if (!title) {
    alert("タイトルを入力してください");
    return;
  }
  tasks.push({ title, note, done: false });
  saveTasks();
  document.getElementById("new-title").value = "";
  document.getElementById("new-note").value = "";
  showView("home-view");
  render();
};

render();
