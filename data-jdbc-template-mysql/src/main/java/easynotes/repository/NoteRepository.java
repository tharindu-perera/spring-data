package easynotes.repository;

import easynotes.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@Repository
public class NoteRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> findAll() {
        String query = "select *  from Employee  ";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public void save(Employee employee) {
        String query = "insert into Employee (id, name, role) values (?,?,?)";

        Object[] args = new Object[]{employee.getId(), employee.getName(), employee.getRole()};

        int out = jdbcTemplate.update(query, args);

        if (out != 0) {
            System.out.println("data.Employee saved with id=" + employee.getId());
        } else System.out.println("data.Employee save failed with id=" + employee.getId());
    }


    public Employee getById(Long id) {
        String query = "select id, name, role from Employee where id = ?";
        //using RowMapper anonymous class, we can create a separate RowMapper for reuse
        Employee emp = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Employee>() {

            public Employee mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setRole(rs.getString("role"));
                return emp;
            }
        });

        return emp;
    }
}