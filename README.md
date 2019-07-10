This is a simple CLI tool to export several **.xsd** generated ISOXML packages into one **.jar** file for importing into your other projects.

***

__Pre-setup__

1. For both LINUX and WINDOWS users (Windows Linux Subsystem not supportted), run command line `xjc -version` to check if you have **xjc** installed.

On successful installation, you will see

```
xjc 2.3.0-b170531.0717
```

On unsuccessful installation, you can make sure you have **Java** installed in your environment, this can be checked using command line `java -version`. **xjc.exe** comes as part of your jdk. (For WINDOWS user, remember to add path in system environment)

2. run command line `mvn -version` to check if you have **Apache Maven** installed.

On successful installation, you will see

```
Apache Maven 3.6.1 (d66c9c0b3152b2e69ee9bac180bb8fcc8e6af555; 2019-04-05T03:00:29+08:00)
Maven home: D:\apache-maven-3.6.1\bin\..
Java version: 9.0.4, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-9.0.4
Default locale: en_SG, platform encoding: GBK
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```
and can skip this section.

On unsuccessful installation, you can follow [here](https://www.baeldung.com/install-maven-on-windows-linux-mac) to install Maven on WINDOWS or LINUX.

***

__Create JAR from .xsd files__

1. Clone this repository using `git clone https://github.com/dlworldpeace/ISO-Packager.git` at yout preferred storage location. 
```
Note: You can skip step 2 and 3 if you are not adding new .xsd files
```
2.  Add your new **.xsd** files into the `src/` directory along all other existing **.xsd** files and `main/`.
3. If your newly added .xsd files have other imports, ensure these imports exist in the same directory and their `"schemaLocation"` of the import fields are updated accordingly, for example in `citiBalanceInquiry.xsd`

change from

```
   <xsd:import namespace="urn:iso:std:iso:20022:tech:xsd:camt.052.001.02"
                schemaLocation="citiconnect/iso/camt05200102.xsd"/>
```
to the following
```
   <xsd:import namespace="urn:iso:std:iso:20022:tech:xsd:camt.052.001.02"
                schemaLocation="camt05200102.xsd"/>
```
because the the required import file `camt05200102.xsd` is in the same directory.

4. From the `src` level directory, run `chmod +x parse_xsd.sh` to give the shell script executable permission.

5. In the same directory, run command `parse_xsd.sh` (for WINDOWS) or `./parse_xsd.sh`(for LINUX) to generate all the **.java** from **.xsd** at `src/main/java/deskera/fintech/` and thereafter export all of them as a **.jar** package.

6. Retrieve the generated **.jar** from `target/deskera-fintech-1.0.jar`.

***

__To update JAR name or version__

If you want to change the name and version of the `.jar` exported, you can change them at `<artifactId>deskera-fintech</artifactId>` and `<version>1.0</version>` of `pom.xml` respectively before step 4 and 5 of **Create JAR from .xsd files**.

***

__To learn more__

What `parse_xsd.sh` does is a consecutive 2 steps of parsing and packaging:

1. An **xjc** command is used to parse each existing **.xsd** files into a folder of java classes, e.g. `xjc -d src/main/java -p deskera.fintech.citiBalanceInquiry src/citiBalanceInquiry.xsd -XautoNameResolution`.

2. a **maven** command `mvn pacakage` is used to export the entire java package as a **.jar** file based on the settings in `pom.xml`.
