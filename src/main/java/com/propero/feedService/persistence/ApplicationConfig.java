package com.propero.feedService.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

/*
You can easily populate your repositories by using the populator elements
of the repository namespace provided in Spring Data Commons.
*/
@Configuration
@EnableJpaAuditing
@EnableJpaRepositories
class PersistenceConfig {

  @Bean
  public AuditorAware<String> auditorProvider() {
    return new AuditorAware<String>() {
      @Override
      public String getCurrentAuditor() {
        return "farid";
      }
    };

  }

  @Bean
  public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {


    Resource sourceData = new ClassPathResource("test-data.json");

    Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
      factory.setResources(new Resource[]{sourceData});
    return factory;
  }

}