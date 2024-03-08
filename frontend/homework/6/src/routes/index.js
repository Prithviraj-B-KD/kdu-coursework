import express from "express";
const router = express.Router();
import { postsController } from "../controllers/index.js";

// GET /posts - Retrieves all posts
router.get("/posts", postsController.getAll);
// GET /posts/:_id - Retrieves a specific post by ID
router.get("/posts/:_id", postsController.getById);
// POST /posts - Creates a new post
router.post("/posts", postsController.post);

export default router;
