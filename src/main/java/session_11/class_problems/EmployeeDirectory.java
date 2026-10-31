import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDirectory {
    public static class Record {
        public String employeeId;
        public String department;

        public Record(String employeeId, String department) {
            this.employeeId = employeeId;
            this.department = department;
        }
    }

    public static Map<String, String> buildLookup(List<Record> records) {
        Map<String, String> lookup = new HashMap<>();
        for (Record record : records) {
            lookup.put(record.employeeId, record.department);
        }
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }
}