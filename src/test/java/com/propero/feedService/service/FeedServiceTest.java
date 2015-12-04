package com.propero.feedService.service;

/**
 * Created by farid on 26/11/15.
 */

import com.propero.feedService.FeedServiceApplication;
import com.propero.feedService.domain.FeedSource;
import com.propero.feedService.enums.FeedId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FeedServiceApplication.class)
@WebAppConfiguration
public class FeedServiceTest {


    @Autowired
    private FeedService feedService;

    @Test
    public void testQueryDsl(){
        Iterable<FeedSource> method = feedService.method();
        method.forEach(System.out::println);
    }

    @Test
    public void testGetAllFeeds(){

    }

    @Test
    public void testGetCurrentSource(){
        feedService.switchFeedSource(FeedId.MyFeed1);
        List<FeedSource> allFeeds = feedService.getAllFeeds();
        allFeeds.stream().forEach(System.out::println);
        Optional<FeedSource> feedSource = feedService.getFeedSource();
        Assert.assertTrue(feedSource.isPresent());
        Assert.assertEquals(FeedId.MyFeed1,feedSource.get().getFeedId());

    }


}
