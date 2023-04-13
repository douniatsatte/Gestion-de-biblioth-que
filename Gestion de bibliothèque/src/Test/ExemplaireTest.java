package Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Domaine.Exemplaire;
import Domaine.Oeuvre;
import Utility.BibliothequeExceptions;
import control.ExemplaireControl;
public class ExemplaireTest {

	 @Test
	    public void testAjouter() throws BibliothequeExceptions {
	        Oeuvre oeuvre = new Oeuvre();
	        oeuvre.setId(1);
	        oeuvre.setTitre("Les Misérables");
	        oeuvre.setAuteur("Victor Hugo");
	        oeuvre.setNbExemplaires(0);
	        ExemplaireControl.ajouter(oeuvre, "neuf");
	        assertEquals(1, oeuvre.getNbExemplaires());
	    }

	    @Test
	    public void testModifier() throws BibliothequeExceptions {
	        Exemplaire exemplaire = new Exemplaire();
	        exemplaire.setId(1);
	        exemplaire.setEtat("abimé");
	        ExemplaireControl.modifier(exemplaire);
	        assertEquals("abimé", exemplaire.getEtat());
	    }

	    @Test
	    public void testSupprimer() throws BibliothequeExceptions {
	        Exemplaire exemplaire = new Exemplaire();
	        exemplaire.setId(1);
	        exemplaire.setEtat("neuf");
	        ExemplaireControl.supprimer(exemplaire);
	        assertNull(ExemplaireControl.findById(1));
	    }

	    @Test
	    public void testFindById() throws BibliothequeExceptions {
	        Exemplaire exemplaire = ExemplaireControl.findById(1);
	        assertNotNull(exemplaire);
	    }

	    @Test
	    public void testFindExemplaireDispo() throws BibliothequeExceptions {
	        Oeuvre oeuvre = new Oeuvre();
	        oeuvre.setId(1);
	        ArrayList<Exemplaire> exemplairesDispo = ExemplaireControl.findExemplaireDispo(oeuvre);
	        assertNotNull(exemplairesDispo);
	    }

	    @Test
	    public void testFind() throws BibliothequeExceptions {
	        Oeuvre oeuvre = new Oeuvre();
	        oeuvre.setId(1);
	        ArrayList<Exemplaire> exemplaires = ExemplaireControl.find(oeuvre);
	        assertNotNull(exemplaires);
	    }
}
