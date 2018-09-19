Compile: 
In order to compile the TextLineTester program begin in the Project3 directory.
From this directory you must compile the txtbuffer package first since the TestLineTester imports it. The first command is 
 $javac -d classes src/edu/uga/cs1302/txtbuff/*.java
Next compile the test package with the command
 $javac -d classes src/edu/uga/cs1302/test/*.java
It is imperative that the package name is correct, all the compiled class files will be in the classes directory.

Execute:
To execute the program begin in the same Project3 directory. The command from here is
 $java -cp classes edu.uga.cs1302.test.TextLineTester
The main method is inside of the TextLineTester file and when it is run, the user will interact with that file.

Javadoc:
The html directory can be found in the Project3 directory. It containes all generated javadoc files for each class



