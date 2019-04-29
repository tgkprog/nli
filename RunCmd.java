///package org.nli.ws.services;

import java.io.*;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

public class RunCmd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fullcmd = "\"C:\\AL500\\BIAFLABEL\\AddToQueue.exe\" \"C:\\AL500\\BiafLabel\\Templates\\2.xml\" -printer \\\\mickaelbpc\\System-N";
		String fullcmd1 = "C:\\AL500\\BIAFLABEL\\AddToQueue.exe C:\\AL500\\BiafLabel\\Templates\\2.xml -printer \\\\mickaelbpc\\System-N";
		//here put your values
		String cmd1 = "/d/u/tmp/aCmd.sh";
		String cmd2 = "param1";
		String cmd3 = "-p2";
		String cmd4 = "another";	
		//String[] command = new String[]{cmd1, cmd2, cmd3,cmd4};
		//leave below alone
		/** to verify actual commands if being built dynamically **/
		try (FileWriter writer = new FileWriter("cmds.txt");
		 BufferedWriter bw = new BufferedWriter(writer)) {
		bw.write(cmd1);
		bw.write(" ");
		bw.write(cmd2);
		bw.write(" ");
		bw.write(cmd3);
		bw.write(" ");
		bw.write(cmd4);
		bw.write("\n--- done --- \n");

	} catch (IOException e) {
		System.err.format("IOException: %s%n", e);
	}
	try {
		System.out.println("starting " + new java.util.Date());
		File log = new File("log"); 
		ProcessBuilder pb =new ProcessBuilder(cmd1, cmd2, cmd3, cmd4);
		pb.redirectErrorStream(true);
		pb.redirectOutput(Redirect.appendTo(log));
		Process process1=pb.start();
		int rtnInt = process1.waitFor();
		System.out.println("done return :" + rtnInt + "; at " + new java.util.Date());
	} catch (Exception e) {
		e.printStackTrace();
	}
   }

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
	
