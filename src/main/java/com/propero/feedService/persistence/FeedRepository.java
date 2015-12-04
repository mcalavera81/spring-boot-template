package com.propero.feedService.persistence;

import com.propero.feedService.domain.FeedSource;
import com.propero.feedService.domain.QFeedSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface FeedRepository extends FeedRepositoryCustom,
        JpaRepository<FeedSource, Long>
        ,QueryDslPredicateExecutor<FeedSource>
        ,QuerydslBinderCustomizer<QFeedSource>{

    default void customize(QuerydslBindings bindings, QFeedSource store) {

    }

}