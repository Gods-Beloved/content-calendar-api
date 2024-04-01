package dev.james.contentcalendarapi.controller;

import dev.james.contentcalendarapi.model.Content;
import dev.james.contentcalendarapi.repository.ContentCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/content/")
@CrossOrigin()
public class ContentController {


    private final ContentCollectionRepository repository;



    @Autowired()
    public ContentController(ContentCollectionRepository contentCollectionRepository) {
        this.repository = contentCollectionRepository;
    }

    @GetMapping("/")
    public List<Content> findAll( ){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content getContentById(
            @PathVariable(value="id")
            Integer id
    ) {
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Content Not Found"));

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
   public void createContent(
           @RequestBody
           Content content
    ) {

        repository.save(content);

   }

   @PutMapping("{id}")
   public void updateContent(
           @RequestBody
           Content content,
           @PathVariable
           Integer id
   ){

        if(!repository.existById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content Not Found");
        }

        repository.save(content);

   }



}
