package edu.neu.csye6200.health;

import java.util.HashMap;
import java.util.Map;

import edu.neu.csye6200.FileUtil;
import edu.neu.csye6200.health.Vaccine.FREQUENCY;

//singleton class
public class VaccineDirectory {
	
	private VaccineDirectory() {}
	
	private static VaccineDirectory instance= null;
	private static final String vaccineFile = "edu/neu/csye6200/inputData/vaccine.txt"; 
	private static Map<Integer,Vaccine> data= new HashMap<Integer,Vaccine>();
	
	static {
		FileUtil.getFileData(vaccineFile).stream().map(x-> new Vaccine(x)).forEach(x-> data.put(x.getId(), x));
	}
	
	public void addVaccine(Integer id, String name, boolean isOptional, FREQUENCY frequency) {
		Vaccine vac  = new Vaccine (id,name,isOptional, frequency);
		data.put(vac.getId(),vac);
	}
	
	public Vaccine getVaccine(Integer id) {
		return data.get(id);
	}

	public static VaccineDirectory getInstance() {
		if(instance == null) {
			instance = new VaccineDirectory();
		} 
		return instance;
	}
	
	@Override
	public Object clone() 
	{
		return null;
	}
	
}
