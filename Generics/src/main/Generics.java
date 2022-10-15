package main;

public class Generics {
    public static void main(String args []){

        League<Team<CricketPlayer>> ipl = new League<>("IPL");

        Team<CricketPlayer> mi = new Team<>("MI");
        Team<CricketPlayer> csk = new Team<>("CSK");
        Team<CricketPlayer> rcb = new Team<>("RCB");
        Team<CricketPlayer> kkr = new Team<>("KKR");

        Team<BadmintonPlayer> india = new Team<>("India");

        CricketPlayer rohit = new CricketPlayer("Rohit Sharma");
        CricketPlayer sachin = new CricketPlayer("Sachin Tendulkar");
        CricketPlayer dhoni = new CricketPlayer("MS Dhoni");
        CricketPlayer jadeda = new CricketPlayer("Ravindra Jadeja");
        CricketPlayer virat = new CricketPlayer("Virat Kohli");
        CricketPlayer gambhir = new CricketPlayer("Gautam Gambhir");
        CricketPlayer pandya = new CricketPlayer("Hardik Pandya");
        CricketPlayer shubhman = new CricketPlayer("Shubhman Gill");

        BadmintonPlayer sindhu = new BadmintonPlayer("P V Sindhu");
        BadmintonPlayer saina = new BadmintonPlayer("Saina Nehwal");

        //mi.addMember(sindhu); - As this is the list of main.CricketPlayer , it won't allow you to add main.BadmintonPlayer.
        mi.addMember(rohit);
        mi.addMember(sachin);

        csk.addMember(dhoni);
        csk.addMember(jadeda);

        rcb.addMember(virat);
        rcb.addMember(pandya);

        kkr.addMember(gambhir);
        kkr.addMember(shubhman);

        india.addMember(sindhu);
        india.addMember(saina);

        mi.matchResult(csk,150,149);
        mi.matchResult(rcb,150,149);
        mi.matchResult(kkr, 11,12);

        rcb.matchResult(kkr,120,34);
        rcb.matchResult(csk, 120,124);

        csk.matchResult(mi,134,12);
        csk.matchResult(kkr, 34,90);

        ipl.addTeam(mi);
        ipl.addTeam(csk);
        ipl.addTeam(rcb);
        ipl.addTeam(kkr);

        ipl.showLeagueTable();
        //ipl.addTeam(india); - It wont allow you to add team India to ipl league as ipl is a league of cricketPlayer  main.League<main.Team<main.CricketPlayer>>.
    }
}
