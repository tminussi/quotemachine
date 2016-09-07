package br.com.bytecraft.repository;

import br.com.bytecraft.model.Quote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by thales on 06/09/16.
 */
@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {
}
