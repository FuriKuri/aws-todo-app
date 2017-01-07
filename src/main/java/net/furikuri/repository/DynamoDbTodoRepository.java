package net.furikuri.repository;


import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import net.furikuri.domain.Todo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Profile("!mock")
public class DynamoDbTodoRepository implements TodoRepository {

  private DynamoDB dynamoDb;

  @Value("${aws.table}")
  private String tableName;
  private final AmazonDynamoDBClient client;

  public DynamoDbTodoRepository() {
    client = new AmazonDynamoDBClient();
    client.setRegion(Region.getRegion(Regions.EU_CENTRAL_1));
    dynamoDb = new DynamoDB(client);
  }

  @Override
  public void save(Todo todo) {
    Table table = dynamoDb.getTable(tableName);
    table.putItem(
      new Item()
        .withPrimaryKey("Id", todo.getId())
        .withString("Value", todo.getValue())
    );
  }

  @Override
  public List<Todo> findAll() {
    return client
      .scan(tableName, Arrays.asList("Id", "Value"))
      .getItems().stream().map((item) ->
        new Todo(item.get("Id").getS(), item.get("Value").getS())
      ).collect(Collectors.toList());
  }
}
