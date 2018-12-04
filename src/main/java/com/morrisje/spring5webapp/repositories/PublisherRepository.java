package com.morrisje.spring5webapp.repositories;

import com.morrisje.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jmorris on 12/4/18
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
