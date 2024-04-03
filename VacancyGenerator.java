import java.util.ArrayList;
import java.util.Random;

public class VacancyGenerator {

    private static Random random = new Random();
    private String[] professions = new String[]{"Программист", "Аналитик", "Тестировщик"};

    private Vacancy generateVacancy(int maxSalary, String companyName) {
        int min = 5000;
        int salary = random.nextInt(maxSalary - min);
        salary += min; 
        String profession = professions[random.nextInt(professions.length)];
        return new Vacancy(companyName, salary, profession);
    }
    
    public ArrayList<Vacancy> generateVacancies(int maxSalary, String companyName, int number){
        ArrayList<Vacancy>generatedArray = new ArrayList<>();
        for (int index = 0; index < number; index++) {
            generatedArray.add(generateVacancy(maxSalary, companyName));
        }
        return generatedArray;
    }

}