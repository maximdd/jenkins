import hudson.AbortException

class SonarQube {

    public final script

    SonarQube(script) {
        this.script = script
    }

    public void doAnalyzing() {
        this.script.sh 'echo SonarQube!'
    }
}