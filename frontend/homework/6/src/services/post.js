import { errors } from "../helper/index.js";
import { Posts } from "../models/index.js";
import { v4 as uuidv4 } from "uuid";

export default class postService {
  /**
   * Retrieves all posts from the data source.
   *
   * @returns {Promise<Posts[]>} - A promise resolving to an array of all posts or an empty array if none exist.
   */
  static getAll() {
    return new Promise((resolve, reject) => {
      resolve(Posts);
    });
  }
  /**
   * Creates a new post.
   *
   * @param {Object} body - The request body containing post data.
   * @param {string} body.content - The required content of the post.
   * @returns {Promise<Object>} - A promise resolving to an object containing a success message and the newly created post, or an error response.
   */
  static post(body) {
    return new Promise((resolve, reject) => {
      if (!body.content) {
        reject(errors["004"]);
      } else {
        const newPost = { id: uuidv4(), content: body.content };
        Posts.push(newPost);
        const response = {
          message: "Post created successfully",
          post: newPost,
        };
        resolve(response);
      }
    });
  }

  /**
   * Retrieves a specific post by its ID.
   *
   * @param {Object} params - The request parameters containing the ID.
   * @param {string} params._id - The ID of the post to retrieve.
   * @returns {Promise<Post | null>} - A promise resolving to the matching post object or null if not found.
   */
  static getById(params) {
    return new Promise((resolve, reject) => {
      const _id = params._id;
      if (_id) {
        const post = Posts.find((p) => p.id === _id);
        resolve(post);
      } else {
        reject(errors["002"]);
      }
    });
  }
}
