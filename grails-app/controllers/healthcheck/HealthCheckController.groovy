package boilerplate.controller.healthcheck

import boilerplate.log.BoilerLogger
import boilerplate.repository.place.PlaceRepository

import org.springframework.http.HttpStatus

class HealthCheckController {

    def index() {
        try {
            PlaceRepository.query([exists: true]).get()
            render("OK")
        } catch (Exception exception) {
            BoilerLogger.error("HealthCheckController -> Erro ao checar disponibilidade do sistema", exception)
            response.status = HttpStatus.SERVICE_UNAVAILABLE.value()
        }
    }
}