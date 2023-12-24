#Defining executable values 
CC = kotlinc
#!/usr/bin/env bash
EX = java
CLS = clear
#Defining flags
CFLAGS = -include-runtime -d
CEXE = -jar
#Defining FILES values
TARGET = src/main/kotlin/com/rscCalculator/main
TARGETkt = build/classes/kotlin/main/
TARGETjar = build/libs/main.jar
#Defining that all
	
$(TARGET): $(TARGET).kt
	$(CC) $(TARGET).kt -d $(TARGETkt) 2> main_log
	$(CC) $(TARGET).kt $(CFLAGS) $(TARGETjar)
	$(CLS)
	#$(EX) $(CEXE) $(TARGETjar)
	
clean:
	$(RM) $(TARGET)