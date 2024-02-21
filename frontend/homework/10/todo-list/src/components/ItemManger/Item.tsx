import { useContext } from 'react';
import "../../styles/ItemManagerStyles/Item.css"

import { ItemProps } from '../../types/ItemProps';
import { ItemContext } from '../../context/ItemContext';


function Item({id,name}: ItemProps) {
    const { items, setItems } = useContext(ItemContext);
    const deleteItem = (itemId: number) => {
        // Implement delete logic, update items accordingly
        setItems(items.filter((item) => item.id !== itemId));
    };
    
  const handleDelete = async () => {
    try {
       deleteItem(id);
    } catch (error) {
      console.error('Error deleting item:', error);
    }
  };
    return ( 
        <div className="Item">
            <div className="item-info">
                <h2>{name}</h2>
            </div>
            <div className="delete-button-div">
                <button className='delete-button' onClick={handleDelete}>X</button>
            </div>
        </div>
     );
}

export default Item;
