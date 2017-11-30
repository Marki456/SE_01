
public class Einweiser {
	Stellplatz[][] platz;
	Einweiser(int[] StellplaetzeproEtage){
		//suche gr��te Etage
		int max = 0;
		for(int i = 0; i < StellplaetzeproEtage.length;i++){
			if(max < StellplaetzeproEtage[i]){
				max = StellplaetzeproEtage[i];
			}
		}
		//legt Datenbank mit Stellplaetzen an
		Stellplatz[][] tmp = new Stellplatz[StellplaetzeproEtage.length-1][max];
		//streicht Stellplaetze  die in der Etage nicht vorkommen
		for(int i = 0; i < StellplaetzeproEtage.length; i++){
			for(int a = max-1; a>= StellplaetzeproEtage[i]-1;a--){
				tmp[i][a].changevergeben();
			}	
		}
		//Gibt exestierenden Stellplaetzen einen Namen nach dem Muster Etage.Stellpaltz+1  --> z.B. 0.1 --> Etage = 0 Stellplatz = 1
		for(int i = 0; i<tmp.length;i++){
			for(int a = 0; a<tmp[0].length;a++){
				tmp[i][a].setName(String.valueOf(i+"."+(a+1)));
			}
		}
		
		platz = tmp;
		
	}
	
	public String getStellplatz(){
		//sucht freien Stellplatz, belget diesen und gibt diesen zur�ck
		
		for(int i = platz.length-1; i >= 0;i--){
			for(int a = 0; a < platz[0].length;a++){
				if(platz[i][a].getvergeben()==false){
					platz[i][a].changevergeben();
					return platz[i][a].getName();
				}
			}
		}
		//Diese Ausgabe d�rfte nicht auftauchen und deutet auf Fehler innerhalb des Managers 
		return "No Free Spaces";
	}
	
	public void Stellplatzchange(String name){
		int i;
		int a;
		//ermittle die Postioin des Punktes im String
		int position =  0;
		for(int x = 0; x < name.length();x++){
			if(name.charAt(x) == '.'){
				position = x;
			}
		}
		i = Integer.parseInt(name.substring(0, position));
		a = Integer.parseInt(name.substring(position+1, name.length()));
		platz[i][a].changevergeben();
		
	}	
}
