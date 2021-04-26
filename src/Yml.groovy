import hudson.model.*

class Yml {

    public final context

    Yml(context) {
        this.context = context
    }

    public String readFile(String variable) {
        File file = new File("/var/jenkins_home/workspace/OAI_master@libs/jenkins/resources/bamboo.yml")
        //def datas = context.readYaml text: file.text
        //readYaml()
        //def datas = context.readYaml text: file.text

        context.sh 'ls -la ${WORKSPACE}'
        def datas = readFile "${WORKSPACE}/bamboo.yml"

        //return datas[0].version
        //return context.test
        return 0
    }
}