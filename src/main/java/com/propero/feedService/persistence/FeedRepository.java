package com.propero.feedService.persistence;

import com.propero.feedService.domain.FeedSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<FeedSource, Long> {

}