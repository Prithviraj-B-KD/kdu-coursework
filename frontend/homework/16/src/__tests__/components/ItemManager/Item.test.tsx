import { describe, expect, it } from 'vitest';
import { render, screen} from "@testing-library/react";
import {  userEvent } from '@testing-library/user-event'; 
import Item from "../../../components/ItemManger/Item";
import { store } from '../../../redux/store';
import { Provider } from 'react-redux';





describe('Item component', () => {

    const itemProps = { id: 1, name: 'Test Item', completed: false };
    it('renders the item name ', () => {
        render(<Provider store={store}><Item {...itemProps} /></Provider>);
        expect(screen.getByText('Test Item')); 
    
    });
    it('checkbox', () => {
        render(<Provider store={store}><Item {...itemProps} /></Provider>);
        expect(screen.getByRole('checkbox'));
    });
    it('should call toggleTODO action and update checkbox state on checkbox click', async () => {
        render( <Provider store={store}><Item {...itemProps}/></Provider>);
    
        const checkbox = screen.getByRole('checkbox');
        await userEvent.click(checkbox);
        expect(checkbox).not.toBeNull(); 
      });
  });