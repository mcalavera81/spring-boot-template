package com.propero.feedService.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

/*
You can easily populate your repositories by using the populator elements
of the repository namespace provided in Spring Data Commons.
*/
@Configuration
class PersistenceConfig {


  @Bean
  public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {

    Resource sourceData = new ClassPathResource("test-data.json");

    Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
      factory.setResources(new Resource[]{sourceData});
    return factory;
  }
}