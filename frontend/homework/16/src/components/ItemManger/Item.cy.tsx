
import Item from './Item'
import { Provider } from 'react-redux'
import { store } from '../../redux/store'

describe('<Item />', () => {
  it('renders', () => {
    const itemProps = { id: 1, name: 'Test Item', completed: false };
    // see: https://on.cypress.io/mounting-react
    cy.mount(<Provider store={store}><Item {...itemProps} /></Provider>)
   
  });

})