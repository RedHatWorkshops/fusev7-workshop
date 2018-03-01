# Fuse 7 Workshop

This workshop introduces participants to Red Hat Fuse through a presentation and hands-on lab format. 


## Agenda

* Overview - Day 1 Afternoon
	* **Business Value**   - 45 mins
	* **Technical Overview**  - 45 mins
	* **Tech deep dive - Fuse Ignite** - 45 mins
	* **Tech deep dive - Fuse Standalone** - 45 mins
	* **Tech deep dive - Fuse on OpenShift**- 45 mins
	
* Fuse Ignite Hands-on Lab - Day 2 All day
    * **Simple Integration** 60 min- Go over the basics of what is in Fuse Ignite, and focus on the simple low-code hands on example for lab.
    * **Data Mapper** 80 mins - First customization extension. Define customize datatype for various connector endpointd. 
    * **Step Extension** 80 mins - Implement step extension using Camel, build reusable modules for citizen developer.
    * **Connector Extension** 80 mins - Extending new connectors for new endpoints.
    * **Operational Concerns** 120 mins - Deep dive into the deployment architecture of Fuse Ignite. And all the concerns people might have when operating Fuse Ignite.
    	* Monitoring 
    	* Installation
    	* Support
    	* Import/Export - Multi-tenancy in Fuse Ingnite
    	* OpenShift 

* Fuse and Runtimes Hands-on Lab - Day 3 All day
    * **Spring Boot**  90 mins - What's new in the runtime
    	* Stand alone 
    	* Fuse on OpenShift
    		* Config and secrets 
    * **Karaf** 90 mins -
    	* Differentce between Karaf 2 and 4
    	* Deploying Fuse with Karaf on OpenShift
    * **Fabirc migration** 90 mins -	
    	* Moving from profile to OpenShift
    * **EAP** 90 mins - 
    	* What is new in EAP
    	* Deploying Fuse with EAP on OpenShift 
    * **Management and Operations** 60 mins -     	* Managing Runtimes on OpenShift
    	* Managing standalone runtimes 	

    

### Publishing slides

`npm start` is a great way to work locally -- you can create content/slides locally, switch to a web browser, and have the new slides automatically generated. When you're ready to "publish" the slides, you should commit to your `master` branch and then merge those changes into your `gh-pages` branch. This `gh-pages` branch obviously must be set up beforehand, and should start off being a copy of your master branch. Do the following to create your `gh-pages` branch:

```
$  git checkout -b gh-pages
$  git push origin gh-pages
```

This special `gh-pages` branch uses [GitHub pages](https://pages.github.com) to host your slides. Now you can navigate to your project's github pages site and view the published slides. For example, for this template site, you can navigate to [https://redhatworkshops.github.io/workshop-template/slides/](https://redhatworkshops.github.io/workshop-template/slides/) and see the published slides. 

You can work locally, committing on master, and then publish by rebasing/merging to the `gh-pages` branch. 


## Labs

It's best to create labs in some kind of text format. [Gitbook](https://github.com/GitbookIO/gitbook/blob/master/docs/setup.md) is a good option. [Asciidoc](http://asciidoc.org) is another good one. 
