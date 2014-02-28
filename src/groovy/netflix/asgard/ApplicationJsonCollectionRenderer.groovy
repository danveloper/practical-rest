/*
 * Copyright 2014 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package netflix.asgard

import grails.converters.JSON
import grails.rest.render.RenderContext
import grails.rest.render.json.JsonCollectionRenderer
import org.codehaus.groovy.grails.web.mime.MimeType


/**
 * Created by danw on 2/27/14.
 */
class ApplicationJsonCollectionRenderer extends JsonCollectionRenderer {

    ApplicationJsonCollectionRenderer() {
        super(Application, new MimeType("application/netflix.asgard.mobile.applications+json"))
    }

    void render(Object obj, RenderContext ctx) {
        Collection<Application> apps = (Collection<Application>) obj
        super.render apps.collect {
            [name: it.name,
                    description: it.description,
                    asgCount: it.autoScalingGroups?.size() ?: 0,
                    healthy: it.healthy,
                    instanceCount: it.autoScalingGroups?.machineInstances?.size() ?: 0] }, ctx
    }

    void renderJson(JSON converter, RenderContext ctx) {
        converter.prettyPrint = true
        super.renderJson converter, ctx
    }
}
