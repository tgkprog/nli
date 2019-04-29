stackoverflow link : https://stackoverflow.com/questions/55888136/how-to-run-vb-exe-file-from-java-server-side-with-parameters

the current status:
when I am running: 
ProcessBuilder pb=new ProcessBuilder("cmd.exe", "/C", ".\\run.cmd"); - no error and nothing happens(attached run.cmd)
ProcessBuilder pb=new ProcessBuilder(command); - no error and nothing happens(attached run.cmd)
ProcessBuilder pb=new ProcessBuilder(fullcmd1); - error message appears:

java.io.IOException: Cannot run program "C:\AL500\BIAFLABEL\AddToQueue.exe C:\AL500\BiafLabel\Templates\2.xml -printer \\mickaelbpc\System-N": CreateProcess error=2, The system cannot find the file specified
	at java.lang.ProcessBuilder.start(ProcessBuilder.java:1048)
	at org.nli.ws.services.tryMain.main(tryMain.java:25)
Caused by: java.io.IOException: CreateProcess error=2, The system cannot find the file specified
	at java.lang.ProcessImpl.create(Native Method)
	at java.lang.ProcessImpl.<init>(ProcessImpl.java:386)
	at java.lang.ProcessImpl.start(ProcessImpl.java:137)
	at java.lang.ProcessBuilder.start(ProcessBuilder.java:1029)
	... 1 more
