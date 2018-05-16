### Features
* Spring Boot 2.0.2.RELEASE
* Working with MongoDB
* Testing with Embedded MongoDB
* Services and Controller testing
* Switching profie
* Code coverage with Jacoco (Separate result between Unit tests and Integration tests)

### How to run with profile ?

```
// Test with embedded mongodb
$mvn clean install -Dspring.profiles.active=use-mongodb-embedded

// Test with Test mongodb
$mvn clean install -Dspring.profiles.active=test

// Test with Production mongodb
$mvn clean install -Dspring.profiles.active=production

```

### References
* [Link 1](https://github.com/Godin/sonar-experiments/blob/master/jacoco-examples/maven-failsafe-plugin-example/pom.xml)
* [Link 2](https://github.com/mvpjava/springboot-IntegrationTests-Tutorial)
* [Link 3](https://github.com/piczmar/maven-jacoco-remote)

