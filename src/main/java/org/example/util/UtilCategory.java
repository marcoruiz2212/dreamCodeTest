package org.example.util;

import org.example.model.Category;

import java.util.Set;

public class UtilCategory {

    public static Category populateCategory(final Long id, final String name, final boolean isRoot, final Long level, final Set<String> keyWords){
       return  Category.builder().id(id)
                                 .name(name)
                                 .level(level)
                                 .keyWords(keyWords)
                                 .isRoot(isRoot).build();
    }


}
