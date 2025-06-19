package infra.adapters.outbound;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardJpaRepository extends JpaRepository<CardEntity, Long> {

}
