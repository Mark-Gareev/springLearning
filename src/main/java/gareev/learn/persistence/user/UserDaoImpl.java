package gareev.learn.persistence.user;

import gareev.learn.domain.User;
import gareev.learn.persistence.UserDao;
import gareev.learn.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    final private NamedParameterJdbcTemplate template;

    public UserDaoImpl(@Autowired NamedParameterJdbcTemplate h2JdbcTemplate) {
        this.template = h2JdbcTemplate;
    }

    @Override
    public Long count() {
        Long count = template.queryForObject("select count(*) from users", new HashMap<>(), Long.class);
        return count != null ? count : 0L;
    }

    @Override
    public List<User> getUsers() {
        HashMap<String, Object> map = new HashMap<>(0);
        String sql = "select * from users";
        return template.query(sql, map, BeanPropertyRowMapper.newInstance(User.class));
    }


    @Override
    public User findUserById(Long id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        String sql = "select * from users where id= :id";
        return template.queryForObject(sql, map, new UserMapper());
    }

    @Override
    public User createUser(User user) {
        Long count = count();
        Map<String, Object> params = new HashMap<>();
        params.put("id", count);
        params.put("name", user.getName());
        params.put("age", user.getAge());
        params.put("birth_date", DateUtil.toSqlDate(user.getBirthDate()));
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template.getJdbcTemplate()).withTableName("users");
        insert.execute(params);
        return findUserById(count);
    }
}

class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("ID");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        LocalDate birthDate = DateUtil.fromSqlDate(rs.getDate("birth_date"));
        User user = new User();
        user.setId(id);
        user.setAge(age);
        user.setName(name);
        user.setBirthDate(birthDate);
        return user;
    }
}
