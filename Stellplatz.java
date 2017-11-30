
public class Stellplatz {
	private boolean vergeben = false;
	private String bezeichnung = "";
	
	public boolean getvergeben(){
		return vergeben;
	}
	
	public void changevergeben(){
		if(vergeben == false){
			vergeben = true;
		}
		else{
			vergeben = false;
		}
	}
	
	public String getName(){
		return bezeichnung;
	}
	public void setName(String Name){
		bezeichnung = Name;
	}
	
}
