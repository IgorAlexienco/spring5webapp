package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.controllers.BookController;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookController bookController;

    private MockMvc mockMvc;

//    @Before("")
//    public void setup() {
//        //MockitoAnnotations.initMocks(this);
//        MockitoAnnotations.openMocks(this);  //.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
//    }

    @Test
    public void testBookList() throws Exception {
        //https://stackoverflow.com/questions/45486001/unit-test-a-interface-implementation-with-mock-in-spring-boot
        MockitoAnnotations.openMocks(this);  //.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

        List<Book> books= new ArrayList<>();
        books.add(new Book());
        books.add(new Book());

        when(bookRepository.findAll()).thenReturn((List)books);
        //when(true).thenReturn((List<Book>)books);

        mockMvc.perform(get("/books/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("books/list"))
                .andExpect(model().attribute("books", hasSize(2)));
        System.out.println("...  end test book list ...");
    }


//    @Test
//    public void testBookList() throws Exception {
//        MockitoAnnotations.openMocks(this);  //.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
//
//        List<Book> books= new ArrayList<>();
//        books.add(new Book());
//        books.add(new Book());
//
//        when(bookRepository.findAll()).thenReturn((List)books);
//        //when(true).thenReturn((List<Book>)books);
//
//        mockMvc.perform(get("/books/list"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("books/list"))
//                .andExpect(model().attribute("books", hasSize(2)));
//        System.out.println("...  end test book list ...");
//    }

}
