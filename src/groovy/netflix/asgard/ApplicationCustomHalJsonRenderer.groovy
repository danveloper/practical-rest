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
import grails.rest.Link
import grails.rest.render.RenderContext
import org.codehaus.groovy.grails.web.mapping.LinkGenerator
import org.codehaus.groovy.grails.web.mime.MimeType
import org.grails.plugins.web.rest.render.json.DefaultJsonRenderer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod


/**
 * Created by danw on 2/27/14.
 */
class ApplicationCustomHalJsonRenderer extends DefaultJsonRenderer<Application> {

    @Autowired
    LinkGenerator linkGenerator

    ApplicationCustomHalJsonRenderer() {
        super(Application, MimeType.JSON)
    }

    @Override
    void render(Application app, RenderContext ctx) {
        def idProperty = app.class.getAnnotation(RestIdProperty).value()
        final entityHref = linkGenerator.link(resource: app, id: app."$idProperty",
                method: HttpMethod.GET.toString(), absolute: false)

        def link = new Link("self", entityHref)

        def model = [_links: link, name: app.name, description: app.description]
        super.render model, ctx
    }

    void renderJson(JSON converter, RenderContext ctx) {
        converter.prettyPrint = true
        super.renderJson converter, ctx
    }
}
