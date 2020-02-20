package boilerplate.utils

import boilerplate.utils.MessageUtils

import org.apache.commons.lang.RandomStringUtils
import org.springframework.validation.Errors
import org.springframework.validation.ObjectError

class DomainUtils {

    public static Object addError(Object entity, String message) {
        entity.errors.reject("", null, message)
        return entity
    }

}