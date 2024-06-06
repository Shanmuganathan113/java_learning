import org.springframework.jdbc.core.ResultSetExtractor;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericResultSetExtractor<T> implements ResultSetExtractor<List<T>> {

    private final Class<T> type;

    public GenericResultSetExtractor(Class<T> type) {
        this.type = type;
    }

    @Override
    public List<T> extractData(ResultSet rs) throws SQLException {
        List<T> results = new ArrayList<>();
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            Map<String, Field> fieldMap = new HashMap<>();

            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                fieldMap.put(field.getName().toLowerCase(), field);
            }

            while (rs.next()) {
                T instance = type.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i).toLowerCase();
                    Field field = fieldMap.get(columnName);
                    if (field != null) {
                        Object value = rs.getObject(i);
                        field.set(instance, value);
                    }
                }
                results.add(instance);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new SQLException("Failed to map result set to type " + type.getName(), e);
        }
        return results;
    }
}
