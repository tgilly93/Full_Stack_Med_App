package com.techelevator.dao;

import com.techelevator.model.Office;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcOfficeDao implements OfficeDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcOfficeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Office getOfficeById(int officeId) {
        String sql = "SELECT * FROM Office WHERE office_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        if (results.next()) {
            return mapRowToOffice(results);
        }
        return null;
    }

//    @Override
//    public List<Office> getAllOffices() {
//        List<Office> offices = new ArrayList<>();
//        String sql = "SELECT * FROM Office";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
//        while (results.next()) {
//            offices.add(mapRowToOffice(results));
//        }
//        return offices;
//    }
//
//    @Override
//    public boolean updateOffice(Office office) {
//        String sql = "UPDATE Office SET office_name = ?, office_phone_number = ?, office_address = ?, office_city = ?, state = ?, zip_code = ?, office_open = ?, office_close = ? WHERE office_id = ?";
//        return jdbcTemplate.update(sql, office.getOfficeName(), office.getOfficePhoneNumber(), office.getOfficeAddress(), office.getOfficeCity(), office.getState(), office.getZipCode(), office.getOfficeOpen(), office.getOfficeClose(), office.getOfficeId()) > 0;
//    }
//
//    @Override
//    public boolean addOffice(Office office) {
//        String sql = "INSERT INTO Office (office_name, office_phone_number, office_address, office_city, state, zip_code, office_open, office_close) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        return jdbcTemplate.update(sql, office.getOfficeName(), office.getOfficePhoneNumber(), office.getOfficeAddress(), office.getOfficeCity(), office.getState(), office.getZipCode(), office.getOfficeOpen(), office.getOfficeClose()) > 0;
//    }

    private Office mapRowToOffice(SqlRowSet rs) {
        return new Office(
                rs.getInt("office_id"),
                rs.getString("office_name"),
                rs.getString("office_phone_number"),
                rs.getString("office_address"),
                rs.getString("office_city"),
                rs.getString("state"),
                rs.getString("zip_code"),
                rs.getString("office_open"),
                rs.getString("office_close")
        );
    }
}
