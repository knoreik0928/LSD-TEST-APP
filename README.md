# LSD-TEST-APP

This application is multi-module Gradle project.
Currently, the only subproject is SystemMonitor-Wkr which is a web application that uses Jersey
to provide REST services. The application provides a REST API that shows the Git hash, which indicates
the exact version of the code used in the building of the binary. In future work, a client will be
added to the code to perform integration tests as part of the pipeline.

The application is coded to use Java 8. It uses JUnit to run unit tests.
It will use TestNG to run integration tests.
