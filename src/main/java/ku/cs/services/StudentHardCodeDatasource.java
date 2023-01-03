package ku.cs.services;

import ku.cs.models.StudentList;

public class StudentHardCodeDatasource {

    public StudentList readData() {
        StudentList list = new StudentList();
        list.addNewStudent("6410400001", "First");
        list.addNewStudent("6410400002", "Second");
        list.addNewStudent("6410400003", "Third");
        list.addNewStudent("6410400004", "Fourth");
        return list;
    }
}
