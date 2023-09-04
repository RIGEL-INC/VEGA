package vega.com.main.repositories.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import vega.com.main.models.common.AbstractEntity;

@NoRepositoryBean
public interface CommonRepository<E extends AbstractEntity> extends JpaRepository<E,Integer> {
}
