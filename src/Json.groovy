import hudson.model.*
import groovy.json.JsonSlurper

class Json {

    public final context

    Json(context) {
        this.context = context
    }

    public String doprintJson(String variable) {
        def response = this.context.httpRequest 'https://nexus.mwnts.net/service/rest/v1/search?repository=apt-oai&name=x11proto-xf86vidmode-dev'
        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parseText(response.content)
        return object.items.version
    }
}