package netflix.asgard
import grails.rest.RestfulController

class ApplicationController extends RestfulController {

    ApplicationController() {
        super(Application)
    }

    protected Application queryForResource(Serializable name) {
        Application.findByName(name as String)
    }
}
