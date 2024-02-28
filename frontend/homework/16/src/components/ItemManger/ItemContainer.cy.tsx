
import ItemContainer from './ItemContainer'
import { Provider } from 'react-redux'
import { store } from '../../redux/store'

describe('<ItemContainer />', () => {
  it('renders', () => {
    // see: https://on.cypress.io/mounting-react
    cy.mount(<Provider store={store}><ItemContainer /></Provider>)
  })
  it('input submit button tested', () => {

    cy.mount(<Provider store={store}><ItemContainer /></Provider>)
    // see: https://on.cypress.io/mounting-react
    cy.get('.input-box input[type="text"]').should('exist');
    cy.get('.input-box input[type="text"]').type('Test');
    cy.get('#submit-button button').click();
    cy.contains('Test').should("exist");
  
    cy.get('.item-info input[type="checkbox"]').first().check();
    const compleletedItem = cy.get('.item-span');
    compleletedItem.should('have.css', 'text-decoration', 'line-through solid rgb(0, 0, 0)');
  });
  it('clear button tested', () => {

    cy.mount(<Provider store={store}><ItemContainer /></Provider>)
    // see: https://on.cypress.io/mounting-react
    cy.get('.input-box input[type="text"]').should('exist');
    cy.get('.input-box input[type="text"]').type('Test 1');
    cy.get('#submit-button button').click();
    cy.get('.input-box input[type="text"]').type('Test 2');
    cy.get('#submit-button button').click();
    cy.get("#clear-button").click();
    cy.contains('Test 1').should("not.exist");
    
  });
  it('checkbox button tested', () => {

    cy.mount(<Provider store={store}><ItemContainer /></Provider>)
    // see: https://on.cypress.io/mounting-react
    cy.get('.input-box input[type="text"]').should('exist');
    cy.get('.input-box input[type="text"]').type('Test 1');
    cy.get('#submit-button button').click();
    cy.get('.input-box input[type="text"]').type('Test 2');
    cy.get('#submit-button button').click();
    cy.get('.item-info input[type="checkbox"]').first().check();
    const compleletedItem = cy.get('.item-span');
    compleletedItem.should('have.css', 'text-decoration', 'line-through solid rgb(0, 0, 0)');
    
  });
 

})