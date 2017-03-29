javac *.java
java RSATM
jar cvfe MyApp.jar RSATM *.class
del *.class
pause