import { defineConfig } from "cypress";

export default defineConfig({
  component: {
    devServer: {
      framework: "react",
      bundler: "vite",
    },
  },

  viewportHeight: 726,
  viewportWidth: 1040,

  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
