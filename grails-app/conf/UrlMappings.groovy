class UrlMappings {

	static mappings = {
        group "/rest", {
            "/autoScalingGroups"(resources: "autoScalingGroup")
            "/machineInstances"(resources: "machineInstances")
            "/machineImages"(resources: "machineImage")
            "/applications"(resources: "application") {
                "/autoScalingGroups"(resources: "autoScalingGroup") {
                    "/machineInstances"(resources: "machineInstance")
                }
            }
        }

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
