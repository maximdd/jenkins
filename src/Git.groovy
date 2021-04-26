class Git {

    public final script

    Git(script) {
        this.script = script
    }

    public void printHash() {
        def proc = "ls".execute()
		def b = new StringBuffer()
		proc.consumeProcessErrorStream(b)
		println proc.text
		println b.toString()
    }
}