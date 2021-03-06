package com.trivia.champion.categories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trivia.champion.factories.UiFactory;
import com.trivia.champion.ui.output.player.IPlayerUi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static com.trivia.champion.utils.Constants.CATEGORIES_API;

public class CategoriesApiParser {
    private HttpClient client;

    public CategoriesApiParser() {
        this.client = HttpClient.newHttpClient();
    }

    public List<ApiCategory> parse() throws Exception {
        List<ApiCategory> categories;
        CategoriesApiResponse categoriesApiResponse = getCategories();
        if (categoriesApiResponse == null) {
            return null;
        }
        categories = categoriesApiResponse.getTrivia_categories();
        return categories;
    }

    private CategoriesApiResponse getCategories() throws Exception {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("accept", "application/json")
                    .uri(URI.create(CATEGORIES_API))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // parse json into questionList
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.body(), new TypeReference<>() {});
        } catch (Exception e) {
            UiFactory factory = UiFactory.getInstance();
            IPlayerUi display = factory.getPlayerUiOutput();
            display.showApiProblem();
        }
        return null;
    }
}
