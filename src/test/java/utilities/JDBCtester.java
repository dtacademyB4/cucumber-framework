package utilities;

import java.sql.*;

public class JDBCtester {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://dtdatabase.c6qqyddfk30u.us-east-2.rds.amazonaws.com/employees";
        String username = "duotech";
        String password = "duotech2020";

        Connection connection = DriverManager.getConnection(url, username, password);

        System.out.println("Connection is successful");

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet resultSet = statement.executeQuery("select * from employees limit 20");



//        resultSet.next();
//
//        System.out.println(resultSet.getObject(2));
//        // In JDBC indexes start from 1
//
//        resultSet.next();
//        resultSet.next();
//        System.out.println(resultSet.getObject("dept_name"));

//        while(resultSet.next()){
//            System.out.println(resultSet.getObject("dept_name"));
//        }

//        resultSet.next();
//        System.out.println(resultSet.getRow());
//
//        resultSet.next();
//        resultSet.next();

        resultSet.first();
        System.out.println(resultSet.getRow());
        resultSet.last();
        System.out.println(resultSet.getRow());
        resultSet.last();
        int noOfRows = resultSet.getRow();

        resultSet.absolute(5);
        System.out.println(resultSet.getObject("last_name"));

        ResultSetMetaData metaData = resultSet.getMetaData();

        int columnCount = metaData.getColumnCount();

        System.out.println(columnCount);

        System.out.println(metaData.getColumnName(1));

        for (int i = 1; i <= columnCount; i++) {
            System.out.print(metaData.getColumnName(i) + " ");
        }
        System.out.println();

        resultSet.first();




        // to update data on the db use executeUpdate()
        statement.executeUpdate("update employees set last_name=\"Obama\", first_name=\"Barack\" where emp_no=10001");

        resultSet = statement.executeQuery("select * from employees limit 20");
        resultSet.first();

        for (int i = 1; i <= noOfRows ; i++) {


            for (int j = 1; j <= columnCount; j++) {

                System.out.print(resultSet.getObject(j) + "\t");
            }
            System.out.println();
            resultSet.next();

        }
    }
}
