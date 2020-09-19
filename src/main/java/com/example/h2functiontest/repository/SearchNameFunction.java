package com.example.h2functiontest.repository;

import java.sql.*;

public class SearchNameFunction {
    private static final String BASE_QUERY = "SELECT id, name, rank FROM theschema.foo";

    public static ResultSet searchName(final Connection conn, final String name, final Integer limit) throws SQLException {
        String url = conn.getMetaData().getURL();
        /*
         * H2 Calls this function twice in a prepared statement; once for preparing it and working out types, and once
         * during execution. In the former, the URL is "jdbc:columnlist:connection" so we can do a 0 row select and
         * return that
         */
        if (url.equals("jdbc:columnlist:connection")) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(BASE_QUERY + " limit 0");
            return rs;
        }

        String query = BASE_QUERY + " WHERE name ILIKE ? || '%' ORDER BY RANK ASC LIMIT ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, name);
        statement.setInt(2, limit);
        return statement.executeQuery();
    }
}
