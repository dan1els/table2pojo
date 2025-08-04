# Table2Pojo

Simple tool to generate POJO classes from database tables/columns. ###

Supports all JDBC supported databases. Includes following JDBC drivers: 
- Oracle 
- MySQL 
- PostgreSQL 

JDBC drivers can be added/updated in `build.gradle` file. 

## Build

Use gradle to build and assemble jar files with dependencies. 
```bash
gradle shadowJar
```

## Run

Configure the database connection properties in `db.properties` file in current directory: 

```
driver=oracle.jdbc.OracleDriver
url=jdbc:oracle:thin:@localhost:1521:orcl
username=dbusername
password=dbpassword
```

Run the jar with arguments. 
```bash
java -jar build/libs/table2pojo-all.jar <options>
```

## Options 

Option | Description
-------|------------
h | help 
a | generate POJOs for all the tables in database  
t | list of database tables delimited by ; (semicolon). overrides `a` option 
p | (optional) java package name of the POJOs. If not specified, default/blank package will be used. 
d | (optional) target directory where POJOs (.Java files) are generated. If not specified, current directory will be used 


## Gradle plugin

Compile fatJar

Put jar in `libs` folder. 

Configure your gradle project:

```kotlin
import com.kumarvv.table2pojo.gradle.Table2PojoExt
import com.kumarvv.table2pojo.gradle.Table2PojoPlugin
import com.kumarvv.table2pojo.model.ConnectionPrefs
import com.kumarvv.table2pojo.model.UserPrefs

buildscript {
    dependencies {
        classpath(files("libs/table2pojo-1.0-all.jar"))
    }
}


apply {
    plugin(Table2PojoPlugin::class.java)
}

sourceSets {
    main {
        kotlin {
            srcDirs(srcDirs.map { it.path })
        }
        java {
            srcDirs("${layout.buildDirectory.get()}/generated/main/java")
        }
    }
}

val databaseUrl = project.findProperty("databaseUrl").toString()
val databaseUser = project.findProperty("databaseUser").toString()
val databasePassword = project.findProperty("databasePassword").toString()
val databaseDriver = project.findProperty("databaseDriver").toString()


configure<Table2PojoExt> {
    userPrefs = UserPrefs()
    userPrefs.dir = "${layout.buildDirectory.get()}/generated/main/java"
    userPrefs.tables = arrayOf("FOO")
    userPrefs.pkg = "com.example.pojo"
    connectionPrefs = ConnectionPrefs()
    connectionPrefs.url = databaseUrl
    connectionPrefs.username = databaseUser
    connectionPrefs.password = databasePassword
    connectionPrefs.driver = databaseDriver
}

```