import org.springframework.jdbc.core.RowMapper;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenericRowMapper<T> implements RowMapper<T> {

    private final Class<T> type;

    public GenericRowMapper(Class<T> type) {
        this.type = type;
    }

    @Override
    public T mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            T instance = type.getDeclaredConstructor().newInstance();
            Field[] fields = type.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = rs.getObject(field.getName());
                field.set(instance, value);
            }
            return instance;
        } catch (Exception ex) {
            throw new SQLException("Error mapping row to " + type.getSimpleName(), ex);
        }
    }
}
