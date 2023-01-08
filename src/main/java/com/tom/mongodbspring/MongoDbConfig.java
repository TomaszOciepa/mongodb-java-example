package com.tom.mongodbspring;


import com.github.javafaker.Faker;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

        int index = 0;

        while (index < 100){
            Faker faker = new Faker();

            Article article = new Article();
            article.setAuthor(faker.dragonBall().character());
            article.setTitle(faker.book().title());

            Comment comment1 = new Comment();
            comment1.setText(faker.chuckNorris().fact());
            Comment comment2 = new Comment();
            comment2.setText(faker.chuckNorris().fact());

            article.setComment(Arrays.asList(comment1, comment2));

            mongoTemplate.insert(article);

            index++;
        }

//        List<Article> all = mongoTemplate.findAll(Article.class);
//        System.out.println(all);

        //author: Nappa
        Query query = new Query((Criteria.where("author").is("Nappa")));
        List<Article> article = mongoTemplate.find(query, Article.class, "article");

        System.out.println(article);


    }

}
