package com.propero.feedService.service;

import org.junit.Rule;
import org.springframework.restdocs.RestDocumentation;

/**
 * Created by farid on 01/12/15.
 */
public class BaseTest {

    @Rule
    public final RestDocumentation restDocumentation = new RestDocumentation("target/generated-snippets/");

}
