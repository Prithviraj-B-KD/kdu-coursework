
import Navbar from './Navbar'
import { store } from '../redux/store'
import { Provider } from 'react-redux'



describe('<Navbar />', () => {
  it('renders', () => {
    // see: https://on.cypress.io/mounting-react
    cy.mount(<Provider store={store}><Navbar /></Provider>)
  })
})
describe('Navbar component', () => {
  it('should update search query on input change', () => {
    cy.mount(<Provider store={store}><Navbar /></Provider>);

    // Find the search input element
    const searchInput = cy.get('input[name="search-bar"]');

    const searchTerm = 'test items';
    searchInput.type(searchTerm);
    cy.get('.navbar-container').contains('Item Lister').should('exist').and('be.visible');
    // Assert that the state in the component has been updated
    cy.get('.search-bar').then(() => {
      expect(store.getState().searchQuery.searchQuery).to.equal(searchTerm);
    });
  });
});

