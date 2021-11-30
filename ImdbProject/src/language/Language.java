package language;



public class Language {
	private static Language instance;
	private Global language;
	
	private Language() {
		
		this.language = new Global("tr");
	}
	
	public static Language getInstance() {
		if (instance == null) {
			instance = new Language();
		}
		return instance;
	}
	
	public void chanceLanguage() {
		if (language.getlanguage().equals("tr")) {
			this.language = new Global("en");
		} else {
			this.language = new Global("tr");
		}
	}
	
	public Global getLanguage() {
		return language;
	}
	
}
