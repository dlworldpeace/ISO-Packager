#!/bin/bash

working_fine=true

# parse every .xsd file into its set of java classes using its filename as part of filepath
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

# if non of XSD parsing fails, package them into one .jar file
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

# do not exit upon completion
read -n 1 -s -r -p "Press any key to exit"