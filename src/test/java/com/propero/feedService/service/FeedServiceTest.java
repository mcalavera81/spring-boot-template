package com.propero.feedService.service;

/**
 * Created by farid on 26/11/15.
 */

import com.propero.feedService.FeedServiceApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FeedServiceApplication.class)
public class FeedServiceTest {


    @Autowired
    private FeedService feedService;

    @Test
    public void feedServiceTest(){

        Assert.assertEquals("CurrentSource",feedService.getCurrentSource());

    }

}
