public interface Observer {
    void receiveOffer(String nameCompany, int salary);

    void receiveOffer(Vacancy vacancy);
    
    String getProfession ();

    String getQualification();

    String getName();

    public void hiredStatus();

}