package com.company;

import com.csvreader.CsvReader;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Main {

    public static void main(String[] args) throws CsvReader.CatastrophicException, IOException, CsvReader.FinalizedException, URISyntaxException {
        Reader readerRoles = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("roles.csv").toURI()));
        CsvReader roles = new CsvReader(readerRoles);
        roles.readHeaders();

        Reader readerAccounts = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("accounts.csv").toURI()));
        CsvReader accounts = new CsvReader(readerAccounts);
        accounts.readHeaders();


        HashMap<String, Role> Roles = new HashMap<String, Role>();
        while (roles.readRecord()) {
            String roleName = roles.get("roles");
            String privilage = roles.get("privilages");
            List<String> privilages = new ArrayList<String>();
            privilages.add(privilage);

            if (Roles.containsKey(roleName)) {
                Roles.get(roleName).addPrivilage(privilage);
            } else {
                Role anyRole = new Role(roleName, privilages);
                Roles.put(roleName, anyRole);
            }
        }


        HashMap<String, Account> Accounts = new HashMap<String, Account>();
        while (accounts.readRecord()) {
            String accountName = accounts.get("account");
            String firstName = accounts.get("firstName");
            String lastName = accounts.get("lastName");
            String email = accounts.get("email");
            String roleName = accounts.get("role");
            List<String> roller = new ArrayList<String>();
            roller.add(roleName);

            if (Accounts.containsKey(accountName)) {
                Accounts.get(accountName).addRoles(roleName);
            } else {
                Account anyAccount = new Account(accountName, firstName, lastName, email, roller);
                Accounts.put(accountName, anyAccount);
            }
        }


        for (Map.Entry<String, Role> eachRole : Roles.entrySet()) { // to iterate and print which role includes the others,and finding out which accounts have

            for (Map.Entry<String, Role> eachRole2 : Roles.entrySet()) {

                    if (eachRole2.getValue().getPrivilages().containsAll(eachRole.getValue().getPrivilages())) {

                        if (!eachRole.getValue().getRole().equals(eachRole2.getValue().getRole())) {
                            System.out.println("\n"+eachRole2.getValue().getRole() + " includes " + eachRole.getValue().getRole() + ":");

                            for (Map.Entry<String, Account> eachAccount : Accounts.entrySet()) {
                                if (eachAccount.getValue().getRoles().contains(eachRole2.getValue().getRole()) && eachAccount.getValue().getRoles().contains(eachRole.getValue().getRole())) {
                                    System.out.println(eachAccount.getValue().getAccount()+" has "+eachRole2.getValue().getRole()+" "+eachRole.getValue().getRole());
                                }
                            }
                        }
                    }
            }
        }
    }
}
