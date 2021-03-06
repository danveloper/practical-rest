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

/**
 * Created by danw on 2/27/14.
 */
class MachineService {

    void defaultDeploy(Long applicationId) {
        def application = Application.get(applicationId)
        def asg = application.autoScalingGroups.first()
        def machineImage = MachineImage.first()
        def machineInstance =
                new MachineInstance(
                        name: "$application.name-$machineImage.name-v0001",
                        autoScalingGroup: asg, image: machineImage).save(flush: true)
    }
}
