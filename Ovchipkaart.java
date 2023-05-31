package ovchipkaart;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Ovchipkaart
{
    // fields
    private double saldo;
    private int ovChipkaartNummer;
    static int nextOvNummer = 1000;
    private boolean ingecheckt = false;
    private int keuze;
    private Scanner kiezen = new Scanner(System.in);
    private boolean keuzeLoop = true;
    List<String> stoppen = new LinkedList<>();
    private int oplaadKeuze;
    private int stop;
    private int reiskant;
    private Scanner doorrijzen = new Scanner(System.in);
    private boolean verderRijzen = true;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    // constructor

    public Ovchipkaart(double saldo)
    {
	this.saldo = saldo;
	ovChipkaartNummer = nextOvNummer;
	nextOvNummer++;
	stoppen.add(0, "Venray");
	stoppen.add(1, "Vierlingsbeek");
	stoppen.add(2, "Boxmeer");
	stoppen.add(3, "Cuijk");
	stoppen.add(4, "Mook-Molenhoek");
	stoppen.add(5, "Nijmegen-Heyendaal");
	stoppen.add(6, "Nijmegen-Centraal");
    }

    // methods

    void stopKiezen(Ovchipkaart ovPas)
    {

	System.out.println("vanaf welke stop wil je reizen?");
	for (int i = 0; i < stoppen.size(); i++)
	{
	    System.out.print(i + " voor ");
	    System.out.println(stoppen.get(i));
	}
	stop = doorrijzen.nextInt();
	System.out.println("Wil je richting Nijmegen of Venray?");
	System.out.println("1 voor Nijmegen, 2 voor Venray.");
	try
	{
	    reiskant = doorrijzen.nextInt();
	} catch (java.util.InputMismatchException e)
	{
	    System.out.println("ERROR,verkeerde input");
	    ovPas.setKeuzeLoop(false);
	}

    }

    void richtingNijmegen(Incheckpaal inchecken)
    {

	if (stop == 6)
	{
	    setIncheckStatus(false);
	    System.out.println("je bent al in Nijmegen.");
	    verderRijzen = false;
	}
	stoppen.get(stop);
	ListIterator<String> ire = stoppen.listIterator(stop);
	ire.next();
	while (ire.hasNext() && verderRijzen == true)
	{
	    System.out.println("Je bent nu bij " + ire.next() + " wil je verder reizen of uitstappen?");
	    System.out.println("1 voor verder reizen 2 voor uitstappen.");
	    try
	    {
		oplaadKeuze = doorrijzen.nextInt();
	    } catch (java.util.InputMismatchException e)
	    {
		System.out.println("ERROR,verkeerde input");
		setKeuzeLoop(false);
	    }
	    if (oplaadKeuze == 1)
	    {
		inchecken.prijsVeranderen(inchecken.getPrijsToevoegen());
		System.out.println("de neiuwe prijs is: €" + decimalFormat.format(inchecken.getPrijs()) + ".");

	    } else if (oplaadKeuze == 2)
	    {
		verderRijzen = false;
	    } else
	    {
		System.out.println("ERROR, verkeerde input.");
		System.out.println("Je reist automatish verder.");
		inchecken.prijsVeranderen(inchecken.getPrijsToevoegen());
		System.out.println("de nieuwe prijs is is: €" + decimalFormat.format(inchecken.getPrijs()) + ".");

	    }

	}
	verderRijzen = true;

    }

    void richtingVenray(Incheckpaal inchecken)
    {

	if (stop == 0)
	{
	    setIncheckStatus(false);
	    System.out.println("je bent al in Venray.");
	    verderRijzen = false;
	}

	stoppen.get(stop);
	ListIterator<String> ire = stoppen.listIterator(stop);
	{
	    while (ire.hasPrevious() && verderRijzen == true)
	    {
		System.out.println("Je bent nu bij " + ire.previous() + " wil je verder reizen of uitstappen?");
		System.out.println("1 voor verder reizen 2 voor uitstappen.");
		try
		{
		    oplaadKeuze = doorrijzen.nextInt();

		} catch (java.util.InputMismatchException e)
		{
		    System.out.println("ERROR,verkeerde input");
		    setKeuzeLoop(false);
		}
		if (oplaadKeuze == 1)
		{
		    inchecken.prijsVeranderen(inchecken.getPrijsToevoegen());
		    System.out.println("de nieuwe prijs is is: €" + decimalFormat.format(inchecken.getPrijs()) + ".");

		} else if (oplaadKeuze == 2)
		{
		    verderRijzen = false;
		} else
		{
		    System.out.println("ERROR, verkeerde input!");
		    System.out.println("je reist automatish verder.");
		    inchecken.prijsVeranderen(inchecken.getPrijsToevoegen());
		    System.out.println("de nieuwe prijs is is: €" + decimalFormat.format(inchecken.getPrijs()) + ".");

		}

	    }
	}
	verderRijzen = true;
    }

    int kiezen()
    {
	System.out.println("wat wil je doen");
	System.out.println("saldo toevoegen of inchecken");
	System.out.println("1 voor saldo toevoegen 2 voor inchecken");
	try
	{
	    keuze = kiezen.nextInt();

	} catch (java.util.InputMismatchException e)
	{
	    System.out.println("ERROR,verkeerde input");
	    setKeuzeLoop(false);
	}
	return keuze;

    }

    void saldoToevoegen(double saldo)
    {
	this.saldo = this.saldo + saldo;
    }

    // getters en setters
    void setSaldo(double saldo)
    {
	this.saldo = saldo;
    }

    double getSaldo()
    {
	return saldo;
    }

    int getOvChipkaartNummer()
    {
	return ovChipkaartNummer;
    }

    void setIncheckStatus(boolean ingecheckt)
    {
	this.ingecheckt = ingecheckt;
    }

    boolean getIncheckStatus()
    {
	return ingecheckt;
    }

    void setKeuze(int keuze)
    {
	this.keuze = keuze;
    }

    int getKeuze()
    {
	return keuze;
    }

    boolean getKeuzeLoop()
    {
	return keuzeLoop;
    }

    void setKeuzeLoop(boolean keuzeLoop)
    {
	this.keuzeLoop = keuzeLoop;
    }

    int getReiskant()
    {
	return reiskant;
    }

}
