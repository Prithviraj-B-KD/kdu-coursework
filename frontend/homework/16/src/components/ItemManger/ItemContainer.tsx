import {  useEffect, useState } from "react";
import "../../styles/ItemManagerStyles/ItemContainer.css";
import Item from "./Item";
import { ItemProps } from "../../types/ItemProps";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../../redux/store";
import { addTODO, clearTODO } from "../../redux/slice/ItemSlice";



function ItemContainer() {
  const reduxDispatch = useDispatch();
  const itemlist = useSelector((state: RootState) => state.persistedReducer.items.items);
  const searchQuery = useSelector((state: RootState) => state.searchQuery.searchQuery);
  const [filteredItems, setFilteredItems] = useState<ItemProps[]>([]);
  const [name, setName] = useState("");
  const [showList, setShowList] = useState(false);

  const addItem = (newItemName: string) => {
    if (newItemName !== "") {
      const newItem = { id: itemlist.length + 1, name: newItemName, completed: false };
      setName("");
      reduxDispatch(addTODO(newItem));
    }
  };
  const handleClear = () => {
    reduxDispatch(clearTODO());
  }

  useEffect(() => {
    const updatedItems = itemlist.filter((item) =>
      item.name.toLowerCase().includes(searchQuery.toLowerCase())
    );

    setFilteredItems(updatedItems);
    setShowList(updatedItems.length > 0 && searchQuery !== ""); // Only show if items or searchQuery exists
  }, [searchQuery, itemlist]);

  return (
    <div className="Item-Container">
      <div className="search-result-Container">
        {showList && (
          <ul>
            {filteredItems.map((item) => (
       
              <Item key={item.id} name={item.name} id={item.id} completed={item.completed} />
            ))}
          </ul>
        )}
        {!showList && searchQuery && <p>No match found</p>}
        {/* Other components */}
      </div>
      <div className="Item-container-heading">
        <h1>Add Items</h1>
      </div>
      <div className="Item-add-box">
        <form
          onSubmit={(e) => {
            e.preventDefault();
            addItem(name);
          }}
        >
          <div className="input-box">
            <input
              type="text"
              name="add-item"
              id="add-input"
              placeholder="Add Items"
              value={name}
              onChange={(e) => setName(e.target.value.trim())}
            />
          </div>
          <div className="submit-div" id="submit-button">
            <button type="submit">Submit</button>
          </div>

        </form>
      </div>
      <div className="submit-div">
            <button id="clear-button" onClick={handleClear}>Clear</button>
          </div>
      <div className="items">
        {itemlist.map((item) => (
          <Item key={item.id} name={item.name} id={item.id} completed={ item.completed} />
        ))}
      </div>
    </div>
  );
}

export default ItemContainer;
