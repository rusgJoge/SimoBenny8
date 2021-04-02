package example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class IdCommit {
	
	private static final Logger logger = Logger.getLogger(IdCommit.class.getName());

	public static void main(String[] args) {
		String s;
        Process p;
        String keyword = "commit";
        String project = "C:\\Users\\Simone Benedetti\\Documents\\Programmazione JAVA\\AddedIDProject";
        String wordToSearch = "added";
        
        try {
            p = Runtime.getRuntime().exec("cmd /c cd "+project+"&& git log --grep="+wordToSearch+" --date=iso-strict --name-status --stat HEAD --abbrev-commit");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null) {
            	if (s.toLowerCase().indexOf(keyword.toLowerCase()) != -1 ) {
            		logger.info("Keyword matched the string");
            		String words[] = s.split(" ");
            		String id = words[1];
            		logger.log(Level.INFO, "Commit id: {0}", id);
            	}
            }	
            p.waitFor();
            p.destroy();
            
        }catch (Exception e) {}
        
    }
    

}


