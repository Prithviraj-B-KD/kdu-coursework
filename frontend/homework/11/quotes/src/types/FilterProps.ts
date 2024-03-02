import { SetStateAction } from "react";

export interface FilterProps {
  filterTags: string[];
  setFilterTags: React.Dispatch<SetStateAction<string[]>>;
}
