# Red Hat JBoss Fuse 7 Labs

These set of labs will help a new user learn how to install, configure and use JBoss Fuse 7. We'll cover topics like different containers (SpringBoot, Karaf or EAP), Fuse Ignite (IPaas) and Fuse Integration Services (Fuse on OpenShift). 

## Prerequisites

To get started with these labs, you'll want to install (and have correctly configured) the following prerequisites:

* JDK 8 ([OpenJDK](http://openjdk.java.net/install/) or [OracleJDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
* [Apache Maven 3.3+](https://maven.apache.org/download.cgi)
* Zip/Unzip utility
* [Git Command Line](https://git-scm.com/downloads)

## Contributing to the labs

We are always happy to accept contributions in the form of correcting errors, adding new labs, making certain points more clear, etc. Please open [Issues](https://github.com/RedHatWorkshops/amqv7-workshop/issues) on this GitHub repo identifying what things you'd like to contribute and then send [Pull Requests](https://github.com/RedHatWorkshops/amqv7-workshop/pulls)!

The Lab guides are written in [Markdown](https://daringfireball.net/projects/markdown/syntax) and are organized/compiled with [Gitbook](https://www.gitbook.com). When you make changes, please also take the time to build/compile/preview the changes using gitbook. See below for instructions on how to build the source.

## Building the Gitbook 
We are using Gitbook to organize and build the lab guide. We highly recommend you [install the gitbook-cli](https://github.com/GitbookIO/gitbook-cli) tools to help you build and preview the labs in Gitbook format. If you have the `gitbook-cli` tools installed, you can navigate to this folder (ie, `amqv7-workshop/labs`) and run the following commands:


    $ gitbook install
    $ gitbook build .

Then if you look in the `_book` folder, you should see the HTML files generated for this book. Open the `index.html` file from that folder to have your book. 

You can also set up live preview of the book by running this command:

    $ gitbook serve

Then you should see something similar to this:

```
info: loading book configuration....OK 
info: load plugin gitbook-plugin-anchors ....OK 
info: load plugin gitbook-plugin-highlight ....OK 
info: load plugin gitbook-plugin-search ....OK 
info: load plugin gitbook-plugin-sharing ....OK 
info: load plugin gitbook-plugin-fontsettings ....OK 
info: load plugin gitbook-plugin-livereload ....OK 
info: >> 6 plugins loaded 
info: start generation with website generator 
info: clean website generator
info: OK 
info: generation is finished 

Starting server ...
Serving book on http://localhost:4000
```

Now navigate to [http://localhost:4000](http://localhost:4000) to see the live-updating Gitbook. If you make changes to the source they'll automatically be built and updated in the web page.


Lastly, to build the Gitbook as a PDF file, run the following command (from the `./labs` folder):

    $ gitbook pdf . 

You should see a file named `book.pdf` in the `./labs` folder.
  
  
## Updating the https://redhatworkshops.github.io/ labs website
 
To do this, first build the gitbook HTML source, then push to the `gh-pages` branch:
 
    rm -fr _book
    gitbook build .
    cd _book
    git init 
    git commit --allow-empty -m 'initial commit'
    git checkout -b gh-pages
    git add .
    git commit -am 'updated docs'
    git push --force https://github.com/RedHatWorkshops/amqv7-workshop.git gh-pages
     
All of this can be found in the `publish-labs.sh` script.
    