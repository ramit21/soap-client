# Parse wsdl file using pom, ant, wsimport

The interface to a SOAP web service is captured in a WSDL. JAXB provides an easy means 
to generate Java classes from a WSDL (or rather: the XSD contained in the <Types/> 

section of the WSDL). 

The wsimport tool is used to parse an existing Web Services Description Language 

(WSDL) file and generate required files (JAX-WS portable artifacts) for web service 

client to access the published web services. This tool is part of the JDK package.

The command that we are executing for the wsdl file kept in /resources folder of the 

project is:

wsimport ./src/main/resources/stockquote.wsdl -keep -d ./src/main/java -p 

com.webservice -Xnocompile -verbose

The flags used in the above command:

-keep: keep the generated java files (By default they are generated and removed)
-d: location of generated files
-p: package for the generated files (this overrides the default from wsdl)
-Xnocompile: dont generate .class files

In this project, an ANT target has been configured to invoke wsimport on the wsdl 

file. The pom contains 'maven-antrun-plugin' to invoke the ant target. So to generate 

the wsdl client, this maven command needs to be executed: 'mvn package'.

Now to invoke the web service from the code, you need to add spring-ws-core and 
use WebServiceGatewaySupport.

Starting this microservice actually makes a call to Soap service and prints the response. 

 