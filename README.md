# Model View Controller Demo

## About
Demonstration of MVC pattern using JavaFX. Basically it simply uses a login dialog to demonstrate the connections between the view, the controller and the data model. 
For simplicity all calls are synchronous and there is exactly one controller for one view.

This application is in german. Two users are set up:

| User   | Password |
| ----   | -------- |
| anton  | geheim   |
| frieda | geheim   |

## How to build
You can build the demo yourself by checking out the code and running ```mvn``` or if you have no Maven installed use ```./mvnw```on Linux or Mac and ```mvnw.cmd```on Windows. 

## How to run
If you prefer to work on the sources run ```mvn javafx:run```. You can build your own Java archive using ```mvn clean install``` and then execute ```java -jar target/mvc-1.1.0.jar```.

Alternatively download the respective release and run ```java -jar mvc-1.1.0.jar```. Please change the release version accordingly. If you are not too keen on the command line you can always right click on the file and execute it by opening it with a JDK Runtime if that is installed on your computer.
