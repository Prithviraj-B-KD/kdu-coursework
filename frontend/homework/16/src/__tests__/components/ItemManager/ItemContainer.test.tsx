import { describe, expect, it } from 'vitest';
import { render, screen} from "@testing-library/react";
import { store } from '../../../redux/store';
import { Provider } from 'react-redux';
import ItemContainer from '../../../components/ItemManger/ItemContainer';

describe('Item Container component', () => {

    it('renders the item name ', () => {
        render(<Provider store={store}><ItemContainer/></Provider>);
        expect(screen.getByText('Add Items')); 
    
    });
    it('Submit button', () => {
        render(<Provider store={store}><ItemContainer /></Provider>);
        expect(screen.getByText('Submit'));
    });
   
  });