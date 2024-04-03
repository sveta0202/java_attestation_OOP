import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;


public class Vacancy {

    private int salary;
    private String profession;
    private String companyName;
    private ArrayList<Observer>candidates = new ArrayList<>();
    private String status;

    public Vacancy(String companyName, int salary, String profession){
        this.companyName = companyName;
        this.salary = salary;
        this.profession = profession;
        this.status = "открыта";
    }

    public void addCandidates(Observer candidate) {
        candidates.add(candidate);
    }

    public LinkedList<Observer> getCandidates() {
        sortCandidates();
        return new LinkedList<Observer>(candidates);
    }


    public ArrayList<Observer> getOldCandidates() {
        return this.candidates;
    }

    public String getProfession() {
        return profession;
    }

    public int getSalary() {
        return salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setClose() {
        this.status = "закрыта";
    }

    private void sortCandidates(){
        Comparator<Observer> comparator = Comparator.comparing(obj -> obj.getQualification());
        candidates.sort(comparator.reversed());
    }

    public String toString() {
        return String.format("Вакансия - %s - %s; должность - %s ; зарплата: %d руб." , this.companyName, this.status, this.profession, this.salary);
     }

}