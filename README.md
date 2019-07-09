This is a simple CLI tool to export several **.xsd** generated ISOXML packages into one **.jar** file for importing into your other projects.

__Pre-setup__

For both Linux and Windows users, run command line `xjc -version` to check if you have **xjc** installed.

On successful install, you will see

```
xjc 2.3.0-b170531.0717
```
and can skip this section.

On unsuccessful install, you can follow these steps:
1. Make sure you have **java** installed in your environment, this can be checked using command line `java -version`.
2. Find out directory of your default jdk using command line `whereis java`. you might see
```
java: /usr/bin/java /usr/share/java /mnt/c/Program Files (x86)/Common Files/Oracle/Java/javapath_target_482333187/java.exe /mnt/c/Program Files/Java/jdk-9.0.4/bin/java.dll /mnt/c/Program Files/Java/jdk-9.0.4/bin/java.exe /mnt/c/ProgramData/Oracle/Java/javapath_target_529715750/java.exe /usr/share/man/man1/java.1.gz
```
3. Create alias to your java's **xjc** program using the command line `alias xjc="<your xjc.exe directory>"`, e.g. 
```
alias xjc="/mnt/c/Program\ Files/Java/jdk-9.0.4/bin/xjc.exe"
```
4. If you want to add the alias to your terminal permenantly, follow this  [tutorial](https://www.hostingadvice.com/how-to/set-command-aliases-linuxubuntudebian/)
5. Check if **xjc** command works using command line `xjc -version` again.

__Create JAR from .xsd files__

1. Clone this repository using `git clone https://github.com/dlworldpeace/ISO-Packager.git` at yout preferred storage location.
2. Add your new **.xsd** files into the `src/` directory along all other existing **.xsd** files and `main/`.
3. If your newly added .xsd files have other imports, ensure these imports exist in the same directory and their `"schemaLocation"` of the import fields are updated accordingly, for example in `citiconnect-balance-inquiry.xsd`

change from

```
   <xsd:import namespace="urn:iso:std:iso:20022:tech:xsd:camt.052.001.02"
                schemaLocation="citiconnect/iso/camt.052.001.02.xsd"/>
```
to the following
```
   <xsd:import namespace="urn:iso:std:iso:20022:tech:xsd:camt.052.001.02"
                schemaLocation="camt.052.001.02.xsd"/>
```
because the the required import file `camt.052.001.02.xsd` is in the same directory.

4. From the `src` level directory, run command `parse_xsd.sh` (Make sure you have set up your python environment) to generate all the **.java** from **.xsd** at `src/main/java/deskera/fintech/` and then export the entire project from `deskera.fintech.*` as a **.jar** package.

5. Retrieve the generated **.jar** from `target/deskera-fintech-1.0.jar`.

__To update JAR name or version__

If you want to change the name and version of the `.jar` exported, you can change them at `<artifactId>deskera-fintech</artifactId>` and `<version>1.0</version>` of `pom.xml` respectively before step 4 and 5.

__To learn more__

What `parse_xsd.sh` does is a consecutive 2 steps of parsing and packaging:

1. An **xjc** command is used to parse each existing **.xsd** files into a folder of java classes, e.g. `xjc -d src/main/java -p deskera.fintech.citiBalanceInquiry src/citiBalanceInquiry.xsd -XautoNameResolution`.

2. a **maven** command `mvn pacakage` is used to export the entire java package as a **.jar** file based on the settings in `pom.xml`.
