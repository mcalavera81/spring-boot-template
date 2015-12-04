package com.propero.feedService.domain;

import com.propero.feedService.enums.FeedId;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by farid on 26/11/15.
 */
@Entity
@ToString(callSuper = true)
public class FeedSource extends BaseEntity{


    public FeedSource() {}

    public FeedSource(FeedId feedId) {
        this.feedId = feedId;
    }

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    @Enumerated(EnumType.STRING)
    private FeedId feedId;


    public FeedId getFeedId() {
        return feedId;
    }

    public void setFeedId(FeedId feedId) {
        this.feedId = feedId;
    }


}
