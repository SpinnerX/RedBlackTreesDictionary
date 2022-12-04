JAVAC = $(shell find . -name '*.java')

a.out: Main.class
	@echo "java Main" > a.out
	chmod a+x a.out


Main.class: Main.java
	javac Main.java

clean:
	rm -rf *.class a.out