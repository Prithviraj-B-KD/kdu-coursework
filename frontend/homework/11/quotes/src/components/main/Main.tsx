import React, { useEffect, useState } from "react";
import { APIQuote } from "../../types/QuotesApi";
import Quote from "../Quote";
import "../../styles/main/main.css";
import Filter from "../Filter";
import { ClipLoader } from "react-spinners";

function Main() {
    const [loading, setLoading] = useState(false);
  const [quotes, setQuotes] = useState<APIQuote[]>([]);
  const [filteredQuotes, setFilteredQuotes] = useState<APIQuote[]>([]);
  const [filterTags, setFilterTags] = useState<string[]>([]);
  useEffect(() => {
    fetch("https://api.quotable.io/quotes/random?limit=3")
      .then((response) => {
        return response.json();
      })
      .then((data: APIQuote[]) => {
        setQuotes(data);
      });
  }, []);
    
    useEffect(() => { 
        console.log(filterTags)
        filterTags.forEach((tag) => setFilteredQuotes([...quotes.filter((quote)=> quote.tags.includes(tag))]));
        
    }, [filterTags,quotes]);

    const fetchNewQuote = () => {
        setLoading(true);
    fetch("https://api.quotable.io/quotes/random")
      .then((response) => {
        return response.json();
      })
      .then((data: APIQuote[]) => {
          setQuotes([...data, ...quotes]);
          setLoading(false);
      });
  };
   

  return (
    <div className="main-container">
      <div className="new-Quotes">
        <button className="new-Quotes-button" onClick={fetchNewQuote}>
        {loading ? (
    <ClipLoader color="#ffffff" loading={loading}  size={20} />
  ) : (
    'New Quote'
  )}
        </button>
      </div>
     <Filter filterTags={filterTags} setFilterTags={setFilterTags}/>
      <div>
              { filterTags.length === 0 ?
                  (quotes.map((quote) => (
                      <Quote key={quote._id} quote={quote} filterTags={filterTags} setFilterTags={setFilterTags} />
                  ))) :
              (filteredQuotes.map((quote) => (
                  <Quote key={quote._id} quote={quote} filterTags={filterTags} setFilterTags={setFilterTags} />
              )))}
      </div>
    </div>
  );
}

export default Main;
