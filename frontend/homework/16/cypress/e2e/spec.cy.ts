describe("template spec", () => {
  it("passes", () => {
    cy.visit("http://localhost:5173");
  });
  it("check add item", () => {
    cy.visit("http://localhost:5173");
    cy.get('.input-box input[type="text"]').should("exist");
    cy.get('.input-box input[type="text"]').type("Test");
    cy.get("#submit-button button").click();
    cy.contains("Test").should("exist");

    cy.get('.item-info input[type="checkbox"]').first().check();
    const compleletedItem = cy.get(".item-span");
    compleletedItem.should(
      "have.css",
      "text-decoration",
      "line-through solid rgb(0, 0, 0)"
    );
  });
  it("Check Search functionality", () => {
    cy.visit("http://localhost:5173");
    cy.get('.input-box input[type="text"]').should("exist");
    cy.get('.input-box input[type="text"]').type("Test");
    cy.get("#submit-button button").click();
    cy.contains("Test").should("exist");

    const searchInput = cy.get('input[name="search-bar"]');
    const searchTerm = "Test";
    searchInput.type(searchTerm);
    // Assert that the state in the component has been updated
    cy.get("ul > .Item").contains("Test");
  });
  it("check redux persist ", () => {
    cy.visit("http://localhost:5173");
    cy.get('.input-box input[type="text"]').should("exist");
    cy.get('.input-box input[type="text"]').type("Test");
    cy.get("#submit-button button").click();
    cy.reload();
    cy.contains("Test").should("exist");
  });
  it("check delete item ", () => {
    cy.visit("http://localhost:5173");
    cy.get('.input-box input[type="text"]').should("exist");
    cy.get('.input-box input[type="text"]').type("Test");
    cy.get("#submit-button button").click();

    cy.contains("Test").should("exist");
    cy.get(".delete-button").click();
    cy.contains("Test").should("not.exist");
  });
  it("check clear item ", () => {
    cy.visit("http://localhost:5173");
    cy.get('.input-box input[type="text"]').should("exist");
    cy.get('.input-box input[type="text"]').type("Test 1");
    cy.get("#submit-button button").click();
    cy.get('.input-box input[type="text"]').type("Test 2");
    cy.get("#submit-button button").click();
    cy.get("#clear-button").click();
    cy.contains("Test 1").should("not.exist");
    cy.contains("Test 2").should("not.exist");
  });
});
