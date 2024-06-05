import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class ResultSetMapper {
    
    public static <T> List<T> mapResultSetToObject(ResultSet rs, Class<T> outputClass) throws Exception {
        List<T> outputList = new ArrayList<>();

        if (rs != null) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            while (rs.next()) {
                T bean = outputClass.getDeclaredConstructor().newInstance();

                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnLabel(i);
                    Object columnValue = rs.getObject(i);

                    // Using reflection to set the field in the DTO
                    var field = outputClass.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(bean, columnValue);
                }

                outputList.add(bean);
            }
        }

        return outputList;
    }
}
