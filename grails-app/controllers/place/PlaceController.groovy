package boilerplate.controller.place

import boilerplate.controller.base.BaseController
import boilerplate.domain.place.Place
import boilerplate.dto.place.save.SavePlaceDTO
import boilerplate.services.place.PlaceService
import grails.converters.JSON

class PlaceController extends BaseController {

    PlaceService placeService

    def save() {
        SavePlaceDTO placeDTO = buildDtoFromJson(request.JSON, SavePlaceDTO)
        Place place = placeService.save(placeDTO)
        render(place as JSON)
    }
    
    def get() {
        Place place = placeService.get(params.long("id"))
        render(place as JSON)
    }

    def delete() {
        Place place = placeService.delete(params.long("id"))
        render(place as JSON)
    }
}