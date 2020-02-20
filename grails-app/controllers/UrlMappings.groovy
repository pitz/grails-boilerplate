package boilerplate

class UrlMappings {

    static mappings = {

        "/healthcheck" {
            controller = "healthCheck"
            action = [GET:"index", POST:"index"]
            format = "json"
        }

        "/place" {
            controller = "place"
            action = [POST: "save", DELETE: "delete", GET: "get"]
            format = "json"
        }

        "500" {
            controller = "error"
            action = "notFound"
            format = "json"
        }

        "404" {
            controller = "error"
            action = "internalServerError"
            format = "json"
        }
    }
}
