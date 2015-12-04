package com.propero.feedService.service;

import com.propero.feedService.domain.FeedSource;
import com.propero.feedService.enums.FeedId;

import java.util.List;
import java.util.Optional;

/**
 * Created by farid on 26/11/15.
 */
public interface FeedService {

    public void switchFeedSource(FeedId feedSource);

    public Optional<FeedSource> getFeedSource();

    public String  getCurrentSource();

    public Iterable<FeedSource> method();

    public List<FeedSource> getAllFeeds();

}
