package com.propero.feedService.service.impl;


import com.propero.feedService.domain.FeedSource;
import com.propero.feedService.domain.QFeedSource;
import com.propero.feedService.enums.FeedId;
import com.propero.feedService.persistence.FeedRepository;
import com.propero.feedService.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * Created by farid on 26/11/15.
 */
@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    private FeedRepository feedRepository;

    @Override
    public String getCurrentSource() {
        return "CurrentSource";
    }

    @Autowired
    private EntityManager entityManager;

    @Override
    public Iterable<FeedSource> method() {
        QFeedSource feedSource= QFeedSource.feedSource;
        Iterable<FeedSource> all = feedRepository.findAll(feedSource.id.isNotNull());
        return all;
    }

    @Override
    public List<FeedSource> getAllFeeds() {
        return feedRepository.findAll();
    }


    @Override
    public Optional<FeedSource> getFeedSource() {
        Optional<FeedSource> currentFeedSource = feedRepository.getCurrentFeedSource();
        return currentFeedSource;
    }

    /**
     * Switches the feedSource.
     * @param feedId
     */
    @Override
    public void switchFeedSource(FeedId feedId) {
        FeedSource feedSource = new FeedSource(feedId);
        feedRepository.save(feedSource);
    }



}
