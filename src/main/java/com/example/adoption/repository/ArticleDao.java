package com.example.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.adoption.entity.Article;

@Repository
public interface ArticleDao extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article>{

}
