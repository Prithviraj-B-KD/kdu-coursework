import "../styles/Navbar.css";
import { FaSearch } from "react-icons/fa";
function NavbarDetails() {
  const { products, setFilteredProducts} = useContext(ProductContext);
  const searchInputRef = useRef<HTMLInputElement>(null);
  const handleSearch = () => {
    
    const query = searchInputRef.current?.value.toLowerCase() || '';
    const filtered = products.filter(product => product.name.toLowerCase().includes(query));
    setFilteredProducts(filtered);
  };
  return (
    <div className="navbar">
      <div className="search-bar-container">
        <input
          className="search-input"
          name="search-input"
          ref={searchInputRef}
          placeholder="Search.."
        />
        <button className="search-button">
          <FaSearch className="search-icon"/>
        </button>
      </div>
    </div>
  );
}

export default NavbarDetails;
