package dev.james.contentcalendarapi.model;

import java.time.LocalDateTime;

public record Content(
    Integer id,
    String title,
    String desc,
    Status status,
    Type contentType,
    LocalDateTime dateCreated,
    LocalDateTime dateModified,
    String url

) {

}


