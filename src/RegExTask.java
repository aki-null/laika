public abstract class RegExTask {
	protected String fPattern;
	
	public RegExTask(String aPattern) {
		fPattern = aPattern;
	}
	
	abstract boolean execute(LaikaBot aBot, String aChannel, String aTarget, String aSender);
}