package boilerplate.repository.place

import boilerplate.domain.place.Place
import grails.compiler.GrailsCompileStatic
import grails.gorm.DetachedCriteria

@GrailsCompileStatic
class PlaceRepository {

    public static DetachedCriteria<Place> query(Map search) {
        DetachedCriteria<Place> query = Place.where {

            if (search.containsKey("column")) {    
                projections {
                    property "${search.column}" 
                }
            }

            if (!Boolean.valueOf(search.includeDeleted)) {
                eq("deleted", false)
            }

            if (search.containsKey("id")) {
                eq("id", search.id)
            }

            if (search.containsKey("name")) {
                eq("name", search.name)
            }

            if (search.containsKey("city")) {
                eq("city", search.city)
            }

            if (search.containsKey("state")) {
                eq("state", search.state)
            }

            if (search.containsKey("publicId")) {
                eq("publicId", search.publicId)
            }

            if (search.containsKey("exists")) {
                projections {
                    property "id"
                }
            } else {
                order(search.sort ?: "id", search.order ?: "desc")
            }
        }

        return query
    }

    public static Place get(String publicId) {
        return PlaceRepository.query([publicId: publicId]).get()
    }
}