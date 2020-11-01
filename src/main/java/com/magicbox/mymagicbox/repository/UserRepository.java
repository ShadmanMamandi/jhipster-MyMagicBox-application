package com.magicbox.mymagicbox.repository;

import com.magicbox.mymagicbox.domain.User;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.neo4j.springframework.data.repository.Neo4jRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * Spring Data Neo4j RX repository for the {@link User} entity.
 */
@Repository
public interface UserRepository extends Neo4jRepository<User, String> {
    Optional<User> findOneByActivationKey(String activationKey);

    List<User> findAllByActivatedIsFalseAndActivationKeyIsNotNullAndCreatedDateBefore(Instant dateTime);

    Optional<User> findOneByResetKey(String resetKey);

    Optional<User> findOneByEmailIgnoreCase(String email);

    Optional<User> findOneByLogin(String login);

    // See https://github.com/neo4j/sdn-rx/issues/51
    List<User> findAll();

    Page<User> findAllByLoginNot(Pageable pageable, String login);
}
