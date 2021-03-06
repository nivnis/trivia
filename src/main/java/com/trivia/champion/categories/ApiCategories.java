package com.trivia.champion.categories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiCategories extends Categories {
    private CategoriesApiParser categoriesApiParser = new CategoriesApiParser();
    private List<ApiCategory> apiCategories;
    private ArrayList<String> categories = new ArrayList<>();

    public ApiCategories() throws Exception {
        apiCategories = categoriesApiParser.parse();
        if (apiCategories == null) {
            return;
        }
        for (ApiCategory apiCategory : apiCategories) {
            categories.add(apiCategory.getName());
        }
        super.setCategories(categories);
    }

    public int getCategoryId(String category) {
        for (ApiCategory apiCategory : apiCategories) {
            if (apiCategory.getName().equals(category))
                return apiCategory.getId();
        }
        return -1;
    }
}
