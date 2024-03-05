import * as React from "react";
import NavbarListPage from "../components/NavbarListPage";
import "../styles/ProductList.css";
import { ProductProps } from "../types/ProductProps";
import { Link } from "react-router-dom";
import ProductCard from "../components/ProductCard";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState } from "../redux/store";
import { getProducts } from "../redux/thunks/getProducts";
import { setData } from "../redux/slice/ProductSlice";
import Loader from "../components/Loader";
import { Alert, Snackbar } from "@mui/material";
import { setShow } from "../redux/slice/SnackbarSlice";

function ProductListPage() {
  const reduxDispatch: AppDispatch = useDispatch();
  const snackbar = useSelector((state: RootState) => state.snackbar);

  React.useEffect(() => {
    reduxDispatch(getProducts());
  }, []);
  const products = useSelector((state: RootState) => state.products.products);
  const loadingState = useSelector((state: RootState) => state.products.state);
  const productError = useSelector((state: RootState) => state.products.error);

  const handleClose = () =>{
    reduxDispatch(setShow(false));
  }
  return (
    <div className="product-list-page">
      <NavbarListPage />
      <div className="heading">
        KDU <span>MARKETPLACE</span>
      </div>
      <div className="products-container">
        {loadingState === "pending" && <Loader />}
        <div className="div">
          {snackbar.show && (
            <Snackbar open={snackbar.show} autoHideDuration={2000} onClose={handleClose}>
              <Alert severity="success" variant="filled" sx={{ width: "100%" }}>
                {snackbar.message}
              </Alert>
            </Snackbar>
          )}
        </div>
        <ul className="products-list">
          {products.map((product: ProductProps) => (
            <li key={product.id}>
              <Link to={`/product/${product.id}`}>
                <ProductCard {...product} />
              </Link>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default ProductListPage;
