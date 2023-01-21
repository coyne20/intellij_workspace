package in.bushansirgur.springbootjdbc.service;

import in.bushansirgur.springbootjdbc.DAO.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired //used for injecting another class instance as a parameter
    public EmployeeService(@Qualifier("mysql") EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

}
