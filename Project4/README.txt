Compile: 
In order to compile Project4 begin in the Project4 directory. From this directory you must first compile the txtbuff package. The first command is 
   $javac -d classes src/edu/uga/cs1302/txtbuff/*.java
Next compile the test pacakge with the following command
     $javac -d classes -cp classes: hamcrest-core-1.3.jar junit-4.12.jar src/edu/uga/cs1302/test/.*java


Execute:
To execute the program begin in the same Project 4 directory. Then use the folling command
   $ java org.junit.runner.JUnitCore edu.uga.cs1302.test.EditableLineTest
