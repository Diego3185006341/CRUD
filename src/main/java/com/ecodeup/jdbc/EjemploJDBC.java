package com.ecodeup.jdbc;

import java.sql.*;

public class EjemploJDBC {
    private static final String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "diego785";


    public static void queryAllClientes() {
        String query = "SELECT * FROM CLIENTE ORDER BY id";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " | " +
                        resultSet.getString("nombres") + " | " + resultSet.getString("apellidos")
                        + " | " + resultSet.getString("direccion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCliente(int id, String nombres, String apellidos, String direccion) {
        String insertQuery = "INSERT INTO CLIENTE (id, nombres, apellidos, direccion) VALUES (?, ?, ?,?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.setString(2, nombres);
            preparedStatement.setString(3, apellidos);
            preparedStatement.setString(4, direccion);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Insert successful!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCliente(int id, String nuevosNombres, String nuevosApellidos, String nuevaDireccion) {
        String updateQuery = "UPDATE CLIENTE SET nombres=?, apellidos=?, direccion=? WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, nuevosNombres);
            preparedStatement.setString(2, nuevosApellidos);
            preparedStatement.setString(3, nuevaDireccion);
            preparedStatement.setInt(4, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Update successful!");
            } else {
                System.out.println("No se encontró ningún cliente con el ID especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCliente(int id) {
        String deleteQuery = "DELETE FROM CLIENTE WHERE id=?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Delete successful!");
            } else {
                System.out.println("No se encontró ningún cliente con el ID especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}