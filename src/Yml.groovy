import hudson.model.*

class Yml {

    public final context

    Yml(context) {
        this.context = context
    }

    public String readFileYml(String variable) {
        //File file = new File("/var/jenkins_home/workspace/OAI_master@libs/jenkins/resources/bamboo.yml")
        //def datas = context.readYaml text: file.text
        //readYaml()
        //def datas = context.readYaml text: file.text

       // context.sh 'ls -la ${WORKSPACE}'
        def datas = context.readFile "${context.env.WORKSPACE}/bamboo.yml"
        def ymlMap = context.readYaml text: datas
        return ymlMap[0].version
        //return context.test
        //eturn "str"
    }
}
