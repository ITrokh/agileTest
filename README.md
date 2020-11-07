# agileTest
AgileEngineTest

To build run the command:

mvn clean package

To execute run:

mvn spring-boot:run

# Using
To search image use this url:
host:port/test/images/search/${searchTerm}?isFullWord=boolean

isFullWord is used to determine that You search by full word, not a part.
 If You want to search by full word set this flag to true, otherwise it should be false or skipped
   Search term can be any field of image json
