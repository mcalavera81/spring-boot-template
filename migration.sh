#!/usr/bin/env bash

mvn -Dspring.profiles.active=migration spring-boot:run
##mvn process-test-resources -Pdb-diff
