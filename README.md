# RedUtilities

RedUtilities is a small Java toolkit for Minecraft plugin development. The preparation of the methods was designed for the application of RedstoneWorld plugins, but can be useful with any pattern.

# Development with RedUtilities

**Note:** Replace `%version%` with the latest version of RedUtilities:

[![Latest version of 'redutilities' @ Cloudsmith](https://api-prd.cloudsmith.io/v1/badges/version/redstoneworld/RedUtilities/maven/redutilities/latest/a=noarch;xg=de.redstoneworld.redutilities/?render=true&show_latest=true)](https://cloudsmith.io/~redstoneworld/repos/RedUtilities/packages/detail/maven/redutilities/latest/a=noarch;xg=de.redstoneworld.redutilities/)

## Usage with Maven

Add the following to your Java project `pom.xml` file:

```xml
<dependency>
    <groupId>de.redstoneworld.redutilities</groupId>
    <artifactId>redutilities</artifactId>
    <version>%version%</version>
</dependency>
```

## Usage with Gradle

Add the following to your Java project `build.gradle` file:

```text
repositories {
    maven {
        name = 'cloudsmith'
        url = 'https://dl.cloudsmith.io/public/redstoneworld/RedUtilities/maven/'
    }
}

dependencies {
    implementation 'de.redstoneworld.redutilities:redutilities:%version%'
}
```

# Javadoc

You can find the Javadoc of RedUtilities [here](https://redstoneworld.github.io/RedUtilities/javadoc).