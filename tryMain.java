package org.nli.ws.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

public class tryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fullcmd = "\"C:\\AL500\\BIAFLABEL\\AddToQueue.exe\" \"C:\\AL500\\BiafLabel\\Templates\\2.xml\" -printer \\\\mickaelbpc\\System-N";
		String fullcmd1 = "C:\\AL500\\BIAFLABEL\\AddToQueue.exe C:\\AL500\\BiafLabel\\Templates\\2.xml -printer \\\\mickaelbpc\\System-N";
		String cmd1 = "C:\\AL500\\BIAFLABEL\\AddToQueue.exe";
		String cmd2 = "C:\\AL500\\BiafLabel\\Templates\\2.xml";
		String cmd3 = "-printer";
		String cmd4 = "\\\\mickaelbpc\\System-N";	
		String[] command = new String[]{cmd1, cmd2, cmd3,cmd4};
		try {
			File log = new File("log"); 
			ProcessBuilder pb=new ProcessBuilder("cmd.exe", "/C", ".\\run.cmd"/*command*/);
			pb.redirectErrorStream(true);
			pb.redirectOutput(Redirect.appendTo(log));
			Process process1=pb.start();
			BufferedReader inStreamReader = new BufferedReader(
			    new InputStreamReader(process1.getInputStream())); 
			 String line;
		        while (true) {
		            line = inStreamReader.readLine();
		            if (line == null) { break; }
		            System.out.println(line);
		        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        /*InputStream stderr = null;
        InputStream stdout = null;
        String strData = null;

        StringBuffer cm = new StringBuffer("");
        cm=cm.append(" \"").append("C:/AL500/BIAFLABEL/AddToQueue.exe").append("\"");
        String printer = new String("//mickaelbpc/System-N");
        printer = printer.trim();
        System.out.println("runBIAF Printer=" + printer);
        cm = cm.append(" ").append("C:/AL500/BiafLabel/Templates/2.xml");
        if (!printer.equals(""))
        {
            cm = cm.append(" -printer ").append(printer);
        }
        /*if (preview)
        {
            cm = cm.append(" -preview");
        }*/
        // out.write("[" + now() + "] " + "command: " + cm.toString() + "\r\n");
       /* try
        {
            StringBuffer sb = new StringBuffer("");
            System.out.println("runBIAF: " + cm);
            Process p = Runtime.getRuntime().exec(cm.toString());
            p.waitFor();
            System.out.println("runBIAF completed");
            stdout = p.getInputStream();
            stderr = p.getErrorStream();

            BufferedReader brData = new BufferedReader(new InputStreamReader(stdout));
            while ((strData = brData.readLine()) != null)
            {
                sb = sb.append(strData).append("\r\n");
            }
            brData.close();

            brData = new BufferedReader(new InputStreamReader(stderr));
            while ((strData = brData.readLine()) != null)
            {
                sb = sb.append(strData).append("\r\n");
            }
            brData.close();
            System.out.println("runBIAF out: " + sb);
        }
        catch (Exception e)
        {
            System.out.println("Error running BIAF: " + e);
            return;
        }*/
	}

}
