
public class WikipediaAutomation extends Base{

	public static void main(String[] args) {
		
		String jsonFilePath = System.getProperty("user.dir")+"\\data.json";
		URL = "https://en.wikipedia.org/wiki/Nike%2BiPod";
		
		try {
			
			if(validateLink(URL) == true) {
				
				getValidInteger();
			
				for(int i=0; i<=input ; i++) {
					System.out.println("Opening URL --> " +URL);
					openLink_CreateArrayofLink(URL);
					URL = uniqueWikiLinksList.get(i).toString();
				}
			}else {
				System.out.println("Invalid link");
			}
			
			System.out.println("Total links without duplicates --> " +uniqueWikiLinksList.size());
			System.out.println("Total numbers of link --> " +allWikiLinksList.size());
			/*
			for (int i=0; i<allWikiLinksList.size(); i++) {
				System.out.println(i+1 + " --> " + allWikiLinksList.get(i).toString());
			}
			*/
			createJSONFile(jsonFilePath, allWikiLinksList.size(), uniqueWikiLinksList.size(), allWikiLinksList);
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
