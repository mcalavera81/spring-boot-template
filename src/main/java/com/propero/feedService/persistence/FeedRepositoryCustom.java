package com.propero.feedService.persistence;

import com.propero.feedService.domain.FeedSource;

import java.util.Optional;

/**
 * Created by farid on 02/12/15.
 */
public interface FeedRepositoryCustom{

    Optional<FeedSource> getCurrentFeedSource();
}
