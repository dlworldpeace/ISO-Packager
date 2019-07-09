#!/bin/bash

working_fine=true

for filename in src/*.xsd; do
    `xjc -d src/main/java -p deskera.fintech.$(basename "$filename" .xsd) src/$(basename "$filename") -XautoNameResolution`
    dir="src/main/java/deskera/fintech/$(basename "$filename" .xsd)"
    if [ -d "$dir" ]
    then
        echo "$(basename "$filename") is succesfully parsed"
    else
        echo "$(basename "$filename") fails to be parsed"
        working_fine=false
    fi
done

if [ "$working_fine" = true ] ;
then
    echo "exporting as a jar package..."
    `mvn package`
    jar="target/deskera-fintech-1.0.jar"
    if [ -f "$jar" ]
    then
        echo "jar package is successfully exported at target/"
    else
        echo "jar package fails to be exported"
    fi
else
    echo "jar package is not exported because some .xsd file fails to be parsed"
fi

read -n 1 -s -r -p "Press any key to exit"