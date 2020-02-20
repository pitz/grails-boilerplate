package boilerplate.controller.base

import boilerplate.utils.GsonBuilderUtils
import com.google.gson.GsonBuilder

import grails.converters.JSON
import grails.validation.ValidationException
import groovy.json.JsonOutput
import org.springframework.http.HttpStatus

class BaseController {
    
    protected buildDtoFromJson(def requestJson, def toDto) {
        return GsonBuilderUtils.buildClassFromJson(JsonOutput.toJson(requestJson), toDto)
    }


    protected buildResponse(def entity, def responseDto) {
        return responseBuilder(entity, responseDto)
    }

    private responseBuilder(def entity, def responseDto) {
        responseDto.success = !Boolean.valueOf(entity.hasErrors())

        if (responseDto.success) {
            response.status = HttpStatus.OK.value()
        } else {
            response.status = HttpStatus.BAD_REQUEST.value()
            responseDto.errorMessage = entity.errors.allErrors[0].defaultMessage ?: message(code: entity.errors.allErrors[0].codes[0])
        }

        return responseDto
    }
}