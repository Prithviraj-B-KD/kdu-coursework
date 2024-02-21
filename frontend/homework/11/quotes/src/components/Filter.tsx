import * as React from 'react';
import { FilterProps } from '../types/FilterProps';



function Filter({ filterTags, setFilterTags }: FilterProps) {
    const handleTagDelete = (tag: string) => {
        setFilterTags(filterTags.filter((t) => t !== tag))
    }
    return ( 
        <div className="filters">
        <div className="sub-heading">Filters</div>
        <div className="selected-tags">
          <ul className="tags">
            {filterTags.map((tag) => (
                <li><div className="filtered-tag"><div>{tag}</div>
                <button onClick={()=> handleTagDelete(tag)}> X</button></div></li>
            ))}
          </ul>
        </div>
      </div>
     );
}

export default Filter;