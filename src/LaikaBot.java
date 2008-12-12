import org.jibble.pircbot.*;
import java.util.Hashtable;
import java.util.LinkedList;

public class LaikaBot extends PircBot {
	// This is set to true when the chain is in progress
	private boolean fChaining = false;
	// All commands
	private Hashtable fCommands = new Hashtable();
	// All regular expressions
	private LinkedList<RegExTask> fRegExs = new LinkedList<RegExTask>();
	// This is set to true when verbose more is turned off
	private boolean fSilent = false;
	private IdManager fIdManager = new IdManager();
	private ChainDetail fChainDetail = new ChainDetail();
	
	public IdManager getIdManager() {
		return fIdManager;
	}
	
	public ChainDetail getChainDetail() {
		return fChainDetail;
	}
	
	public boolean isChaining() {
		return fChaining;
	}
	
	public void setChaining(boolean aTo) {
		fChaining = aTo;
	}
	
	public void quitChain() {
		fChaining = false;
		fChainDetail.clearTimer();
		fChainDetail = new ChainDetail();
	}
	
	private void processMessage(String aChannel, String aMessage, String aSender) {
		for (RegExTask lCurrentTask: fRegExs)
			if (lCurrentTask.execute(this, aChannel, aMessage, aSender))
				return;
	}
	
	private void populateRegExs() {
		fRegExs.add(new ReportHospRegEx("You continue to beat [\\S]+ on the ground."));
		fRegExs.add(new RespectChangeRegEx("Respect: [0-9]+"));
	}
	
	private void populateCommands() {
		fCommands.put("!chain", new ChainCommand());
		fCommands.put("!report", new ReportCommand());
		SetRespectCommand lRespectCommand = new SetRespectCommand();
		fCommands.put("!respect:", lRespectCommand);
		fCommands.put("!respect", lRespectCommand);
		fCommands.put("!register", new RegisterCommand());
		fCommands.put("!unregister", new UnregisterCommand());
		fCommands.put("!rotation", new RotationCommand());
		fCommands.put("!skip", new SkipCommand());
		WaitingToHospCommand lHospCommand = new WaitingToHospCommand();
		fCommands.put("w2h", lHospCommand);
		fCommands.put("!w2h", lHospCommand);
		fCommands.put("!help", new HelpCommand());
		fCommands.put("!timeleft", new TimeLeftCommand());
		fCommands.put("!reset", new ResetCommand());
		fCommands.put("!id", new IdCommand());
		fCommands.put("!addid", new AddIdCommand());
		fCommands.put("!delid", new DelIdCommand());
	}
	
	public void onDisconnect() {
		while (!isConnected()) {
			try {
				reconnect();
				joinChannel(PropertyManager.getSettings().getProperty("channel", "#flyinghellfish"));
			}
			catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (Exception ex) { }
			}
		}
	}
	
	public LaikaBot(String aName) {
		setMessageDelay(100);
		setName(aName);
		populateCommands();
		populateRegExs();
	}
	
	private boolean isOperator(String aChannel, String aSender) {
		// return true;
		User[] lAllUsers = getUsers(aChannel);
		for (User lCurrentUser: lAllUsers) {
			if (lCurrentUser.equals(aSender))
			 	return lCurrentUser.getPrefix().length() != 0;
		}
		return false;
	}
	
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		if (isOperator(channel, sender)) {
			String[] lMessages = message.split(" ");
			if (lMessages[0].toLowerCase().equals("!verbose")) {
				if (lMessages[1].toLowerCase().equals("off")) {
					fSilent = true;
					sendMessage(channel, Colors.BOLD + Colors.BROWN + "Verbose mode: OFF");
				} else if (lMessages[1].toLowerCase().equals("on")) {
					fSilent = false;
					sendMessage(channel, Colors.BOLD + Colors.BROWN + "Verbose mode: ON");
				}
			}
			if (!fSilent) {
				if (fCommands.containsKey(lMessages[0].toLowerCase())) {
					((ICommand)fCommands.get(lMessages[0].toLowerCase())).execute(this, channel, sender, lMessages);
				} else if (fChaining)
					processMessage(channel, message, sender);
			}
		}
	}
}