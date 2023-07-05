package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public  class Category {

    private Long id;

    private String name;


    private List<Category> subCategories;

    private Set<String> keyWords;

    private boolean isRoot;

    private Long level;

    public void addSubCategories(final Category category){
        if(subCategories == null){
            subCategories = new ArrayList<>();
        }
        subCategories.add(category);
    }
}
