import grails.rest.render.hal.HalJsonRenderer
import netflix.asgard.Application
import netflix.asgard.ApplicationJsonCollectionRenderer
import netflix.asgard.ApplicationJsonRenderer
import netflix.asgard.AutoScalingGroup
import org.codehaus.groovy.grails.web.mime.MimeType


beans = {
    //applicationRenderer(HalJsonRenderer, Application, MimeType.JSON)
    //autoScalingGroupRenderer(HalJsonRenderer, AutoScalingGroup, MimeType.JSON)

    applicationJsonRenderer(ApplicationJsonRenderer)
    applicationJsonCollectionRenderer(ApplicationJsonCollectionRenderer)
}
