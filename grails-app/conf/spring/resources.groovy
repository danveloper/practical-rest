import grails.rest.render.hal.HalJsonRenderer
import netflix.asgard.Application
import netflix.asgard.ApplicationJsonCollectionRenderer
import netflix.asgard.ApplicationJsonRenderer
import netflix.asgard.AutoScalingGroup
import netflix.asgard.machine.MachineCreationResponse
import org.codehaus.groovy.grails.web.mime.MimeType
import org.grails.plugins.web.rest.render.json.DefaultJsonRenderer


beans = {
    //applicationRenderer(HalJsonRenderer, Application, MimeType.JSON)
    //autoScalingGroupRenderer(HalJsonRenderer, AutoScalingGroup, MimeType.JSON)

    applicationJsonRenderer(ApplicationJsonRenderer)
    applicationJsonCollectionRenderer(ApplicationJsonCollectionRenderer)

    machineCreationRenderer(DefaultJsonRenderer, MachineCreationResponse)
}
