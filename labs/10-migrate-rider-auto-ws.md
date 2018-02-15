# Migrate the Rider-Auto-WS component to SpringBoot standalone

This project demonstrates the migration of a karaf-based SOAP webservice from [Rider Auto](https://github.com/RedHatWorkshops/rider-auto-osgi/tree/master/rider-auto-ws) to Fuse 7 standalone SpringBoot. 

### Prerequisites

1. Ensure you have JBoss Developers Studio version 11.2 + with the latest Fuse Tooling
2. Ensure AMQ 7.x is running locally

### Procedure

To begin, we need to create a Fuse SpringBoot project in JBDS.

1. Open JBDS
2. Right-click on the Project Explorer and select "New", then "Fuse Integration Project"

![Create Fuse Project](images/10-Step-2.png)

3. Type in the project name "rider-auto-ws".  Click "Next".

![Type Project Name](images/10-Step-3.png)

4. Chose the latest Camel version (2.21)

5. Choose the predefined template under "JBoss Fuse", then select "Advanced", "CXF code first" and "Spring DSL".  Click Finish.

![Type Project Name](images/10-Step-5.png)

6.  Now that we have a template project, let's update the pom.xml file.  Update the `artifactId` name to 'artifactId'.  Underneath camel-cxf component in dependencies, paste the following:

```
		<dependency>
			<groupId>org.apache.camel</groupId>
			<artifactId>camel-amqp</artifactId>
			<version>${camel.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.camel</groupId>
			<artifactId>camel-bindy</artifactId>
			<version>${camel.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.camel</groupId>
			<artifactId>camel-csv</artifactId>
			<version>${camel.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.camel</groupId>
			<artifactId>camel-jaxb</artifactId>
			<version>${camel.version}</version>
		</dependency>
```

7. Replace the contents of the camel-context.xml file with:

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:cxf="http://camel.apache.org/schema/cxf"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd        http://camel.apache.org/schema/spring http://camel.apache.org/schema/spring/camel-spring.xsd        http://camel.apache.org/schema/cxf http://camel.apache.org/schema/cxf/camel-cxf.xsd    ">
    <bean class="org.apache.qpid.jms.JmsConnectionFactory" id="jmsConnectionFactory">
        <property name="remoteURI" value="amqp://localhost:5672"/>
        <property name="username" value="admin"/>
        <property name="password" value="admin"/>
    </bean>
    <bean
        class="org.springframework.jms.connection.CachingConnectionFactory" id="jmsCachingConnectionFactory">
        <property name="targetConnectionFactory" ref="jmsConnectionFactory"/>
    </bean>
    <bean class="org.apache.camel.component.jms.JmsConfiguration" id="jmsConfig">
        <property name="connectionFactory" ref="jmsCachingConnectionFactory"/>
        <property name="cacheLevelName" value="CACHE_CONSUMER"/>
    </bean>
    <bean class="org.apache.camel.component.amqp.AMQPComponent" id="amqp">
        <property name="configuration" ref="jmsConfig"/>
    </bean>
    <cxf:cxfEndpoint address="http://localhost:8183/cxf/order"
        id="orderEndpoint" serviceClass="org.fusesource.camel.ws.OrderEndpoint"/>
    <camelContext id="rider-auto-ws" trace="true" xmlns="http://camel.apache.org/schema/spring">
        <route customId="true" id="ws-to-jms">
            <from id="_from1" uri="cxf:bean:orderEndpoint"/>
            <setBody id="_setBody1">
                <simple>${in.body[0]}</simple>
            </setBody>
            <marshal id="_marshal1">
                <jaxb contextPath="org.fusesource.camel.model"/>
            </marshal>
            <inOnly id="_inOnly1" uri="amqp:incomingOrders"/>
            <transform id="_transform1">
                <constant>OK</constant>
            </transform>
        </route>
    </camelContext>
</beans>
```

Notice we've updated the JMS endpoint to point to AMQ 7 using the AMQP protocol.

8. Save the camel-context.xml file.
9. Now we need to migrate the Order POJO and Endpoint.  First, delete the existing package and contents under `src/main/java`.  Copy `../10-artifacts/Order.java` to your new rider-auto-ws project, and paste it into a new source package called `org.fusesource.camel.model`.
10.  Do the same for `../10-artifacts/OrderEndpoint.java`, except paste it into a new package called `org.fusesource.camel.ws`.
11. Create a new package structure under `src/main/resources/org/fusesource/camel/model/`.  Copy `../10-artifacts/jaxb.index` to the new package.
12. If everything compiles, try right-clicking on the `camel-context.xml` file and selecting "Run As" and then "Local Camel Context".

![Type Project Name](images/10-Step-12.png)

13.  Try hitting the WSDL page [here](http://localhost:8183/cxf/order?wsdl) in a web browser.  If everything is working, it should display.

14.  Using PostMan or SOAP UI, copy the WSDL URL and send a sample SOAP request message.  You should receive an OK response message, and your request should end up on the AMQ `incomingOrders` queue.

![Type Project Name](images/10-Step-14.png)

