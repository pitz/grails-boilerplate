package boilerplate.controller.place

import boilerplate.controller.base.BaseController
import boilerplate.domain.place.Place
import boilerplate.dto.place.list.ListPlaceDTO
import boilerplate.dto.place.list.ListPlaceResponseDTO
import boilerplate.dto.place.save.SavePlaceDTO
import boilerplate.dto.place.show.ShowPlaceResponseDTO
import boilerplate.repository.place.PlaceRepository
import boilerplate.services.place.PlaceService

import grails.converters.JSON

class PlaceController extends BaseController {

    PlaceService placeService

    def save() {
        SavePlaceDTO savePlaceDto = buildDtoFromJson(request.JSON, SavePlaceDTO)
        Place place = placeService.save(savePlaceDto.properties)
        render(buildResponse(place) as JSON)
    }
    
    def get() {
        Place place = PlaceRepository.get(params.id)

        ShowPlaceResponseDTO placeResponseDTO
        if (place) placeResponseDTO = new ShowPlaceResponseDTO(place)
        render(placeResponseDTO as JSON)
    }

    def delete() {
        Place place = placeService.delete(params.id)
        render(buildResponse(place) as JSON)
    }

    def list() {
        ListPlaceDTO requestDto = buildDtoFromJson(request.JSON, ListPlaceDTO)
        List<Place> placeList = placeService.list(requestDto.toMap())

        ListPlaceResponseDTO placeListResponseDto = new ListPlaceResponseDTO(placeList)
        render(placeListResponseDto as JSON)
    }
}