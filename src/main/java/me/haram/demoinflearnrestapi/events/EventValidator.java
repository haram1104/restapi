package me.haram.demoinflearnrestapi.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component
public class EventValidator {

    public void validate(EventDto eventDto, Errors errors) {
        if(eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() > 0) {
            errors.rejectValue("basePrice", "wrongValue", "BasePrice is wrong.");
            errors.rejectValue("maxPrice", "wrongValue", "MaxPrice is wrong.");
        }

        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        LocalDateTime beginEventDateTime = eventDto.getBeginEventDateTime();
        LocalDateTime closeEnrollmentDateTime = eventDto.getCloseEnrollmentDateTime();
        LocalDateTime beginEnrollmentDateTime = eventDto.getBeginEnrollmentDateTime();
        if(endEventDateTime.isBefore(beginEventDateTime) ||
        endEventDateTime.isBefore(closeEnrollmentDateTime) ||
        endEventDateTime.isBefore(beginEnrollmentDateTime)) {
            errors.rejectValue("endEventDateTime", "wrongValue", "EndEventDateTime is wrong.");
        }

        // TODO beginEventDateTime
        if(endEventDateTime.isBefore(beginEventDateTime)) {
            errors.rejectValue("beginEventDateTime", "wrongValue", "BeginEventDateTime is wrong.");
        }
        // TODO CloseEnrollmentDateTime
        if(closeEnrollmentDateTime.isBefore(beginEnrollmentDateTime)) {
            errors.rejectValue("closeEnrollmentDateTime", "wrongValue", "CloseEnrollmentDateTime is wrong.");
        }
    }
}
