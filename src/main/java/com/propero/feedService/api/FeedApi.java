package com.propero.feedService.api;

import com.propero.feedService.domain.FeedData;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by farid on 26/11/15.
 */

@Controller
@RequestMapping("/api/feedSource")
public class FeedApi {



    @RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody FeedData getFeedSource(){

        return new FeedData("190.1", "10/10/10 10:10:22","EURUSD");

    }

}
