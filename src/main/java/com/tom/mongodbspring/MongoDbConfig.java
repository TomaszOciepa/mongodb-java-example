package com.tom.mongodbspring;


import com.github.javafaker.Faker;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MongoDbConfig {

    private MongoTemplate mongoTemplate;
    private ArticleRepo articleRepo;

    public MongoDbConfig(MongoTemplate mongoTemplate, ArticleRepo articleRepo) {
        this.mongoTemplate = mongoTemplate;
        this.articleRepo = articleRepo;
    }


    





    public void init(){
        System.out.println("Hello World");
//        int index = 0;
//
//        while (index < 100){
//            Faker faker = new Faker();
//
//            Article article = new Article();
//            article.setAuthor(faker.dragonBall().character());
//            article.setTitle(faker.book().title());
//
//            Comment comment1 = new Comment();
//            comment1.setText(faker.chuckNorris().fact());
//            Comment comment2 = new Comment();
//            comment2.setText(faker.chuckNorris().fact());
//
//            article.setComment(Arrays.asList(comment1, comment2));
//
//            mongoTemplate.insert(article);
//
//            index++;
//        }

        Article articleMy = new Article();
        articleMy.setAuthor("Tomasz");
        articleMy.setTitle("Baza mongo działaj!!!");


        Comment commentMy1 = new Comment();
        commentMy1.setText("Super Kurs!!!");
        Comment commentMy2 = new Comment();
        commentMy2.setText("Może być");

        articleMy.setComment(Arrays.asList(commentMy1, commentMy2));

//        mongoTemplate.insert(articleMy);
//        articleRepo.save(articleMy);
//        List<Article> all = mongoTemplate.findAll(Article.class);
//        System.out.println(all);

//        author: Nappa
//        Query query = new Query((Criteria.where("author").is("Nappa")));
//        List<Article> article = mongoTemplate.find(query, Article.class, "article");

//        System.out.println(all);

        Article article99 = articleRepo.findArticleByTitle("Baza mongo działaj!!!").get();
        System.out.println(article99.getComment()+ " "+ article99.getAuthor());
    }

}
