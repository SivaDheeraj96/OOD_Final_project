/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.health;

import edu.neu.csye6200.Person;
import java.util.Date;

/**
 *
 * @author dheeraj
 */
public class ImmunizationController {
    private ImmunizationModel model;
    private ImmunizationView view;
    
    
    public ImmunizationController(ImmunizationModel model, ImmunizationView view){
        this.model = model;
        this.view = view;
    }
    
    public void addVaccine(int id, String name, Vaccine.FREQUENCY frequency, boolean isOptional)
    {
        this.model.getVaccineDirectory().addVaccine(id, name, frequency, isOptional);
    }
    
    public void removeVaccine(Vaccine vaccine)
    {
        this.model.getVaccineDirectory().removeVaccine(vaccine);
    }
    
    public void modifyVaccine(Vaccine oldVaccine, Vaccine newVaccine)
    {
        this.model.getVaccineDirectory().modifyVaccine(oldVaccine, newVaccine);
    }
    
    
    
    
    public void addVaccineRecord(int id, Vaccine vaccine, Person person, Date recievedDate)
    {
        this.model.addVaccineRecord(id, vaccine, person, recievedDate);
    }
    
    public void removeVaccineRecord(VaccineRecord vaccine)
    {
        this.model.removeVaccineRecord(vaccine);
    }
    public void modifyVaccineRecord(VaccineRecord oldVaccineRecord, VaccineRecord newVaccineRecord)
    {
        this.model.modifyVaccineRecord(oldVaccineRecord, newVaccineRecord);
    }
}
