package boilerplate.error

import org.springframework.http.HttpStatus

class ErrorController {

    def notFound() {
        response.status = HttpStatus.NOT_FOUND.value()
    }

    def internalServerError() {
        response.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
    }

}