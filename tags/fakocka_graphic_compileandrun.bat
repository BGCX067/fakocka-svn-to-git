﻿set PATH=%PATH%;C:\Program Files\Java\jdk1.6.0_25\bin\
set CLASSPATH=build\
mkdir build
javac src/fakocka/model/*.java src/fakocka/gui/*.java -d build/
java fakocka.gui.Application

