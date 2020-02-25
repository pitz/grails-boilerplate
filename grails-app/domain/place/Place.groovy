package boilerplate.domain.place

import boilerplate.base.BaseEntity

class Place extends BaseEntity {

    String publicId

    String name

    String city

    String state

    public Place(String name, String city, String state) {
        this.name = name
        this.city = city
        this.state = state
        this.publicId = UUID.randomUUID().toString()
    }
}