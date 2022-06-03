package guru.springframework.spring5webapp.controllers;


import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController {

    public final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository){
        this.publisherRepository= publisherRepository;
    }

    @RequestMapping("/publishers")
    public String getPublishers(Model publisher){
        publisher.addAttribute("publishers", publisherRepository.findAll());
        return "publishers/list";
    }

}
