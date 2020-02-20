package boilerplate.dto.place.show

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ShowPlaceResponseDTO {

    Long id

    String name

    String city

    String state

    Date lastUpdated

    Date dateCreated
    
    Boolean deleted 

}