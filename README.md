# SpringBoot-Mongodb-project
A Restful webservice  using SpringBoot and mongodb.

Steps :
step 1: mongodb and intellij or eclispse should be installed in system.
  link to download mongodb -> https://www.mongodb.com/download-center/community
  link to download intellij -> https://www.jetbrains.com/idea/download/#section=windows
  link to download eclipse -> https://www.eclipse.org/downloads
step 2: spring plugin should be installed in your selected editor
step 3: create a spring started booter project 
        GroupId, ArtifcatId, project name, project description should be filled while creating the project.
step 4: select dependencies 
        for this project selecet web and mongodb dependency and click next.The project is created with nessceary jar files and libraries.
step 5: In pom.xml you can verify the dependencies you included.
step 6: To link mongodb to the project write the following code in application.properties which is under resources folder.
        spring.data.mongodb.uri=mongodb://localhost:27017/test
        ## Here test is the Database name creadted in mongodb.
step 7: create a new class Student under com.example.demo.model package and put the above code       
 
  
