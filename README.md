
To run above code, please follow below steps:
  1)	Import this project as maven project in your IDE
  2)	Update path of driver in Base.java at line 27
  3)	Update  Wikipedia URL in WikipediaAutomation.java at line 7
  4)	Run WikipediaAutomation.java and enter valid number in IDE console to get results
  5)	At the end, data.json file will be generated

**Description of java files**
Structure of the project Utilities.java --> Base.java --> WikipediaAutomation.java
I have used multi-leve inheritance. WikipediaAutomation.java(contains main class) will be child class of Base.java and Base.java will be child of Utilities.java
 
    Utilities.java contains methods to
      •	Validate given URL
      •	Get valid number from user to open number of links from given URL
      •	Remove duplicate links from list and create new list without duplicate links
      •	Generate JSON file which contains numbers of found links, numbers of unique links, list of all found links 
    Base.java extends Utilities.java. Also, it will return list of links and contains methods to
      •	Open browser and URL
      •	Get all wiki links
      •	Close browser
    WikipediaAutomation.java is main class, which extends Base.java.
