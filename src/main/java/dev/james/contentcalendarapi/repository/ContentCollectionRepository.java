package dev.james.contentcalendarapi.repository;

import dev.james.contentcalendarapi.model.Content;
import dev.james.contentcalendarapi.model.Status;
import dev.james.contentcalendarapi.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<Content>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return content;
    }

    public Optional<Content> findById(Integer id){
        return content.stream().filter(content -> content.id().equals(id)).findFirst();
    }

    public void save(Content content1) {


               content.add(content1);

    }

    @PostConstruct()
    public void init(){

        Content content1 = new Content(1,
                "April 2014","Content table for april",
                Status.IDEA,Type.ARTICLE, LocalDateTime.now(),
                null,
                "");

        content.add(content1);



    }

    public boolean existById(Integer id) {
        return content.stream().filter(content -> content.id().equals(id)).count() == 1;
    }
}
