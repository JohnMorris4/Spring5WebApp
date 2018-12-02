package com.morrisje.spring5webapp.repositories;

import com.morrisje.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepsoitory extends CrudRepository<Book, Long> {

}
