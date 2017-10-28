 webpack is a module bundler for modern JavaScript applications.
 When webpack processes your application, it recursively builds a dependency graph that includes every module your application needs, 
 then packages all of those modules into a small number of bundles - often only one - to be loaded by the browser.
 
 webpack is used to compile JavaScript modules.
 
 
 webpack creates a graph of all of your application's dependencies. The starting point of this graph is known as an entry point. The entry point tells webpack where to start and follows the graph of dependencies to know what to bundle. 
 
  define entry points using the entry property in our**webpack configuration object.**
  
  #### webpack.config.js

    module.exports = {
      entry: './path/to/my/entry/file.js'
    };
