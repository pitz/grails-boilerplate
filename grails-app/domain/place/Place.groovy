package boilerplate.domain.place

import boilerplate.base.BaseEntity
import boilerplate.dto.place.save.SavePlaceDTO

class Place extends BaseEntity {

    String name

    String city

    String state

    public Place(SavePlaceDTO placeDto) {
        this.name = placeDto.name
        this.city = placeDto.city
        this.state = placeDto.state
    }
}