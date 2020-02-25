package boilerplate.dto.place.list

import boilerplate.domain.place.Place
import boilerplate.dto.place.show.ShowPlaceResponseDTO
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ListPlaceResponseDTO {

    List<ShowPlaceResponseDTO> places = []
    
    public ListPlaceResponseDTO(List<Place> placeList) {
        for (Place place : placeList) {
            places.add(new ShowPlaceResponseDTO(place))
        }
    }
}