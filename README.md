# Consuming and creating a SOAP Web service

## Consuming a SOAP web service

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

=========================================================================================

## Creating a SOAP web service
 
 
Add dependency in pom for spring-boot-starter-web-services, wsdl4j

Create schema file (Country.xsd) in the resources that Spring-WS will export automatically as a WSDL.
 
Add jaxb2-maven-plugin plugin in pom to create domain classes from the schema.

Create repository (CountryRepository.java) class that returns data to the soap service.

Create country service endpoint to handle incoming requests (CountryEndpoint.java).

Configure web service beans (WebServiceConfig.java)

Start the application, and access the wsdl file at http://localhost:8090/ws/countries.wsdl

Using soap ui, make a hit to the web service with following request:

	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
		  xmlns:gs="http://spring.io/guides/gs-producing-web-service">
		   <soapenv:Header/>
		   <soapenv:Body>
			  <gs:getCountryRequest>
				 <gs:name>Spain</gs:name>
			  </gs:getCountryRequest>
		   </soapenv:Body>
	</soapenv:Envelope>
