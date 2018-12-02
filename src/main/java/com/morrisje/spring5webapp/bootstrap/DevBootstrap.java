package com.morrisje.spring5webapp.bootstrap;

import com.morrisje.spring5webapp.model.Author;
import com.morrisje.spring5webapp.model.Book;
import com.morrisje.spring5webapp.repositories.AuthorRepository;
import com.morrisje.spring5webapp.repositories.BookRepsoitory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepsoitory bookRepsoitory;

    public DevBootstrap(AuthorRepository authorRepository, BookRepsoitory bookRepsoitory) {
        this.authorRepository = authorRepository;
        this.bookRepsoitory = bookRepsoitory;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {


        //Laura
        Author laura = new Author("Laura", "Lemay");
        Book javaIn21Days = new Book("Teach Yourself Java in 21 Days", "1575210204", "SAMS Publishing");
        laura.getBooks().add(javaIn21Days);
        javaIn21Days.getAuthors().add(laura);
        authorRepository.save(laura);
        bookRepsoitory.save(javaIn21Days);


        Author kathy = new Author("Kathy", "Sierra");
        Book headFirstJava = new Book("Head First Java", "123456", "OReilly");
        kathy.getBooks().add(headFirstJava);
        headFirstJava.getAuthors().add(kathy);
        authorRepository.save(kathy);
        bookRepsoitory.save(headFirstJava);
    }
}
