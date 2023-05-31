package ovchipkaart;

import java.text.DecimalFormat;

public class Incheckpaal
{
    private double prijsToevoegen = 1.67;
    private double prijs = 1.67;
    private double eindPrijs = 11.69;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");


    void inchecken(Ovchipkaart ovPas)
    {
	if (ovPas.getSaldo() >= eindPrijs)
	{
	    System.out.println("Je bent ingecheckt.");
	    ovPas.setIncheckStatus(true);
	} else
	{
	    System.out.println("ERROR, niet genoeg saldo om intechecken!");
	    ovPas.setKeuzeLoop(false);
	}
    }

    void uitchecken(Ovchipkaart ovPas)
    {
	if (ovPas.getIncheckStatus() == true)
	{
	    System.out.println("Je bent uitgechekt dankjewel om met ons te reizen.");
	    ovPas.setIncheckStatus(false);
	    ovPas.saldoToevoegen(-prijs);
	    System.out.println("je nieuwe saldo is: €" + decimalFormat.format(ovPas.getSaldo()) + ".");
	} else
	{
	    ovPas.setKeuzeLoop(false);
	}
    }

    void prijsVeranderen(double prijs)
    {
	this.prijs = this.prijs + prijs;
    }

    public void setPrijs(double prijs)
    {
	this.prijs = prijs;
    }

    public double getPrijs()
    {
	return prijs;
    }

    public double getPrijsToevoegen()
    {
	return prijsToevoegen;
    }

}
