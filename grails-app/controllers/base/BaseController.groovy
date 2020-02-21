package boilerplate.controller.base

import boilerplate.dto.base.BaseResponseDTO
import boilerplate.utils.GsonBuilderUtils
import groovy.json.JsonOutput
import org.springframework.http.HttpStatus

class BaseController {
    
    protected buildDtoFromJson(def requestJson, def toDto) {
        return GsonBuilderUtils.buildClassFromJson(JsonOutput.toJson(requestJson), toDto)
    }

    protected Object buildResponse(def entity) {
        return buildResponse(entity, new BaseResponseDTO())
    }

    protected Object buildResponse(def entity, def responseDto) {
        if (entity.hasErrors()) {
            response.status = HttpStatus.BAD_REQUEST.value()
            responseDto.errorMessage = entity.errors.allErrors[0].defaultMessage ?: message(code: entity.errors.allErrors[0].codes[0])
        } else {
            responseDto.id = entity?.publicId
            response.status = HttpStatus.OK.value()
        }
        return responseDto
    }
}