package ovchipkaart;

public class Passagier
{

    public static void main(String[] args)
    {
	Ovchipkaart ovPas = new Ovchipkaart(20);
	Incheckpaal inchecken = new Incheckpaal();
	Oplaadpaal opladen = new Oplaadpaal();
	System.out.println(ovPas.getSaldo());

	while (ovPas.getKeuzeLoop() == true)
	{
	    ovPas.kiezen();
	    if (ovPas.getKeuze() == 1)
	    {
		opladen.saldoToevoegen(ovPas);
	    } else if (ovPas.getKeuze() == 2)
	    {
		ovPas.stopKiezen(ovPas);
		inchecken.inchecken(ovPas);
		if (ovPas.getReiskant() == 1)
		{
		    ovPas.richtingNijmegen(inchecken);
		} else if (ovPas.getReiskant() == 2)
		{
		    ovPas.richtingVenray(inchecken);
		} else
		{
		    System.out.println("ERROR, Verkeerde input");
		}
		inchecken.uitchecken(ovPas);
	    } else
	    {
		System.out.println("ERROR, verkeerde input");
		ovPas.setKeuzeLoop(false);
	    }
	}

    }

}