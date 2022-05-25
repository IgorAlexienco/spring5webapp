package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
       this.authorRepository =  authorRepository;
       this.bookRepository = bookRepository;
       this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("... Boot strap data ...");

        Author eric = new Author("Eric", "Evans");
        Book bbb= new Book("Domain Driven Design","123123");

        Publisher publisher= new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setAddressLine1("Market Street");
        publisher.setCity("St Petersburg");
        publisher.setZip("SL8RU3");

        eric.getBooks().add(bbb);
        bbb.getAuthors().add(eric);
        //bbb.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(bbb);

        Author rod = new Author("Rod", "Johnson");
        Book bbEJB= new Book("J2EE development without EJB","213214");
        rod.getBooks().add(bbEJB);
        bbEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(bbEJB);

        bbb.setPublisher(publisher);
        bbEJB.setPublisher(publisher);

        publisher.getBooks().add(bbb);
        publisher.getBooks().add(bbEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Number of Authors:" + authorRepository.count());

        System.out.println("Publisher Num books published:" + publisher.getBooks().size());
        System.out.println("Number of Publishers:" + publisherRepository.count());
    }

}
