

public interface Publisher {

    //void sendOffer(String companyName, int salary);

    void sendOffer(Vacancy vacancy);

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void showJobSeekers();


}