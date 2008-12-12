import java.util.LinkedList;
import java.util.Timer;

public class ChainDetail {
	// Count down timer
	private Timer fChainTimer = new Timer();
	// Chain counter
	private int fChainCount = 0;
	// Start respect
	private int fStartRespect = 0;
	private int fLastRespect = 0;
	// Rotation number
	private int fCurrentRotation = 0;
	// Rotation list
	private LinkedList<String> fChainRotation = new LinkedList<String>();
	// Last hospitalization time
	private long fLastHospTime = 0;
	// This is set to true when the chain has started (someone has already made a hit)
	private boolean fStarted = false;
	
	public boolean isRegistered(String aSomeone) {
		for (String lCurrentMember: fChainRotation)
			if (lCurrentMember.equals(aSomeone))
				return true;
		return false;
	}
	
	public void updateLastHospTime() {
		fLastHospTime = System.currentTimeMillis();
	}
	
	public long getLastHospTime() {
		return fLastHospTime;
	}
	
	public int getChainCount() {
		return fChainCount;
	}
	
	public void setChainCount(int aTo) {
		fChainCount = aTo;
	}
	
	public int getStartRespect() {
		return fStartRespect;
	}
	
	public void setStartRespect(int aTo) {
		fStartRespect = aTo;
	}
	
	public int getLastRespect() {
		return fLastRespect;
	}
	
	public void setLastRespect(int aTo) {
		fLastRespect = aTo;
	}
	
	public boolean hasStarted() {
		return fStarted;
	}
	
	public void setStarted(boolean aTo) {
		fStarted = aTo;
	}
	
	public String getCurrentRotationString() {
		try {
			return fChainRotation.get(fCurrentRotation);
		} catch (Exception e) {
			return null;
		}
	}
	
	public LinkedList<String> getRotationList() {
		return fChainRotation;
	}
	
	public int getCurrentRotation() {
		return fCurrentRotation;
	}
	
	public boolean registerRotation(String aId) {
		if (!fChainRotation.contains(aId)) {
			fChainRotation.add(aId);
			return true;
		} else
			return false;
	}
	
	public void nextRotation() {
		if (fChainRotation.size() <= fCurrentRotation + 1)
			fCurrentRotation = 0;
		else
			fCurrentRotation++;
	}
	
	// -1 : Not found, 0 : Success, 1 : Requires notification
	public int unregisterRotation(String aId) {
		if (fChainRotation.contains(aId)) {
			int lTargetPosition = fChainRotation.indexOf(aId);
			fChainRotation.remove(aId);
			if (fCurrentRotation == lTargetPosition) {
				if (fChainRotation.size() < fCurrentRotation + 1)
					fCurrentRotation = 0;
				return 1;
			} else if (fCurrentRotation > lTargetPosition) {
				fCurrentRotation--;
				return 0;
			} else
				return 0;
		} else
			return -1;
	}
	
	public void clearTimer() {
		fChainTimer.cancel();
		fChainTimer = new Timer();
	}
	
	public void resetTimer(String aChannel, LaikaBot aBot) {
		fChainTimer.cancel();
		fChainTimer = new Timer();
		populateTimerTasks(aChannel, aBot);
	}
	
	private void populateTimerTasks(String aChannel, LaikaBot aBot) {
		fChainTimer.schedule(new ChainTimerTask("2 minutes and 30 seconds", false, false, aBot, aChannel), 150000);
		fChainTimer.schedule(new ChainTimerTask("1 minute and 30 seconds", false, true, aBot, aChannel), 210000);
		fChainTimer.schedule(new ChainTimerTask("1 minute", false, false, aBot, aChannel), 240000);
		fChainTimer.schedule(new ChainTimerTask("30 seconds", false, true, aBot, aChannel), 270000);
		fChainTimer.schedule(new ChainTimerTask("", true, false, aBot, aChannel), 300000);
	}
}