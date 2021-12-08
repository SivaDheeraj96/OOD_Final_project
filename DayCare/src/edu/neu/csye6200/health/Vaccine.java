package edu.neu.csye6200.health;

public class Vaccine {
	public static enum FREQUENCY{
		DAILY(0),
		WEEKLY(1),
		MONTHLY(2),
		QUARTERLY(3),
		YEARLY(4),
		ONLYONCE(5);
		
		private final int value;
	    private FREQUENCY(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	}
	private int id;
	private String name;
	private boolean isOptional;
	private FREQUENCY frequency;
	
	protected Vaccine(int id, String name, boolean isOptional,FREQUENCY frequency){
		this.id = id;
		this.name = name;
		this.isOptional = isOptional;
		this.frequency = frequency;
	}
	
	protected Vaccine(String data){
		this.id = -1;
		this.name = "";
		this.isOptional = false;
		this.frequency = FREQUENCY.ONLYONCE;
		
		
		String[] vals = data.split(",");
		
		try {
		this.id=Integer.parseInt(vals[0]);
		}
		catch(Exception e) {
			System.err.println("error parsing vaccine id"+vals[0]);
			e.printStackTrace();
		}
		this.name= vals[1];
		this.isOptional= Boolean.getBoolean(vals[2]);
		this.frequency = FREQUENCY.valueOf(vals[3]);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOptional() {
		return isOptional;
	}

	public void setOptional(boolean isOptional) {
		this.isOptional = isOptional;
	}

	public FREQUENCY getFrequency() {
		return frequency;
	}

	public void setFrequency(FREQUENCY frequency) {
		this.frequency = frequency;
	} 
	@Override
	public String toString() {
		return "id: "+this.getId()+" name: "+this.getName()+" isOptional: "+this.isOptional()+" frequency: "+this.getFrequency();
	}

}
