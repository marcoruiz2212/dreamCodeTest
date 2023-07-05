package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Category;

import java.util.Set;


/**
 * Services to handle all the category logic
 */
public class CategoryService {

    /**
     * Lookup the keywords
     * @param category all the categories
     * @param categoryName categoryName to lookup
     * @return
     */
    public Set<String> getKeywordByCategory(final Category category, final String categoryName){
        final Category categoryReturn = getCategoryByName(category, categoryName);
        return categoryReturn != null ? categoryReturn.getKeyWords() : null;
    }


    /**
     * Lookup the Level of the category
     * @param category all the categories
     * @param categoryName categoryName to lookup
     * @return
     */
    public Long getLevelByCategory(final Category category, final String categoryName){
        final Category categoryReturn = getCategoryByName(category, categoryName);
        return categoryReturn != null ? categoryReturn.getLevel() : null;
    }


    /**
     * Recursive method to find the category by name
     * @param category
     * @param categoryName
     * @return
     */
    private Category getCategoryByName(final Category category, final String categoryName){
        if(category.getName().equalsIgnoreCase(categoryName)){
            return category;
        }else{
            if(category.getSubCategories() != null){
                for(Category cat: category.getSubCategories()){
                    final Category categoryFind = getCategoryByName(cat, categoryName);
                    if(categoryFind != null){
                        return categoryFind;
                    }

                }
            }
        }

        return null;
    }

}
