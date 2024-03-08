import { postService } from "../services/index.js";
import { Helper } from "../helper/index.js";

class postsController {
  /**
   * Handles requests to retrieve all posts.
   *
   * @param {Object} request - The Express request object.
   * @param {Object} response - List of all posts or error.
   */
  getAll(request, response) {
    postService
      .getAll()
      .then((data) => {
        Helper.responseJsonHandler(null, data, response);
      })
      .catch((error) => {
        Helper.responseJsonHandler(error, null, response);
      });
  }

  /**
   * Handles requests to create a new post.
   *
   * @param {Object} request - expects a request body .
   * @param {Object} response - Successfully message on create or error.
   */
  post(request, response) {
    postService
      .post(request.body)
      .then((data) => {
        Helper.responseJsonHandler(null, data, response);
      })
      .catch((error) => {
        Helper.responseJsonHandler(error, null, response);
      });
  }

  /**
   * Handles requests to retrieve a specific post by its ID.
   *
   * @param {Object} request - expects id in params.
   * @param {Object} response - return post of given param.id .
   */
  getById(request, response) {
    postService
      .getById(request.params)
      .then((data) => {
        Helper.responseJsonHandler(null, data, response);
      })
      .catch((error) => {
        Helper.responseJsonHandler(error, null, response);
      });
  }
}
export default new postsController();
