package com.isi.observability_grafana.web;

import com.isi.observability_grafana.entities.Product;
import com.isi.observability_grafana.model.Post;
import com.isi.observability_grafana.repository.ProductRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController

public class ProductController {
    private final ProductRepository productRepository;
    private RestClient jsonPlaceholderClient;
//    private RestClient weatherClient;
    public ProductController(ProductRepository productRepository,
                             RestClient.Builder restClient) {
        this.productRepository = productRepository;
        // Configurer le client pour JSONPlaceholder
        this.jsonPlaceholderClient = restClient
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
        // Configurer le client pour OpenWeatherMap
        /*this.weatherClient = restClient
                .baseUrl("https://api.openweathermap.org/data/2.5")
                .build();*/
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @GetMapping("/posts")
    public List<Post> allPosts(){
        return jsonPlaceholderClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});
    }

    /*@GetMapping("/weather")
    public WeatherInfo getWeather(@RequestParam String city) {
        return weatherClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weather")
                        .queryParam("q", city)
                        .queryParam("appid", "4a452d5c-638d-11ef-a732-0242ac130004-4a452dca-638d-11ef-a732-0242ac130004")  // Remplace par ta clé API
                        .build())
                .retrieve()
                .body(WeatherInfo.class);
    }*/
}
