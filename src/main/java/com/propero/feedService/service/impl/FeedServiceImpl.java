package com.propero.feedService.service.impl;


import com.propero.feedService.persistence.FeedRepository;
import com.propero.feedService.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
