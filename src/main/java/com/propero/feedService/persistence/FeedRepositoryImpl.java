package com.propero.feedService.persistence;

import com.propero.feedService.domain.FeedSource;
import com.propero.feedService.domain.QFeedSource;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.Optional;

/**
 * Created by farid on 02/12/15.
 */
public class FeedRepositoryImpl extends QueryDslRepositorySupport implements  FeedRepositoryCustom {


    public FeedRepositoryImpl() {
        super(FeedSource.class);
    }

    @Override
    public Optional<FeedSource> getCurrentFeedSource() {
        QFeedSource qFeedSource= QFeedSource.feedSource;
        FeedSource feedSource = from(qFeedSource).orderBy(qFeedSource.createdOn.desc()).limit(1).singleResult(qFeedSource);
        return Optional.ofNullable(feedSource);
    }

}
