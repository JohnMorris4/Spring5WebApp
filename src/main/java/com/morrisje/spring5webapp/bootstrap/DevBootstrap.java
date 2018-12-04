package com.morrisje.spring5webapp.bootstrap;

import com.morrisje.spring5webapp.model.Author;
import com.morrisje.spring5webapp.model.Book;
import com.morrisje.spring5webapp.model.Publisher;
import com.morrisje.spring5webapp.repositories.AuthorRepository;
import com.morrisje.spring5webapp.repositories.BookRepsoitory;
import com.morrisje.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepsoitory bookRepsoitory;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepsoitory bookRepsoitory, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepsoitory = bookRepsoitory;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //New Publisher
        Publisher sams = new Publisher();
        sams.setName("SAMS");
        sams.setAddress("125 12th Ave, NY NY");
        publisherRepository.save(sams);

        Publisher oracle = new Publisher();
        oracle.setName("Oracle");
        oracle.setAddress("500 Oracle Parkway Redwood Shores, CA");
        publisherRepository.save(oracle);

        //Laura
        Author laura = new Author("Laura", "Lemay");
        Book javaIn21Days = new Book("Teach Yourself Java in 21 Days", "1575210204", sams);
        laura.getBooks().add(javaIn21Days);
        javaIn21Days.getAuthors().add(laura);
        authorRepository.save(laura);
        bookRepsoitory.save(javaIn21Days);


        Author kathy = new Author("Kathy", "Sierra");
        Book headFirstJava = new Book("Head First Java", "123456", oracle);
        kathy.getBooks().add(headFirstJava);
        headFirstJava.getAuthors().add(kathy);
        authorRepository.save(kathy);
        bookRepsoitory.save(headFirstJava);
    }
}
