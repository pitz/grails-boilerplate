package boilerplate.controller.interceptor

import grails.compiler.GrailsCompileStatic
import org.springframework.http.HttpStatus

@GrailsCompileStatic
class BoilerPlateInterceptor {
    BoilerPlateInterceptor() {
        match(uri: "/**")
    }

    boolean before() {
        if (request.getHeader("Access-Token") != grailsApplication.config.getProperty('api.accessToken')) {
            response.status = HttpStatus.UNAUTHORIZED.value()
            return false
        }

        return true
    }

    boolean after()  { return true }
    void afterView() { }
}