package practical

import grails.rest.RestfulController
import netflix.asgard.Application

class ApplicationController extends RestfulController {

    def applicationService

    ApplicationController() {
        super(Application)
    }

    protected Map getParametersToBind() {
        if (params.hasProperty("healthy"))
            params.remove "healthy"
        params
    }

    protected List<Application> listAllResources(Map params) {
        applicationService.getAllHealthyApplications()
    }

    protected Application queryForResource(Serializable id) {
        applicationService.getHealthyApplication(id as Long)
    }
}
