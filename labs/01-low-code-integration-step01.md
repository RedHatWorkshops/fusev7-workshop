# Simple SaaS integration with Swagger Document

## Prerequisites
* A valid [Fuse Online](https://www.redhat.com/en/explore/fuse-online) account 

## Background

Utility payment management system has offered an online service to pay for the water utility bill -- Water Company. You job is read from the input of a frontend application and setup re-occurring payment for different account. 
 
![Demo 1](images/01-Step-01.png)

To access the frontend application go to 
> **https://todo-*YOUR_FUSE_IGNITE_URL*/index.php**

![Demo 2](images/01-Step-02.png)

This data are stored in the default embedded Fuse Online database. 

![Demo 3](images/01-Step-03.png)

The **Water Company** API has a backend dashboard that display all the payment. You will be able to view the result of the payment. 
(Data cleans every three hours.)
https://water-company-tp3demo.4b63.pro-ap-southeast-2.openshiftapps.com/main

![Demo 37](images/01-Step-37.png)

## Low Code Integration

### Step One - Setup Connector and Connection

In the Ignite navigation panel, click Customizations, and click on *Create API Connector*

![Demo 4](images/01-Step-04.png) 

Click *Use a URL* and enter the swagger location

> https://raw.githubusercontent.com/weimeilin79/fuse7tp3demo/master/waterpayment.yml
  
![Demo 5](images/01-Step-05.png) 

Follow the instruction and click through to the final step. 
![Demo 6](images/01-Step-06.png) 
![Demo 7](images/01-Step-07.png) 
![Demo 8](images/01-Step-08.png) 
![Demo 9](images/01-Step-09.png)

In the Ignite navigation panel, click Connections, and click on *Create Connection*

![Demo 10](images/01-Step-10.png)

Selects "Pay Water Bill" as the Connection Type.
![Demo 11](images/01-Step-11.png)

Enter "/" as the Base path, and select *"Next"*
![Demo 12](images/01-Step-12.png)

Name your Connection.
![Demo 13](images/01-Step-13.png)
![Demo 14](images/01-Step-14.png)


### Step Two - Integration

In the Ignite navigation panel, click Integrations, and click on *Create Integration*

![Demo 15](images/01-Step-15.png)

On the Choose a Start Connection page, click the default PostgresDB connection.

![Demo 16](images/01-Step-16.png)

Choose *Periodic SQL Invocation* to setup the re-occurr payment.
![Demo 17](images/01-Step-17.png)

Enter following input. 

* **SQL Statement:** *SELECT TASK FROM TODO WHERE TASK LIKE 'reoccurring%';*
* **Period:** *30000*

![Demo 18](images/01-Step-18.png)

On the Choose a Finish Connection page, click **PayBill** connection that you created.
![Demo 19](images/01-Step-19.png)

On the Choose an Action page, click **Payment**, which will kick off water utility bill payment.
![Demo 20](images/01-Step-20.png)

In the left panel, hover over the plus sign between the TODO *PERIODIC SQL INVOCATION* step and the finish *PAYMENT* connection to display a pop-up in which you click Add a Step.
![Demo 21](images/01-Step-21.png)

On the Choose a Step page, click Data Mapper. 
![Demo 22](images/01-Step-22.png)

In the data mapper, the Sources panel on the left displays the fields in the output from the Todo step. The Target panel on the right displays the fields from the Water Company API. In the Target panel, expand the body field. Drag the **Task** field from Souce panel to the **senderid** in the Target Panel.

![Demo 23](images/01-Step-23.png)

On the Mappiung Detail Panel, Under Action, select **Separate**.

![Demo 25](images/01-Step-25.png)

On the same Mappiung Detail Panel, Under Targets, enter 2 in the Separate Index, and select *Add Transformation* and select **Trim**. And Click on *Add Target*

![Demo 26](images/01-Step-26.png)

Enter **amount** in the new popup target section. Make sure the index is set to **3**

![Demo 27](images/01-Step-27.png)

Click Done. 
![Demo 28](images/01-Step-28.png)

Click on *Save as Draft* to save this integration. And name the integration. Click on *Publish* to start the integration.
![Demo 29](images/01-Step-29.png)

Wait until the integration become active.
![Demo 30](images/01-Step-30.png)


### Step Three - Integration Result

Go to the frontend TODO application

> **https://todo-*YOUR_FUSE_IGNITE_URL*/index.php**

Enter *reoccurring YOUR_NAME BILLING_AMT* in the TODO form.

![Demo 31](images/01-Step-31.png)

Go to the *Water Company* backend dashboard and view the result of the integration. 
> https://water-company-tp3demo.4b63.pro-ap-southeast-2.openshiftapps.com/main

![Demo 32](images/01-Step-32.png)

Enter another name *reoccurring YOUR_NAME BILLING_AMT* in the TODO form.
![Demo 33](images/01-Step-33.png)

Go to the *Water Company* backend dashboard and view the result of the integration. 
> https://water-company-tp3demo.4b63.pro-ap-southeast-2.openshiftapps.com/main

![Demo 34](images/01-Step-34.png)

Delete all entry in frontend TODO application
![Demo 35](images/01-Step-35.png)

Deactivate the integration.
![Demo 36](images/01-Step-36.png)

## Resource
[Fuse Online] (https://www.redhat.com/en/explore/fuse-online) - https://www.redhat.com/en/explore/fuse-online
[Demo Video](https://vimeo.com/257550267) - https://vimeo.com/257550267