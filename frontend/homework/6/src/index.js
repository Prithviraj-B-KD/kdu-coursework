import express, { json, urlencoded } from "express";
import cors from "cors";
import router from "../src/routes/index.js";

const app = express();
app.use(json());
app.use(urlencoded({ extended: true }));

// Mount the '/api/v1/' router under the main app
app.use("/api/v1/", router);

app.get("/", (req, res) => {
  res.send("<h1>Hello World!</h1>");
});

app.listen(3000, () =>
  console.log(`Server is running on  http://localhost:3000`)
);
