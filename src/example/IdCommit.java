package example;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class IdCommit {
	
	private static final Logger logger = Logger.getLogger(IdCommit.class.getName());
	
	public static void commitString(String wordToSearch, String project,String fileName, int i) throws IOException {
		
		String s;
        Process p;
        String keyword = "commit";
        String outname = fileName + "TotalCommit.txt";
        FileWriter result = null;
        //String project = "C:\\Users\\Simone Benedetti\\Documents\\Programmazione JAVA\\Bahir";
        //String wordToSearch = "BAHIR-49";
        
        try {
            p = Runtime.getRuntime().exec("cmd /c cd "+project+"&& git log --grep="+wordToSearch+" --date=iso-strict --name-status --stat HEAD --abbrev-commit");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            if(i != 0) {
            	result = new FileWriter(outname,true);
            }else {
            	result = new FileWriter(outname);
            }
            while ((s = br.readLine()) != null) {
            	result.write(s);
            	result.append("\n");
            }	
            p.waitFor();
            p.destroy();
            
        }catch (Exception e) {
        	logger.log(Level.WARNING,"Exception found");
        }finally {
            try {
	               result.flush();
	               result.close();
	               //System.out.println("file chiuso");
	            } catch (IOException e) {
	               System.out.println("Error while flushing/closing fileWriter !!!");
	               e.printStackTrace();
	            }
        }
        return;
        
    }
		
	

	public static void main(String[] args) {
		String s;
        Process p;
        String keyword = "commit";
        String project = "C:\\Users\\Simone Benedetti\\Documents\\Programmazione JAVA\\Bahir";
        String wordToSearch = "BAHIR-49";
        
        try {
            p = Runtime.getRuntime().exec("cmd /c cd "+project+"&& git log --grep="+wordToSearch+" --date=iso-strict --name-status --stat HEAD --abbrev-commit");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null) {
            	if (s.toLowerCase().indexOf(keyword.toLowerCase()) != -1 ) {
            		String[] words = s.split(" ");
            		String id = words[1];
            		logger.log(Level.INFO, "Commit id: {0}", id);
            	}
            }	
            p.waitFor();
            p.destroy();
            
        }catch (Exception e) {
        	logger.log(Level.WARNING,"Exception found");
        }
        
    }
    

}


