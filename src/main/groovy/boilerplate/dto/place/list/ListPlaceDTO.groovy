package boilerplate.dto.place.list

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ListPlaceDTO {

    String name

    String city

    String state

    Integer offset

    Integer max

    public toMap() {
        Map listPlaceMap = [:]

        if (this.name) listPlaceMap.name = name
        if (this.city) listPlaceMap.city = city
        if (this.state) listPlaceMap.state = state
        if (this.offset) listPlaceMap.offset = offset
        if (this.max) listPlaceMap.max = max

        return listPlaceMap
    }

}