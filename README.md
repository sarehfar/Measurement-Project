# Software Measurement Project
## Team G
Student  | Student ID
-------- | ----------
Sareh Farid  | 27845782
Seyed Hamed Valiollahi Bayeki  | 40057506
Ahmad Memari (Arash) | 40088010
Sharareh Keshavarzi | 40087339
Hanieh QasemiBoroujeni | 40057756

## Metrics
Metric No.  | Name | Category
----------- | ---- | --------
Metric 1 | Statement Coverage | Test coverage metric
Metric 2 | Branch Coverage | Test coverage metric
Metric 3 | Mutation Score | Test-suite effectiveness
Metric 4 | McCabe complexity | Complexity metric
Metric 5 | Code churn | Software maintenance metric
Metric 6 | Post-release defect density | Software quality

## Projects
Project No.  | Name | Repository
------------ | ---- | ----------
Project 1 | Apache Commons Codec | https://github.com/apache/commons-codec
Project 2 | Apache Commons Collections | https://github.com/apache/commons-collections
Project 3 | Apache Commons Configuration | https://github.com/apache/commons-configuration
Project 4 | Apache Maven Doxia | https://github.com/apache/maven-doxia

## Directory Structure
Directory  | Description
---------- | -----------
Correlation  | Contains the correlation data for all the metrics including scatter plots.
Data  | Contains the raw data collected for all the metrics.
Presentation  | Contains the project presentation in PDF format.
Report  | Contains the project report in PDF format.
Script  | Contains all the scripts that were used for the project.

## Scripts
### Mutation
Description

- Location: Script/Mutation
- Language: Java
- Dependencies: x

#### How to Run

### Spearman
Description

- Location: Script/Spearman
- Language: Python
- Dependencies: x

#### How to Run

## Maven Plugins
### JaCoCo (Test Coverage and Complexity)
Description

```xml
<plugin>
   <groupId>org.jacoco</groupId>
   <artifactId>jacoco-maven-plugin</artifactId>
   <version>0.8.3</version>
   <executions>
      <execution>
         <id>prepare-agent</id>
         <goals>
            <goal>prepare-agent</goal>
         </goals>
      </execution>
      <execution>
         <id>post-unit-test</id>
         <phase>test</phase>
         <goals>
            <goal>report</goal>
         </goals>
         <configuration>
            <!--Sets the path to the file which contains the execution data. -->
            <dataFile>target/jacoco.exec</dataFile>
            <!--Sets the output directory for the code coverage report. -->
            <outputDirectory>target/jacoco-ut</outputDirectory>
         </configuration>
      </execution>
   </executions>
</plugin>
```

### Pit (Mutation Coverage)
Description

```xml
<plugin>
   <groupId>org.pitest</groupId>
   <artifactId>pitest-maven</artifactId>
   <version>1.2.0</version>
   <executions>
      <execution>
         <id>pit-report</id>
         <phase>test</phase>
         <goals>
            <goal>mutationCoverage</goal>
         </goals>
         <configuration>
            <outputFormats>CSV</outputFormats>
         </configuration>
      </execution>
   </executions>
</plugin>
```
