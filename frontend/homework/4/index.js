// index.js

const addButton = document.getElementById("add");
const todoInput = document.getElementById("todo-input");
const listElement = document.getElementById("list");

addButton.addEventListener("click", () => {
  const todoText = todoInput.value.trim(); // Trim whitespace

  if (todoText) {
    // Check if input is not empty
    const listItem = document.createElement("li");
    listItem.textContent = todoText;

    const deleteButton = document.createElement("button");
    deleteButton.textContent = "Delete";
    deleteButton.addEventListener("click", () => {
      listItem.remove();
    });

    listItem.appendChild(deleteButton);
    listElement.appendChild(listItem);

    todoInput.value = ""; // Clear input field
  } else {
    alert("Please enter a to-do item.");
  }
});
