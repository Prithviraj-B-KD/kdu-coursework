import "../../styles/ItemManagerStyles/Item.css";
import { useDispatch } from "react-redux";
import { deleteTODO, toggleTODO } from "../../redux/slice/ItemSlice";
import { ItemProps } from "../../types/ItemProps";

function Item({ id, name, completed }: ItemProps) {
  const reduxDispatch = useDispatch();
  const deleteItem = (itemId: number) => {
    reduxDispatch(deleteTODO(itemId));
  };
  const handleToggleCompleted = () => {
    reduxDispatch(toggleTODO(id));
  };

  const handleDelete = async () => {
    try {
      deleteItem(id);
    } catch (error) {
      console.error("Error deleting item:", error);
    }
  };
  return (
    <div className="Item">
      <div className="item-info">
      <input
          type="checkbox"
          checked={completed}
          onChange={handleToggleCompleted}
        />
        <h2>
          {" "}
          <span
            style={{
              textDecoration: completed ? "line-through" : "none",
            }}
          >
            {name}
          </span>
        </h2>
      </div>
    
      <div className="delete-button-div">
        <button className="delete-button" onClick={handleDelete}>
          X
        </button>
      </div>
     
    </div>
  );
}

export default Item;
