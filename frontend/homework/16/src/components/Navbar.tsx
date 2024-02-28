
import "../styles/Navbar.css"
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '../redux/store';
import { updateSearch } from "../redux/slice/SearchSlice";




function Navbar() {
    const searchQuery = useSelector((state: RootState) => state.searchQuery.searchQuery);
    const reduxDispatch = useDispatch();
    const handleSearch = (value:string) => {
        reduxDispatch(updateSearch(value));
    }
    
    return ( 
        <div className="navbar-container">
            <div className="navbar-heading"><h2>Item Lister</h2></div>
            <div className="search-bar">
                <input type="text" name='search-bar'
                         value={searchQuery}
                         onChange={(e) => handleSearch(e.target.value)}
                    placeholder='Search items...' />
            </div>
        </div>
     );
}

export default Navbar;