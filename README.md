How to run with profile ?

```
// Test with embedded mongodb
$mvn clean install -Dspring.profiles.active=use-mongodb-embedded

// Test with Test mongodb
$mvn clean install -Dspring.profiles.active=test

// Test with Production mongodb
$mvn clean install -Dspring.profiles.active=production

```