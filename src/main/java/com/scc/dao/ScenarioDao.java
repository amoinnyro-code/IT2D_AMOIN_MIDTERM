package com.scc.dao;

import com.scc.model.ScenarioEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScenarioDao {

    public void addRecord(ScenarioEntity entity) {
        String sql = "INSERT INTO vehicles (model_name, plate_no, daily_rate, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, entity.getModelName());
            pstmt.setString(2, entity.getPlateNo());
            pstmt.setDouble(3, entity.getDailyRate());
            pstmt.setString(4, entity.getStatus());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting record: " + e.getMessage());
        }
    }

    public List<ScenarioEntity> getAllRecords() {
        List<ScenarioEntity> entities = new ArrayList<>();
        String sql = "SELECT id, model_name, plate_no, daily_rate, status FROM vehicles";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ScenarioEntity entity = new ScenarioEntity(
                        rs.getInt("id"),
                        rs.getString("model_name"),
                        rs.getString("plate_no"),
                        rs.getDouble("daily_rate"),
                        rs.getString("status")
                );
                entities.add(entity);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching records: " + e.getMessage());
        }

        return entities;
    }
}