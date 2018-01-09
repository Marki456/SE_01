
public class Schrankwaerter {
 boolean Schranke = false;
 //False = Schranke zu
 public void Schranke_schließen(){
	 Schranke = false;
 }
 public void Schranke_oeffnen(){
	 Schranke = true;
 }
 public boolean getSchranke(){
	 return Schranke;
 }
 
 public void einfahren() throws InterruptedException{
	 Schranke_oeffnen();

	 Thread.sleep(3000);

	 Schranke_schließen();
 }
 public void ausfahren(Kunde k) throws InterruptedException{
	 if(k.hatBezahlt()){
		 einfahren();
	 }
	 else{
		 //Bedingung wenn Kunde nicht bezahlt hat. Kann in diesem Szenario nicht auftreten
	 }
 }
 
}

