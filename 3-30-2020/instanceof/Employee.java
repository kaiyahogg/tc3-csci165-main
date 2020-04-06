
/**
 Class Invariant: All objects have a name string and hire date.
 A name string of "No name" indicates no real name specified yet.
 A hire date of Jan 1, 1000 indicates no real hire date specified yet.
*/
public class Employee
{
    private String name;
    private Date hireDate;

    public Employee( ){
         name = "No name";
         hireDate = new Date("Jan", 1, 1000); //Just a placeholder.
    }

    public Employee(String theName, Date theDate){
        name = theName;
        hireDate = new Date(theDate);
    }

    public Employee(Employee originalObject){
         name = originalObject.name;
         hireDate = new Date(originalObject.hireDate);
    }

    public String getName( ){
        return name;
    }

    public Date getHireDate( ){
        return new Date(hireDate);
    }

    public void setName(String newName){
        if(newName != null)
            name = newName;
    }

    public void setHireDate(Date newDate){
        if (newDate != null)
            hireDate = new Date(newDate);
    }

    public String toString( ){
        return (name + " " + hireDate.toString( ));
    }

    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof Employee))return false;

        Employee otherEmployee = (Employee)otherObject;
        return (name.equals(otherEmployee.name) &&
               hireDate.equals(otherEmployee.hireDate));
    }
}
