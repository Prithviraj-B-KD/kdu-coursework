import * as React from "react";
import "../styles/Quote.css";
import { QuoteProps } from "../types/QuotesProps";



function Quote({ filterTags, setFilterTags, quote, }: QuoteProps) {
    const handleTags = (tag:string) => {
        if (!filterTags.includes(tag)) {
            setFilterTags([...filterTags,tag])
        }
    }
  return (
    <div className="quote-container">
      <div className="quote-content">
        <p>{quote.content}</p>
      </div>
      <div className="quote-author">
        <p>~{quote.author}</p>
      </div>
      <div className="quote-date">
        <p>{quote.dateAdded}</p>
      </div>

      <div>
        <ul className="tags">
          {quote.tags.map((tag) => {
            return (
              <li>
                <div onClick={()=>handleTags(tag)} className="tag">{tag}</div>
              </li>
            );
          })}
        </ul>
      </div>
    </div>
  );
}

export default Quote;
