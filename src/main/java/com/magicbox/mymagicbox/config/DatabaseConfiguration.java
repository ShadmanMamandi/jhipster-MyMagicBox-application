package com.magicbox.mymagicbox.config;

import io.github.jhipster.config.JHipsterConstants;
import org.neo4j.springframework.data.repository.config.EnableNeo4jRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableNeo4jRepositories("com.magicbox.mymagicbox.repository")
public class DatabaseConfiguration {
    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);
}
