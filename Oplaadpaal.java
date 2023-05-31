package ovchipkaart;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Oplaadpaal
{
    // fields

    private Scanner bedragToevoegen = new Scanner(System.in);
    private double toegevoegdSaldo;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    // methods
    void saldoToevoegen(Ovchipkaart ovPas)
    {
	System.out.println("Wat voor bedrag wil je toevoegen: ");
	try
	{
	    toegevoegdSaldo = bedragToevoegen.nextDouble();

	} catch (java.util.InputMismatchException e)
	{
	    System.out.println("ERROR,verkeerde input");
	    ovPas.setKeuzeLoop(false);
	}
	if (toegevoegdSaldo > 120)
	{
	    System.out.println("ERROR, je mag niet meer als €150 op je saldo hebben.");
	} else if (toegevoegdSaldo < 1)
	{
	    System.out.println("ERROR, mag niet minder als 1 euro aan saldo toevoegen.");
	} else
	{
	    ovPas.saldoToevoegen(toegevoegdSaldo);
	    System.out.println("je nieuwe saldo is: €" + decimalFormat.format(ovPas.getSaldo()) + ".");
	}

    }
    // getters and setters
}
