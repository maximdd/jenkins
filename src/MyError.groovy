import hudson.AbortException

//https://nexus.mwnts.net/service/rest/v1/search?repository=apt-oai&name=x11proto-xf86vidmode-dev

class MyError {

    public final script

    MyError(script) {
        this.script = script
    }

    public void doErrorExit() {
        //throw new AbortException("My own [ERROR]")

    }
}