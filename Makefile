JAVAC = $(shell find . -name '*.java')

Main.class: 
	javac $(JAVAC)
	java Main

clean:
	rm -rf *.class
