package com.tom.mongodbspring;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MongoDbConfig {

    private MongoTemplate mongoTemplate;

    public MongoDbConfig(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){

        Article article = new Article();
        article.setAuthor("Tomasz Ociepa");
        article.setTitle("Nauka mongodb-spring");

        Comment comment1 = new Comment();
        comment1.setText("Wow ale dobry artykuł!!");
        Comment comment2 = new Comment();
        comment2.setText("Jest świetny!!");

        article.setComment(Arrays.asList(comment1, comment2));

        mongoTemplate.insert(article);

        List<Article> all = mongoTemplate.findAll(Article.class);

        System.out.println(all);


    }

}
