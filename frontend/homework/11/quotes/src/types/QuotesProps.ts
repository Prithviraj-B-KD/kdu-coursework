import { Dispatch, SetStateAction } from "react";
import { APIQuote } from "./QuotesApi";

export interface QuoteProps {
  filterTags: string[];
  setFilterTags: Dispatch<SetStateAction<string[]>>;
  quote: APIQuote;
}
