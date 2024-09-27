import React from 'react'
import HomePage from './Homepage'
import { Provider } from 'react-redux'
import { store } from '../redux/store'

describe('<HomePage />', () => {
  it('renders', () => {
    // see: https://on.cypress.io/mounting-react
    cy.mount(<Provider store={store}><HomePage /></Provider>)
  })
})