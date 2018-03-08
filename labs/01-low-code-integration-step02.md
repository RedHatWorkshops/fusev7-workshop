# Integrating existing SaaS API with Broker connection in Fuse Online

## Prerequisites
* A valid [Fuse Online](https://www.redhat.com/en/explore/fuse-online) account 
* Finished the simple SaaS integration with Swagger Document [demo](https://github.com/weimeilin79/fuse7tp3demo/blob/master/README.md) 

## Background

Utility payment management system has offered an online service to pay for the water utility bill -- Water Company. You job is kick off a payment whenever an event is sent to the default message broker. 
 
![Demo 50](images/01-Step-50.png)

The **Water Company** API has a backend dashboard that display all the payment. You will be able to view the result of the payment. 
(Data cleans every three hours.)

> https://water-company-tp3demo.4b63.pro-ap-southeast-2.openshiftapps.com/main

![Demo 37](images/01-Step-37.png)

OpenShift management Console is available at:

> https://console.fuse-ignite.openshift.com/console/

![Demo 51](images/01-Step-51.png)

## Low Code Integration

### Step One - Start and configure AMQ broker

Before we start integration, let's start the default broker. Go to the OpenShift management Console. And select project on *Fuse Online*

> https://console.fuse-ignite.openshift.com/console/

![Demo 52](images/01-Step-52.png)

Scale up **broker-amq** from 0 to 1 located at the bottom of the overview.
![Demo 53](images/01-Step-53.png)

Once started, click on the running pod.
![Demo 55](images/01-Step-55.png)

Go to AMQ console by click on the *Open Java Console*
![Demo 54](images/01-Step-54.png)

Click on +Create on the tab panel
![Demo 56](images/01-Step-56.png)

Enter 
> **Queue name:** paymentevent
> 
> **Destination Type:** Queue
 
![Demo 57](images/01-Step-57.png)

On the lefthand panel, select Queue with name paymentevent and click **+Send** on the top tab panel. and set the credential of the sender by clicking on **Preference** .

![Demo 58](images/01-Step-58.png)

Start config
> **Activemq user name:** amq
> 
> **Activemq password:** topSecret
And click done on the left panel.

![Demo 59](images/01-Step-59.png)


Go back to the Ignite console. in navigation panel, click Connections, and click on *Create Connection*
![Demo 60](images/01-Step-60.png)

Selects "AMQ" as the Connection Type.
![Demo 61](images/01-Step-61.png)

Enter

> **Base URL:** tcp://broker-amq-tcp:61616
> 
> **User Name:** amq
> 
> **Password**: topSecret

and select *"Next"*
![Demo 62](images/01-Step-62.png)

Click on validate.
![Demo 63](images/01-Step-63.png)

Name your connection.
![Demo 64](images/01-Step-64.png)
![Demo 65](images/01-Step-65.png)

### Step Two - Integration

In the Ignite navigation panel, click Integrations, and click on *Create Integration*

![Demo 15](images/01-Step-15.png)

On the Choose a Start Connection page, click the default DefaultBroker connection.

![Demo 66](images/01-Step-66.png)

Choose *Subscribe for message* to listen to events send to broker.
![Demo 67](images/01-Step-67.png)

Enter following input. 

* **Destination Name:** *paymentevent*
* **Destination Type:** *Queue*

![Demo 68](images/01-Step-68.png)

On the Choose a Finish Connection page, click **PayBill** connection that you created.
![Demo 69](images/01-Step-69.png)

On the Choose an Action page, click **Payment**, which will kick off water utility bill payment.
![Demo 70](images/01-Step-70.png)

In the left panel, hover over the plus sign between the TODO *PERIODIC SQL INVOCATION* step and the finish *PAYMENT* connection to display a pop-up in which you click Add a Step.
![Demo 71](images/01-Step-71.png)

On the Choose a Step page, click Data Mapper. 
![Demo 72](images/01-Step-72.png)

In the data mapper, the Sources panel on the left displays the fields in the output from the Todo step. The Target panel on the right displays the fields from the Water Company API. In the Target panel, expand the body field. click on the '+ ' sign in Constant. 

![Demo 73](images/01-Step-73.png)

Create two constant

* **50:** *String*
* **YOUR_NAME:** *String*
![Demo 75](images/01-Step-75.png)

Map your constant from Source panel to Target accordingly

![Demo 76](images/01-Step-76.png)

Name your integration and click publish.
![Demo 77](images/01-Step-77.png)

![Demo 78](images/01-Step-78.png)


### Step Three - Integration Result

Go back to your AMQ console, enter pay in the payload and click send message.

![Demo 79](images/01-Step-79.png)
![Demo 80](images/01-Step-80.png)


Go to the *Water Company* backend dashboard and view the result of the integration. 
> https://water-company-tp3demo.4b63.pro-ap-southeast-2.openshiftapps.com/main
![Demo 81](images/01-Step-81.png)



## Resource
[Fuse Online] (https://www.redhat.com/en/explore/fuse-online) - https://www.redhat.com/en/explore/fuse-online
[Demo Video](https://vimeo.com/257550267) - https://vimeo.com/257550267
[Demo Video](https://vimeo.com/257656566) - https://vimeo.com/257656566