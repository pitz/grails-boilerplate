package boilerplate

class UrlMappings {

    static mappings = {

        "/healthcheck" {
            controller = "healthCheck"
            action = [GET:"index", POST:"index"]
            format = "json"
        }

        "/places/$id?" {
            controller = "place"
            action = [POST: "save", DELETE: "delete", GET: "get"]
            format = "json"
        }

        "/places/list" {
            controller = "place"
            action = [POST: "list"]
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
