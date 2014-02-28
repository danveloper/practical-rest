import netflix.asgard.ApplicationCustomHalJsonRenderer
import netflix.asgard.ApplicationJsonCollectionRenderer
import netflix.asgard.ApplicationJsonRenderer


beans = {
    //applicationRenderer(HalJsonRenderer, Application, MimeType.JSON)
    //autoScalingGroupRenderer(HalJsonRenderer, AutoScalingGroup, MimeType.JSON)

    //applicationJsonRenderer(ApplicationJsonRenderer)
    //applicationJsonCollectionRenderer(ApplicationJsonCollectionRenderer)

    applicationCustomHal(ApplicationCustomHalJsonRenderer)
}
