# Jakarta Bean Validation Utilities &middot; [![GitHub Workflow Status (with event)](https://img.shields.io/github/actions/workflow/status/seart-group/jakarta-validation-utils/package.yml)](https://github.com/seart-group/jakarta-validation-utils/actions/workflows/package.yml) [![Maven Central](https://img.shields.io/maven-central/v/ch.usi.si.seart/jakarta-validation-utils)](https://central.sonatype.com/artifact/ch.usi.si.seart/jakarta-validation-utils) [![javadoc](https://javadoc.io/badge2/ch.usi.si.seart/jakarta-validation-utils/javadoc.svg)](https://javadoc.io/doc/ch.usi.si.seart/jakarta-validation-utils) [![MIT license](https://img.shields.io/github/license/seart-group/jakarta-validation-utils)](https://github.com/seart-group/jakarta-validation-utils/blob/master/LICENSE)

This library provides several custom validation annotations:

- ASCII-only strings
- Alphanumeric strings
- Null or non-blank strings
- OWASP-compliant emails
- Custom password requirements
- BCrypt and SHA hash values
- GitHub Personal Access Tokens (PATs)

## Requirements

Requires a minimum of Java 8.

## Using the current version

To use the most recent version, simply include the library with the latest version of the Jakarta Validation API,
for example:

```xml
<dependencies>
  <dependency>
    <groupId>jakarta.validation</groupId>
    <artifactId>jakarta.validation-api</artifactId>
    <version>3.0.2</version>
  </dependency>
  <dependency>
    <groupId>ch.usi.si.seart</groupId>
    <artifactId>jakarta-validation-utils</artifactId>
    <version>${project.version}</version>
  </dependency>
</dependencies>
```

## Using the legacy version

If you are still using the previous major release of Jakarta Validation API (i.e. you are using Spring Boot 2),
then you will need to include the alternative dependency:

```xml
<dependencies>
  <dependency>
    <groupId>jakarta.validation</groupId>
    <artifactId>jakarta.validation-api</artifactId>
    <version>2.0.2</version>
  </dependency>
  <dependency>
    <groupId>ch.usi.si.seart</groupId>
    <artifactId>jakarta-validation-utils-legacy</artifactId>
    <version>${project.version}</version>
  </dependency>
</dependencies>
```

## Migrating from legacy

Aside from upgrading your Jakarta Validation API (or its dependents),
you will only need to change the `artifactId` from `jakarta-validation-utils-legacy` to `jakarta-validation-utils`.
No other code changes required.
