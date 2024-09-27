import { describe, expect, it } from 'vitest';
import { fireEvent, render, screen} from "@testing-library/react";
import { Provider } from 'react-redux';
import Navbar from '../../components/Navbar';
import { store } from '../../redux/store';




describe('Navbar component', () => {

    it('renders the item name and completion checkbox', () => {
        render(<Provider store={store}><Navbar /></Provider>);
        expect(screen.getByText('Item Lister')).not.toBeNull(); 
    });
    
    it('dispatches searchQuery action', () => { 
        const {getByPlaceholderText}  = render(<Provider store={store}><Navbar /></Provider>);
        const searchInput = getByPlaceholderText('Search items...');
        fireEvent.change(searchInput, { target: { value: 'Test' } });
        expect(store.getState().searchQuery.searchQuery).toBe('Test');
    });
  });