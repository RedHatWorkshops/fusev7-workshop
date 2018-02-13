# Workshop Template

This workshop template is the base layout for a text-based workshop. Using text for building workshop material is preferable for collaboration, versioning, audit, and easy pull request/diff workflows. 

It consists of two main text-based sections:

* slides/
* labs/

## Slides

Slides are done with [reveal.js](https://github.com/hakimel/reveal.js/). You can checkout this repo (or download a release) and navigate to the slides directory. You'll need `npm` for nodejs modules and dependency management. If on a mac, you should be able to `brew install npm` to get npm. Run the following commands to install the dependencies:

```
slides $  npm install
```

Once the dependencies have been installed, you can start up the reveal.js web page like this:

```
slides $  npm start
```

Your slides will go into `slides/index.html`. Please refer to the [reveal.js documentation](https://github.com/hakimel/reveal.js/) for how to create slides. There is also a `demo.html` file in the `slides` folder that gives concrete examples for how to create certain transitions and effects for your slides. You can also change the theme for your slides in the `index.html` file. 


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
