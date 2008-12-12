import java.util.*;
import java.io.*;

public class IdManager {
	// ID Map
	private Map fIdMap = new HashMap();
	
	public IdManager() {
		File lFile = new File("memberIds.dat");
		if (!lFile.exists())
			return;
		try {
			BufferedReader lInput =  new BufferedReader(new FileReader(lFile));
			try {
				String lCurrentLine = null;
				while ((lCurrentLine = lInput.readLine()) != null) {
					String[] lPairs = lCurrentLine.split(", ");
					addId(lPairs[0], lPairs[1]);
				}
			}
			finally {
				lInput.close();
			}
		}
		catch (Exception ex) { }
	}
	
	public void saveIds() {
		try
		{
			PrintStream lPs = new PrintStream(new FileOutputStream("memberIds.dat"));
			try {
				Iterator lIt = fIdMap.entrySet().iterator();
				while (lIt.hasNext()) {
					Map.Entry pairs = (Map.Entry)lIt.next();
					lPs.println(pairs.getKey() + ", " + pairs.getValue());
				}
			}
			finally {
				lPs.close();
			}
		}
		catch (Exception ex) { }
	}
	
	public void addId(String aName, String aId) {
		fIdMap.put(aName, aId);
	}
	
	public String delId(String aName) {
		return (String)fIdMap.remove(aName);
	}
	
	public String getId(String aName) {
		return (String)fIdMap.get(aName);
	}
}