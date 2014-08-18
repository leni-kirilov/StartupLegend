package com.kirilov.startuplegends.game;


import com.kirilov.startuplegends.game.model.Company;
import com.kirilov.startuplegends.game.model.Employee;
import com.kirilov.startuplegends.game.model.GameSetting;
import com.kirilov.startuplegends.game.model.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
         enter game length

         initial cash
         initial team - 3 friends with random characteristics and stats
            - salary, happiness, motivation, skills

         cash (decreases with time), time
         actions:
             - project actions - start, change quality vs innovation vs speed; stop and pivot;
                    - give name
             - investor - seek
             -

        events/crisis

        if reach over 100 000$ -> progress to next level

        GAME OVER

*/
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static Company company;
    private static GameSetting settings;
    public static List<String> events = new ArrayList<>();
    private static double managementBoost = 1.0;

    public static void main(String[] args) {
        displayGameTitle();
        settings = createGameSettings();
        company = createCompany();
        Project project = createProject();
        company.getProjects().add(project);

        playGame();
    }

    private static void playGame() {
        do {
            displayPlayScreen();
            pickAction();

            calculateIteration();

            displayEvents();
        } while (settings.moveToNextIteration() != -1);

        displayGameOver();
    }

    private static void calculateIteration() {
        paySalaries();
        progressProject();
    }

    private static void progressProject() {
        Project project = company.getProjects().get(0);

        int progress = 0;
        for (Employee e : company.getEmployees()) {
            progress += e.getSkill() * e.getMoodModifier();
        }
        project.setPercentageCompleted((int) (project.getPercentageCompleted() + progress * managementBoost));

        if (project.getPercentageCompleted() >= 100) {
            company.setCash(company.getCash() + project.getProfit());
            events.add(String.format("PROJECT %s is completed!", project.getName()));
        }
        managementBoost = 1.0;
    }

    private static void displayEvents() {
        System.out.println("======EVENTS=====");
        for (String event : events) {
            System.out.println(event);
        }
        events.clear();
    }

    private static void displayGameOver() {
        clearConsole();
        if (company.getCash() > 100_000) {
            System.out.println("YOU WIN!");
        } else {
            System.out.println("YOU LOSE!");
        }
    }

    private static void paySalaries() {
        long iterationSalaries = 0;
        for (Employee e : company.getEmployees()) {
            iterationSalaries += e.getSalaryPerIteration();
        }
        company.setCash(company.getCash() - iterationSalaries);
    }

    private static void displayPlayScreen() {
        clearConsole();
        displayCurrentIteration();
        displayCash();
        displayProjectStatus();
        displayTeamMembersStats();
        System.out.println("============================");

    }

    private static void displayProjectStatus() {
        Project p = company.getProjects().get(0);
        System.out.printf("Project %s ; Complete %d %%\n", p.getName(), p.getPercentageCompleted());
    }

    private static void displayTeamMembersStats() {
        System.out.println("====TEAM===");
        company.displayTeam();
        System.out.println("===========");
    }

    private static void displayCash() {
        System.out.format("CASH = $%s \n", company.getCash());
    }

    private static void displayCurrentIteration() {
        System.out.println("============================");
        System.out.print(company.getName());
        System.out.println("--- ITERATION " + settings.getCurrentIteration() + "/" + settings.getGameLengthInIterations());
    }

    private static void pickAction() {
        System.out.println("Actions list:");
        System.out.println("1) Do nothing.");
        System.out.println("2) Work more.");
        System.out.println("3) Fun more.");
        System.out.print("PICK ACTION: ");
        int actionId = scanner.nextInt();
        switch (actionId) {
            case 1: {
                break;
            }
            case 2: {
                //cycle through all employees and lower happiness (30%)
                // if employee happiness is below 0% -> it leaves the company -> decreasing work
                //increase project progress rate by 15%
                for (Employee e : company.getEmployees()) {
                    e.decreaseMood();
                }
                managementBoost = 1.3;
                break;
            }
            case 3: {
                //cycle through all employees and increase happiness (25%)
                //decrease project progress rate by 15%
                for (Employee e : company.getEmployees()) {
                    e.increaseMood();
                }
                managementBoost = 0.6;
                break;
            }
        }
    }

    private static void displayGameTitle() {
        System.out.println("============================");
        System.out.println("====   STARTUP LEGENDS =====");
        System.out.println("============================");
    }

    private static GameSetting createGameSettings() {
        System.out.print("ENTER GAME LENGTH IN MONTHS: ");
        GameSetting gameSetting = new GameSetting();
        gameSetting.setLengthInIterations(scanner.nextInt());
        return gameSetting;
    }

    private static Company createCompany() {
        System.out.print("ENTER COMPANY NAME: ");
        String companyName = scanner.next();
        Company company = new Company();
        company.setName(companyName);
        company.setCash(10000);
        return company;
    }


    private static Project createProject() {
        System.out.print("ENTER PROJECT NAME: ");
        String projectName = scanner.next();
        Project project = new Project();
        project.setName(projectName);
        return project;
    }

    public static void clearConsole() {
//        try {
//            final String os = System.getProperty("os.name");
//
//            if (os.contains("Windows")) {
//                Runtime.getRuntime().exec("Clear-Host");
//            } else {
//                Runtime.getRuntime().exec("clear");
//            }
//        } catch (final Exception e) {
//            //  Handle any exceptions.
//        }

        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
}
