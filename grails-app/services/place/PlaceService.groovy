package boilerplate.services.place

import boilerplate.domain.place.Place
import boilerplate.repository.place.PlaceRepository
import boilerplate.utils.DomainUtils
import boilerplate.utils.MessageUtils

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@GrailsCompileStatic
class PlaceService {

    public Place save(Map fields) {
        println " @save "

        Place validatedPlace = validateSave(fields)
        if (validatedPlace.hasErrors()) return validatedPlace

        Place place = new Place(fields.name.toString(), fields.city.toString(), fields.state.toString())
        place.save(failOnError: true)
        return place
    }

    private Place validateSave(Map fields) {
        Place validatePlace = new Place(fields.name.toString(), fields.city.toString(), fields.state.toString())

        if (!validatePlace.name)  DomainUtils.addError(validatePlace, MessageUtils.getMessage("boilerplate.domain.place.name.notNull"))
        if (!validatePlace.city)  DomainUtils.addError(validatePlace, MessageUtils.getMessage("boilerplate.domain.place.city.notNull"))
        if (!validatePlace.state) DomainUtils.addError(validatePlace, MessageUtils.getMessage("boilerplate.domain.place.state.notNull"))

        return validatePlace
    }

    public Place delete(String publicId) {
        Place place = PlaceRepository.get(publicId)

        if (!place) return null
        if (place.deleted) {
            DomainUtils.addError(place, MessageUtils.getMessage("boilerplate.domain.place.alreadyDeleted"))
            return place
        }
        
        place.deleted = true
        place.save(failOnError: true)
        return place
    }

    public List<Place> list(Map params) {
        List<Place> placeList = PlaceRepository.query(params).list(offset: params.offset ?: 0, max: params.max ?: 10)
        return placeList
    }
}