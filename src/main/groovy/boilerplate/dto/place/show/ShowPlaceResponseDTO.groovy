package boilerplate.dto.place.show

import boilerplate.domain.place.Place
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ShowPlaceResponseDTO {

    String id

    String name

    String city

    String state

    Date lastUpdated

    Date dateCreated
    
    public ShowPlaceResponseDTO(Place place) {
        this.id = place.publicId
        this.name = place.name
        this.city = place.city
        this.state = place.state
        this.lastUpdated = place.lastUpdated
        this.dateCreated = place.lastUpdated
    }
}