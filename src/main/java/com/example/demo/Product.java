package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("product")
public class Product {
    @Id
    public String id;
    public String name;
    public String image_url;
}
