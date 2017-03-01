/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.rshelloworld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

/**
 * A simple CDI service which is able to say hello to someone
 *
 * @author Pete Muir
 *
 */
public class HelloService {

    String envVar(String env) {
        String value = System.getenv(env);
        if (value != null) {
            return String.format("%s=%s%n",
                    env, value);
        } else {
            return String.format("%s is"
                    + " not assigned.%n", env);
        }
    }

    String createHelloMessage(String name) {
        StringBuffer resultString = new StringBuffer();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return "PostgreSQL JDBC Driver not found ";
        }

        Connection connection = null;

        try {
            StringBuffer postgresUrl = new StringBuffer("jdbc:postgresql://");
            postgresUrl.append(String.format("%s:%s",System.getenv("POSTGRESQL_SERVICE_HOST"),
                    System.getenv(("POSTGRESQL_SERVICE_PORT"))));

            connection = DriverManager.getConnection(postgresUrl.toString());
//                    "jdbc:postgresql://127.0.0.1:5432/testdb", "mkyong",
//                    "123456");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return "Connection Failed! Check output console";

        }

        if (connection != null) {
            return ("Database connection made");
        } else {
            return("Failed to make connection!");
        }



//        Map<String, String> env = System.getenv();
//        for (String envName : env.keySet()) {
//            resultString.append(String.format("%s=%s%n\n",
//                    envName,
//                    env.get(envName)));
//        }
//        return resultString.toString();
    }

}
