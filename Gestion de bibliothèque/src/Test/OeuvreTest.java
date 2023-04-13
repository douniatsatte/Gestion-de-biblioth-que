package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Domaine.Oeuvre;
import Utility.BibliothequeExceptions;
import control.OeuvreControl;
public class OeuvreTest {

	 private Oeuvre oeuvre;
	    private Oeuvre oeuvre2;

	    @Before
	    public void setUp() {
	        oeuvre = new Oeuvre();
	        oeuvre2 = new Oeuvre();
	    }
	    
	    @Test
	    public void testAjouter() throws BibliothequeExceptions {
	        OeuvreControl.ajouter(oeuvre);
	        ArrayList<Oeuvre> oeuvres = OeuvreControl.getListOeuvres();
	        assertTrue(oeuvres.contains(oeuvre));
	    }
	    
	    @Test
	    public void testModifier() throws BibliothequeExceptions {
	        OeuvreControl.ajouter(oeuvre);
	        oeuvre.setTitre("nouveauTitre");
	        OeuvreControl.modifier(oeuvre);
	        Oeuvre oeuvreModifiee = OeuvreControl.findById(oeuvre.getId());
	        assertEquals("nouveauTitre", oeuvreModifiee.getTitre());
	    }
	    
	    @Test
	    public void testSupprimer() throws BibliothequeExceptions {
	        OeuvreControl.ajouter(oeuvre);
	        OeuvreControl.supprimer(oeuvre);
	        ArrayList<Oeuvre> oeuvres = OeuvreControl.getListOeuvres();
	        assertFalse(oeuvres.contains(oeuvre));
	    }
	    
	    @Test
	    public void testFindById() throws BibliothequeExceptions {
	        OeuvreControl.ajouter(oeuvre);
	        Oeuvre oeuvreTrouvee = OeuvreControl.findById(oeuvre.getId());
	        assertEquals(oeuvre, oeuvreTrouvee);
	    }
	    
	    @Test
	    public void testFindByTitre() throws BibliothequeExceptions {
	        OeuvreControl.ajouter(oeuvre);
	        OeuvreControl.ajouter(oeuvre2);
	        ArrayList<Oeuvre> oeuvresTrouvees = OeuvreControl.findByTitre("titre1");
	        assertTrue(oeuvresTrouvees.contains(oeuvre));
	        assertFalse(oeuvresTrouvees.contains(oeuvre2));
	    }
}
