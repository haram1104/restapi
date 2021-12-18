package me.haram.demoinflearnrestapi.common;

import me.haram.demoinflearnrestapi.index.IndexController;
import org.springframework.hateoas.EntityModel;
import org.springframework.validation.Errors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class ErrorsResource extends EntityModel<Errors> {

    public ErrorsResource(Errors content) {
        super(content);
        add(linkTo(methodOn(IndexController.class).index()).withRel("index"));
    }
}
