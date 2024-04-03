import java.util.ArrayList;

public class Company {

    private String name;
    private Publisher jobAgency;
    private int maxSalary;
    private ArrayList<Vacancy> openVacancies = new ArrayList<>();
    private VacancyGenerator vacancyGenerator = new VacancyGenerator();
    private int numbVac = 3;

    public Company(String name, Publisher jobAgency, int maxSalary){
        this.jobAgency = jobAgency;
        this.name = name;
        this.maxSalary = maxSalary;
        this.openVacancies = vacancyGenerator.generateVacancies(maxSalary, name, numbVac);
    }

    public void needEmployee(){
        if (openVacancies.size() > 0) {
            for (Vacancy x : openVacancies) {
            jobAgency.sendOffer(x);
            }
        } else System.out.println("У компании " + this.name + " сейчас нет вакансий");
        System.out.print("-------------\n");
    }


    public ArrayList<Observer> hireCandidates(){
        ArrayList<Observer> hiredObservers = new ArrayList<>();
        int skip = 0;
        int extSkip = 0;
        for (Vacancy x : openVacancies) {
            if (x.getCandidates().size() > 0) {
                hiredObservers.add(x.getCandidates().getLast());
                String check = x.getCandidates().getLast().getName();
                boolean flag = false;
                for (Vacancy i : openVacancies){
                    for (Observer j : i.getCandidates()){
                        if (j.getName() == check && skip <= 0){
                            if (flag == true) i.getOldCandidates().remove(j);
                            flag = true;
                        }
                    }
                    skip-=1;
                } 
            extSkip += 1;
            skip = extSkip;
            x.setClose();    
            }
        }
        for (Vacancy s : openVacancies) {
            if (s.getCandidates().size() > 0) {
                s.getCandidates().getLast().hiredStatus();
        }
        }           
        return hiredObservers;
    }



    public void hireAndRemove(){
        for (Observer x : hireCandidates()) {
            jobAgency.removeObserver(x);
        }
    }


    public void showOpenVacancies(){
        if (openVacancies.size() == 0) System.out.println("У компании " + name + " нет вакансий на данный момент");
        else {
            for (Vacancy vacancy : this.openVacancies) {
                System.out.println(vacancy);
                for (Observer x : vacancy.getCandidates()) {             
                    System.out.print(x);
                }
            }
        }
        System.out.println("------------");
    }
}