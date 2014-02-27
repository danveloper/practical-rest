import java.text.SimpleDateFormat
import netflix.asgard.Application
import netflix.asgard.AutoScalingGroup
import netflix.asgard.MachineImage
import netflix.asgard.MachineInstance

class BootStrap {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    final  appNames = ['abcassandra', 'abtest', 'edge-api', 'mimir', 'account', 'eureka', 'atlas', 'backend']

    def init = { servletContext ->
        def amiLastUpdated = simpleDateFormat.parse("2013-01-31 12:31:23")
        def ami = new MachineImage(
                name: "aws-centos",
                environment: "prod",
                lastUpdated: amiLastUpdated,
                region: "us-east-1d").save(flush: true, failOnError: true)

        appNames.each { appName ->
            def application = new Application(
                    name: appName,
                    description: "$appName Test Server",
                    healthy: true).save(flush: true, failOnError: true)

            (1..9)[new Random().nextInt(9)].times { n ->
                def asg = new AutoScalingGroup(name: "$appName-useast-$n", application: application)
                        .save(flush: true, failOnError: true)
                (1..100)[new Random().nextInt(99)].times {
                    makeMachine ami, asg
                }
            }

        }
    }

    def makeMachine(MachineImage image, AutoScalingGroup asg) {
        def name = "ami-"
        8.times {
            name += (('a'..'z')+(0..9))[new Random().nextInt(35)]
        }
        new MachineInstance(name: name, image: image, autoScalingGroup: asg).save(flush: true, failOnError: true)
    }

    def destroy = {
    }
}
