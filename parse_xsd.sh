#!/bin/bash

for filename in src/*.xsd; do
    `xjc -d src/main/java -p deskera.fintech.$(basename "$filename" .xsd) src/$(basename "$filename") -XautoNameResolution`
    dir="src/main/java/deskera/fintech/$(basename "$filename" .xsd)"
    if [ -d "$dir" ]
    then
        echo "$(basename "$filename") is succesfully parsed"
    else
        echo "$(basename "$filename") fails to be parsed"
    fi
done

`mvn package`
jar="target/deskera-fintech-1.0.jar"
if [ -f "$jar" ]    
then
    echo "jar package is successfully exported at target/"
else
    echo "jar package fails to be exported"
fi

read -n 1 -s -r -p "Press any key to exit"