

How to define my directory from the project:


Reading a specific file:
-----------------
    String fileContents = new File('/path/to/file').getText('UTF-8')

    new File() // is relative to the current position.

The absolute path is related to the ClassLoader() definition or to the full path of the file in the local file system.


Using the ClassLoader():
-----------------

      URL url = this.getClass().getClassLoader().getResource(templateName) // the 'templateName should be set in the resources dir in the IntellijIdea project.
      String content = new String(Files.readAllBytes(Paths.get(url.path)))
      def engine = new XmlTemplateEngine()
      def model = [repo: repo, externalRepoPath: externalRepoPath, repoIdInMavenFile: repoIdInMavenFile]
      engine.createTemplate(content).make(model)
