const loginButton = document.querySelector("#login-button");
const username = document.querySelector("#username-input");
const password = document.querySelector("#password-input");

if (loginButton) {
  loginButton.addEventListener("click", async () => {
    await fetch("http://localhost:3000/api/v1/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        username: username.value,
        password: password.value,
      }),
    })
      .then((response) => {
        if (!response.ok) {
          alert("Invalid username or password !!");
          username.value = "";
          password.value = "";
          return;
        }
        return response.json();
      })
      .then((data) => {
        console.log(data);
        localStorage.setItem("user", JSON.stringify(data));
        window.location.href = "http://127.0.0.1:5500/client/index.html";
      });
  });
}
