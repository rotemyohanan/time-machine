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


### Output


Once you've bundled all of your assets together, you still need to tell webpack where to bundle your application. 

The webpack output property tells webpack how to treat bundled code.

    webpack.config.js

    const path = require('path');

    module.exports = {
      entry: './path/to/my/entry/file.js',
      output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'my-first-webpack.bundle.js'
     }
    };
    
    
#### Loaders
The goal is to have all of the assets in your project be webpack's concern and not the browser's (though, to be clear, this doesn't mean that they all have to be bundled together). 
webpack treats every file (.css, .html, .scss, .jpg, etc.) as a module. However, webpack itself only understands JavaScript.

