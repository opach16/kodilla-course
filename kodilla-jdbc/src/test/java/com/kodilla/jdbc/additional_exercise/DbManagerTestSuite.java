package com.kodilla.jdbc.additional_exercise;

import com.kodilla.jdbc.DbManager;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DbManagerTestSuite {

    @Test
    void testConnect() {
        //given
        //when
        DbManager dbManager = DbManager.getInstance();

        //then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //given
        DbManager dbManager = DbManager.getInstance();

        //when
        String sqlQuery = """
                SELECT U.FIRSTNAME, U.LASTNAME, I.SUMMARY
                FROM USERS U
                JOIN ISSUES I ON U.ID = I.USER_ID_ASSIGNEDTO
                """;
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME") + ", " +
                    rs.getString("SUMMARY"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(18, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        //given
        DbManager dbManager = DbManager.getInstance();

        //when
        String sqlQuery = """
                SELECT U.FIRSTNAME, U.LASTNAME
                FROM USERS U JOIN POSTS P ON U.ID = P.USER_ID
                GROUP BY P.USER_ID
                HAVING COUNT(*) >= 2;
                """;
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(2, counter);
    }
}
