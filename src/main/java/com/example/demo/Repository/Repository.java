package com.example.demo.Repository;

import java.util.ArrayList;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.CosmosDatabase;
import com.azure.cosmos.models.CosmosItemResponse;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.PartitionKey;
import com.azure.cosmos.util.CosmosPagedIterable;
import com.example.model.Family;

public class Repository {
    private CosmosClient client;
    private CosmosDatabase database;
    private CosmosContainer container;

    public Repository() {
        super();
        connectCosmos();

    }

    private void connectCosmos() {
        ArrayList<String> preferredRegions = new ArrayList<String>();
        preferredRegions.add("West US");
        client = new CosmosClientBuilder()
                .endpoint("https://examlive.documents.azure.com:443/")
                .key("n5vo1rHi07Hl0tNZ0j1MZyeyonKrIih8a822uh9WBsyGCxQJNsenLBwvGRRkGPS9OuTiRyyRTEv8ACDbJqlcWQ==")
                .preferredRegions(preferredRegions)
                .userAgentSuffix("CosmosDBJavaQuickstart")
                .consistencyLevel(ConsistencyLevel.EVENTUAL)
                .buildClient();
    }

    public String GetUser(String Id) {
        database = client.getDatabase("ToDoList");
        container = database.getContainer("Items");
        CosmosItemResponse<Family> item = container.readItem(Id, new  PartitionKey("Andersen"), com.example.model.Family.class);
        Family family = item.getItem();
        String result = String.format("%s %s %s", family.getPartitionKey(), family.getLastName(), family.getAddress().getCity());
        return result;
    }

}
