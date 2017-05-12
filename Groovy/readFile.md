

How to define my directory from the project:


Reading a specific file:
-----------------
String fileContents = new File('/path/to/file').getText('UTF-8')


The new File()
is relative to the current position.

The absolute path is related to the ClassLoader() definition.


Using the ClassLoader():
-----------------

      URL url = this.getClass().getClassLoader().getResource(templateName)
      String content = new String(Files.readAllBytes(Paths.get(url.path)))
      def engine = new XmlTemplateEngine()
      def model = [repo: repo, externalRepoPath: externalRepoPath, repoIdInMavenFile: repoIdInMavenFile]
      engine.createTemplate(content).make(model)
