package com.magicbox.mymagicbox.repository;

import com.magicbox.mymagicbox.domain.PersistentToken;
import com.magicbox.mymagicbox.domain.User;
import java.time.LocalDate;
import java.util.List;
import org.neo4j.springframework.data.repository.Neo4jRepository;

public interface PersistentTokenRepository extends Neo4jRepository<PersistentToken, String> {
    List<PersistentToken> findByUser(User user);

    List<PersistentToken> findByTokenDateBefore(LocalDate localDate);
}
