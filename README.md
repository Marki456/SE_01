Wenn ein Auto vorfährt muss das Parkhaus die Schranken öffnen sofern es nicht voll ist.<br> 
Wenn ein Auto im Parkhaus Einfährt muss es einen Platz zugewiesen bekommen.<br>
Wenn ein Auto das Parkhaus verlassen möchte muss es Zahlen.<br>
Wenn ein ein Auto das Parkhaus verlässt muss der Platz frei gegeben werden.<br>

Stakeholder sind: <br>
Intern:Mitarbeiter aktiv,Manager passiv,Systembetreiber passviv<br>
Extern: Kunden aktiv<br>
Nutzen:<br>
Kunden sind Nutznießer des Parkhauses<br>
Mitarbeiter verdienen ihr Gehalt <br>
Manager erzielt Kalk. Gehalt<br>
Systembetreiber wird bezahlt<br>
Verbesserung:<br>
Kunden können näher an ihrem Ziel Parken<br> 
Der Manager kann effizienter Kunden Betreuen durch die Digitale Arbeit<br>
Disruption:<br>
Mitarbeiter werden durch Algorithmen verdrängt das ist disruptiv<br>
Kommunkiationsplan:<br>
Mitarbeiter müssen gefeuert Werden<br>
Systembetreiber müssen ein Ergonomisches System aufbauen bzw. die Ergonomie muss definiert werden<br>

1:Als reisender möchte ich mein auto eine Woche Parken um es sicher in der nähe des Reiseanfangs zu Parken.<br>
2:Als Pendler Parke ich mein Auto jeden Tag 8 Stunden weil es nah an der Arbeit liegt der Arbeit.<br>
3:Als Frau Parke ich mein Auto in einem Parkhaus weil ich mich dort sicherer fühle als auf offenen Parkplätzen.<br>
4:Als Kunde möchte ich wissen wie viel ich bezhalen muss, um meine Schulden zu begleichen.<br>
5:Als Kunde benötige ich ein Parkhaus um mein Auto vor Witterung zu schützen.<br>
6:Als Fahrlehrer Möchte Parkhaus nutzen um meine Fahrschüler auf Enge Parklücken zu trainieren.<br>
7:Als Behinderter benötige ich Parkpklätze die Groß genug sind für mich um einzuparken.<br>
8:Als Kunde möchte einen Freien Parkplatz zugewiesen bekommen ,weil ein besetzter Parkplatz mir nichts bringt.<br>
9:Als Kunde muss ich wissen ob das Parkhaus Voll ist ,weil ich es sonst umsonst betreten könnte.<br>
10:Als Kunde möchte ich das sich die Schranke beim verlassen des Parkhauses öffnet wenn ich bezahlt habe um es zu verlassen.<br>




---------------------------------<br>
<br>
<br>
public interface Platzwirdgespert{<br>
Einweiser einweisen;<br>
<br>
@Override<br>
boolean platzwirdgespert();<br>
}<br>
<br>
----<br>
<br>
import static org.junit.Assert.*;<br>
<br>
import org.junit.Assert;<br>
import org.junit.Test;<br>
<br>
public class platzwirdgespertTest implements Platzwirdgespert{<br>
	public boolean platzwirdgespert() {<br>
		return (einweisen.testePlatzobfrei(einweisen.suchePlatz()));<br>
	}<br>
	<br>
	public void platztest_platzwirdgespert_Returnsfalse(){<br>
	assertFalse(platzwirdgespert());	<br>
	}<br>
}<br>
<br>
----<br>
public interface Parkhausvoll {<br>
<br>
	Manager m;<br>
	<br>
	@Override<br>
	boolean parkhauswirdfrei();<br>
}<br>
----<br>
import static org.junit.Assert.*;<br>
<br>
import org.junit.Assert;<br>
import org.junit.Test;<br>
<br>
<br>
public class ParkhausvollTest implements Parkhausvoll{<br>
<br>
	@Override<br>
	public boolean parkhauswirdfrei() {<br>
		m.setfreespaces(0);<br>
		m.ausfahren();<br>
	return	m.istPlatzrfei();<br>
	}<br>
	<br>
	public void parkhauswirdleer_autosFahreneinbisvoll_Returnstrue(){<br>
		assertTrue(parkhauswirdfrei());	<br>
		}<br>
}<br>
----<br>
public interface weißSchulden {<br>
<br>
	kassierer k;<br>
	<br>
	@Override<br>
	double berechnetPreis(double Aufenthaltsdauer,double PreisproZeitangabe);<br>	
}<br>
----<br>
import static org.junit.Assert.*;<br>
<br>
import org.junit.Assert;<br>
import org.junit.Test;<br>
<br>
public class weißSchuldenTest implements weißSchulden{<br>
<br>
	@Override<br>
	public int berechnetPreis(double Aufenthaltsdauer,double PreisproZeitangabe) {<br>
		//getPreis("Aufenthaltsdauer,PreisproZeitangabe")<br>
		double i = k.getPreis(Aufenthaltsdauer , PreisproZeitangabe);<br>
		return i;<br>
	}<br>
<br>
	public void gibtPreiszuruek_berechnetPreis_ReturnsZahlenwertgroeßer0(){<br>
		<br>
		assertTrue(berechnetPreis(0.5,0.5)>0);<br>
			<br>
		}<br>
}<br>
----<br>
<br>

