package com.propero.feedService.service.documentation;

import com.propero.feedService.FeedServiceApplication;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by farid on 30/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FeedServiceApplication.class)
@WebAppConfiguration
public class FeedApiDocumentation {

    @Autowired
    private WebApplicationContext webContext;

    private MockMvc mockMvc;

    @Rule
    public final RestDocumentation restDocumentation = new RestDocumentation("build/generated-snippets");

    @Before
    public void setupMockMvc() {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext)
                .apply(documentationConfiguration(this.restDocumentation))
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();

    }


    @Test
    public void homePage() throws Exception {
        mockMvc.perform(get("/api/feedSource")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType((MediaType.APPLICATION_JSON_UTF8)))
                .andExpect(jsonPath("$.price",is("190.1")))
                .andExpect(jsonPath("$.dateTime",is("10/10/10 10:10:22")))
                .andExpect(jsonPath("$.asset",is("EURUSD")));

    }

}
