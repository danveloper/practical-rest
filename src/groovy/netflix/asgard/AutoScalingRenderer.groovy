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

import grails.plugin.restrenderers.AbstractObjectRenderer
import grails.rest.render.RenderContext
import groovyx.gpars.GParsPool


/**
 * Created by danw on 2/27/14.
 */
class AutoScalingRenderer extends AbstractObjectRenderer<AutoScalingGroup> {

    @Override
    Class<AutoScalingGroup> getTargetType() {
        AutoScalingGroup
    }

    def json(AutoScalingGroup obj, RenderContext ctx) {
        def model = getModel(obj)
        write getJsonConverter(model).toString(), ctx
    }

    def json(Collection<AutoScalingGroup> objs, RenderContext ctx) {
        def models = GParsPool.withPool {
            objs.collectParallel { AutoScalingGroup instance ->
                getModel instance
            }
        }
        write getJsonConverter(models).toString(), ctx
    }

    private static Map getModel(AutoScalingGroup instance) {
        [
                id: instance.name
        ]
    }
}