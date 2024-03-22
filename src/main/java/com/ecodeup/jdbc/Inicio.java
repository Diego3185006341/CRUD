package com.ecodeup.jdbc;

public class Inicio {


    public static void main(String[] args) {


        // Call the method to query all clients
        EjemploJDBC.queryAllClientes();

        // Example usage of the insert method
        EjemploJDBC.insertCliente(45,"John", "Doe", "1234 Main St");


        EjemploJDBC.updateCliente(45,"jose","Ruiz","568 Main St");

        // Call the method to query all clients
        EjemploJDBC.queryAllClientes();

        EjemploJDBC.deleteCliente(45);

        // Call the method to query all clients
        EjemploJDBC.queryAllClientes();
    }
}
